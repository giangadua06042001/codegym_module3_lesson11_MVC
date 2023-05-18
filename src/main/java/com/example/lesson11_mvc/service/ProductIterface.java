package com.example.lesson11_mvc.service;

import com.example.lesson11_mvc.model.Product;

import java.util.List;

public interface ProductIterface {
    List<Product> findAll();
   void save(Product product);
   Product findById(int id);
   void update (int id,Product product);
   void remove(int id);
}
