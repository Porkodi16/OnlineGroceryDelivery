
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

import com.edu.OnlineGroceryDelivery.Service.AddressService;
import com.edu.OnlineGroceryDelivery.entity.Address;
import com.edu.OnlineGroceryDelivery.entity.Customer;


@RestController
@RequestMapping("/api/address")

public class AddressController {
	
	@Autowired
	
	
	AddressService addressService;

	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	@PostMapping
	
	public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
		return new ResponseEntity<Address> (addressService.saveAddress(address) , HttpStatus.CREATED);
	}
	
	@GetMapping
	
	public List<Address> getAddressList() {
		return addressService.getAddressList();
	}
	
	
	@GetMapping("/{id}")
	
	public Address getAddressById(@PathVariable("id") long id) {
		return addressService.getAddressById(id);
	}
	
	@PutMapping("/{id}")
	
	public  Address updateAddress(@PathVariable("id") long id , @RequestBody Address address) {
		return addressService.updateAddress(id,address);
	}
		
	@DeleteMapping("/{id}") 
	public ResponseEntity<String>deleteAddress(@PathVariable("id") long id) {
		return new ResponseEntity<String> (addressService.deleteAddress(id),HttpStatus.OK);


	}

}
