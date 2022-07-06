package com.edu.OnlineGroceryDelivery.ServiceTests;



import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.OnlineGroceryDelivery.Exception.GivenIdNotFoundException;
import com.edu.OnlineGroceryDelivery.Exception.NoAddressFoundException;
import com.edu.OnlineGroceryDelivery.Exception.NoRecordFoundException;
import com.edu.OnlineGroceryDelivery.Exception.RecordAlreadyExistException;
import com.edu.OnlineGroceryDelivery.Repository.AddressRepository;
import com.edu.OnlineGroceryDelivery.Service.AddressServiceImpl;
import com.edu.OnlineGroceryDelivery.entity.Address;

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
public class AddressServiceTest {
	
	@Mock
	private AddressRepository addressRepository;
	
	
	@Autowired
	@InjectMocks
	private AddressServiceImpl addressService;
	
	
	private Address address1;
	private Address  address2;
	List<Address> addressList;
	
	// Method to execute before each testcase execution
		// Before each testcase
		@BeforeEach
		public void setUp() {
			addressList = new ArrayList<>();
			
			address1 = new Address(400,289,"Kolkata");
			address2 = new  Address(401,902,"Gujarat");
			
	       addressList.add(address1);
	       addressList.add(address2);
		}
		
		// Method to execute after each testcase execution

		@AfterEach
		public void afterTest() {
			address1 =address2= null;
			addressList = null;
		}
		
		// To test saveAddress() method
		@DisplayName("Test for saveAddress() method")
		@Test
		public void givenAddressToAddShouldReturnAddedAddress() {
			
			when(addressRepository.save(address1)).thenReturn(address1);
			
			// when - behaviour that we are going test
			
			Address savedAddress = addressService.saveAddress(address1);
			
			System.out.println(savedAddress);
			assertThat(savedAddress).isNotNull();
			
		}
		
		// To test saveAddress() method throws exception if given Record is already exist 
	    @Test
	    public void givenExistingIdWhenSaveAddressThenThrowsException(){
	    	
	    	Address address = new Address(400,289,"Kolkata");
	    	
	        when(addressRepository.findById(address.getId()))
	                .thenReturn(Optional.of(address));
	        
	        
	       org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> {
	            addressService.saveAddress(address);
	        });
	       
	    } 
	       
	    
	 // To Test getAddressList() method
		@Test
		public void givenGetAllAddressShouldReturnListOfAllAddress()throws NoRecordFoundException {
			
			addressRepository.saveAll(addressList);
			
			when(addressRepository.findAll()).thenReturn(addressList);
			
			List<Address> actualAddressList = addressService.getAddressList();
			
			assertThat(actualAddressList).isEqualTo(addressList);
		}
		
		@Test
		public void givenIdThenShouldReturnAddressOfThatId() throws GivenIdNotFoundException{
			
			when(addressRepository.findById(400L)).thenReturn(Optional.ofNullable(address1));
			assertThat(addressService.getAddressById(address1.getId())).isEqualTo(address1);
			
		}
		
		
		@Test
		public void givenIdToDeleteThenShouldDeleteAddressOfThatId() {
			when(addressRepository.findById(address1.getId())).thenReturn(Optional.ofNullable(address1));
			
	        assertThat(addressService.deleteAddress(address1.getId())).isEqualTo(" Address Record is Deleted Successfully");
		}
		
		
		@Test
		
		public void  givenIdToDeleteNotExistThenThrowsException() {
			long id = 5L;
			org.junit.jupiter.api.Assertions.assertThrows(NoAddressFoundException.class, () ->  {
				addressService.deleteAddress(id);
			});
		}
		
		
		
	   @DisplayName("JUnit test for UpdateAddress method")
	    @Test
	    public void givenAddressObject_whenUpdateAddress_thenReturnUpdatedAddress(){
	    	long id = 400L;
	        when(addressRepository.save(address1)).thenReturn(address1);
	        when(addressRepository.findById(id)).thenReturn(Optional.of(address1));
	        address1.setCity("Bangalore");
	        Address updatedAddress = addressService.updateAddress(id, address1);

	        assertThat(updatedAddress.getCity()).isEqualTo("Bangalore");
	      
			System.out.println(updatedAddress);
			assertThat(updatedAddress).isNotNull();

	    }
	    
	    @Test
		public void givenIdToUpdateNotExistThenThrowsException()  {
			long id = 5L;
			Address address = new Address();
			address1.setCity("Bangalore");
	        
		    org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () -> {
	        addressService.updateAddress(id, address);
	});

	
	    }
	    
}

		
		
		
		
		
		
