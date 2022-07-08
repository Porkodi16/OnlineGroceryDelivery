
package com.edu.OnlineGroceryDelivery.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.OnlineGroceryDelivery.Service.OrderService;
import com.edu.OnlineGroceryDelivery.entity.Customer;
import com.edu.OnlineGroceryDelivery.entity.Order;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	
	OrderService orderService;

	
	@PostMapping
	
	public ResponseEntity<Order> saveOrder( @Valid @RequestBody Order order) {
		return new ResponseEntity<Order> (orderService.saveOrder(order) , HttpStatus.CREATED);
	}
	
	@GetMapping
	
	public List<Order> getOrderList() {
		return orderService.getOrderList();
	}
	
	
	@GetMapping("/{orderId}")
	
	public Order getOrderById(@PathVariable("orderId") long orderId) {
		return orderService.getOrderById(orderId);
	}
	
	@PutMapping("/{orderId}")
	
	public  Order updateOrder(@PathVariable("orderId") long orderId , @RequestBody Order order) {
		return orderService.updateOrder(orderId,order);
	}
		
	@DeleteMapping("/{orderId}") 
	public ResponseEntity<String>deleteOrder(@PathVariable("orderId") long orderId) {
		return new ResponseEntity<String> (orderService.deleteOrder(orderId),HttpStatus.OK);

	}
	
	@GetMapping("/GetByPaymentMode/{paymentMode}")
	public List<Order> getOrderByPaymentMode(@PathVariable("paymentMode") String paymentMode) {
		return  orderService.getOrderByPaymentMode(paymentMode);

	}
}


	


