package com.edu.OnlineGroceryDelivery.Repository;



import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.OnlineGroceryDelivery.entity.Customer;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	
@Test
public void saveCustomerTest() {/// testcase 
		
		Customer customer= customerRepository.save(new Customer(2, "jansi","rani","jansi@gmail.com","6574432145"));
		
	
        Assertions.assertThat(customer.getCustId()).isGreaterThan(0);
        // if id is greater than 0 
    	
    }



@Test
public void getCustomerTest() {
	Customer customer = customerRepository.findById(2L).get();
	
	Assertions.assertThat(customer.getCustId()).isEqualTo(2L);

}

@Test
public void getCustomerListTest() {
	List<Customer> custom = customerRepository.findAll();
	
	Assertions.assertThat(custom.size()).isGreaterThan(0);

}
@Test
public void updateCustomerTest() {
	Customer customer = customerRepository.findById(2L).get();
	
	customer.setEmail("ryan@gmail.com");
	
	Customer updated = customerRepository.save(customer); 
	
	
	Assertions.assertThat(updated.getEmail()).isEqualTo("ryan@gmail.com");

	
}

}