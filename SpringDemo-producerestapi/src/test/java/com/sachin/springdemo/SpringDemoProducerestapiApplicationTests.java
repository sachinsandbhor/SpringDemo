package com.sachin.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.sachin.springdemo.entities.Product;

@SpringBootTest
class SpringDemoProducerestapiApplicationTests {
	
	@Value ("${productRestApi.services.url}")
	private String baseUrl;

	@Test
	void testGetProduct() {
		System.out.print(baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"/1", Product.class);
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
	}
	
	@Test
	public void createProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Samsung");
		product.setDescription("Samsung S3");
		product.setPrice(100000);
		
		Product newProduct = restTemplate.postForObject(baseUrl, product, Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("Samsung", product.getName());
	}
	
	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"/1", Product.class);
		product.setPrice(123456);
		restTemplate.put("http://localhost:8080/productapi/products", product);
	}

}
