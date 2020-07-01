package com.kodilla.good.patterns.challenges.shop;

public class App {
    public static void main(String[] args) {
        Product coconutMilk = new Product("Coconut milk", 17.99);
        Product coffee = new Product("Arabica coffee", 40.99);
        Product tapioca = new Product("Tapioca",9.99);

        Item item1 = new Item(coconutMilk, 1);
        Item item2 = new Item(coffee, 0.75);
        Item item3 = new Item(tapioca, 0.5);

        Producer extraFoodShop = new Producer("ExtraFoodProducer", "Warsaw");
        Producer healthyShop = new Producer("Healthy Shop", "Wroclaw");
        Producer glutenFreeShop = new Producer("Gluten Free Shop", "Gdansk");

        OrderProcessor processor = new OrderProcessor();

        processor.processOrder(extraFoodShop, item1);
        processor.processOrder(healthyShop, item2);
        processor.processOrder(glutenFreeShop, item3);

    }
}
