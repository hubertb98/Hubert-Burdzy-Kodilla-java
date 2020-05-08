package com.kodilla.testing.weather.stub;

import java.util.HashMap;

public class TemperaturesStub implements Temperatures {

    @Override
    public HashMap<Integer, Double> getTemperatures() {
        HashMap<Integer, Double> stubResult = new HashMap<>();

        stubResult.put(4, 19.4);
        stubResult.put(0, 26.2);
        stubResult.put(1, 23.1);
        stubResult.put(2, 15.6);
        stubResult.put(3, 24.8);

        return stubResult;
    }

}
