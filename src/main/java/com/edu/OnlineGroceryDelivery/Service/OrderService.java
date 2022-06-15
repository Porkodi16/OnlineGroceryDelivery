package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;

import com.edu.OnlineGroceryDelivery.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);

	List<Order> getOrderList();

	Order getOrderById(long orderId);

	Order updateOrder(long orderId, Order order);

	String deleteOrder(long orderId);

}
