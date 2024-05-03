package airline;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Kiosk {
		/***** MAIN MENU *****/
		private static final String TITLE_MM = "Airline Reservation Kiosk";

		private static final String[] OPTIONS_MM = { "Search Flights", "View Reservation", "Cancel Reservation" };

		private static final String OPTION_ZERO_MM = "Exit";

		/***** SUB MENU 1 *****/
		private static final String TITLE_SM1 = "Make a Reservation";
		private static final String[] OPTIONS_SM1 = { "View All Flights", "Search Flights by Arrival/Destination" };
		private static final String OPTION_ZERO_SM1 = "Return to Main Menu";

		/***** SUB MENU 2 *****/
		private static final String TITLE_SM2 = "Choose your section";
		private static final String[] OPTIONS_SM2 = { "First Class", "Business Class", "Economy Class" };
		private static final String OPTION_ZERO_SM2 = "Cancel";

		/***** SUB MENU 3 *****/
		private static final String TITLE_SM3 = "Reserve additional seats?";
		private static final String[] OPTIONS_SM3 = { "Yes" };
		private static final String OPTION_ZERO_SM3 = "No";

		/***** SUB MENU 4  *****/
		private static final String TITLE_SM4 = "Book a reservation?";
		private static final String[] OPTIONS_SM4 = { "Yes" };
		private static final String OPTION_ZERO_SM4 = "No";

		/***** SUB MENU 5  *****/
		private static final String TITLE_SM5 = "Cancel reservation?";
		private static final String[] OPTIONS_SM5 = { "Yes" };
		private static final String OPTION_ZERO_SM5 = "No";

		static Scanner input = new Scanner(System.in);
		public static void main(String args[]) throws IOException, InterruptedException {
			Menu mainMenu = new Menu(TITLE_MM, OPTIONS_MM, OPTION_ZERO_MM);
			while (true) {
				switch (mainMenu.makeSelection()) {
				case 0:
					exitKiosk();
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

		private static void searchFlights() {
			Menu subMenu1 = new Menu(TITLE_SM1, OPTIONS_SM1, OPTION_ZERO_SM1);
			while (true) {
				switch (subMenu1.makeSelection()) {
				case 0:
					return;
				case 1:
					viewAllFlights();
					break;
				case 2:
					searchFlightsByLoc();
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
	                //System.out.println(e);
	                System.out.println("Unable to get data.");
	                return -1;
	            } // end-try-catch
	            System.out.println("Searching for confirmations by email...");
	            try {
	                confirmation = data.getConfirmation(email);
	            } catch (Exception e) {
	                //System.out.println(e);
	                System.out.println("Returning to menu...");
	            } //end-try-catch
	            return confirmation;

		} // end-viewRes

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
			if(subMenu5.makeSelection() == 0) {return;}
			if(data.cancelreservation(confirmationId)) {
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
	                    //System.out.println(e);
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
					//System.out.println(e);
					System.out.println("Unable to retrieve seat information.");
					return;
				} //end-try-catch
				if(totalOpen < 1) {
					System.out.println("No seats available -- Select another flight.");
					return;
				}
				if(subMenu4.makeSelection() == 0)
					return;
	            customerInfo = enterInfo();
				try {
					seatsToReserve = chooseSeats(openSeats);
				} catch (Exception e) {
					//System.out.println(e);
					System.out.println ("Transaction Canceled");
					return;
				} //end-try-catch
	            confirmation = data.makeRes(customerInfo, chosenFlight, seatsToReserve);
	            if (confirmation == 0) {
	                    System.out.println("Reservation failed.");
	                    return;
	            } else {
	                    System.out.println("\nReservation confirmed.");
	                    System.out.println("Name: " + customerInfo[0] + " " + customerInfo[1]);
	                    System.out.println("Confirmation #: " + confirmation);
	            } //end-if-else
		} //end-viewAllFlights


		private static int[] chooseSeats(final int[] OPEN_SEATS) throws Exception {
			int[] remaining = OPEN_SEATS;
			int[] selected = {0, 0, 0};
			int entry;
			Menu subMenu2 = new Menu(TITLE_SM2, OPTIONS_SM2, OPTION_ZERO_SM2);
			Menu subMenu3 = new Menu(TITLE_SM3, OPTIONS_SM3, OPTION_ZERO_SM3);
			while(true) {
				System.out.print("\nSeats available:  ");
				System.out.print("First Class (" + remaining[0] + ") | ");
				System.out.print("Business Class (" + remaining[1] + ") | ");
				System.out.print("Economy Class (" + remaining[2] + ")");
				switch(subMenu2.makeSelection()) {
					case 1: try {
								entry = numOfSeats(remaining[0]);
							} catch (Exception e) {
								//System.out.println(e);
								System.out.println("No Seats Availible of the Chosen Type");
								continue;
							} //end-try-catch
							remaining[0] -= entry;
							selected[0] += entry;
							break;
					case 2:	try {
								entry = numOfSeats(remaining[1]);
							} catch (Exception e) {
								//System.out.println(e);
								System.out.println("No Seats Availible of the Chosen Type");
								continue;
							} //end-try-catch
							remaining[1] -= entry;
							selected[1] += entry;
							break;
					case 3:	try {
								entry = numOfSeats(remaining[2]);
							} catch (Exception e) {
								//System.out.println(e);
								System.out.println("No Seats Availible of the Chosen Type");
								continue;
							} //end-try-catch
							remaining[2] -= entry;
							selected[2] += entry;
							break;
					case 0: throw new Exception("Transaction cancelled.");
				} //end-switch
				System.out.print("\nSelected seats:  ");
				System.out.print("First Class (" + selected[0] + ") | ");
				System.out.print("Business Class (" + selected[1] + ") | ");
				System.out.print("Economy Class (" + selected[2] + ")");
				switch(subMenu3.makeSelection()) {
					case 1: break;
					case 0: return selected;
				} //end-switch
			} //end-loop
		} //end-chooseSeats

		private static int numOfSeats(final int MAX) throws Exception {
			if(MAX < 1)
				throw new Exception("No available seats in this section.");
			try (Scanner input = new Scanner(System.in)) {
				String rawInput;
				int seats;
				while(true) {
					System.out.print("How many seats would you like to reserve (max="
						+ MAX + ")? ");
					rawInput = input.nextLine().trim();
					try {
						seats = Integer.parseInt(rawInput);
					} catch (Exception e) {
						invalid("number of seats");
						continue;
					} //end-try-catch
					if(seats >= 0  && seats <= MAX) {
						return seats;
					} else {
						System.out.println("Please enter a number between 0 and " + MAX);
						System.out.println("Try again...");
					} //end-if-else
				} //end-loop
			}
		} //end-numOfSeats

		private static String[] enterInfo() {
			String rawFirst, first, rawLast, last, email;
			try (Scanner input = new Scanner(System.in)) {
				
				System.out.println("Please enter your information...");
				while (true) {
					System.out.print("First name: ");
					rawFirst = input.nextLine().trim();
					if (isOnlyLetters(rawFirst)) {
						first = rawFirst;
						break;
					} else {
						invalid("First name");
					} //end-if-else
				} //end-loop
				while (true) {
					System.out.print("Last name: ");
					rawLast = input.nextLine().trim();
					if (isOnlyLetters(rawLast)) {
						last = rawLast;
						break;
					} else {
						invalid("Last name");
					} // end-if-else
				} // end-loop
				System.out.print("Email: ");
				email = input.nextLine().trim();
			}

			return new String[] { first, last, email };
		} // end-enterInfo

		private static boolean isOnlyLetters(String s) {
			return s.matches("[ -a-zA-Z]+[a-z-']*$");
		} // end-isOnlyLetters



		private static void invalid(final String S) {
			System.out.println("\nINVALID [" + S + "]:  Try again...");
		} // end-invalid

		private static void searchFlightsByLoc() {
			try (/* Variables */
			Scanner input = new Scanner(System.in)) {
				Menu subMenu4 = new Menu(TITLE_SM4, OPTIONS_SM4, OPTION_ZERO_SM4);
				String departure, arrival, date;
				String[] customerInfo;
				Data data;
				int[] openSeats; //0=First; 1=Business; 2=Economy
				int[] seatsToReserve;
				int chosenFlight, confirmation, totalOpen;
				int[] dateValues = {0, 0, 0};
				/* Try to access the data */
				try {
					data = Data.getInstance();
				} catch (Exception e) {
					//System.out.println(e);
					System.out.println("Unable to connect to \"Data\"");
					input.close();
					return;
				}
				/* Get user input & validate */
				System.out.print("Enter your destination airport: ");
				arrival = input.nextLine();
				System.out.print("Enter your departure airport: ");
				departure = input.nextLine();
				System.out.print("Enter your preferred departure date (MM/DD/YY): ");
				date = input.nextLine().trim();
				/* Changes the date from String to integers */
				try {
					dateValues = Data.convert(date);
				} catch (Exception e) {

					System.out.println(e.toString().substring(21));
					System.out.println("You entered... " + departure + " " + arrival + " " + date);

				}
				chosenFlight = data.search(departure, arrival, dateValues);
				if (chosenFlight <= 0) {
				    System.out.println("No flight selected.");
				    return;
				} // end-if
				try {
				    openSeats = data.availableSeats(chosenFlight);
				    totalOpen = openSeats[0] + openSeats[1] + openSeats[2];
				} catch (Exception e) {
				    //System.out.println(e);
				    System.out.println("Unable to retrieve seat information.");
				    return;
				} //end-try-catch
				if(totalOpen < 1) {
				    System.out.println("No seats available -- Select another flight.");
				    return;
				}
				if(subMenu4.makeSelection() == 0)
					return;
				customerInfo = enterInfo();
				try {
				    seatsToReserve = chooseSeats(openSeats);
				} catch (Exception e) {
				    //System.out.println(e);

					System.out.println("Transaction Successfully canceled");

				    return;
				} //end-try-catch
				confirmation = data.makeRes(customerInfo, chosenFlight, seatsToReserve);
				if (confirmation == 0) {
					System.out.println("Reservation failed.");
					return;
				} else {
					System.out.println("\nReservation confirmed.");
					System.out.println("Name: " + customerInfo[0] + " " + customerInfo[1]);
					System.out.println("Confirmation #: " + confirmation);
				} //end-if-else
			}
		} // end-searchFlightsByLoc


	    private static void exitKiosk() {
	        // Close the Scanner object before exiting
	        input.close();
	        System.out.println("\nGoodbye...");
	        System.exit(0);
	    }

	} // end-Class:KioskTerminal
