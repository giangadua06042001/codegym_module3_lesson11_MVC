package com.example.lesson11_mvc.service;

import com.example.lesson11_mvc.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class productService implements ProductIterface {
    private static Map<Integer,Product>productMap;
    static {
        productMap = new HashMap<>();
        productMap.put(1,new Product(1,"cai ban",20000));
        productMap.put(2,new Product(2,"nuoc giat",30000));
        productMap.put(3,new Product(3,"May tinh",40000));
        productMap.put(4,new Product(4,"cai bang",50000));
        productMap.put(5,new Product(5,"cai ghe",50000));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(),product);

    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);

    }

    @Override
    public void remove(int id) {
        productMap.remove(id);

    }
}
