package com.edu.OnlineGroceryDelivery.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.edu.OnlineGroceryDelivery.entity.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer , Long>{


	Optional<Customer> findByEmail(String string);

	Optional<Customer> findBycontactNo(String string);
	
	@Query("select c from CustomerTbl c where c.firstName =:firstName") // jpQl 


	List<Customer> getCustomerByFirstName(@Param("firstName")String firstName);
	
	@Query("select c from CustomerTbl c where c.lastName =:lastName")

	List<Customer> getCustomerByLastName(@Param("lastName")String lastName);




}


