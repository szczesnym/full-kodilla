package com.kodilla.exception.test;

import org.junit.Assert;
import org.junit.Test;

public class FlightTestSuite {
    @Test(expected = RouteNotFoundException.class)
    public void checkFromCityNotInMap() throws RouteNotFoundException {
        //Given
        FlightSearch flightSearch = new FlightSearch();
        //When
        flightSearch.addDestinationToMap("Krakow", "Berlin");
        //Then
        flightSearch.findFlight(new Flight("Warsaw", "Barcelona"));
    }

    @Test(expected = RouteNotFoundException.class)
    public void checkFromCityInMapToCityNotInMap() throws RouteNotFoundException {
        //Given
        FlightSearch flightSearch = new FlightSearch();
        //When
        flightSearch.addDestinationToMap("Krakow", "Berlin");
        //Then
        flightSearch.findFlight(new Flight("Krakow", "Barcelona"));
    }

    @Test
    public void checkFromCityInMapToCityInMap() throws RouteNotFoundException {
        //Given
        FlightSearch flightSearch = new FlightSearch();
        boolean searchResult = false;
        //When
        flightSearch.addDestinationToMap("Krakow", "Berlin");
        searchResult = flightSearch.findFlight(new Flight("Krakow", "Berlin"));
        //Then
        Assert.assertTrue(searchResult);
    }
}
