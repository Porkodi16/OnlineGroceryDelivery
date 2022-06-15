package com.edu.OnlineGroceryDelivery.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.OnlineGroceryDelivery.entity.Products;

public interface ProductsRepository  extends JpaRepository <Products, Long>{

}
