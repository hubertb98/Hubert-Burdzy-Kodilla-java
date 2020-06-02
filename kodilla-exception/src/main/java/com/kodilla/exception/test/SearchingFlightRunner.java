package com.kodilla.exception.test;

public class SearchingFlightRunner {
    public static void main(String[] args) {
        Flight flight = new Flight("Warsaw", "Lisbon");
        SearchFlight searchFlight = new SearchFlight();

        try {
            searchFlight.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("This flight does not exist");
        }
    }
}
