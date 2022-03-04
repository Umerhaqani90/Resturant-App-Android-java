package com.restaurent.myrestaurent.model;

public class CartModel {
    int imgDish;
    String dishName, dishPrice;


    public CartModel(int imgDish, String dishName, String dishPrice) {
        this.imgDish = imgDish;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
    }

    public int getImgDish() {
        return imgDish;
    }

    public void setImgDish(int imgDish) {
        this.imgDish = imgDish;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(String dishPrice) {
        this.dishPrice = dishPrice;
    }
}
