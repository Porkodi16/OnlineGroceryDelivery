
package com.edu.OnlineGroceryDelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.OnlineGroceryDelivery.Service.ProductsService;
import com.edu.OnlineGroceryDelivery.entity.Products;

@RestController
@RequestMapping("/api/products")

public class ProductsController {
	
	@Autowired
	ProductsService productsService;
	
	

	

	public ProductsController(ProductsService productsService) {
		super();
		this.productsService = productsService;
	}

	@PostMapping
	
	 	public ResponseEntity<Products> saveGroceryItem(@RequestBody Products products) {
		return new ResponseEntity<Products> (productsService.saveProducts(products) , HttpStatus.CREATED);
	}
	
	@GetMapping
	
	public List<Products> getProductsList() {
		return productsService.getProductsList();
	}
	
	@GetMapping("/{productId}")
	
	public Products getProductsById(@PathVariable("productId") long productId) {
		return productsService.getProductsById(productId);
	}
	
	@PutMapping("/{productId}")
	
	public  Products updateProducts(@PathVariable("productId") long productId , @RequestBody Products products) {
		return productsService.updateProducts(productId,products);
	}
		
	@DeleteMapping("/{productId}") 
	public ResponseEntity<String>deleteProducts(@PathVariable("productId") long productId) {
		return new ResponseEntity<String> (productsService.deleteProducts(productId),HttpStatus.OK);
	
	}




}
