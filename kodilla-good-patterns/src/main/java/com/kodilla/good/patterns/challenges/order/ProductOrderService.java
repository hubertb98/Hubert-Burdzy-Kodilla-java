package com.kodilla.good.patterns.challenges.order;

public class ProductOrderService implements OrderService{

    @Override
    public boolean createOrder(User user, Invoice invoice) {
        System.out.println("Created order for " + user.getName() + " " + user.getSurname() + ". Invoice number is: " + invoice.getId());
        return true;
    }
}
