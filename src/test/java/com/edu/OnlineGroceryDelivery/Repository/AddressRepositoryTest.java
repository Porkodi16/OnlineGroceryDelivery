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

import com.edu.OnlineGroceryDelivery.entity.Address;
import com.edu.OnlineGroceryDelivery.Repository.AddressRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)


public class AddressRepositoryTest {

	@Autowired
	private AddressRepository addressRepository;
	
	
	
@Test
public void saveAddressTest() {/// testcase 
		
		Address address = addressRepository.save(new Address( 4,10,"Sea Area","Chennai",603451));
		
	
        Assertions.assertThat(address.getId()).isGreaterThan(0);
        // if id is greater than 0 
    	
    }



@Test
public void getAddessTest() {
	Address address = addressRepository.findById(4L).get();
	
	Assertions.assertThat(address.getId()).isEqualTo(4L);

}

@Test
public void getAddressListTest() {
	List<Address> add = addressRepository.findAll();
	
	Assertions.assertThat(add.size()).isGreaterThan(0);

}
	
	@Test
	public void updateAddressTest() {
		Address address = addressRepository.findById(3L).get();
		
		address.setStreetName("Ganga");
				
		
		Address updated = addressRepository.save(address); 
		
		
		Assertions.assertThat(updated.getStreetName()).isEqualTo("Ganga");



}



@Test

public void deleteAddressTest() {
	Address addre = addressRepository.findById(6L).get();
	addressRepository.delete(addre);
	
	Address address =null;
	Optional<Address> add1 = addressRepository.findByStreetName("Sea Area");
	if(add1.isPresent()) {
		address = add1.get();// null
	}
	
	Assertions.assertThat(add1).isNull();
	
}
	
	
}
	