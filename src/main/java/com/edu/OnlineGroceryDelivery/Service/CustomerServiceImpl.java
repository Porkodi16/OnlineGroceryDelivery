package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.OnlineGroceryDelivery.Exception.GivenIdNotFoundException;
import com.edu.OnlineGroceryDelivery.Exception.NoRecordFoundException;
import com.edu.OnlineGroceryDelivery.Exception.ResourceNotFoundException;
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
	
	//return customerRepository.findAll();

}

@Override
public Customer getCustomerById(long custId) {
	
	/*Customer customer=new Customer();
	
	customer=customerRepository.findById(custId).orElseThrow(
			()-> new ResourceNotFoundException("Customer" ,"custId" ,custId));
	
	
	return customer;

}*/
	
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





	

}




