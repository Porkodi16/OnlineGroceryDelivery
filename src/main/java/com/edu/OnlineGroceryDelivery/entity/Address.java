

package com.edu.OnlineGroceryDelivery.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="AddressTbl")




public class Address  {
	
	

	
	@ManyToOne
	@JoinColumn(name="custId") 
		@JsonIgnoreProperties("address")
	private Customer customer;
	
	@Id
	
	private long id;
	private long houseNo;
	private String streetName;
	private String city;
	private long pinCode;
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
	
	
	
}
	
	
