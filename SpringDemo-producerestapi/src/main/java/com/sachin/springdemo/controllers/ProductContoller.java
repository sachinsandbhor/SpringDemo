package com.sachin.springdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.springdemo.entities.Product;
import com.sachin.springdemo.repos.ProductRepository;

@RestController
public class ProductContoller {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products/")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable("id")int productId) {
		return productRepository.findById(productId).get();
	}
	
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct(@PathVariable("id")int productId) {
		productRepository.deleteById(productId);
	}

}
