package com.kodilla.good.patterns.flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearcher {

    public static List<List<Flight>> flightPlan(FlightBook flightBook, Flight flight) {
        List<AirportEnum> listMiddleAirport = new ArrayList<>();
        List<List<Flight>> flightPlan = new ArrayList<>();
        List<AirportEnum> listOfPossibleTo = flightBook.searchBookFromOrTo(flight.getDepartureAirport(), FlightPoint.From);
        List<AirportEnum> listOfPossibleFrom = flightBook.searchBookFromOrTo(flight.getArrivalAirport(), FlightPoint.To);
        for (AirportEnum midAirportFrom : listOfPossibleFrom) {
            for (AirportEnum midAirportTo : listOfPossibleTo) {
                if (midAirportFrom.equals(midAirportTo)) {
                    listMiddleAirport.add(midAirportTo);
                }
            }
        }
        for (AirportEnum middleAirport : listMiddleAirport) {
            List<Flight> possibleConnection = new ArrayList<>();
            Flight startingFlight = flightBook.flightFromBook(flight.getDepartureAirport(), middleAirport);
            Flight endingFlight = flightBook.flightFromBook(middleAirport, flight.getArrivalAirport());
            possibleConnection.add(startingFlight);
            possibleConnection.add(endingFlight);
            flightPlan.add(possibleConnection);
        }
/* The same result using STREAM

        flightPlan = listMiddleAirport.stream()
                .map(middleAirport ->
                    new ArrayList<Flight>(
                            Arrays.asList(
                                            flightBook.flightFromBook(flight.getDepartureAirport(), middleAirport),
                                            flightBook.flightFromBook(middleAirport, flight.getArrivalAirport())
                            )
                    )
                )
                .collect(Collectors.toList());

*/
        return flightPlan;
    }
}
