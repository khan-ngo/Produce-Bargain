package com.jdbUseCaseWebAppProject.daoi;

import java.util.List;

import com.jdbUseCaseWebAppProject.entities.Product;

public interface ProductDAOI {

	List<Product> getAllProducts();

	Product getProductById(int pId);

	void showAllProducts(List<Product> productList);

	boolean insertProduct(Product product);

	boolean updateProduct(Product product);

	boolean removeProductById(int pId);

	List<Product> getProductsByCategory(String category);

	Product getIDByProductName(String pName);

}
