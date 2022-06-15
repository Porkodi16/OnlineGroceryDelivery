package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;

import com.edu.OnlineGroceryDelivery.entity.Products;

public interface ProductsService {

	Products saveProducts(Products products);

	List<Products> getProductsList();

	Products getProductsById(long productId);

	Products updateProducts(long productId, Products products);

	String deleteProducts(long productId);

}
