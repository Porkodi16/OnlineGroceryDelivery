package com.edu.OnlineGroceryDelivery.ServiceTests;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.OnlineGroceryDelivery.Exception.GivenIdNotFoundException;
import com.edu.OnlineGroceryDelivery.Exception.NoRecordFoundException;
import com.edu.OnlineGroceryDelivery.Exception.RecordAlreadyExistException;
import com.edu.OnlineGroceryDelivery.Repository.CustomerRepository;
import com.edu.OnlineGroceryDelivery.Service.CustomerServiceImpl;
import com.edu.OnlineGroceryDelivery.entity.Customer;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;



@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	
	@Autowired
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	
	private Customer customer1;
	private Customer  customer2;
	List<Customer> customerList;
	
	// Method to execute before each testcase execution
		// Before each testcase
		@BeforeEach
		public void setUp() {
			customerList = new ArrayList<>();
			
			customer1 = new Customer(100,"Sakthi" , "sakthi@gmail.com");
			customer2 = new Customer(101,"Keerthy","keerthy@gmail.com");
			
	       customerList.add(customer1);
	       customerList.add(customer2);
		}
		
		// Method to execute after each testcase execution

		@AfterEach
		public void afterTest() {
			customer1 = customer2= null;
			customerList = null;
		}
		
		// To test saveCustomer() method
		@DisplayName("Test for saveCustomer() method")
		@Test
		public void givenCustomerToAddShouldReturnAddedCustomer() {
			
			when(customerRepository.save(customer1)).thenReturn(customer1);
			
			// when - behaviour that we are going test
			
			Customer savedCustomer = customerService.saveCustomer(customer1);
			
			System.out.println(savedCustomer);
			assertThat(savedCustomer).isNotNull();
			
		}
		
		// To test saveCustomer() method throws exception if given Record is already exist 
	    @Test
	    public void givenExistingIdWhenSaveCustomerThenThrowsException(){
	    	
	    	Customer customer = new Customer(100,"Sakthi" , "sakthi@gmail.com");
	    	
	        when(customerRepository.findById(customer.getCustId()))
	                .thenReturn(Optional.of(customer));
	        
	        
	       org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> {
	            customerService.saveCustomer(customer);
	        });
	       
	    } 
	       
	    
	 // To Test getCustomerList() method
		@Test
		public void givenGetAllCustomersShouldReturnListOfAllCustomers()throws NoRecordFoundException {
			
			customerRepository.saveAll(customerList);
			
			when(customerRepository.findAll()).thenReturn(customerList);
			
			List<Customer> actualCustomerList = customerService.getCustomerList();
			
			assertThat(actualCustomerList).isEqualTo(customerList);
		}
		
		@Test
		public void givenIdThenShouldReturnEmployeeOfThatId() throws GivenIdNotFoundException{
			
			when(customerRepository.findById(100L)).thenReturn(Optional.ofNullable(customer1));
			assertThat(customerService.getCustomerById(customer1.getCustId())).isEqualTo(customer1);
			
		}
		
		
		@Test
		public void givenIdToDeleteThenShouldDeleteCustomerOfThatId() {
			when(customerRepository.findById(customer1.getCustId())).thenReturn(Optional.ofNullable(customer1));
			
	        assertThat(customerService.deleteCustomer(customer1.getCustId())).isEqualTo("Record is Deleted Successfully");
		}
		
		
		@Test
		
		public void  givenIdToDeleteNotExistThenThrowsException() {
			long custId = 4L;
			org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () ->  {
				customerService.deleteCustomer(custId);
			});
		}
		
		
		
	   @DisplayName("JUnit test for UpdateCustomer method")
	    @Test
	    public void givenCustomerObject_whenUpdateCustomer_thenReturnUpdatedCustomer(){
	    	long custId = 100L;
	        when(customerRepository.save(customer1)).thenReturn(customer1);
	        when(customerRepository.findById(custId)).thenReturn(Optional.of(customer1));
	        customer1.setEmail("sri@gmail.com");
	        customer1.setFirstName("Rudhra");
	        Customer updatedCustomer = customerService.updateCustomer(custId, customer1);

	        assertThat(updatedCustomer.getEmail()).isEqualTo("sri@gmail.com");
	      assertThat(updatedCustomer.getFirstName()).isEqualTo("Rudhra");
	      
			System.out.println(updatedCustomer);
			assertThat(updatedCustomer).isNotNull();

	    }
	    
	    @Test
		public void givenIdToUpdateNotExistThenThrowsException()  {
			long custId = 4L;
			Customer customer = new Customer();
			customer1.setEmail("sri@gmail.com");
	       customer1.setFirstName("Rudhra");
	        
		    org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () -> {
	        customerService.updateCustomer(custId, customer);
	});

	
	    }
	    
}

		
		
		
		
		
		
