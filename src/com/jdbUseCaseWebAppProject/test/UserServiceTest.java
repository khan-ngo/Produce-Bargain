package com.jdbUseCaseWebAppProject.test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.jdbUseCaseWebAppProject.entities.User;
import com.jdbUseCaseWebAppProject.services.UserService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
	
	@Test
	public void testInsertUser() {
		boolean result = false;
		
		User user = new User("test", "Test", "test@testing.com", "TestPass123");
				
		UserService userService = new UserService();
		 result = userService.insertUser(user);
		 
		 assertTrue(result);
	}
	
	
	@Test
	public void testRemoveUserByEmail() {
		boolean result = false;
		
		UserService userService = new UserService();		
		 result = userService.removeUserByEmail("test@testing.com");
		 
		 assertTrue(result);	}

}
