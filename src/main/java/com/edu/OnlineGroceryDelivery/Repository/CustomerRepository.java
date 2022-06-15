package com.edu.OnlineGroceryDelivery.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.OnlineGroceryDelivery.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer , Long>{


	Optional<Customer> findByEmail(String string);



}


