package airline;

import java.util.Scanner;

public class Menu {
    /* Instance variables for Menu class */
    final String TITLE;
    final String[] OPTIONS;
    final String OPTION_ZERO;

    /* Constructor */
    public Menu(final String TITLE,
                final String[] OPTIONS,
                final String OPTION_ZERO) {
        this.TITLE = TITLE;
        this.OPTIONS = OPTIONS;
        this.OPTION_ZERO = OPTION_ZERO;
    } //end-Menu
    static Scanner input = new Scanner(System.in);
    /* Calls printMenu() */
    /* Prompts the user to make a selection*/
    /* Verifies & sanitizes user input */
    /* Returns selected option as int-type */
    /* Tries again if user enters invalid input */
    /* *** Always returns 'good' values *** */
    public int makeSelection() {
        /* Instance variables for makeSelection() */
        String rawInput = "";
        boolean validInput = false;
        final int MENU_SIZE = OPTIONS.length;
        int selection = 0;

        printMenu();
        System.out.print("Enter selection: ");
        try {
        	rawInput = input.nextLine();
        	selection = Integer.parseInt(rawInput);
        } catch (Exception e) {
        	invalid(MENU_SIZE);
        }
        /* After receiving a valid entry, */
        /* change validInput to fall out of loop */
        if (selection >= 0 && selection <= MENU_SIZE) {
        	validInput = true;
        } else {
        	invalid(MENU_SIZE);
        }
        // input.close();  // causes nextLine() to throw Exception ??
        
        /* Return the user-selected menu option */
        return selection;
    } //end-makeSelection

    /* Prints the menu and */
    /* automatically numbers each option */
    private void printMenu() {
        /* Instance variables for printMenu() */
        int optionNumber = 1;
        final int MENU_WIDTH = TITLE.length();
        /* Prints menu with formatting */
        System.out.println();
        System.out.println(TITLE);
        printDashedLine(MENU_WIDTH);
        for (String prompt : OPTIONS) {
            System.out.println(optionNumber +
                ") " +
                prompt);
            optionNumber++;
        }
        System.out.println("0) " + OPTION_ZERO);
        printDashedLine(MENU_WIDTH);
    } //end-printMenu

    /* Prints a dashed line the same width as "TITLE" */
    static void printDashedLine(final int WIDTH) {
        for (int i = WIDTH; i > 0; i--) {
            System.out.print("-");
        }
        System.out.println();
    } //end-printDashedLine

    /* Prints a console message after invalid entry */
    private void invalid(final int MENU_SIZE) {
        System.out.println("\nINVALID INPUT: " +
            "Please enter a number between 0 and " +
             MENU_SIZE +
            "\nTry again...\n");
    } //end-invalid
} //end-class:Menu