package com.homeworkWeek2;

import java.util.Date;

public class WorkSpace {
    public static void main(String[] args) {
        // Create an instance of AirlineBookingSystem
        AirlineBookingSystem bookingSystem = new AirlineBookingSystem();

        // Add some flights
        Flight flight1 = new Flight("0001", "New York", "Amsterdam", new Date(), 100);
        Flight flight2 = new Flight("0002", "Amsterdam", "New York", new Date(), 150);
        bookingSystem.addFlight(flight1);
        bookingSystem.addFlight(flight2);

        // Create a passenger
        Passenger passenger = new Passenger("Ove Kindvall", "ove@feyenoord.nl", "1234567890");

        // Make a reservation
        Reservation reservation = bookingSystem.makeReservation(flight1, passenger);
        if (reservation != null) {
            System.out.println("Reservation successful. Reservation number: " + reservation.getReservationNumber());
        }

        // Attempt to make another reservation for the same flight
        Reservation reservation2 = bookingSystem.makeReservation(flight2, passenger);
        if (reservation2 != null) {
            System.out.println("Reservation successful. Reservation number: " + reservation2.getReservationNumber());
        }
    }
}