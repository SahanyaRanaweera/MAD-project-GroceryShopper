package com.example.groceryshopper.Model;

public class Customer {
    int id;
    String fullName;
    String address;
    String homeNo;
    String mobile;
    String email;
    String username;
    String password;

    public Customer(int id, String fullName, String address, String homeNo, String mobile, String email, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.homeNo = homeNo;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public Customer(String fullName, String address, String homeNo, String mobile, String email, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.homeNo = homeNo;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getHomeNo() {
        return homeNo;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
