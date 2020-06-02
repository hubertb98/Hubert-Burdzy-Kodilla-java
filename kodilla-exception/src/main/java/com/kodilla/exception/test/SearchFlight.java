package com.kodilla.exception.test;

import java.util.HashMap;

public class SearchFlight  {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        HashMap<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Warsaw", true);
        flightMap.put("London", true);
        flightMap.put("Katowice", false);
        flightMap.put("Rome", false);
        flightMap.put("Lisbon", true);
        flightMap.put("Berlin", false);

        if(!flightMap.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("Error");
        } else {
            if (flightMap.get(flight.getArrivalAirport())) {
                System.out.println("The flight form: " + flight.getDepartureAirport() +
                        " to " + flight.getArrivalAirport() + " is available.");
            } else {
                System.out.println("The flight form: " + flight.getDepartureAirport() +
                        " to " + flight.getArrivalAirport() + " is not available.");
            }
        }
    }
}
