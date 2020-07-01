package com.kodilla.good.patterns.challenges.filght;

import java.util.Objects;

public class Flight {
    private final String departureAirport;
    private final String intermediateAirport;
    private final String arrivalAirport;

    public Flight(final String departureAirport, final String intermediateAirport, final String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.intermediateAirport = intermediateAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getIntermediateAirport() {
        return intermediateAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!Objects.equals(departureAirport, flight.departureAirport))
            return false;
        if (!Objects.equals(intermediateAirport, flight.intermediateAirport))
            return false;
        return Objects.equals(arrivalAirport, flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        int result = departureAirport != null ? departureAirport.hashCode() : 0;
        result = 31 * result + (intermediateAirport != null ? intermediateAirport.hashCode() : 0);
        result = 31 * result + (arrivalAirport != null ? arrivalAirport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureAirport='" + departureAirport + '\'' +
                ", intermediateAirport='" + intermediateAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                '}';
    }
}
