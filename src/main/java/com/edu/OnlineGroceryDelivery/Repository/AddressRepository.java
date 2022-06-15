package com.edu.OnlineGroceryDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.OnlineGroceryDelivery.entity.Address;

public interface AddressRepository extends JpaRepository <Address , Long> {

}
