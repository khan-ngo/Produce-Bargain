package com.jdbUseCaseWebAppProject.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.jdbUseCaseWebAppProject.entities.Product;
import com.jdbUseCaseWebAppProject.services.ProductService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {

	@Test
	public void testInsertProduct() {
		boolean result = false;
		
		Product product = new Product("TestingUniqueName123", "Small Mixed Box",	"small",	"7-9",	"1-2",	"For snacking",	"Ideal for snacking and cooking.",12.00);

		ProductService productService = new ProductService();
		  result = productService.insertProduct(product);
		 
		 assertTrue(result);
		 }



}
