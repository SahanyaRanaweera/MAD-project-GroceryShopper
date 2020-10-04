package com.example.groceryshopper.Model;

public class Item {
    String category;
    String imgUrl;
    String imgName;
    String price;

    public Item(){
    }

    public Item(String category, String imgUrl, String imgName, String price) {
        this.category = category;
        this.imgUrl = imgUrl;
        this.imgName = imgName;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
