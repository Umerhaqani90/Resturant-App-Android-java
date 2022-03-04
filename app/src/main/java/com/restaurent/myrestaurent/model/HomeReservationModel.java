package com.restaurent.myrestaurent.model;

public class HomeReservationModel {
    int image;
    String title;
    String loc;
    String shopname;

    public HomeReservationModel(int image, String title, String loc, String shopname) {
        this.image = image;
        this.title = title;
        this.loc = loc;
        this.shopname = shopname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }
}
