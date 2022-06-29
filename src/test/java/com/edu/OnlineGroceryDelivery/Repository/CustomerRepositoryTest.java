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
		
		Customer customer= customerRepository.save(new Customer(3, "Rio","Ryan","ryan@gmail.com","7890012345"));
		
	
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
	Customer customer = customerRepository.findById(1L).get();
	
	customer.setEmail("prik@gmail.com");
	
	Customer updated = customerRepository.save(customer); 
	
	
	Assertions.assertThat(updated.getEmail()).isEqualTo("prik@gmail.com");

	
}
@Test 

public  void deleteCustomerTest() {
	Customer cus = customerRepository.findById(25L).get();
	customerRepository.delete(cus);
	
	Customer customer =null;
	Optional<Customer> cust1 = customerRepository.findBycontactNo("8907653421");
	if(cust1.isPresent()) {
		customer = cust1.get();// null
	}
	
	Assertions.assertThat(customer).isNull();
	


}
}