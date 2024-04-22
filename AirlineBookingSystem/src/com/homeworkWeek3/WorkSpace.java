package com.homeworkWeek3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WorkSpace {
    public static void main(String[] args) {
        Airline airline = new Airline();
        airline.addFlight(new Flight("FL001", "New York", "Los Angeles", "10:00 AM", 100));
        airline.addFlight(new Flight("FL002", "Los Angeles", "New York", "12:00 PM", 80));
        airline.addFlight(new Flight("FL003", "Chicago", "Miami", "2:00 PM", 120));
      
        try (Scanner scanner = new Scanner(System.in)) {
				while (true) {
			    System.out.println("1. View available flights");
			    System.out.println("2. Book a flight");
			    System.out.println("3. Exit");
			    System.out.print("Enter your choice: ");

			    int choice = scanner.nextInt();


				    switch (choice) {
				        case 1:
				            airline.displayAvailableFlights();
				            break;
				        case 2:
				            System.out.print("Enter the index of the flight you want to book: ");
				            int flightIndex = scanner.nextInt();
				            airline.bookFlight(flightIndex);
				            break;
				        case 3:
				            System.out.println("Thank you for using our service. Goodbye!");
				            System.exit(0);
				        default:
				            System.out.println("Invalid choice. Please try again.");
				    }
				}
      }catch  (InputMismatchException e) {
			System.out.println("Please use a correct input");
      }

    }
}