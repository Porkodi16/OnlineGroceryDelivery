package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.OnlineGroceryDelivery.Exception.GivenIdNotFoundException;
import com.edu.OnlineGroceryDelivery.Exception.NameNotFoundException;
import com.edu.OnlineGroceryDelivery.Exception.NoRecordFoundException;
import com.edu.OnlineGroceryDelivery.Repository.CustomerRepository;
import com.edu.OnlineGroceryDelivery.entity.Customer;

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
	List<Customer> custom=customerRepository.findAll();
	
	if (custom.isEmpty())
		throw new NoRecordFoundException();
	else
		return custom;
	

}

@Override
public Customer getCustomerById(long custId) {
	
	
	Optional<Customer> customer=customerRepository.findById(custId);
	if(customer.isPresent()) {
		return  customer.get();
	}
	
	else {
		throw new GivenIdNotFoundException();
	}
	}
	



@Override
public Customer updateCustomer(long custId, Customer customer) {
	
	
	Customer cust=new Customer();
	cust=customerRepository.findById(custId).orElseThrow (
		()-> new NoRecordFoundException());
	
	
	
	
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
			()->new NoRecordFoundException());
	
	customerRepository.deleteById(custId);
	return "Record is Deleted Successfully";
}


@Override
public List<Customer> getCustomerByFirstName(String firstName) {
	// TODO Auto-generated method stub
	
	List<Customer> customer=customerRepository.getCustomerByFirstName(firstName);
	if(customer.isEmpty())
	{
		throw new NameNotFoundException();
	}
	else
	{
		return customer;
	}
}

@Override
public List<Customer> getCustomerByLastName(String lastName) {
	// TODO Auto-generated method stub
	
	List<Customer> customer =customerRepository.getCustomerByLastName(lastName);
	if(customer.isEmpty())
	{
		throw new NameNotFoundException();

	}
	else
	{
	
return customer;
	}
}

@Override
public List<Customer> getCustomerByEmail(String email) {
	// TODO Auto-generated method stub
			return customerRepository.getCustomerByEmail(email);

}

@Override
public List<Customer> getCustomerByContactNo(String contactNo) {
	// TODO Auto-generated method stub
	return customerRepository.getCustomerByContactNo(contactNo);
}


	
}








