package com.jdbUseCaseWebAppProject.entities;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table
@NamedQueries ({
	@NamedQuery(query="SELECT u FROM User u", name="GetAllUsers"),
	@NamedQuery(query="DELETE FROM User u WHERE u.uEmail = :uEmail", name="queryDeleteUserbyuEmail"),
})
public class User {
	
	@Id
	@Column(name="email")
    @Email(message = "Invalid email! Please enter valid email")
    @NotNull(message = "is required")
	private String uEmail;
	
	@Basic
	@Column(name="firstName")
    @Size(min=4, max=10 , message = "First name is required")
    @NotNull(message = "First name is required")
	private String uFirstName;
	
	@Basic
	@Column(name="lastName")
    @Size(min=4, max=10 , message = "First name length must be between {2} and {1}")
    @NotNull(message = "Last Name is required")
	private String uLastName;
	
	@Basic
	@Column(name="password" , nullable=false)
	@Size(min = 1, max = 20, message = "First name length must be between {2} and {1}")
	@NotEmpty(message="Please Enter your password")
	private String uPassword;

	@OneToMany
	private List<Product> uProducts;
 
	public User() {
		super();
	}
	 
	
	public User(String uEmail, String uPassword) {
		super();
		this.uEmail = uEmail;
		this.uPassword = uPassword;
	}
	
	public User(String uFirstName, String uLirstName, String uEmail, String uPassword) {
		super();
		this.uEmail = uEmail;
		this.uFirstName = uFirstName;
		this.uLastName = uLirstName;
		this.uPassword = uPassword;
	}
	
	public String getuEmail() {
		return uEmail;
	}


	
	public String getuFirstName() {
		return uFirstName;
	}


	public void setuFirstName(String uFirstName) {
		this.uFirstName = uFirstName;
	}


	public String getuLastName() {
		return uLastName;
	}


	public void setuLastName(String uLastName) {
		this.uLastName = uLastName;
	}


	public String getuPassword() {
		return uPassword;
	}


	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}


	public List<Product> getuProducts() {
		return uProducts;
	}


	public void setuProducts(List<Product> uProducts) {
		this.uProducts = uProducts;
	}


	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uEmail == null) ? 0 : uEmail.hashCode());
		result = prime * result + ((uFirstName == null) ? 0 : uFirstName.hashCode());
		result = prime * result + ((uLastName == null) ? 0 : uLastName.hashCode());
		result = prime * result + ((uPassword == null) ? 0 : uPassword.hashCode());
		result = prime * result + ((uProducts == null) ? 0 : uProducts.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (uEmail == null) {
			if (other.uEmail != null)
				return false;
		} else if (!uEmail.equals(other.uEmail))
			return false;
		if (uFirstName == null) {
			if (other.uFirstName != null)
				return false;
		} else if (!uFirstName.equals(other.uFirstName))
			return false;
		if (uLastName == null) {
			if (other.uLastName != null)
				return false;
		} else if (!uLastName.equals(other.uLastName))
			return false;
		if (uPassword == null) {
			if (other.uPassword != null)
				return false;
		} else if (!uPassword.equals(other.uPassword))
			return false;
		if (uProducts == null) {
			if (other.uProducts != null)
				return false;
		} else if (!uProducts.equals(other.uProducts))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [uEmail=" + uEmail + ", uFirstName=" + uFirstName + ", uLastName=" + uLastName + ", uPassword="
				+ uPassword + ", uProducts=" + uProducts + "]";
	}



}
