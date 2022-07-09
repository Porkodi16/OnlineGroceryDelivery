
package com.edu.OnlineGroceryDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.edu.OnlineGroceryDelivery.Exception.*;
import com.edu.OnlineGroceryDelivery.Repository.ProductsRepository;
import com.edu.OnlineGroceryDelivery.entity.Customer;
import com.edu.OnlineGroceryDelivery.entity.Products;

@Service

public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	
	ProductsRepository productsRepository;




	@Override
	public Products saveProducts(Products products) {
		// TODO Auto-generated method stub
		Optional<Products> pro=productsRepository.findById(products.getProductId());
		if(!pro.isPresent())
		return productsRepository.save(products);
		else
			throw new RecordAlreadyExistException();

		//return productsRepository.save(products);

		
	}

	@Override
	public Products getProductsById(long productId) {
		// TODO Auto-generated method stub
		Optional<Products> products=productsRepository.findById(productId);
		if(products.isPresent()) {
			return  products.get();
		}
		
		else {
			throw new GivenIdNotFoundException();
		}
		}


		
	

	@Override
	public List<Products> getProductsList() {
		// TODO Auto-generated method stub
		
		List<Products> prod=productsRepository.findAll();
		
		if (prod.isEmpty())
			throw new NoProductsFoundException();
		else
			return prod;

	}

	@Override
	public Products updateProducts(long productId, Products products) {
		// TODO Auto-generated method stub
		
		Products pro=new Products ();
		pro=productsRepository.findById(productId).orElseThrow (
			()-> new NoRecordFoundException());
		
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
				()-> new NoProductsFoundException());

		
		
		productsRepository.deleteById(productId);
		return " Product Record is Deleted Successfully";

	}

	@Override
	public List<Products> getProductsByProductName(String productName) {
		// TODO Auto-generated method stub
		return productsRepository.getProductsByProductName(productName);
	}

	@Override
	public List<Products> getProductsByProductsCategory(String productCategory) {
		// TODO Auto-generated method stub
		return productsRepository.getProductsByProductCategory(productCategory);

	}

}
