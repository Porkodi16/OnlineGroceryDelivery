
package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.OnlineGroceryDelivery.Exception.*;
import com.edu.OnlineGroceryDelivery.Repository.OrderRepository;
import com.edu.OnlineGroceryDelivery.entity.Order;

@Service
public class OrderServiceImpl  implements OrderService{
	
	@Autowired
	
	OrderRepository orderRepository;
	
	


	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrderList() {
		// TODO Auto-generated method stub
		List<Order> ord=orderRepository.findAll();
		
		if (ord.isEmpty())
			throw new NoRecordFoundException();
		else
			return ord;


	}

	@Override
	public Order getOrderById(long orderId) {
		// TODO Auto-generated method stub
		
	
		
		Optional<Order> order=orderRepository.findById(orderId);
		if(order.isPresent()) {
			return  order.get();
		}
		
		else {
			throw new GivenIdNotFoundException();
		}
		}

		
	

	@Override
	public Order updateOrder(long orderId, Order order) {
		// TODO Auto-generated method stub
		
		Order ord=new Order();
		ord=orderRepository.findById(orderId).orElseThrow (
				() -> new NoRecordFoundException());
		
		ord.setOrderId(order.getOrderId());
		ord.setOverallTotal(order.getOverallTotal());
		ord.setPaymentMode(order.getPaymentMode());
		ord.setProductCount(order.getProductCount());
		ord.setCustomer(order.getCustomer());
		
		orderRepository.save(ord);
		

		
		return ord;
	}

	@Override
	public String deleteOrder(long orderId) {
		// TODO Auto-generated method stub
		
		Order order=new Order();
		order =orderRepository.findById(orderId).orElseThrow (
				() -> new NoRecordFoundException());

		orderRepository.deleteById(orderId);
		return "Record is Deleted Successfully";
	}

	@Override
	public List<Order> getOrderByPaymentMode(String paymentMode) {
		// TODO Auto-generated method stub
		return orderRepository .getOrderByPaymentMode(paymentMode);
	
	}	

}
