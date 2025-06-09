package com.webeng.assignment2.service;

import com.webeng.assignment2.model.Product;

public interface ProductService {
    public abstract void addProduct(Product product);
    public abstract void updateProduct(int id, Product product);
    public abstract void deleteProduct(int id);
    public abstract Iterable<Product> getAllProducts();
}
