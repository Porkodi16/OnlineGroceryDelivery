package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;

import com.edu.OnlineGroceryDelivery.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> getCustomerList();

	Customer getCustomerById(long custId);

	Customer updateCustomer(long custId, Customer customer);

	String deleteCustomer(long custId);


}
