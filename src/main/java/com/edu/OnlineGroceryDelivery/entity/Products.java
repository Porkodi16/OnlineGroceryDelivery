
package com.edu.OnlineGroceryDelivery.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="ProductTbl" )

public class Products implements Serializable {
	
	@Id
	
	
	@GeneratedValue(generator = "seq" , strategy = GenerationType.AUTO)
	 @SequenceGenerator(name="seq" , initialValue = 1000)

	
	private long productId;
	@NotNull
	@NotBlank(message="Product Name is Mandatory")
	private String productName;
	private String productCategory;
	@NotNull
	@Range(min=20 , max=60000 , message="ProductPrice is mandatory")
	private float productPrice;
	private int quantity_of_Product;
	
	@ManyToMany(mappedBy="products" , cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("products")
	private List<Order>order;

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity_of_Product() {
		return quantity_of_Product;
	}

	public void setQuantity_of_Product(int quantity_of_Product) {
		this.quantity_of_Product = quantity_of_Product;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", quantity_of_Product=" + quantity_of_Product
				+ ", order=" + order + "]";
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(long productId, String productName, String productCategory, float productPrice,
			int quantity_of_Product) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.quantity_of_Product = quantity_of_Product;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public Products(long productId, String productName, String productCategory, float productPrice,
			int quantity_of_Product, List<Order> order) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.quantity_of_Product = quantity_of_Product;
		this.order = order;
	}
	
	
}

