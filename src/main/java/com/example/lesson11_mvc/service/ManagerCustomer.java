package com.example.lesson11_mvc.service;

import com.example.lesson11_mvc.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManagerCustomer implements CustomerInterface {
    private static HashMap<Integer, Customer> customerHashMap;
    static {
        customerHashMap=new HashMap<>();
        customerHashMap.put(1,new Customer(1,"Nguyen Thi Anh","Nguyen@gmail","Nguyenthi@gmail"));
        customerHashMap.put(2,new Customer(2,"Nguyen Thi an","Nguyen@gmail","Nguyenthi@gmail"));
        customerHashMap.put(3,new Customer(3,"Nguyen Thi noi","Nguyen@gmail","Nguyenthi@gmail"));
        customerHashMap.put(4,new Customer(4,"Nguyen Thi Von","Nguyen@gmail","Nguyenthi@gmail"));
        customerHashMap.put(5,new Customer(5,"Nguyen Thi Moi","Nguyen@gmail","Nguyenthi@gmail"));
    }
    @Override
    public List<Customer> ShowList() {
        return new ArrayList<>(customerHashMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerHashMap.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customerHashMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerHashMap.put(id,customer);

    }

    @Override
    public void remove(int id) {
        customerHashMap.remove(id);

    }
}
