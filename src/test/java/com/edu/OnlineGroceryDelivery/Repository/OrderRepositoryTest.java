

package com.edu.OnlineGroceryDelivery.Repository;



import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.edu.OnlineGroceryDelivery.entity.Order;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback (false)
public class OrderRepositoryTest {


	@Autowired
	private OrderRepository orderRepository;
	
	
	
 @Test
public void saveOrderTest() {/// testcase 
		
		Order order= orderRepository.save(new Order(67,700,"Paytm",1));

		
		
	
        Assertions.assertThat(order.getOrderId()).isGreaterThan(0);
        // if id is greater than 0 
    	
    }



@Test
public void getOrderTest() {
	Order order = orderRepository.findById(72L).get();
	
	Assertions.assertThat(order.getOrderId()).isEqualTo(72L);

}

@Test
public void getOrderListTest() {
	List<Order> or = orderRepository.findAll();
	
	Assertions.assertThat(or.size()).isGreaterThan(0);

}
@Test
public void updateOrderTest() {
	Order order = orderRepository.findById(73L).get();
	
	order.setPaymentMode("Gpay");
	
	Order updated = orderRepository.save(order); 
	
	
	Assertions.assertThat(updated.getPaymentMode()).isEqualTo("Gpay");

	
}
 @Test 

public  void deleteOrderTest() {
	Order orde = orderRepository.findById(81L).get();
	orderRepository.delete(orde);
	
	Order order =null;
	Optional<Order> orde1 = orderRepository.findByPaymentMode("Prepaid Cards");
	if(orde1.isPresent()) {
		order = orde1.get();// null
	}
	
	Assertions.assertThat(order).isNull();
	


}
}