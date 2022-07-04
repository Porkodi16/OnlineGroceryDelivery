package com.edu.OnlineGroceryDelivery.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.OnlineGroceryDelivery.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	Optional<Order> findByPaymentMode(String string);

	Optional<Order> findByOrderId(long l);

	
	@Query("select o from Order  o where o.paymentMode =:paymentMode")
	List<Order> getOrderByPaymentMode(@Param("paymentMode")String paymentMode);



}
