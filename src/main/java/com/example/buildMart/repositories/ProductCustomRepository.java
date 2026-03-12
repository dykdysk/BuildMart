package com.example.buildMart.repositories;

import com.example.buildMart.models.Product;

import java.util.List;

public interface ProductCustomRepository {
    List<Product> findByCategory(String category);
    List<Product> findByParams(Float rating, Float minPrice, Float maxPrice);
}
