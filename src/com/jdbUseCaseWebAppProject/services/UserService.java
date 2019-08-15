package com.jdbUseCaseWebAppProject.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.jdbUseCaseWebAppProject.daoi.UserDAOI;
import com.jdbUseCaseWebAppProject.entities.Product;
import com.jdbUseCaseWebAppProject.entities.User;



public class UserService implements UserDAOI{

	@Override
	public boolean insertUser(User user) {
		boolean result = true;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			entitymanager.getTransaction().begin();
			entitymanager.persist(user);
			entitymanager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.getMessage();
			result = false;
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		return result;
	}

	@Override
	public List<User> getAllUsers() {

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("GetAllUsers");

		List<User> userList = query.getResultList();

		entitymanager.close();
		entitymanagerfactory.close();
		return userList;
	}

	
	public boolean deletUserByuEmail(String uEmail) {
		boolean result = true;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();


		try {
			Query query = entitymanager.createNamedQuery("queryDeleteUserbyuEmail");
			query.setParameter("uEmail", uEmail);
			
		} catch(PersistenceException e) {
			e.getMessage();
		}
		finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		
	return result;
	}
	
	@Override
	public User getUserByEmail(String uEmail) {
		
		System.out.println("@@@ getUserByEmail:uEmail " + uEmail);
		User userFound = new User(uEmail, "password");

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {
			userFound = entitymanager.find(User.class, uEmail);
			if (userFound == null) {
				userFound = new User(uEmail, "password");
				return userFound;
			}
			System.out.println("@@@ getUserByEmail:userFound " + userFound );
		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		return userFound;

	}

	@Override
	public boolean addProductToUser(User user, int pId) {

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		System.out.println("registerProductToUser::clist::after " + user.toString());

		System.out.println("addProductToUser:user " + user);
		try {
			User userFound = entitymanager.find(User.class, user.getuEmail());	
			List<Product> cList = null;

			Product productFound = entitymanager.find(Product.class, pId);

			entitymanager.getTransaction().begin();
			List<Product> clist = userFound.getuProducts();
			clist.add(productFound);
			userFound.setuProducts(clist);

			entitymanager.getTransaction().commit();
			
		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}

		return true;

	}
	
	@Override
	public boolean removeProductFromUser(User user, int pId) {

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			User userFound = entitymanager.find(User.class, user.getuEmail());			
			Product productFound = entitymanager.find(Product.class, pId);

			entitymanager.getTransaction().begin();
			
			List<Product> clist = userFound.getuProducts();
			clist.remove(productFound);
			userFound.setuProducts(clist);
			entitymanager.getTransaction().commit();

		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		return true;
	}	
	
	
	@Override
	public boolean removeAllProductsFromUser(User user) {

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {
			User userFound = entitymanager.find(User.class, user.getuEmail());			

			entitymanager.getTransaction().begin();
			
			List<Product> clist = userFound.getuProducts();
		
				userFound.setuProducts(null);
			
			entitymanager.getTransaction().commit();

		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}

		return true;
	}	
	
	
	@Override
	public List<Product> getUserProducts(User user) {
		List<Product> productList = null;

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {
			
			User userFound = entitymanager.find(User.class, user.getuEmail());
			productList = userFound.getuProducts();
			
				System.out.println("getUserProducts::productList" + productList.size());
				
			if (productList == null) {
				System.out.println("No Classes found for you ...");
			} else {
				for (Product c : productList) {
					System.out.println(c.toString());
				}
			}

		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		return productList;

	}
	
@Override

	public boolean userExists(String uEmail) {
		boolean result = false;

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {
			User userFound = entitymanager.find(User.class, uEmail);

			if(userFound != null) {
				result = true;
			} 
		} catch (PersistenceException e) {
			e.getMessage();
			result = false;
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}

		return result;

	}


	@Override
	public boolean validateUser(String uEmail, String uPassword) {
		boolean result = true;

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {
			User userFound = entitymanager.find(User.class, uEmail);	

			if (userFound != null) {
				User user = getUserByEmail(uEmail);

				if((user.getuEmail().contentEquals(uEmail)) && (user.getuPassword().equals(uPassword))) {
					System.out.println("validateUser::email & password match");
					result = true;
				}
			}
		}
		catch (PersistenceException e) {
			e.getMessage();
			result = false;
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}

		return result;
	}

	@Override
	public User loginUser(String uEmail, String uPassword) {

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		User user = new User();

		try {
			User userFound = entitymanager.find(User.class, uEmail);
			user = userFound;

		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			if (user != null) {
				try {
					entitymanager.close();
					entitymanagerfactory.close();
				} catch (Exception e) {

				}
			}
		}

		return user;

	}


	@Override
	public boolean removeUserByEmail(String uEmail) {
		boolean result = true;

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();


		try {
			entitymanager.getTransaction().begin();
			User userFound = entitymanager.find(User.class, uEmail);

			entitymanager.remove(userFound);
			entitymanager.getTransaction().commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}

		return result;
	}


	@Override
	public boolean updateUser(User user) {
		boolean result = true;

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("UseCaseDB");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {
			entitymanager.getTransaction().begin();

			User userFound = entitymanager.find(User.class, user.getuEmail());

			userFound.setuEmail(user.getuEmail());
			userFound.setuFirstName(user.getuFirstName());
			userFound.setuLastName(user.getuLastName());
			userFound.setuPassword(user.getuPassword());

			entitymanager.getTransaction().commit();
		} catch(PersistenceException e) {
			e.printStackTrace();
			result = false;
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		return result;
	}

}
