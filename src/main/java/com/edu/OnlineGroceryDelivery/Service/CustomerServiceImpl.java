package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.OnlineGroceryDelivery.Repository.CustomerRepository;
import com.edu.OnlineGroceryDelivery.entity.Customer;
import com.edu.OnlineGroceryDelivery.ResourceNotFoundException.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	

public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

@Override
public Customer saveCustomer(Customer customer) {
	return customerRepository.save(customer);
}

@Override
public List<Customer> getCustomerList() {
	// TODO Auto-generated method stub
	return customerRepository.findAll();
}

@Override
public Customer getCustomerById(long custId) {
	
	Customer customer=new Customer();
	
	customer=customerRepository.findById(custId).orElseThrow(
			()-> new ResourceNotFoundException("Customer" ,"custId" ,custId));
	
	
	return customer;

}



@Override
public Customer updateCustomer(long custId, Customer customer) {
	
	
	Customer cust=new Customer();
	cust=customerRepository.findById(custId).orElseThrow (
		()-> new ResourceNotFoundException("Customer" , "custId",custId));
	
	
	cust.setCustId(customer.getCustId());
	cust.setFirstName(customer.getFirstName());
	cust.setLastName(customer.getLastName());
	cust.setEmail(customer.getEmail());
	cust.setContactNo(customer.getContactNo());
	cust.setAddress(customer.getAddress());
	cust.setOrder(customer.getOrder());
	
	
	customerRepository.save(cust);
		
	
	return cust;
}



@Override
public String deleteCustomer(long custId) {
	
	Customer customer=new Customer();
	customer=customerRepository.findById(custId).orElseThrow (
			()->new ResourceNotFoundException("Customer","custId", custId));
	
	customerRepository.deleteById(custId);
	return "Record is Deleted Successfully";
}

@Override
public List<Customer> getCustomerByFirstName(String firstName) {
	// TODO Auto-generated method stub
	return customerRepository.getCustomerByFirstName(firstName);
}




	

}




