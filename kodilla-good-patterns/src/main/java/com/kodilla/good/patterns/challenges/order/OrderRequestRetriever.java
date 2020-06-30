package com.kodilla.good.patterns.challenges.order;


public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("John", "Smith", "j.smith@gmail.com", new UserAddress("Warsaw", 56132, "ul. Kolorowa", 12));

        Item towel = new Item(new Product("Towel"), 2, 19.99, 39.98);
        Item puzzle = new Item(new Product("Eiffel Tower puzzle"), 1, 27.75, 27.75);

        Invoice invoice = new Invoice(49066);
        invoice.getItemList().add(towel);
        invoice.getItemList().add(puzzle);

        return new OrderRequest(user, invoice);
    }
}
