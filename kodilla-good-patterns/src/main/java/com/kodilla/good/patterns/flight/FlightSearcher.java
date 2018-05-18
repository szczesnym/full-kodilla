package com.kodilla.good.patterns.flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearcher {
    private FlightBook flightBook;

    public FlightSearcher(FlightBook flightBook) {
        this.flightBook = flightBook;
    }

    public List<Flight> allFlightsFromAirport(AirportEnum fromAirport) {
        return flightBook.allFlights(fromAirport, FlightPoint.From);
    }

    public List<Flight> allFlightsToAirport(AirportEnum toAirport) {
        return flightBook.allFlights(toAirport, FlightPoint.To);
    }


    public List<List<Flight>> findFlightsWithConnections(Flight flight) {
        List<AirportEnum> listMiddleAirport = new ArrayList<>();
        List<List<Flight>> flightPlan = new ArrayList<>();
        List<AirportEnum> listOfPossibleTo = flightBook.searchBookFromOrTo(flight.getDepartureAirport(), FlightPoint.From);
        List<AirportEnum> listOfPossibleFrom = this.flightBook.searchBookFromOrTo(flight.getArrivalAirport(), FlightPoint.To);
        for (AirportEnum midAirportFrom : listOfPossibleFrom) {
            for (AirportEnum midAirportTo : listOfPossibleTo) {
                if (midAirportFrom.equals(midAirportTo)) {
                    listMiddleAirport.add(midAirportTo);
                }
            }
        }
        for (AirportEnum middleAirport : listMiddleAirport) {
            List<Flight> possibleConnection = new ArrayList<>();
            Flight startingFlight = this.flightBook.flightFromBook(flight.getDepartureAirport(), middleAirport);
            Flight endingFlight = this.flightBook.flightFromBook(middleAirport, flight.getArrivalAirport());
            possibleConnection.add(startingFlight);
            possibleConnection.add(endingFlight);
            flightPlan.add(possibleConnection);
        }

        return flightPlan;
    }

}
