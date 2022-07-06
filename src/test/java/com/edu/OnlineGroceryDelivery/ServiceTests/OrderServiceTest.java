
package com.edu.OnlineGroceryDelivery.ServiceTests;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.edu.OnlineGroceryDelivery.Exception.GivenIdNotFoundException;
import com.edu.OnlineGroceryDelivery.Exception.NoRecordFoundException;
import com.edu.OnlineGroceryDelivery.Exception.RecordAlreadyExistException;
import com.edu.OnlineGroceryDelivery.Repository.OrderRepository;
import com.edu.OnlineGroceryDelivery.Service.OrderServiceImpl;
import com.edu.OnlineGroceryDelivery.entity.Order;

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
public class OrderServiceTest {
	
	@Mock
	private OrderRepository orderRepository;
	
	
	@Autowired
	@InjectMocks
	private OrderServiceImpl orderService;
	
	
	private Order order1;
	private Order  order2;
	List<Order> orderList;
	
	// Method to execute before each testcase execution
		// Before each testcase
		@BeforeEach
		public void setUp() {
			orderList = new ArrayList<>();
			
			order1 = new Order(200,1000 , "UPI");
			order2 = new Order(201,2000,"Gpay");
			
	       orderList.add(order1);
	       orderList.add(order2);
		}
		
		// Method to execute after each testcase execution

		@AfterEach
		public void afterTest() {
			order1 = order2= null;
			orderList = null;
		}
		
		// To test saveOrder() method
		@DisplayName("Test for saveOrder() method")
		@Test
		public void givenOrderToAddShouldReturnAddedOrder() {
			
			when(orderRepository.save(order1)).thenReturn(order1);
			
			// when - behaviour that we are going test
			
			Order savedOrder = orderService.saveOrder(order1);
			
			System.out.println(savedOrder);
			assertThat(savedOrder).isNotNull();
			
		}
		
		// To test saveOrder() method throws exception if given Record is already exist 
	    @Test
	    public void givenExistingIdWhenSaveOrderThenThrowsException(){
	    	
	    	Order order = new Order(200,1000 , "UPI");
	    	
	        when(orderRepository.findById(order.getOrderId()))
	                .thenReturn(Optional.of(order));
	        
	        
	       org.junit.jupiter.api.Assertions.assertThrows(RecordAlreadyExistException.class, () -> {
	            orderService.saveOrder(order);
	        });
	       
	    } 
	       
	    
	 // To Test getOrderList() method
		@Test
		public void givenGetAllOrdersShouldReturnListOfAllOrders()throws NoRecordFoundException {
			
			orderRepository.saveAll(orderList);
			
			when(orderRepository.findAll()).thenReturn(orderList);
			
			List<Order> actualOrderList = orderService.getOrderList();
			
			assertThat(actualOrderList).isEqualTo(orderList);
		}
		
		@Test
		public void givenIdThenShouldReturnOrderOfThatId() throws GivenIdNotFoundException{
			
			when(orderRepository.findById(200L)).thenReturn(Optional.ofNullable(order1));
			assertThat(orderService.getOrderById(order1.getOrderId())).isEqualTo(order1);
			
		}
		
		
		@Test
		public void givenIdToDeleteThenShouldDeleteOrderOfThatId() {
			when(orderRepository.findById(order1.getOrderId())).thenReturn(Optional.ofNullable(order1));
			
	        assertThat(orderService.deleteOrder(order1.getOrderId())).isEqualTo("Record is Deleted Successfully");
		}
		
		
		@Test
		
		public void  givenIdToDeleteNotExistThenThrowsException() {
			long orderId = 4L;
			org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () ->  {
			orderService.deleteOrder(orderId);
			});
		}
		
		
		
	   @DisplayName("JUnit test for UpdateOrder Method")
	    @Test
	    public void givenOrderObject_whenUpdateOrder_thenReturnUpdatedOrder(){
	    	long orderId = 200L;
	        when(orderRepository.save(order1)).thenReturn(order1);
	        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order1));
	        order1.setPaymentMode("Gpay");
	        Order updatedOrder = orderService.updateOrder(orderId, order1);

	        assertThat(updatedOrder.getPaymentMode()).isEqualTo("Gpay");
	        
			System.out.println(updatedOrder);
			assertThat(updatedOrder).isNotNull();

	    }
	    
	    @Test
		public void givenIdToUpdateNotExistThenThrowsException()  {
			long orderId = 4L;
			Order order = new Order();
			order1.setPaymentMode("Gpay");
	        
		    org.junit.jupiter.api.Assertions.assertThrows(NoRecordFoundException.class, () -> {
	        orderService.updateOrder(orderId, order);
	});

	
	    }
	    
}

		
		
		
		
		
		
