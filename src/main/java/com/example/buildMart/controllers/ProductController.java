package com.example.buildMart.controllers;

import com.example.buildMart.models.Product;
import com.example.buildMart.repositories.ProductCustomRepository;
import com.example.buildMart.repositories.ProductRepository;
import com.example.buildMart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<Product> findById(@PathVariable String id){
        return  productService.findById(id);
    }

    @GetMapping("/category")
    public List<Product> findByCategory(@RequestParam String category){
        return productService.findByCategory(category);
    }

    @GetMapping("/params")
    public List<Product> findByPrice(@RequestParam(required = false) Float rating, @RequestParam(required = false) Float minPrice, @RequestParam(required = false) Float maxPrice){
        return productService.findByParams(rating ,minPrice, maxPrice);
    }
}
