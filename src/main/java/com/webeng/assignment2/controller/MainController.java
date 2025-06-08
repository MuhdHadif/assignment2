package com.webeng.assignment2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webeng.assignment2.model.Product;
import com.webeng.assignment2.repository.ProductRepository;



@Controller
@RequestMapping(path="/main")
public class MainController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/addProduct")
    public @ResponseBody String addProduct(
        @RequestParam String name,
        @RequestParam Integer category,
        @RequestParam float price) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        productRepository.save(product);
        return "Product added";
    }
    
    @GetMapping("/allProducts")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
}
