package com.edu.OnlineGroceryDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.OnlineGroceryDelivery.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
