
package com.edu.OnlineGroceryDelivery.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	public ResponseEntity<Customer> saveCustomer( @Valid @RequestBody Customer customer) {
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
	
	public  Customer updateCustomer( @PathVariable("custId") long custId , @Valid @RequestBody Customer customer) {
		return customerService.updateCustomer(custId,customer);
	}
		
	@DeleteMapping("/{custId}") 
	public ResponseEntity<String>deleteCustomer(@PathVariable("custId") long custId) {
		return new ResponseEntity<String> (customerService.deleteCustomer(custId),HttpStatus.OK);
	
	}
	
	
	@GetMapping("/GetByFirstName/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable("firstName")String firstName) {
		return customerService.getCustomerByFirstName(firstName);
	}
	
	@GetMapping("/GetByLastName/{lastName}")
	public List<Customer> getCustomerByLastName(@PathVariable("lastName")String lastName) {
		return customerService.getCustomerByLastName(lastName);
	}
	
	@GetMapping("GetByEmail/{email}")
	
	public List<Customer> getCustomerByEmail(@PathVariable ("email") String email) {
		return customerService.getCustomerByEmail(email);
	}
	
	@GetMapping("/GetByContactNo/{contactNo}")
	public List<Customer> getCustomerByContactNo(@PathVariable("contactNo") String contactNo) {
		return  customerService.getCustomerByContactNo(contactNo);
	}
	
	/*@GetMapping("/GetCustomerByOrderId/{orderId}")
	public List<Customer> getCustomerByOrderId(@PathVariable("orderId") long orderId) {
		return customerService.getCustomerByOrderId(orderId);
	}
*/
	}
	

	
	


