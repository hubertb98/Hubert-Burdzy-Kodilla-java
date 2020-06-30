package com.kodilla.good.patterns.challenges.order;

public class Item {
    private Product product;
    private int quantity;
    private double price;
    private double value;

    public Item(Product product, int quantity, double price, double value) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getValue() {
        return value = price * quantity;
    }
}
