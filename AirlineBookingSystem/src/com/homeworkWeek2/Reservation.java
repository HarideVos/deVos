package com.homeworkWeek2;

public class Reservation {
   
	private String reservationNumber;
    private Flight flight;
    private Passenger passenger;
    
    public Reservation(String reservationNumber, Flight flight, Passenger passenger) {
        this.reservationNumber = reservationNumber;
        this.flight = flight;
        this.passenger = passenger;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    // getters for flight and passenger
    public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}


}


