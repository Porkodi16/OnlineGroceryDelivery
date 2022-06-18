package com.edu.OnlineGroceryDelivery.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edu.OnlineGroceryDelivery.entity.Customer;

public interface CustomerRepository  extends JpaRepository<Customer , Long>{


	Optional<Customer> findByEmail(String string);

	Optional<Customer> findBycontactNo(String string);

	@Query("select e from customerTbl c where c.firstName =:firstName") // jpQl 

	List<Customer> getCustomerByFirstName(String firstName);



}


