
package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.OnlineGroceryDelivery.Repository.OrderRepository;
import com.edu.OnlineGroceryDelivery.entity.Order;
import com.edu.OnlineGroceryDelivery.ResourceNotFoundException.*;

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
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(long orderId) {
		// TODO Auto-generated method stub
		
		Order order=new Order();
		order =orderRepository.findById(orderId).orElseThrow (
				() -> new ResourceNotFoundException("Order","orderId" ,orderId));
		return order;
	}

	@Override
	public Order updateOrder(long orderId, Order order) {
		// TODO Auto-generated method stub
		
		Order ord=new Order();
		ord=orderRepository.findById(orderId).orElseThrow (
				() -> new ResourceNotFoundException("Order","orderId" ,orderId));
		
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
				() -> new ResourceNotFoundException("Order","orderId" ,orderId));

		orderRepository.deleteById(orderId);
		return "Record is Deleted Successfully";
	}
	
	

}
