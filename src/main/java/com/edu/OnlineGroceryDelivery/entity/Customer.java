
package com.edu.OnlineGroceryDelivery.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="CustomerTbl")

public class Customer  {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)	
	
	
	
	private long custId;
	
	@NotNull
	@NotBlank(message="First Name is Mandatory")
	@Size(min=2 , max =5)
	private String firstName;
	@NotBlank(message="Last Name is Mandatory")
	private String lastName;
	@Column(nullable=false, unique= true)
	@NotBlank(message="Email is Mandatory")
	@Email(message="Invalid Email Id")
	private String email;
	@NotBlank(message="Contact Number is Mandatory")
	@Size(min=10 , max=15)
	private String contactNo;
	
	@OneToMany(mappedBy="customer" , cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("customer")
	private List<Address> address;
	
	
	@OneToMany(mappedBy="customer" , cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("customer")
	private List<Order>order;


	public long getCustId() {
		return custId;
	}


	public void setCustId(long custId) {
		this.custId = custId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public List<Order> getOrder() {
		return order;
	}


	public void setOrder(List<Order> order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", contactNo=" + contactNo + ", address=" + address + ", order=" + order + "]";
	}


	public Customer(long custId, String firstName, String lastName, String email, String contactNo) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		//this.address = d;
		//this.order = string;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}