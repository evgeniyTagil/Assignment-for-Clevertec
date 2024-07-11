package ru.clevercec.check.model;

public class Product {
    private int id;
    private String description;
    private double price;
    private int qualityInStock;
    private boolean wholesaleProduct;

    public Product() {
    }

    public Product(int id, String description, double price, int qualityInStock, boolean wholesaleProduct) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.qualityInStock = qualityInStock;
        this.wholesaleProduct = wholesaleProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQualityInStock() {
        return qualityInStock;
    }

    public void setQualityInStock(int qualityInStock) {
        this.qualityInStock = qualityInStock;
    }

    public boolean isWholesaleProduct() {
        return wholesaleProduct;
    }

    public void setWholesaleProduct(boolean wholesaleProduct) {
        this.wholesaleProduct = wholesaleProduct;
    }

}
