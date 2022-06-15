
package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.OnlineGroceryDelivery.Repository.AddressRepository;
import com.edu.OnlineGroceryDelivery.entity.Address;
import com.edu.OnlineGroceryDelivery.ResourceNotFoundException.*;

@Service
public class AddressServiceImpl implements AddressService {
	
	
	@Autowired
	
	AddressRepository addressRepository;
	
	
	


	public AddressServiceImpl(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}


	@Override
	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}

	
	@Override
	public Address getAddressById(long custId) {
		// TODO Auto-generated method stub
	
		
		Address address=new Address();
		
		address=addressRepository.findById(custId).orElseThrow(
				()-> new ResourceNotFoundException("Address" ,"custId",custId));
		return address;
	}

	@Override
	public Address updateAddress(long custId, Address address) {
		// TODO Auto-generated method stub
		Address addr=new Address();
		
		addr=addressRepository.findById(custId).orElseThrow(
				()-> new ResourceNotFoundException("Address" ,"custId",custId));
		
		addr.setHouseNo(address.getHouseNo());
		addr.setStreetName(address.getStreetName());
		addr.setCity(address.getCity());
		addr.setPinCode(address.getPinCode());
		addr.setCustomer(address.getCustomer());
		
		addressRepository.save(addr);
		return addr;
	}

	@Override
	public String deleteAddress(long custId) {
		// TODO Auto-generated method stub
		Address address=new Address();
		
		address=addressRepository.findById(custId).orElseThrow(
				()-> new ResourceNotFoundException("Address" ,"custId",custId));
		
		addressRepository.deleteById(custId);
		return "Record is Deleted Successfully";

		

	}

	@Override
	public List<Address> getAddressList() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();
	}
	}

