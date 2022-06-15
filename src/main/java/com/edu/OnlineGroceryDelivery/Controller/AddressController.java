
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
	
	
	@GetMapping("/{custId}")
	
	public Address getAddressById(@PathVariable("custId") long custId) {
		return addressService.getAddressById(custId);
	}
	
	@PutMapping("/{custId}")
	
	public  Address updateAddress(@PathVariable("custId") long custId , @RequestBody Address address) {
		return addressService.updateAddress(custId,address);
	}
		
	@DeleteMapping("/{custId}") 
	public ResponseEntity<String>deleteAddress(@PathVariable("custId") long custId) {
		return new ResponseEntity<String> (addressService.deleteAddress(custId),HttpStatus.OK);


	}

}
