package com.kodilla.good.patterns.flight;

import java.util.List;

import static com.kodilla.good.patterns.flight.AirportEnum.*;

public class FlightSearchRunner {
    public static void main(String[] args) {
        Flight flight1 = new Flight(WAW, BER);
        Flight flight2 = new Flight(WAW, BAR);
        Flight flight3 = new Flight(LUB, BER);
        Flight flight4 = new Flight(LUB, LIS);
        Flight flight5 = new Flight(BER, LUB);
        Flight flight6 = new Flight(LIS, LUB);
        Flight flight7 = new Flight(WAW, LIS);
        Flight searchFlight = new Flight(WAW, LUB);
        FlightBook flightBook = new FlightBook();
        flightBook.addFlightToBook(flight1);
        flightBook.addFlightToBook(flight2);
        flightBook.addFlightToBook(flight3);
        flightBook.addFlightToBook(flight4);
        flightBook.addFlightToBook(flight5);
        flightBook.addFlightToBook(flight6);
        flightBook.addFlightToBook(flight7);

        List<List<Flight>> flightPlan = FlightSearcher.flightPlan(flightBook, searchFlight);
        flightPlan.stream()
                .forEach(flightList -> System.out.format("Possible route:%s\n", flightList));
    }
}
