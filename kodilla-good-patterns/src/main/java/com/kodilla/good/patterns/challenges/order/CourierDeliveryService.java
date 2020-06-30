package com.kodilla.good.patterns.challenges.order;

public class CourierDeliveryService implements DeliveryService{

    @Override
    public boolean deliverTo(User user) {
        System.out.println("Delivering to: " + user.getName() + " " + user.getSurname());
        System.out.println("Address: " + user.getUserAddress());
        return true;
    }
}
