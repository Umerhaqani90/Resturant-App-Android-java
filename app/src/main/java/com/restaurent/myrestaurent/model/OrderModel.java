package com.restaurent.myrestaurent.model;

public class OrderModel {

    int imgOrder;
    String txtProductOrderName, txtProductOrderPrice, txtProOrderQuantity;


    public OrderModel(int imgOrder, String txtProductOrderName, String txtProductOrderPrice, String txtProOrderQuantity) {
        this.imgOrder = imgOrder;
        this.txtProductOrderName = txtProductOrderName;
        this.txtProductOrderPrice = txtProductOrderPrice;
        this.txtProOrderQuantity = txtProOrderQuantity;
    }

    public int getImgOrder() {
        return imgOrder;
    }

    public void setImgOrder(int imgOrder) {
        this.imgOrder = imgOrder;
    }

    public String getTxtProductOrderName() {
        return txtProductOrderName;
    }

    public void setTxtProductOrderName(String txtProductOrderName) {
        this.txtProductOrderName = txtProductOrderName;
    }

    public String getTxtProductOrderPrice() {
        return txtProductOrderPrice;
    }

    public void setTxtProductOrderPrice(String txtProductOrderPrice) {
        this.txtProductOrderPrice = txtProductOrderPrice;
    }

    public String getTxtProOrderQuantity() {
        return txtProOrderQuantity;
    }

    public void setTxtProOrderQuantity(String txtProOrderQuantity) {
        this.txtProOrderQuantity = txtProOrderQuantity;
    }
}
