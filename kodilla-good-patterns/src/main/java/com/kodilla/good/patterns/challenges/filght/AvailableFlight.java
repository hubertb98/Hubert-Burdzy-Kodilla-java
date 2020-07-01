package com.kodilla.good.patterns.challenges.filght;

import java.util.HashMap;
import java.util.Map;

public class AvailableFlight {
    public static Map<Integer, Flight> getAvailableFlightMap() {
        Map<Integer, Flight> availableFlightMap = new HashMap<>();
        availableFlightMap.put(0,new Flight("Warsaw", "", "Wroclaw"));
        availableFlightMap.put(1,new Flight("Wroclaw", "Warsaw", "Rzeszow"));
        availableFlightMap.put(2,new Flight("Warsaw", "Cracow", "Rzeszow"));
        availableFlightMap.put(3,new Flight("Wroclaw", "", "Cracow"));
        availableFlightMap.put(4,new Flight("Warsaw", "Gdansk", "Wroclaw"));
        availableFlightMap.put(5,new Flight("Wroclaw", "", "Warsaw"));


        return availableFlightMap;
    }

}
