package airline;

import java.io.IOException;
import java.util.Scanner;

public class Kiosk {
	/***** MAIN MENU *****/
	private static final String TITLE_MM = "Airline Reservation Kiosk";

	private static final String[] OPTIONS_MM = {"Search Flights", "View Reservation", "Cancel Reservation"};

	private static final String OPTION_ZERO_MM = "Exit";

	/***** SUB MENU 1 *****/
	private static final String TITLE_SM1 = "Make a Reservation";
	private static final String[] OPTIONS_SM1 = {"View All Flights", "Search Flights by Arrival/Destination"};
	private static final String OPTION_ZERO_SM1 = "Return to Main Menu";

	/***** SUB MENU 2 *****/
	private static final String TITLE_SM2 = "Choose your section";
	private static final String[] OPTIONS_SM2 = {"First Class", "Business Class", "Economy Class"};
	private static final String OPTION_ZERO_SM2 = "Cancel";

	/***** SUB MENU 3 *****/
	private static final String TITLE_SM3 = "Reserve additional seats?";
	private static final String[] OPTIONS_SM3 = {"Yes"};
	private static final String OPTION_ZERO_SM3 = "No";

	/***** SUB MENU 4 *****/
	private static final String TITLE_SM4 = "Book a reservation?";
	private static final String[] OPTIONS_SM4 = {"Yes"};
	private static final String OPTION_ZERO_SM4 = "No";

	/***** SUB MENU 5 *****/
	private static final String TITLE_SM5 = "Cancel reservation?";
	private static final String[] OPTIONS_SM5 = {"Yes"};
	private static final String OPTION_ZERO_SM5 = "No";

	static Scanner input = new Scanner(System.in);

	public static void main(String args[]) throws IOException, InterruptedException {
		Menu mainMenu = new Menu(TITLE_MM, OPTIONS_MM, OPTION_ZERO_MM);
		boolean exit = false;
		while (!exit) {
			switch (mainMenu.makeSelection()) {
				case 0:
					exitKiosk();
					exit = true;
					break;
				case 1:
					searchFlights();
					break;
				case 2:
					viewRes();
					break;
				case 3:
					cancelRes();
					break;
			} // end-switch
		} // end-loop
	} // end-main

	private static void exitKiosk() {
		System.out.println("Exiting Airline Reservation Kiosk. Thank you!");
	}

	private static void searchFlights() {
		Menu subMenu1 = new Menu(TITLE_SM1, OPTIONS_SM1, OPTION_ZERO_SM1);
		while (true) {
			switch (subMenu1.makeSelection()) {
				case 0:
					return;
				case 1:
					viewAllFlights();
					break;

			} // end-switch
		} // end-loop
	} // end-searchFlights



	private static int viewRes() {
		Data data;
		int confirmation = 0;
		String[] customerInfo = enterInfo();
		String email = customerInfo[2];
		try {
			data = Data.getInstance();
		} catch (Exception e) {
			System.out.println("Unable to get data.");
			return -1;
		} // end-try-catch
		System.out.println("Searching for confirmations by email...");
		try {
			confirmation = data.getConfirmation(email);
		} catch (Exception e) {
			System.out.println("Returning to menu...");
		} // end-try-catch
		return confirmation;
	} // end-viewRes

	private static String[] enterInfo() {
		String[] customerInfo = new String[3];
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter your information:");
		System.out.print("First Name: ");
		customerInfo[0] = input.nextLine();

		System.out.print("Last Name: ");
		customerInfo[1] = input.nextLine();

		System.out.print("Email Address: ");
		customerInfo[2] = input.nextLine();

		return customerInfo;
	}

	private static void cancelRes() {
		Menu subMenu5 = new Menu(TITLE_SM5, OPTIONS_SM5, OPTION_ZERO_SM5);
		Data data;
		int confirmationId;
		try {
			data = Data.getInstance();
		} catch (Exception e) {
			System.out.println("Unable to get data.");
			return;
		} // end-try-catch
		confirmationId = viewRes();
		if (subMenu5.makeSelection() == 0) {
			return;
		}
		if (data.cancelReservation(confirmationId)) {
			System.out.println("Reservation canceled successfully.");
		} else {
			System.out.println("Unable to cancel reservation.");
		}
	} // end-cancelRes

	private static void viewAllFlights() {
		Menu subMenu4 = new Menu(TITLE_SM4, OPTIONS_SM4, OPTION_ZERO_SM4);
		Data data;
		String[] customerInfo;
		int chosenFlight, confirmation, totalOpen;
		int[] openSeats; //0=First; 1=Business; 2=Economy
		int[] seatsToReserve;
		try {
			data = Data.getInstance();
		} catch (Exception e) {
			System.out.println("Unable to get data.");
			return;
		} // end-try-catch
		chosenFlight = data.getFlights();
		if (chosenFlight <= 0) {
			System.out.println("No flight selected.");
			return;
		} // end-if
		try {
			openSeats = data.availableSeats(chosenFlight);
			totalOpen = openSeats[0] + openSeats[1] + openSeats[2];
		} catch (Exception e) {
			System.out.println("Unable to retrieve seat information.");
			return;
		} // end-try-catch
		if (totalOpen < 1) {
			System.out.println("No seats available -- Select another flight.");
			return;
		}
		if (subMenu4.makeSelection() == 0) {
			return;
		}
		customerInfo = enterInfo();
		try {
			seatsToReserve = chooseSeats(openSeats);
		} catch (Exception e) {
			System.out.println("Transaction Canceled");
			return;
		} // end-try-catch
		confirmation = data.makeReservation(customerInfo, chosenFlight, seatsToReserve);
		if (confirmation == 0) {
			System.out.println("Reservation failed.");
			return;
		} else {
			System.out.println("\nReservation confirmed.");
			System.out.println("Name: " + customerInfo[0] + " " + customerInfo[1]);
			System.out.println("Confirmation #: " + confirmation);
		} // end-if-else
	} // end-viewAllFlights

	private static int[] chooseSeats(final int[] OPEN_SEATS) throws Exception {
		int[] remaining = OPEN_SEATS;
		int[] selected = {0, 0, 0};
		int entry;
		Menu subMenu2 = new Menu(TITLE_SM2, OPTIONS_SM2, OPTION_ZERO_SM2);
		Menu subMenu3 = new Menu(TITLE_SM3, OPTIONS_SM3, OPTION_ZERO_SM3);
		while (true) {
			System.out.print("\nSeats available:  ");
			System.out.print("First Class (" + remaining[0] + ") | ");
			System.out.print("Business Class (" + remaining[1] + ") | ");
			System.out.print("Economy Class (" + remaining[2] + ")");
			switch (subMenu2.makeSelection()) {
				case 1:
					try {
						entry = numOfSeats(remaining[0]);
					} catch (Exception e) {
						System.out.println("No Seats Available of the Chosen Type");
						continue;
					}
			}
		}
	}

	private static int numOfSeats(int remainingSeats) {
		System.out.println("Enter the number of seats you want to reserve (0 to cancel): ");
		int numSeats = input.nextInt();

		if (numSeats < 0 || numSeats > remainingSeats) {
			System.out.println("Invalid number of seats. Please enter a value between 0 and " + remainingSeats);
			return numOfSeats(remainingSeats); // Recursively call until a valid input is provided
		} else {
			return numSeats;
		}
	}
}