package com.example.groceryshopper.Model;

public class DealsList {
    String category;
    String imgUrl;
    String imgName;
    String price;

    public DealsList() {
    }

    public DealsList(String category, String imgUrl, String imgName, String price) {
        this.category = category;
        this.imgUrl = imgUrl;
        this.imgName = imgName;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getImgName() {
        return imgName;
    }

    public String getPrice() {
        return price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
