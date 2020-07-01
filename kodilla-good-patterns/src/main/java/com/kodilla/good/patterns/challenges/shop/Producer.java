package com.kodilla.good.patterns.challenges.shop;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Shop{
    private String producerName;
    private String city;

    public Producer(String producerName, String city) {
        this.producerName = producerName;
        this.city = city;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean process(Item item) {
        System.out.println("Welcome to " + getProducerName() + ". We have everything you want.");
        return true;
    }
}
