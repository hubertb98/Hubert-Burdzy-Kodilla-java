package com.kodilla.good.patterns.challenges.filght;

import java.util.Map;

public class FlightFinder {
    public void findFlightFromAirport(String departureAirport, Map<Integer, Flight> availableFlightMap) {
        System.out.println("\nAvailable flights form " + departureAirport + "\n");
        availableFlightMap.entrySet().stream()
                .filter(e -> e.getValue().getDepartureAirport().equals(departureAirport))
                .forEach(System.out::println);
    }

    public void findFlightWithIntermediateAirport(String intermediateAirport, Map<Integer, Flight> availableFlightMap) {
        System.out.println("\nAvailable flights through " + intermediateAirport);
        availableFlightMap.entrySet().stream()
                .filter(e -> e.getValue().getIntermediateAirport().equals(intermediateAirport))
                .forEach(System.out::println);
    }

    public void findFlightToAirport(String arrivalAirport, Map<Integer, Flight> availableFlightMap) {
        System.out.println("\nAvailable flights to " + arrivalAirport);
        availableFlightMap.entrySet().stream()
                .filter(e -> e.getValue().getArrivalAirport().equals(arrivalAirport))
                .forEach(System.out::println);
    }
}