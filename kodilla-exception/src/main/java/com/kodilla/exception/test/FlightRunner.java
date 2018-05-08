package com.kodilla.exception.test;

public class FlightRunner {
    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        boolean searchResult;

        flightSearch.addDestinationToMap("Berlin", "Warsaw");
        try {
            searchResult = flightSearch.findFlight(new Flight("Berlin", "Krakow"));
        } catch (RouteNotFoundException e) {
            System.out.format("Excetion:%s", e);
        }
        try {
            searchResult = flightSearch.findFlight(new Flight("Berlin", "Warsaw"));
        } catch (RouteNotFoundException e) {
            System.out.format("Excetion:%s", e);
        }
        try {
            searchResult = flightSearch.findFlight(new Flight("Krakow", "Warsaw"));
        } catch (RouteNotFoundException e) {
            System.out.format("Excetion:%s", e);
        }
    }
}
