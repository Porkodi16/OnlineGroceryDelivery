package com.edu.OnlineGroceryDelivery.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.OnlineGroceryDelivery.entity.Products;

public interface ProductsRepository  extends JpaRepository <Products, Long>{

	Optional<Products> findByProductName(String string);

	Optional<Products> findByProductId(long l);

}
