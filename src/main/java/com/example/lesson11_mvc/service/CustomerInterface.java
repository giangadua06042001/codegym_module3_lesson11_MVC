package com.example.lesson11_mvc.service;

import com.example.lesson11_mvc.model.Customer;

import java.util.List;

public interface CustomerInterface {
    List<Customer> ShowList();
    void save(Customer customer);
    Customer findById(int id);
    void update(int id,Customer customer);
    void remove(int id);
}
