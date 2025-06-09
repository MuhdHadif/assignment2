package com.webeng.assignment2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webeng.assignment2.model.Product;
import com.webeng.assignment2.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }
    
    @Override
    public void updateProduct(int id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        optionalProduct.ifPresent(DBProduct -> {
            if (!product.getName().isEmpty())
                DBProduct.setName(product.getName());
            if (!product.getCategory().equals(0))
                DBProduct.setCategory(product.getCategory());
            if (product.getPrice() != 0)
                DBProduct.setPrice(product.getPrice());
            productRepository.save(DBProduct);
        });
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
