

package com.edu.OnlineGroceryDelivery.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="AddressTbl")




public class Address  {
	
	

	
	
	@Id
	
	private long id;
	private long houseNo;
	@NotNull
	@NotBlank(message="Street Name is Mandatory")
	private String streetName;
	@NotBlank(message="City is Mandatory")
	private String city;	
	private long pinCode;
	
	
	
	@ManyToOne
	@JoinColumn(name="custId") 
	@JsonIgnoreProperties("address")
   private Customer customer;

	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(long houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPinCode() {
		return pinCode;
	}
	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [customer=" + customer + ", id=" + id + ", houseNo=" + houseNo + ", streetName=" + streetName
				+ ", city=" + city + ", pinCode=" + pinCode + "]";
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(long id, long houseNo, String streetName, String city, long pinCode) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.pinCode = pinCode;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Address(Customer customer, long id, long houseNo, String streetName, String city, long pinCode) {
		super();
		this.customer = customer;
		this.id = id;
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.city = city;
		this.pinCode = pinCode;
	}
	public Address(long id, long houseNo, @NotBlank(message = "City is Mandatory") String city) {
		super();
		this.id = id;
		this.houseNo = houseNo;
		this.city = city;
	}
	
	
	
}
	
	
