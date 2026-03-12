package com.example.buildMart.repositories;

import com.example.buildMart.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class ProductCustomRepositoryImpl implements ProductCustomRepository {
    private final MongoTemplate mongoTemplate;
    @Autowired
    public ProductCustomRepositoryImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }
    @Override
    public List<Product> findByCategory(String category){
        Query query = new Query();
        query.addCriteria(Criteria.where("categories").is(category));
        return mongoTemplate.find(query, Product.class);
    };
    @Override
    public List<Product> findByParams(Float rating, Float minPrice, Float maxPrice){
        Query query = new Query();
        if (rating!=null){
            query.addCriteria(Criteria.where("rating").gte(rating));
        }
        query.addCriteria(Criteria.where("price").gte(minPrice).lte(maxPrice));
        return mongoTemplate.find(query, Product.class);
    }

}
