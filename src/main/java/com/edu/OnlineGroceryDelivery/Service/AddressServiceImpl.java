
package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.OnlineGroceryDelivery.Exception.*;
import com.edu.OnlineGroceryDelivery.Repository.AddressRepository;
import com.edu.OnlineGroceryDelivery.entity.Address;
import com.edu.OnlineGroceryDelivery.entity.Customer;

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
	public Address getAddressById(long id) {
		// TODO Auto-generated method stub
	
		
	/*	Address address=new Address();
		
		address=addressRepository.findById(custId).orElseThrow(
				()-> new ResourceNotFoundException("Address" ,"custId",custId));
		return address;
	}*/
		Optional<Address> address=addressRepository.findById(id);
		if(address.isPresent()) {
			return  address.get();
		}
		
		else {
			throw new GivenIdNotFoundException();
		}
		}


	@Override
	public Address updateAddress(long id, Address address) {
		// TODO Auto-generated method stub
		
		Address addr=new Address();
		
		addr=addressRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Address" ,"id",id));
		
		addr.setId(address.getId());
		addr.setHouseNo(address.getHouseNo());
		addr.setStreetName(address.getStreetName());
		addr.setCity(address.getCity());
		addr.setPinCode(address.getPinCode());
		addr.setCustomer(address.getCustomer());
		
		addressRepository.save(addr);
		return addr;
	}

	@Override
	public String deleteAddress(long id) {
		// TODO Auto-generated method stub
		Address address=new Address();
		
		address=addressRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Address" ,"id",id));
		
		addressRepository.deleteById(id);
		return "Record is Deleted Successfully";

		

	}

	@Override
	public List<Address> getAddressList() {
		// TODO Auto-generated method stub
		
		
		List<Address> add=addressRepository.findAll();
		
		if (add.isEmpty())
			throw new NoRecordFoundException();
		else
			return add;

	//	return addressRepository.findAll();
	}
	}

