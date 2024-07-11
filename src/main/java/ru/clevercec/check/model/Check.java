package ru.clevercec.check.model;

import java.util.List;

public class Check {
    private List<OrderItem> orderItems;
    private double totalAmountOfProducts;
    private double totalDiscount;
    private double totalAmountAfterDiscount;

    public Check() {
    }

    public Check(List<OrderItem> orderItems, double totalAmountOfProducts, double totalDiscount, double totalAmountAfterDiscount) {
        this.orderItems = orderItems;
        this.totalAmountOfProducts = totalAmountOfProducts;
        this.totalDiscount = totalDiscount;
        this.totalAmountAfterDiscount = totalAmountAfterDiscount;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderItem> getItems() {
        return orderItems;
    }

    public void setItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalAmountOfProducts() {
        return totalAmountOfProducts;
    }

    public void setTotalAmountOfProducts(double totalAmountOfProducts) {
        this.totalAmountOfProducts = totalAmountOfProducts;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalAmountAfterDiscount() {
        return totalAmountAfterDiscount;
    }

    public void setTotalAmountAfterDiscount(double totalAmountAfterDiscount) {
        this.totalAmountAfterDiscount = totalAmountAfterDiscount;
    }
}
