package com.jdbUseCaseWebAppProject.entities;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries ({
@NamedQuery (query="SELECT p FROM Product p", name="queryAllProducts"),
@NamedQuery(query="SELECT p FROM Product p WHERE p.pCategory = :category", name="queryProductsByCategory")
})

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column (updatable = false, nullable = false)
	private int pId;
	
	@Basic
	@Column
	private String pCategory;
	
	@Basic
	@Column
	private String pName;
	
	@Basic
	@Column
	private String pSize;
	
	@Basic
	@Column
	private String pWeight;
	
	@Basic
	@Column
	private String pServing;
	
	@Basic
	@Column
	private String pSummary;
	
	@Basic
	@Column(length=500)
	private String pDescription;
	
	@Basic
	@Column
	private double pPrice;
	

	@Basic
	@Column
    private String pImage;
	
		
	public Product() {
		super();
	}

	
	
	public Product(String pCategory, String pName, String pSize, String pWeight, String pServing,
			String pSummary, String pDescription, double pPrice) {
		super();
		this.pCategory = pCategory;
		this.pName = pName;
		this.pSize = pSize;
		this.pWeight = pWeight;
		this.pServing = pServing;
		this.pSummary = pSummary;
		this.pDescription = pDescription;
		this.pPrice = pPrice;
	}


	public Product(int pId, String pCategory, String pName, String pSize, String pWeight, String pServing,
			String pSummary, String pDescription, double pPrice) {
		super();
		this.pId = pId;
		this.pCategory = pCategory;
		this.pName = pName;
		this.pSize = pSize;
		this.pWeight = pWeight;
		this.pServing = pServing;
		this.pSummary = pSummary;
		this.pDescription = pDescription;
		this.pPrice = pPrice;
	}

	public int getpId() {
		return pId;
	}


	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public String getpWeight() {
		return pWeight;
	}

	public void setpWeight(String pWeight) {
		this.pWeight = pWeight;
	}

	public String getpServing() {
		return pServing;
	}

	public void setpServing(String pServing) {
		this.pServing = pServing;
	}

	public String getpSummary() {
		return pSummary;
	}

	public void setpSummary(String pSummary) {
		this.pSummary = pSummary;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}


	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}


	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}



	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pCategory=" + pCategory + ", pName=" + pName + ", pSize=" + pSize
				+ ", pWeight=" + pWeight + ", pServing=" + pServing + ", pSummary=" + pSummary + ", pDescription="
				+ pDescription + ", pPrice=" + pPrice + ", pImage=" + pImage + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pCategory == null) ? 0 : pCategory.hashCode());
		result = prime * result + ((pDescription == null) ? 0 : pDescription.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pServing == null) ? 0 : pServing.hashCode());
		result = prime * result + ((pSize == null) ? 0 : pSize.hashCode());
		result = prime * result + ((pSummary == null) ? 0 : pSummary.hashCode());
		result = prime * result + ((pWeight == null) ? 0 : pWeight.hashCode());
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
		Product other = (Product) obj;
		if (pCategory == null) {
			if (other.pCategory != null)
				return false;
		} else if (!pCategory.equals(other.pCategory))
			return false;
		if (pDescription == null) {
			if (other.pDescription != null)
				return false;
		} else if (!pDescription.equals(other.pDescription))
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (Double.doubleToLongBits(pPrice) != Double.doubleToLongBits(other.pPrice))
			return false;
		if (pServing == null) {
			if (other.pServing != null)
				return false;
		} else if (!pServing.equals(other.pServing))
			return false;
		if (pSize == null) {
			if (other.pSize != null)
				return false;
		} else if (!pSize.equals(other.pSize))
			return false;
		if (pSummary == null) {
			if (other.pSummary != null)
				return false;
		} else if (!pSummary.equals(other.pSummary))
			return false;
		if (pWeight == null) {
			if (other.pWeight != null)
				return false;
		} else if (!pWeight.equals(other.pWeight))
			return false;
		return true;
	}



	
}
