package com.jdbUseCaseWebAppProject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jdbUseCaseWebAppProject.entities.Product;
import com.jdbUseCaseWebAppProject.entities.User;
import com.jdbUseCaseWebAppProject.services.ProductService;
import com.jdbUseCaseWebAppProject.services.UserService;

@Controller // control all the method
@SessionAttributes("sUser")
public class MainController {
	
	// SessionAttribute requires existing user object
	@ModelAttribute("sUser")
	public User setupsUser() {
		// setup business logic
		// initialize 
		User user = new User();
		
		return user;
	}
	
	
	@RequestMapping(value= {"/", "/home"})
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("userLoginStatus", "NO");
		return mav;
	}

	@RequestMapping(value= {"/welcome"})
	public ModelAndView toWelcome() {
		ModelAndView mav = new ModelAndView("welcome");
		return mav;
	}
	
	
	@RequestMapping(value= {"/aboutus"})
	public ModelAndView goAboutus() {
		ModelAndView mav = new ModelAndView("aboutus");
		return mav;
	}

	
	@RequestMapping(value= {"/howitworks"})
	public ModelAndView goHowitworks() {
		ModelAndView mav = new ModelAndView("howitworks");
		return mav;
	}
	
	
	@GetMapping("/login")
	public ModelAndView getLogin() {
		ModelAndView mav = new ModelAndView("login");
		User user = new User();
		mav.addObject("sUser", user);
		return mav;
	}	

	@PostMapping(value="/login")
	public ModelAndView doLogin(
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		
		ModelAndView mav = new ModelAndView();
		String message = null;

		UserService userService = new UserService();
		boolean result = userService.validateUser(email, password);
		if (result != true) {
			message = "Email or Password does not match. Please try again.";

			mav = new ModelAndView("login");
			mav.addObject("messageResult", message);
			return mav;
		}
		
		User user = userService.getUserByEmail(email);
		if (user == null) {
			message = "Invalid Email or Password. Please try again.";
			mav = new ModelAndView("login");
			mav.addObject("messageResult", message);
			return mav;
		}
			mav = new ModelAndView("welcome");
			mav.addObject("sUser", user);
			mav.addObject("messageResult", message);
			mav.addObject("landingPage", "welcome");
			mav.addObject("userLoginStatus", "YES");
		
		return mav;
	}
	
	// For validation
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields();
		binder.setRequiredFields("uLastName","uFirstName","uEmail", "uPassword");
	}

	@GetMapping("/register")
	public ModelAndView goRegister() {

		ModelAndView mav = new ModelAndView("register");
		User user = new User();
		mav.addObject("userKey", user);

		return mav; 
	}	

	@RequestMapping(value="/register", method=RequestMethod.POST )	
	public ModelAndView doRegister(
			@Valid @ModelAttribute("userKey") User user,
			BindingResult errors){
		
			ModelAndView mav = new ModelAndView();

		if(errors.hasErrors()) {
			mav.setViewName("register");
			return mav;
		} else {

			UserService userService = new UserService();
			User newUser = new User(user.getuFirstName(), user.getuLastName(), user.getuEmail(), user.getuPassword());
			
			boolean result = userService.insertUser(newUser);
			String message = result? "User Added " : "try again, not saved";
			
			mav.addObject("messageResult", message);
			mav.setViewName("welcome");

			return mav;
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		   return "logout";
	}	

	
	@GetMapping("/profile")
	public ModelAndView getProfile() {

		ModelAndView mav = new ModelAndView("profile");
		return mav; 
	}	

			
			
	@RequestMapping(value = "/profile",  method=RequestMethod.POST)
	public ModelAndView profile(
			@SessionAttribute("sUser") User sUser) {

		ModelAndView mav = new ModelAndView("profile");
		return mav; 
	}	
	
	@RequestMapping("/updateprofile")
	public ModelAndView updateMyProfile(
			@SessionAttribute("sUser") User u,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("password") String password){
		
		boolean result = true;
		UserService userService = new UserService();
		User user = new User(firstName, lastName, email, password);

		
		if(user != null) {
			result = userService.updateUser(user);
		}
		
		String message = result? " >> Successfully Updated User: " + user.getuFirstName() + " << " : "  >> Unable to Update user: \""+ user.getuFirstName() + "\" .  << ";
		String color = result?"green":"red";

		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("sUser", user);
		mav.addObject("messageResult", message);
		mav.addObject("textColor", color);
		
		return mav;
	}
	

//User Admin
	// Prints a All Users to the View 
	@RequestMapping("/showUsers")
	public ModelAndView showAllUsers() {

		UserService userService = new UserService();
		List<User> userList = userService.getAllUsers();

		ModelAndView mav = new ModelAndView("allusers");
		mav.addObject("userList", userList);
		return mav;
	}
	
	@GetMapping("/adduser")
	public ModelAndView goAddUser() {
		ModelAndView mav = new ModelAndView("adduser");
		return mav;
	}	
	
	@RequestMapping(value="/adduserform")
	public ModelAndView addUser(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("password") String password,
			@RequestParam("email") String email){

		UserService userService = new UserService();

		User user = new User(firstName, lastName, email, password);
		boolean result = userService.insertUser(user);
		String message = result? " >> Successfully Added User: " + firstName + " << " : "  >> Unable to add user \""+firstName + "\" . Try using a different email address.<<<";
		String color = result?"green":"red";
		List<User> userList = userService.getAllUsers();

		ModelAndView mav = new ModelAndView("allusers");
		mav.addObject("messageResult", message);
		mav.addObject("textColor", color);
		mav.addObject("userList", userList);

		return mav;
	}

	@RequestMapping("/deleteuser/{urlEmail}")
	public ModelAndView confirmDeleteUser(@PathVariable("urlEmail") String email) {
		UserService userService = new UserService();
		User user = userService.getUserByEmail(email);
		
		ModelAndView mav = new ModelAndView("confirmdeleteuser");

		if (user == null) {
			String message = "Invalid Email or Password. Please try again.";
			mav = new ModelAndView("allusers");
			mav.addObject("messageResult", message);
		} else {
			
		mav.addObject("firstName", user.getuFirstName());
		mav.addObject("lastName", user.getuLastName());
		mav.addObject("email", user.getuEmail());
		}
		return mav;
	}

	@RequestMapping("/removeUser/{urlEmail}")
	public ModelAndView deleteUser(@PathVariable("urlEmail") String email) {
		System.out.println("email : " + email);
		ModelAndView mav = new ModelAndView("allusers");

		UserService userService = new UserService();

		boolean result = userService.removeUserByEmail(email);
		//boolean result = userService.deletUserByuEmail(email);
		String message = result? " >> Successfully Deleted User: " + email + " << " : "  >> Unable to Delete user \"" + email + "\" . Try using a different email. << ";
		String color = result?"green":"red";

		List<User> userList = userService.getAllUsers();

		mav.addObject("messageResult", message);
		mav.addObject("textColor", color);
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping("/updateUser/{urlEmail}")
	public ModelAndView updateUser(@PathVariable("urlEmail") String email) {
		UserService userService = new UserService();
		User user = userService.getUserByEmail(email);
		ModelAndView mav = new ModelAndView();
		String message;
		
		if (user == null) {
			message = " >> Encountered issue accessing user : " + email + ". Please try another user ";
			
			List<User> userList = userService.getAllUsers();

			mav.addObject("messageResult", message);
			mav.addObject("textColor", "red");
			mav.addObject("userList", userList);

			mav.setViewName("allusers");
			return mav;
		}

		mav.addObject("user",user);
		mav.addObject("firstName", user.getuFirstName());
		mav.addObject("lastName", user.getuLastName());
		mav.addObject("email", user.getuEmail());
		mav.setViewName("updateUser");

		return mav;
	}

	@RequestMapping(value="/updateuser", method=RequestMethod.POST)
	public ModelAndView updateUserForm(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("email") String email,
			@RequestParam("password") String password){

		boolean result = true;

		UserService userService = new UserService();
		User user = new User(firstName, lastName, email, password);

		System.out.println("user: " + user.toString());

		if(user != null) {
			result = userService.updateUser(user);
		}

		String message = result? " >> Successfully Updated User " + user.getuFirstName() + " << " : "  >> Unable to Update user \""+ user.getuFirstName() + "\" .  << ";
		String color = result?"green":"red";
		List<User> userList = userService.getAllUsers();

		ModelAndView mav = new ModelAndView("allusers");
		mav.addObject("messageResult", message);
		mav.addObject("textColor", color);
		mav.addObject("userList", userList);

		return mav;
	}


	// Products Admin
	
	@GetMapping("/addproduct")
	public ModelAndView goAddproduct() {
		ModelAndView mav = new ModelAndView("addproduct");
		return mav;
	}	


	@RequestMapping("/updateproduct/{urlId}")
	public ModelAndView updateproduct(@PathVariable("urlId") int id) {
		ProductService productService = new ProductService();
		Product product = productService.getProductById(id);

		ModelAndView mav = new ModelAndView("updateproduct");
		mav.addObject("product", product);
		mav.addObject("id", product.getpId());
		mav.addObject("category", product.getpCategory());
		mav.addObject("name", product.getpName());
		mav.addObject("size", product.getpSize());
		mav.addObject("weight", product.getpWeight());
		mav.addObject("serving", product.getpServing());
		mav.addObject("summary", product.getpSummary());
		mav.addObject("description", product.getpDescription());
		mav.addObject("price", product.getpPrice());

		return mav;
	}

	@RequestMapping(value="/updateproductform/{urlId}")
	public ModelAndView updateproductform(
			@PathVariable("urlId") int id,
			@RequestParam("category") String category,
			@RequestParam("name") String name,
			@RequestParam("size") String size,
			@RequestParam("weight") String weight,
			@RequestParam("serving") String serving,
			@RequestParam("summary") String summary,
			@RequestParam("description") String description,
			@RequestParam("price") double price){

		boolean result = true;

		ProductService productService = new ProductService();
		Product product = new Product(id, category, name, size, weight, serving, summary, description, price);

		if(product != null) {
			result = productService.updateProduct(product);
			System.out.println("product is not null");
		}

		String message = result? " >> Successfully Updated Product:  " + product.getpName() + " << " : "  >> Unable to Update user \""+ product.getpName() + "\" .  << ";
		String color = result?"green":"red";
		List<Product> productList = productService.getAllProducts();

		ModelAndView mav = new ModelAndView("allproducts");
		mav.addObject("messageResult", message);
		mav.addObject("textColor", color);
		mav.addObject("productList", productList);

		return mav;
	}







	/*
	 * 
	 * Products Sections
	 * 
	 */

	// Prints a All Products to the View 
	@RequestMapping("/showProducts")
	public ModelAndView getAllProducts() {

		ProductService productServices = new ProductService();
		List<Product> productList = productServices.getAllProducts();
		ModelAndView mav = new ModelAndView("allproducts");
		mav.addObject("productList", productList);

		return mav;
	}


	@RequestMapping("/removeProduct/{urlId}")
	public ModelAndView deleteEmployee(@PathVariable("urlId") int id) {
		System.out.println("Product id from url = " + id);

		ProductService productService = new ProductService();
		boolean result = productService.removeProductById(id);
		String message = result ?"Product Removed= "+id:"Unable to remove product " + id;

		List<Product> productList = productService.getAllProducts();

		ModelAndView mav = new ModelAndView("allproducts");
		mav.addObject("messageResult", message);
		mav.addObject("id", id);
		mav.addObject("productList", productList);
		return mav;

	}

	@RequestMapping(value="/addproductform")
	public ModelAndView addproductform(
			@RequestParam("category") String category,
			@RequestParam("name") String name,
			@RequestParam("size") String size,
			@RequestParam("weight") String weight,
			@RequestParam("serving") String serving,
			@RequestParam("summary") String summary,
			@RequestParam("description") String description,
			@RequestParam("price") double price){

		ProductService productService = new ProductService();

		Product product = new Product(category, name, size, weight, serving, summary, description, price);
		boolean result = productService.insertProduct(product);

		String message = result? " >> Successfully Added Product: " + name + " << " : "  >> Unable to add product \""+ name + "\" . <<";
		String color = result?"green":"red";
		
		List<Product> productList = productService.getAllProducts();

		ModelAndView mav = new ModelAndView("allproducts");
		mav.addObject("category", category);
		mav.addObject("name", name);
		mav.addObject("size", size);
		mav.addObject("weight", weight);
		mav.addObject("serving", serving);
		mav.addObject("summary", summary);
		mav.addObject("description", description);
		mav.addObject("price", price);
		mav.addObject("productList", productList);
		mav.addObject("messageResult", message);
		mav.addObject("color", color);

		return mav;
	}

	@RequestMapping("/confirmdeleteproduct/{urlId}")
	public ModelAndView confirmdeleteproduct(@PathVariable("urlId") int id) {
		ProductService productService = new ProductService();
		Product product = productService.getProductById(id);
		System.out.println("confirmdeleteproduct::product " + product);

		ModelAndView mav = new ModelAndView("confirmdeleteproduct");
		mav.addObject("id", product.getpId());
		mav.addObject("category", product.getpCategory());
		mav.addObject("name", product.getpName());
		mav.addObject("size", product.getpSize());
		mav.addObject("weight", product.getpWeight());
		mav.addObject("serving", product.getpServing());
		mav.addObject("summary", product.getpSummary());
		mav.addObject("description", product.getpDescription());
		mav.addObject("price", product.getpPrice());
		mav.addObject("product", product);

		return mav;
	}

	
	//Shopping

	@RequestMapping("/products")
	public ModelAndView goProducts(Model model) {
		ModelAndView mav = new ModelAndView("products");

		return mav;
	}	


	@RequestMapping(value="/product/vegetables")
	public ModelAndView doVegetables() {

		ProductService productServices = new ProductService();
		List<Product> productList = productServices.getProductsByCategory("Veggie");

		ModelAndView mav = new ModelAndView("product");
		mav.addObject("productList", productList);
		mav.addObject("category", "Vegetable");
		mav.addObject("textColor", "style= \"color: #398439;\"");
		mav.addObject("btnClass", "btn-success");

		return mav;
	}	


	@RequestMapping (value = "/product/fruit")
	public ModelAndView doFruits() {

		ProductService productServices = new ProductService();
		List<Product> productList = productServices.getProductsByCategory("fruit");

		ModelAndView mav = new ModelAndView("product");
		mav.addObject("productList", productList);
		mav.addObject("category", "Fruit");
		mav.addObject("textColor", "style= \"color: #ac2925;\"");
		mav.addObject("btnClass", "btn-danger");

		return mav;	
	}	
 

	@RequestMapping(value = "/product/Mixed")
	public ModelAndView domixed() {

		ProductService productServices = new ProductService();
		List<Product> productList = productServices.getProductsByCategory("Mixed");

		ModelAndView mav = new ModelAndView("product");
		mav.addObject("productList", productList);
		mav.addObject("category", "Mixed");
		
		mav.addObject("textColor", "style= \"color: #d58512;\"");
		mav.addObject("btnClass", "btn-warning");

		return mav;	
	}	
	
	
	
	@RequestMapping (value = "/cart")
	public ModelAndView goCart(@SessionAttribute("sUser") User sUser) {

		UserService userService = new UserService();
		List<Product> productList = userService.getUserProducts(sUser);

		ModelAndView mav = new ModelAndView("cart");
		mav.addObject("productList", productList);
		
		return mav;	
	}	
 
	
	@RequestMapping(value = "/addtocart/{urlId}", method=RequestMethod.POST)
	public ModelAndView addToCart(
			@PathVariable("urlId") int id,
			@SessionAttribute("sUser") User sUser) {
		
		UserService userService = new UserService();
		System.out.println("sUser : " + sUser);
		boolean result = userService.addProductToUser(sUser, id);
		
		String message = result?"Successfully Added " + id :"Failed to add "+ id;
		List<Product> productList = userService.getUserProducts(sUser);
		
		ModelAndView mav = new ModelAndView("cart");
		mav.addObject("productList", productList);
		mav.addObject("messageResult", message);
		
		return mav;
	}
	
	@RequestMapping(value = "/deleteitemfromcart/{urlId}")
	public ModelAndView deleteitemfromcart(
			@PathVariable("urlId") int id,
			@SessionAttribute("sUser") User sUser) {
		
		UserService userService = new UserService();
		boolean result = userService.removeProductFromUser(sUser, id);
		String message = result?"Successfully removed item #" + id + " from Cart":"Failed to remove item # "+ id;

		List<Product> productList = userService.getUserProducts(sUser);

		ModelAndView mav = new ModelAndView("cart");
		mav.addObject("productList", productList);
		mav.addObject("messageResult", message);

		return mav;
		
	}
	
	@RequestMapping (value = "/checkout")
	public ModelAndView goCheckout(@SessionAttribute("sUser") User sUser) {

		UserService userService = new UserService();
		 boolean result = userService.removeAllProductsFromUser(sUser);
			String message = result?"Successfully cleared the Cart":"Failed to clear the Cart";

		ModelAndView mav = new ModelAndView("checkout");

		return mav;	
	}	
 
	
	

}
