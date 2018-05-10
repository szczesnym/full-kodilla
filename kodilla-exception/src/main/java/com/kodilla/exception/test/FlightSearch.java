package com.kodilla.exception.test;

import com.kodilla.exception.test.RouteNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightSearch {
    Map<String, Map<String, Boolean>> flightMap;

    public FlightSearch() {
        flightMap = new HashMap<>();
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        String cityOfDeparture = flight.getDepartureAirport();

        if (flightMap.get(cityOfDeparture) == null) {
            throw new RouteNotFoundException("No routes FROM this city");
        }
        Map<String, Boolean> mapOfPossibleDestinations = flightMap.get(cityOfDeparture);
        if (mapOfPossibleDestinations.get(flight.getArrivalAirport()) != null) {
            return true;
        } else {
            throw new RouteNotFoundException("No routes TO this city");
        }
    }

    public void addDestinationToMap(String cityOfOrigin, String cityOfDestination) {
        if (!flightMap.containsKey(cityOfOrigin)) {
            flightMap.put(cityOfOrigin, new HashMap<String, Boolean>());
        }
        Map<String, Boolean> mapOfPossibleDestinationsForOrigin = flightMap.get(cityOfOrigin);
        mapOfPossibleDestinationsForOrigin.put(cityOfDestination, Boolean.TRUE);
    }

    public void showFlights() {
        flightMap.entrySet()
                .stream()
                .forEach(System.out::println);
    }

}
