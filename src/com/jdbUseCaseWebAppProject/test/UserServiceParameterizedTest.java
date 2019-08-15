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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.jdbUseCaseWebAppProject.entities.User;
import com.jdbUseCaseWebAppProject.services.UserService;


@RunWith(Parameterized.class)
public class UserServiceParameterizedTest {
	User expected;

	static EntityManagerFactory entitymanagerfactory;
	static EntityManager entitymanager;
	
	public UserServiceParameterizedTest(User expected) {
		super();
		this.expected = expected;
	}
	
 	@Parameterized.Parameters
 	public static Collection params() {

 		return Arrays.asList(new Object[][]{
 		
 			{new User("khan", "Johnson", "c@c.com", "bb")},
 			{new User("Clem", "Startin", "c@s.com", "pass")},
 			{new User("Thornie", "cs@abc.com", "ta@abc.com", "Attwool")},
 			{new User("Harcourt", "Guerre","hg@abc.com", "pass")},
 			{new User("Holmes", "Taffley", "ht@abc.com", "pass")},
 			{new User("Alexandra", "Iannitti","ai@abc.com",  "pass")},
 			{new User("Laryssa", "Jiroudek","lj@abc.com", "pass")},
 			{new User("Cahra", "Jaulme", "cj@abc.com", "pass")}

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
	public void testGetUserByEmail() {
		
		String expectedEmail = expected.getuEmail();

		UserService userServices = new UserService();
 		User user = userServices.getUserByEmail(expected.getuEmail());
 		String actualEmail = user.getuEmail();
 		
 		assertEquals(expectedEmail, actualEmail); 		
	}

	@Test
	public void testUserExists() {
		boolean result = false;
		
		UserService userServices = new UserService();
 		result = userServices.userExists(expected.getuEmail());

 	   assertTrue(result);
	}
	
	@Test
	public void testValidateUser() {
		boolean result = false;
		
		UserService userServices = new UserService();
 		result = userServices.validateUser(expected.getuEmail(), expected.getuPassword());
 				
  	   assertTrue(result);

	}

	@Test
	public void testLoginUser() {
		String expectedEmail = expected.getuEmail();

		UserService userServices = new UserService();
		User user = userServices.loginUser(expected.getuEmail(), expected.getuPassword());
 		String actualEmail = user.getuEmail();

 		assertEquals(expectedEmail, actualEmail); 		

	}

	
	
	
	public void testRegisterProductToUser() {
		fail("Not yet implemented"); // TODO
	}

	public void testGetUserProducts() {
		fail("Not yet implemented"); // TODO
	}
	
	public void testRemoveUserByEmail() {
		fail("Not yet implemented"); // TODO
	}

	public void testUpdateUser() {
		fail("Not yet implemented"); // TODO
	}
	public void testInsertUser() {
		fail("Not yet implemented"); // TODO
	}

	public void testGetAllUsers() {
		fail("Not yet implemented"); // TODO
	}
	

	
}
