package com.kodilla.good.patterns.flight;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Flight {
    private AirportEnum fromAirport;
    private AirportEnum toAirport;

    public Flight() {
        super();
    }

    public Flight(AirportEnum fromAirport, AirportEnum toAirport) {
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
    }

    public AirportEnum getDepartureAirport() {
        return fromAirport;
    }

    public AirportEnum getArrivalAirport() {
        return toAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(getDepartureAirport(), flight.getDepartureAirport()) &&
                Objects.equals(getArrivalAirport(), flight.getArrivalAirport());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getDepartureAirport(), getArrivalAirport());
    }

    @Override
    public String toString() {
        return new String("Departure/From:" + this.fromAirport + " Arrival/To:" + this.toAirport);
    }
}
