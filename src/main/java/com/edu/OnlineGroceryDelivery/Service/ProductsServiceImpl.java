
package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.edu.OnlineGroceryDelivery.Repository.ProductsRepository;
import com.edu.OnlineGroceryDelivery.entity.Customer;
import com.edu.OnlineGroceryDelivery.entity.Products;
import com.edu.OnlineGroceryDelivery.ResourceNotFoundException.*;

@Service

public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	
	ProductsRepository productsRepository;
	
	



	public ProductsServiceImpl(ProductsRepository productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}

	@Override
	public Products saveProducts(Products products) {
		// TODO Auto-generated method stub
		return productsRepository.save(products);

		
	}

	@Override
	public Products getProductsById(long productId) {
		// TODO Auto-generated method stub
		
		Products products=new Products();
		
		products=productsRepository.findById(productId).orElseThrow(
				()-> new ResourceNotFoundException("Products" ,"productId" ,productId));
		
		
		return products;


		
	}

	@Override
	public List<Products> getProductsList() {
		// TODO Auto-generated method stub
		return productsRepository.findAll();
	}

	@Override
	public Products updateProducts(long productId, Products products) {
		// TODO Auto-generated method stub
		
		Products pro=new Products ();
		pro=productsRepository.findById(productId).orElseThrow (
			()-> new ResourceNotFoundException("Products" , "productId",productId));
		
		pro.setProductId(products.getProductId());
		pro.setProductName(products.getProductName());
		pro.setProductCategory(products.getProductCategory());
		pro.setProductPrice(products.getProductPrice());
		pro.setQuantity_of_Product(products.getQuantity_of_Product());
		

		return pro;
	}

	@Override
	public String deleteProducts(long productId) {
		// TODO Auto-generated method stub
		
		
		Products products = new Products();
		
		products=productsRepository.findById(productId).orElseThrow(
				()-> new ResourceNotFoundException("Products" ,"productId" ,productId));

		
		
		productsRepository.deleteById(productId);
		return "Record is Deleted Successfully";

	}

	
	

}
