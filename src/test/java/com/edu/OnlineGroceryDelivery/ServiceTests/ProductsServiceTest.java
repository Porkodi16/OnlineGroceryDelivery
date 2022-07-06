
package com.edu.OnlineGroceryDelivery.ServiceTests;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.OnlineGroceryDelivery.Exception.GivenIdNotFoundException;
import com.edu.OnlineGroceryDelivery.Exception.NoProductsFoundException;
import com.edu.OnlineGroceryDelivery.Exception.NoRecordFoundException;
import com.edu.OnlineGroceryDelivery.Exception.RecordAlreadyExistException;
import com.edu.OnlineGroceryDelivery.Repository.ProductsRepository;
import com.edu.OnlineGroceryDelivery.Service.ProductsServiceImpl;
import com.edu.OnlineGroceryDelivery.entity.Products;

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
public class ProductsServiceTest {
	
	@Mock
	private ProductsRepository productsRepository;
	
	
	@Autowired
	@InjectMocks
	private ProductsServiceImpl productsService;
	
	
	private Products products1;
	private Products  products2;
	List<Products> productsList;
	
	// Method to execute before each testcase execution
		// Before each testcase
		@BeforeEach
		public void setUp() {
			productsList = new ArrayList<>();
			
			products1 = new Products(300,"Mango" , 2);
			products2 = new Products(301,"Lemon", 3);

	       productsList.add(products1);
	       productsList.add(products2);
		}
		
		// Method to execute after each testcase execution

		@AfterEach
		public void afterTest() {
			products1 = products2= null;
			productsList = null;
		}
		
		// To test saveProducts() method
		@DisplayName("Test for saveProducts() method")
		@Test
		public void givenProductsToAddShouldReturnAddedProducts() {
			
			when(productsRepository.save(products1)).thenReturn(products1);
			
			// when - behaviour that we are going test
			
			Products savedProducts = productsService.saveProducts(products1);
			
			System.out.println(savedProducts);
			assertThat(savedProducts).isNotNull();
			
		}
		
		// To test saveProducts() method throws exception if given Record is already exist 
	    @Test
	    public void givenExistingIdWhenSaveProductsThenThrowsException(){
	    	
	    	Products products = new Products(300,"Mango" , 2);
	    	
	        when(productsRepository.findById(products.getProductId()))
	                .thenReturn(Optional.of(products));
	        
	        
	       org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> {
	            productsService.saveProducts(products);
	        });
	       
	    } 
	       
	    
	 // To Test getProductsList() method
		@Test
		public void givenGetAllProductssShouldReturnListOfAllProducts()throws NoRecordFoundException {
			
			productsRepository.saveAll(productsList);
			
			when(productsRepository.findAll()).thenReturn(productsList);
			
			List<Products> actualProductsList = productsService.getProductsList();
	
			assertThat(actualProductsList).isEqualTo(productsList);
		}
		
		@Test
		public void givenIdThenShouldReturnProductsOfThatId() throws GivenIdNotFoundException{
			
			when(productsRepository.findById(300L)).thenReturn(Optional.ofNullable(products1));
			assertThat(productsService.getProductsById(products1.getProductId())).isEqualTo(products1);
			
		}
		
		
		@Test
		public void givenIdToDeleteThenShouldDeleteProductsOfThatId() {
			when(productsRepository.findById(products1.getProductId())).thenReturn(Optional.ofNullable(products1));
			
	        assertThat(productsService.deleteProducts(products1.getProductId())).isEqualTo(" Product Record is Deleted Successfully");
		}
		
		
		@Test
		
		public void  givenIdToDeleteNotExistThenThrowsException() {
			long productId = 4L;
			org.junit.jupiter.api.Assertions.assertThrows(NoProductsFoundException.class, () ->  {
			productsService.deleteProducts(productId);
			});
		}
		
		   @DisplayName("JUnit test for UpdateProducts Method")
		    @Test
		    public void givenProductsObject_whenUpdateProducts_thenReturnUpdatedProducts(){
		    	long productId = 300L;
		        when(productsRepository.findById(productId)).thenReturn(Optional.of(products1));
		        products1.setProductName("Cherry");
		        Products updatedProducts = productsService.updateProducts(productId, products1);

		        assertThat(updatedProducts.getProductName()).isEqualTo("Cherry");
		        
				System.out.println(updatedProducts);
				assertThat(updatedProducts).isNotNull();
		   }
		
		
	    
	    @Test
		public void givenIdToUpdateNotExistThenThrowsException()  {
			long productId = 4L;
			Products products = new Products();
			products1.setProductName("Cherry");
	        
		    org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () -> {
	        productsService.updateProducts(productId, products);
	});

	
	    }
	    
}

		
		
		
		
		
		



