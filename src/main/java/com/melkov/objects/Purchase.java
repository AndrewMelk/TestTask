package com.melkov.objects;

/**
 * Created by andrew on 17.05.16.
 */
public class Purchase{
    private int id;
    private int prodId;
    private String productName;
    private int quantity;
    private double productPrice;
    private String date;

    public Purchase(String productName, int quantity, double productPrice, String date) {

        this.productName = productName;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.date = date;
    }

    public Purchase(int prodId, int quantity, double productPrice, String date) {
        this.prodId = prodId;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.date = date;
    }

    public Purchase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Purchase{" + "\n" +
                "        productName='" + productName + '\'' + "\n" +
                "        quantity=" + quantity + "\n" +
                "        productPrice=" + productPrice + "\n" +
                "        date=" + date + "\n" +
                '}';
    }
}
