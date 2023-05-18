package com.example.lesson11_mvc.model;

public class Customer {
    private int id;
    private String name;
    private String Address;
    private String email;

    public Customer(int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        Address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
