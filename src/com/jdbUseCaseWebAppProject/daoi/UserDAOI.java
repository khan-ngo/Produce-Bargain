package com.jdbUseCaseWebAppProject.daoi;

import java.util.List;

import com.jdbUseCaseWebAppProject.entities.Product;
import com.jdbUseCaseWebAppProject.entities.User;

public interface UserDAOI {

	List<User> getAllUsers();

	boolean insertUser(User user);

	User getUserByEmail(String uEmail);

	boolean validateUser(String uEmail, String uPassword);

	User loginUser(String uEmail, String uPassword);

	boolean removeUserByEmail(String uEmail);

	boolean updateUser(User user);

	boolean addProductToUser(User user, int pId);

	boolean removeProductFromUser(User user, int pId);

	List<Product> getUserProducts(User user);

	boolean removeAllProductsFromUser(User user);

	boolean userExists(String uEmail);

}
