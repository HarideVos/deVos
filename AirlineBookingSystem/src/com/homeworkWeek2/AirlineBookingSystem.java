package com.homeworkWeek2;


public class AirlineBookingSystem {
    private int MAX_FLIGHTS = 100;
    private int MAX_RESERVATIONS = 1000;

    private Flight[] flights;
    private Reservation[] reservations;
    private int numFlights;
    private int numReservations;
    private int reservationCounter;

    public AirlineBookingSystem() {
        flights = new Flight[MAX_FLIGHTS];
        reservations = new Reservation[MAX_RESERVATIONS];
        numFlights = 0;
        numReservations = 0;
        reservationCounter = 1;
    }

    public void addFlight(Flight flight) {
        if (numFlights < MAX_FLIGHTS) {
            flights[numFlights++] = flight;
        } else {
            System.out.println("Cannot add more flights. Maximum capacity reached.");
        }
    }

    public Reservation makeReservation(Flight flight, Passenger passenger) {
        if (flight.bookSeat()) {
            if (numReservations < MAX_RESERVATIONS) {
                String reservationNumber = generateReservationNumber();
                Reservation reservation = new Reservation(reservationNumber, flight, passenger);
                reservations[numReservations++] = reservation;
                return reservation;
            } else {
                System.out.println("Cannot make reservation. Maximum capacity reached.");
            }
        } else {
            System.out.println("Sorry, the flight " + flight.getFlightNumber() + " is fully booked.");
        }
        return null;
    }

    private String generateReservationNumber() {
        return "R" + reservationCounter++;
    }
}
