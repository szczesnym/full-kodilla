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
        if (bookOfFlights.isEmpty()) {
            bookOfFlights.add(flight);
        } else if (!bookOfFlights.contains(flight)) {
            bookOfFlights.add(flight);
        }
    }

    public boolean searchBookForFlight(Flight flight) {
        return bookOfFlights.stream()
                .anyMatch(flight1 -> flight1.getDepartureAirport().equals(flight.getDepartureAirport()) && flight1.getArrivalAirport().equals(flight.getArrivalAirport()));

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

