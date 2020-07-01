package com.kodilla.good.patterns.challenges.filght;

public class App {
    public static void main(String[] args) {
        String departureAirport = "Warsaw";
        String intermediateAirport = "Gdansk";
        String arrivalAirport = "Rzeszow";

        Flight flight = new Flight(departureAirport, intermediateAirport, arrivalAirport);
        FlightFinder flightFinder = new FlightFinder();

        flightFinder.findFlightFromAirport(departureAirport, AvailableFlight.getAvailableFlightMap());
        flightFinder.findFlightWithIntermediateAirport(intermediateAirport, AvailableFlight.getAvailableFlightMap());
        flightFinder.findFlightToAirport(arrivalAirport, AvailableFlight.getAvailableFlightMap());
    }
}
