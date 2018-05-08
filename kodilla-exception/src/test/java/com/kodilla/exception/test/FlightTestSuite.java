package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Test;

public class FlightTestSuite {
    @Test(expected = RouteNotFoundException.class)
    public void checkFromCityNotInMap() {
        //Given
        FlightSearch flightSearch = new FlightSearch();
        //When
        flightSearch.addDestinationToMap("Krakow", "Berlin");
        // java unreported exception  flightSearch.findFlight(new Flight("Warsaw", "Barcelona"));
        //Then
        try {
            flightSearch.findFlight(new Flight("Warsaw", "Barcelona"));
        } catch (RouteNotFoundException e) {
            System.out.format("Exception CATCHed:%s", e.getMessage());
        }
    }

    @Test(expected = RouteNotFoundException.class)
    public void checkFromCityInMapToCityNotInMap() {
        //Given
        FlightSearch flightSearch = new FlightSearch();
        //When
        flightSearch.addDestinationToMap("Krakow", "Berlin");
        // java unreported exception  flightSearch.findFlight(new Flight("Krakow", "Barcelona"));
        //Then
        try {
            flightSearch.findFlight(new Flight("Krakow", "Barcelona"));
        } catch (RouteNotFoundException e) {
            System.out.format("Exception CATCHed:%s", e.getMessage());
        }
    }

    @Test
    public void checkFromCityInMapToCityInMap() {
        //Given
        FlightSearch flightSearch = new FlightSearch();
        boolean searchResult = false;
        //When
        flightSearch.addDestinationToMap("Krakow", "Berlin");
        // java unreported exception flightSearch.findFlight(new Flight("Krakow", "Berlin"));
        try {
            searchResult = flightSearch.findFlight(new Flight("Krakow", "Berlin"));
        } catch (RouteNotFoundException e) {
            System.out.format("Exception CATCHed:%s", e.getMessage());
        }
        //Then
        Assert.assertTrue(searchResult);
    }
}
