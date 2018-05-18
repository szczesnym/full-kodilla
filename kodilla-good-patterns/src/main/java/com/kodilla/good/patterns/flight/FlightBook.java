package com.kodilla.good.patterns.flight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FlightBook {
    private List<Flight> bookOfFlights;

    public FlightBook() {
        bookOfFlights = new ArrayList<>();
    }

    public List<Flight> getBookOfLights() {
        return this.bookOfFlights;
    }

    public void addFlightToBook(Flight flight) {
        if (!bookOfFlights.contains(flight)) {
            bookOfFlights.add(flight);
        }
    }
    public List<Flight> allFlights(AirportEnum airportFrom, FlightPoint flightPoint) {
        if(flightPoint.equals(FlightPoint.From )) {
            return bookOfFlights.stream()
                .filter(flight -> flight.getDepartureAirport().equals(airportFrom))
                .collect(Collectors.toList());
        } else {
            return bookOfFlights.stream()
                    .filter(flight -> flight.getArrivalAirport().equals(airportFrom))
                    .collect(Collectors.toList());
        }
    }

    public Flight flightFromBook(AirportEnum fromAirport, AirportEnum toAirport) {
        int indexOfFlight = bookOfFlights.indexOf(new Flight(fromAirport, toAirport));
        return bookOfFlights.get(indexOfFlight);
    }

    public List<AirportEnum> searchBookFromOrTo(AirportEnum airport, FlightPoint flightPoint) {
        List<AirportEnum> searchResult = new ArrayList<>();

        if (flightPoint.equals(FlightPoint.From)) {
            searchResult = bookOfFlights.stream()
                    .filter(bookEntry -> bookEntry.getDepartureAirport().equals(airport))
                    .map(flight -> flight.getArrivalAirport())
                    .collect(Collectors.toList());
        } else {
            searchResult = bookOfFlights.stream()
                    .filter(bookEntry -> bookEntry.getArrivalAirport().equals(airport))
                    .map(flight -> flight.getDepartureAirport())
                    .collect(Collectors.toList());
        }
        return searchResult;
    }
}

