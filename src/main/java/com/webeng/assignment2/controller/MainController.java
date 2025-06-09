package com.webeng.assignment2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webeng.assignment2.model.Product;
import com.webeng.assignment2.service.ProductService;

@Controller
@RequestMapping(path="/main")
public class MainController {
    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public @ResponseBody String addProduct(
        @RequestParam String name,
        @RequestParam Integer category,
        @RequestParam float price) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        productService.addProduct(product);
        return "Product added";
    }

    @PostMapping("/updateProduct")
    public @ResponseBody String updateProduct(
        @RequestParam Integer id,
        @RequestParam(defaultValue = "") String name,
        @RequestParam(defaultValue = "0") Integer category,
        @RequestParam(defaultValue = "0") float price) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        product.setPrice(price);
        productService.updateProduct(id, product);
        return "Product updated, id = " + id;
    }

    @PostMapping("/deleteProduct")
    public @ResponseBody String deleteProduct(
        @RequestParam Integer id) {
        productService.deleteProduct(id);
        return "Product deleted";
    }
    
    @GetMapping("/allProducts")
    public @ResponseBody Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
