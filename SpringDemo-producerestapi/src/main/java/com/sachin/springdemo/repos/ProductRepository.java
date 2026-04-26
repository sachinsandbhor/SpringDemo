package com.sachin.springdemo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.springdemo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
