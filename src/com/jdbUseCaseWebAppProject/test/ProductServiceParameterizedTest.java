package com.jdbUseCaseWebAppProject.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import com.jdbUseCaseWebAppProject.entities.Product;
import com.jdbUseCaseWebAppProject.entities.User;
import com.jdbUseCaseWebAppProject.services.ProductService;
import com.jdbUseCaseWebAppProject.services.UserService;


@RunWith(Parameterized.class)
public class ProductServiceParameterizedTest {
	Product expected;

	static EntityManagerFactory entitymanagerfactory;
	static EntityManager entitymanager;
	
	public ProductServiceParameterizedTest(Product expected) {
		super();
		this.expected = expected;
	}
	
 	@Parameterized.Parameters
 	public static Collection params() {

 		return Arrays.asList(new Object[][]{
 		
 			{new Product(1, "Mixed", "Small Mixed Box",	"small",	"7-9",	"1-2",	"For snacking",	"Ideal for snacking and cooking.",12.00)},
 			{new Product(2, "Mixed", "Small Mixed Box", "small", "7-9", "1-2", "For snacking", "Ideal for snacking and cooking.", 12.00)},
 			{new Product(3, "Mixed", "Medium Mixed Box", "medium", "11-13", "2-4", "About 30 pounds of organic fresh produce!", "About 30 pounds of organic fresh produce!", 15.00)},
 			{new Product(4, "Mixed", "Large Mixed Box", "large", "17-19", "4-6",	"Great for families, avid cooks, and hosting friends for dinner.", "Great for families, avid cooks, and hosting friends for dinner", 20.00)},
 			{new Product(5, "Fruit", "Small All Fruit Box", "small", "7-9", "1-2", "Approximately 15 to 20 pieces of fruit.", "Approximately 15 to 20 pieces of fruit.", 12.00)},
 			{new Product(6, "Fruit", "medium All Fruit Box", "medium", "11-13", "2-4", "Perfect for small families or individuals who love to cook!","Perfect for small families or individuals who love to cook!", 15.00)},
 			{new Product(7, "Fruit", "Large", "All Fruit Box", "17-19", "4-6", "Can't have too much fruit? This option is perfect for you!", "Are you obsessed with fruit? This option offers approximately 30 pounds of only fruit. Photo shown is a sample of the variety and number of items typically included. Contents will vary each week depending on what we rescue.", 28.00)},
 			{new Product(8, "Veggie", "Small All Veggie Box", "small", "7-9",	"1-2", "Trying to eat more veggies? Here's what you need!", "Trying to eat more veggies? Here's what you need!", 12.00)},
 			{new Product(9, "Veggie", "Medium All Veggie Box", "medium", "11-13", "2-4", "Perfect for small families or individuals who love to cook!", "Perfect for small families or individuals who love to cook!", 15.00)},
 			{new Product(10, "Veggie", "Large All Veggie Box", "large", "25-30", "10-20", "30 pounds of fresh veggies!", "30 pounds of fresh veggies!", 28.00)}

 			});
 		}
 	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		 entitymanager = entitymanagerfactory.createEntityManager();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entitymanager.close();
		entitymanagerfactory.close();

	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetProductById() {

		int expectedEmail = expected.getpId();

		ProductService productService = new ProductService();
		Product actual = productService.getProductById(expected.getpId());
		int actualEmail = actual.getpId();

 		assertEquals(expectedEmail, actualEmail); 	
 		}
		
		
		
	
}
