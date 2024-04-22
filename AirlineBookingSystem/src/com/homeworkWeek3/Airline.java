package com.homeworkWeek3;
import java.util.ArrayList;

public class Airline {
    private ArrayList<Flight> flights;

    public Airline() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void displayAvailableFlights() {
        System.out.println("Available Flights:");
        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            System.out.println((i + 1) + ". " + flight.getFlightNumber() +
                    " from " + flight.getOrigin() +
                    " to " + flight.getDestination() +
                    " Departure Time: " + flight.getDepartureTime() +
                    " Available Seats: " + flight.getAvailableSeats());
        }
    }

    public void bookFlight(int flightIndex) {
        try {
            Flight selectedFlight = flights.get(flightIndex);
            selectedFlight.bookSeat();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid flight index!");
        }
    }
}