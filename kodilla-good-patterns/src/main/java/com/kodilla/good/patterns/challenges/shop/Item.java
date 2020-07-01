package com.kodilla.good.patterns.challenges.shop;

public class Item {
    private Product product;
    private double quantity;

    public Item(Product product, double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return product + "";
    }
}
