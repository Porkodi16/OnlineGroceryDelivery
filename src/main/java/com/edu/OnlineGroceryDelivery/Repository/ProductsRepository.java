package com.edu.OnlineGroceryDelivery.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.OnlineGroceryDelivery.entity.Products;

public interface ProductsRepository  extends JpaRepository <Products, Long>{

	Optional<Products> findByProductName(String string);

	Optional<Products> findByProductId(long l);
	
	@Query("select p from ProductTbl p where p.productName =:productName")

	List<Products> getProductsByProductName(@Param("productName")String productName);

}
