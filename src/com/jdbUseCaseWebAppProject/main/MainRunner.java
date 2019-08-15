package com.jdbUseCaseWebAppProject.main;

import java.util.List;
import java.util.Scanner;

import com.jdbUseCaseWebAppProject.entities.Product;
import com.jdbUseCaseWebAppProject.entities.User;
import com.jdbUseCaseWebAppProject.services.ProductService;
import com.jdbUseCaseWebAppProject.services.UserService;


public class MainRunner {
	
	static Scanner reader = new Scanner(System.in);
	static UserService userServices = new UserService();

	public static void main(String[] args) {

//		loadProducts();  	// Load Product Data 
//		loadUsers();   // Load User Date
		
		
		
//		SMSApp();	//Runs the SMS App

	} // End Main

	
	// Used to upload data for testing
	public static void loadProducts() {
		System.out.println("--- addProduct() ---");
		
		Product product1 = new Product("Mixed",	"Small Mixed Box",	"small",	"7-9",	"1-2",	"For snacking",	"Ideal for snacking and cooking.",12.00);
		addProduct(product1);
		addProduct(new Product("Mixed", "Small Mixed Box", "small", "7-9", "1-2", "For snacking", "Ideal for snacking and cooking.", 12.00));
		addProduct(new Product("Mixed", "Medium Mixed Box", "medium", "11-13", "2-4", "About 30 pounds of organic fresh produce!", "About 30 pounds of organic fresh produce!", 15.00));
		addProduct(new Product("Mixed",	"Large Mixed Box", "large", "17-19", "4-6",	"Great for families, avid cooks, and hosting friends for dinner.", "Great for families, avid cooks, and hosting friends for dinner", 20.00));
		addProduct(new Product("Fruit", "Small All Fruit Box", "small", "7-9", "1-2", "Approximately 15 to 20 pieces of fruit.", "Approximately 15 to 20 pieces of fruit.", 12.00));
		addProduct(new Product("Fruit", "medium All Fruit Box", "medium", "11-13", "2-4", "Perfect for small families or individuals who love to cook!","Perfect for small families or individuals who love to cook!", 15.00));
		addProduct(new Product("Fruit", "Large", "All Fruit Box", "17-19", "4-6", "Can't have too much fruit? This option is perfect for you!", "Are you obsessed with fruit? This option offers approximately 30 pounds of only fruit. Photo shown is a sample of the variety and number of items typically included. Contents will vary each week depending on what we rescue.", 28.00));
		addProduct(new Product("Veggie", "Small All Veggie Box", "small", "7-9",	"1-2", "Trying to eat more veggies? Here's what you need!", "Trying to eat more veggies? Here's what you need!", 12.00));
		addProduct(new Product("Veggie", "Medium All Veggie Box", "medium", "11-13", "2-4", "Perfect for small families or individuals who love to cook!", "Perfect for small families or individuals who love to cook!", 15.00));
		addProduct(new Product("Veggie", "Large All Veggie Box", "large", "25-30", "10-20", "30 pounds of fresh veggies!", "30 pounds of fresh veggies!", 28.00));
		System.out.println("----------------------------\n");
	}
	
	// Used to upload data for testing
	public static void loadUsers() {
		System.out.println("--- addUser() ---");		
		User user1 = new User("Khanh", "Smith", "a@a.com", "aa");
		addUser(user1);
		addUser(new User("khan", "Johnson", "c@c.com", "bb"));
		addUser(new User("Clem", "Startin", "c@s.com", "pass"));
		addUser(new User("Thornie", "cs@abc.com", "ta@abc.com", "Attwool"));
		addUser(new User("Harcourt", "Guerre","hg@abc.com", "pass"));
		addUser(new User("Holmes", "Taffley", "ht@abc.com", "pass"));
		addUser(new User("Alexandra", "Iannitti","ai@abc.com",  "pass"));
		addUser(new User("Laryssa", "Jiroudek","lj@abc.com", "pass"));
		addUser(new User("Cahra", "Jaulme", "cj@abc.com", "pass"));
		System.out.println("----------------------------\n");
	
	}
	
	// Used to upload data for testing
	public static void SMSApp() {

		int choice = 0;
		
			System.out.println("\nAre you a(n):");
			System.out.println("1. Sign-In");
			System.out.println("2. Register");
			System.out.println("3. Quit");
			System.out.println("Please, enter 1 or 2.");
			System.out.println("\n");

			try {
				choice = reader.nextInt();
				switch (choice) {
				case 1:
					// get input from user
					System.out.print("\nEnter Your Email:\n");
					String loginEmail = reader.next();

					System.out.print("\nEnter Your Password:\n");
					String loginPass = reader.next();

					// Validate to make sure Credentials
					boolean validUser = userServices.validateUser(loginEmail, loginPass);

					if (validUser) {
						System.out.println("Login Success ..");
						User user = userServices.getUserByEmail(loginEmail);

						if (user.getuProducts() != null) {
							System.out.println("Your order: \n");
							userServices.getUserProducts(user);

						} else {
							System.out.println("You are currently not registered.");
						}

					} else {
						break;
					}
				case 2:
					// get input from user
					
					System.out.print("\nEnter Your First Name:\n");
					String registerFirstName = reader.next();
					
					System.out.print("\nEnter Your Last Name:\n");
					String registerLastName = reader.next();
					
					System.out.print("\nEnter Your Email:\n");
					String registerEmail = reader.next();

					System.out.print("\nEnter Your Password:\n");
					String registerPass = reader.next();
					
//					String registerFullName = registerFirstName + " "+ registerLastName;
					User user = new User(registerEmail, registerFirstName, registerLastName, registerPass);
					
					// validate before 
					// does the account exist ?
					addUser(user);

					break;

				case 3:
					System.out.println("\n\n");
					System.out.println("GoodBye.\n");
					
					break;
				} // end switch(choice)

				
				System.out.println("Listing of all available Products: ");
				System.out.println("----------------------------");

				ProductService productServices = new ProductService();
				
				List<Product> productList = productServices.getAllProducts();
				productServices.showAllProducts(productList);
//				List<Product> productList = productServices.showAllProducts();
				
//				for (Product c : productList) {
//					System.out.println(c.toString());
//				}

				
//				System.out.println("\nWhich Product ?");
//				int choosenClass = reader.nextInt();
//
//				Product product = productServices.getProductById(choosenClass);
//				System.out.println("product Chosen: " + product);
//
//				userServices.registerUserToProduct(loginEmail, choosenClass);
//
//				System.out.println("Your Classes: \n");
//				userServices.getUserProducts(loginEmail);
				
			} // end try

			catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				reader.nextLine();
			}
		reader.close();

	}

	// Used to upload data for testing
	private static void addProduct(Product product) {
		ProductService productServices = new ProductService();

		boolean result = productServices.insertProduct(product);

		if (result) {
			System.out.println("Product saved, Product ID:" + product.getpId());
		} else {
			System.out.println("Product NOT saved, Product ID: " + product.getpId());
		}
	}

	// Used to upload data for testing
	private static void addUser(User user) {
		UserService userServices = new UserService();
		boolean result = userServices.insertUser(user);
		if (result) {
			System.out.println("User saved, User Email:" + user.getuEmail());
		} else {
			System.out.println("User NOT saved, User Email: " + user.getuEmail());
		}
	}

}
