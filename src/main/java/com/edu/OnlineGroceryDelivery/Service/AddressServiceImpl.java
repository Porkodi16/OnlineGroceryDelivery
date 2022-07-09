
package com.edu.OnlineGroceryDelivery.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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




	@Override
	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		Optional<Address> add=addressRepository.findById(address.getId());
		if(!add.isPresent())
		return addressRepository.save(address);
		else
			throw new RecordAlreadyExistException();

		
		
	}

	
	@Override
	public Address getAddressById(long id) {
		// TODO Auto-generated method stub
	
		
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
				()-> new NoRecordFoundException());
		
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
				()-> new NoAddressFoundException());
		
		addressRepository.deleteById(id);
		return " Address Record is Deleted Successfully";

		

	}

	@Override
	public List<Address> getAddressList() {
		// TODO Auto-generated method stub
		
		
		List<Address> add=addressRepository.findAll();
		
		if (add.isEmpty())
			throw new NoRecordFoundException();
		else
			return add;

	}


	@Override
	public List<Address> getAddressByCity(String city) {
		// TODO Auto-generated method stub
		return addressRepository.getAddressByCity(city);
	}


	@Override
	public List<Address> getAddressByStreetName(String streetName) {
		// TODO Auto-generated method stub
		return addressRepository.getAddressByStreetName(streetName);
	}


	@Override
	public List<Address> getAddressByPinCode(long pinCode) {
		// TODO Auto-generated method stub
		return addressRepository.getAddressByPinCode(pinCode);
	}


	@Override
	public Map<Object, Object> getAddressGroupByCity() {
				List<Object[]> objects =  addressRepository.getAddressGroupByCity();
				
				Map<Object, Object> map = new HashMap<>();
				
				for(Object[] obj : objects) {
					map.put(obj[0], obj[1]);
				}
				return map;
			}

		
	}

