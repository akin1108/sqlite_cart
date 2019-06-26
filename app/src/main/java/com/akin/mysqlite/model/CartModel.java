package com.akin.mysqlite.model;

public class CartModel {

    String medicine;
    int quantity,rate,total;

    public CartModel(String medicine, int quantity, int rate, int total) {
        this.medicine = medicine;
        this.quantity = quantity;
        this.rate = 10;
        this.total = total;
    }

    public CartModel() {

    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
