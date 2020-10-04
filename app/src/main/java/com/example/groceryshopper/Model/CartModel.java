package com.example.groceryshopper.Model;

public class CartModel {
    String itemName;
    String price;
    int quantity = 1;
    String uName;

    public CartModel() {
    }

    public CartModel(String itemName, String price, String uName) {
        this.itemName = itemName;
        this.price = price;
        this.uName = uName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
