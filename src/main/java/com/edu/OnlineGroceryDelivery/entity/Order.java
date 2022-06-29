
package com.edu.OnlineGroceryDelivery.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity

@Table(name="OrderTbl")

public class Order  implements Serializable {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)	

	private long orderId;
	private long overallTotal;
	@NotBlank(message="PaymentMode is Mandatory")
	private String paymentMode;
	private long productCount;
	
	@ManyToOne
	@JoinColumn( name="custId")//,insertable=false,updatable=false)
	@JsonIgnoreProperties("order")
	private Customer customer;
	
	
	@ManyToMany
	@JsonIgnoreProperties("order")
	private List<Products> products;


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public long getOverallTotal() {
		return overallTotal;
	}


	public void setOverallTotal(long overallTotal) {
		this.overallTotal = overallTotal;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}


	public long getProductCount() {
		return productCount;
	}


	public void setProductCount(long productCount) {
		this.productCount = productCount;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", overallTotal=" + overallTotal + ", paymentMode=" + paymentMode
				+ ", productCount=" + productCount + ", customer=" + customer + ", products=" + products + "]";
	}


	public Order(long orderId, long overallTotal, String paymentMode, long productCount) {
		super();
		this.orderId = orderId;
		this.overallTotal = overallTotal;
		this.paymentMode = paymentMode;
		this.productCount = productCount;
	}


	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Products> getProducts() {
		return products;
	}


	public void setProducts(List<Products> products) {
		this.products = products;
	}


	public Order(long orderId, long overallTotal, String paymentMode, long productCount, Customer customer,
			List<Products> products) {
		super();
		this.orderId = orderId;
		this.overallTotal = overallTotal;
		this.paymentMode = paymentMode;
		this.productCount = productCount;
		this.customer = customer;
		this.products = products;
	}

}
	

