package com.webeng.assignment2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webeng.assignment2.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
    
}
