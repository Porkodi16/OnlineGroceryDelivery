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

import com.edu.OnlineGroceryDelivery.entity.Products;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)


public class ProductsRepositoryTest {

	@Autowired
	private ProductsRepository productsRepository;
	
	
	
 @Test
public void saveProductsTest() {/// testcase 
		
		Products products = productsRepository.save(new Products(35, "DryFruits","Fruits",200,1));
		
	
        Assertions.assertThat(products.getProductId()).isGreaterThan(0);
        // if id is greater than 0 
    	
    }



@Test
public void getProductsTest() {
	Products products= productsRepository.findById(31L).get();
	
	Assertions.assertThat(products.getProductId()).isEqualTo(31L);

}

@Test
public void getProductsListTest() {
	List<Products> pr = productsRepository.findAll();
	
	Assertions.assertThat(pr.size()).isGreaterThan(0);

}
@Test
public void updateProductsTest() {
	Products products = productsRepository.findById(30L).get();
	
	products.setProductName("Kiwi");
	
	Products updated = productsRepository.save(products); 
	
	
	Assertions.assertThat(updated.getProductName()).isEqualTo("Kiwi");

	
}


@Test

public void deleteProductsTest() {
	Products prod= productsRepository.findById(89L).get();
	productsRepository.delete(prod);
	
	Products products =null;
	Optional<Products> pr1 = productsRepository.findByProductName("Cherry");

	if(pr1.isPresent()) {
		products = pr1.get();// null
	}
	
	Assertions.assertThat(products).isNull();
	
}
	
	}

