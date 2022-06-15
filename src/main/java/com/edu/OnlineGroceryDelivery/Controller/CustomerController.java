
package com.edu.OnlineGroceryDelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.OnlineGroceryDelivery.Service.CustomerService;
import com.edu.OnlineGroceryDelivery.entity.Customer;

@RestController
@RequestMapping("/api/customer")

public class CustomerController {
	
	@Autowired
	
	CustomerService customerService;
	
	

	
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@PostMapping
	
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer> (customerService.saveCustomer(customer) , HttpStatus.CREATED);
	}
	
	@GetMapping
	
	public List<Customer> getCustomerList() {
		return customerService.getCustomerList();
	}
	
	@GetMapping("/{custId}")
	
	public Customer getCustomerById(@PathVariable("custId") long custId) {
		return customerService.getCustomerById(custId);
	}
	
	@PutMapping("/{custId}")
	
	public  Customer updateCustomer(@PathVariable("custId") long custId , @RequestBody Customer customer) {
		return customerService.updateCustomer(custId,customer);
	}
		
	@DeleteMapping("/{custId}") 
	public ResponseEntity<String>deleteCustomer(@PathVariable("custId") long custId) {
		return new ResponseEntity<String> (customerService.deleteCustomer(custId),HttpStatus.OK);
	
	}

	
	}
	


