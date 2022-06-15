package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;

import com.edu.OnlineGroceryDelivery.entity.Address;

public interface AddressService {

	Address saveAddress(Address address);

	List<Address> getAddressList();

	Address getAddressById(long custId);

	Address updateAddress(long custId, Address address);

	String deleteAddress(long custId);

}
