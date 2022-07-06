package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;
import java.util.Map;

import com.edu.OnlineGroceryDelivery.entity.Address;

public interface AddressService {

	Address saveAddress(Address address);

	List<Address> getAddressList();

	Address getAddressById(long id);

	Address updateAddress(long id, Address address);

	String deleteAddress(long id);

	List<Address> getAddressByCity(String city);

	List<Address> getAddressByStreetName(String streetName);

	List<Address> getAddressByPinCode(long pinCode);

	Map<Object, Object> getAddressGroupByCity();

}
