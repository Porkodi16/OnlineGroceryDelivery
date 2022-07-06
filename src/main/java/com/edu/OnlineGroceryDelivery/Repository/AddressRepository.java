package com.edu.OnlineGroceryDelivery.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.OnlineGroceryDelivery.entity.Address;

public interface AddressRepository extends JpaRepository <Address , Long> {


	Optional<Address> findByHouseNo(long id);

		@Query("select a from Address a where a.city =:city")

	List<Address> getAddressByCity(@Param("city")String city);
		
		@Query("select a from Address a where a.streetName =:streetName")

		List<Address> getAddressByStreetName(@Param("streetName")String streetName);
		
		@Query("select a from Address a where a.pinCode =:pinCode")


		List<Address> getAddressByPinCode(@Param("pinCode")long pinCode);

		
		@Query ("select a.city , count(a.id) from Address a group by a.city")
		List<Object[]> getAddressGroupByCity();




}
