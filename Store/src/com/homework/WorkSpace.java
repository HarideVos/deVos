package com.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkSpace {

    public static void main(String[] args) {
    	   Scanner scanner = new Scanner(System.in);
           List<Product> inventory = new ArrayList<>();

           System.out.println("Welcome to the store!");

           while (true) {
               System.out.println("What would you like to do?");
               System.out.println("a. Add item to inventory");
               System.out.println("b. Check inventory");
               System.out.println("c. Leave store");
               String choice = scanner.nextLine();

               switch (choice.toLowerCase()) {
                   case "a":
                       System.out.println("Which item would you like to add?");
                       System.out.println("1. Laptop");
                       System.out.println("2. Table");
                       System.out.println("3. Light");
                       int option = Integer.parseInt(scanner.nextLine());
                       switch (option) {
                           case 1:
                               System.out.println("Enter details for Laptop:");
                               System.out.print("ID: ");
                               int id = Integer.parseInt(scanner.nextLine());
                               System.out.print("Name: ");
                               String name = scanner.nextLine();
                               System.out.print("Price: ");
                               double price = Double.parseDouble(scanner.nextLine());
                               System.out.print("Rating: ");
                               double rating = Double.parseDouble(scanner.nextLine());
                               System.out.print("Screen Size (inches): ");
                               double screenSize = Double.parseDouble(scanner.nextLine());
                               System.out.print("RAM (GB): ");
                               int ram = Integer.parseInt(scanner.nextLine());
                               System.out.print("SSD (GB): ");
                               int ssd = Integer.parseInt(scanner.nextLine());
                               System.out.print("Processor: ");
                               String processor = scanner.nextLine();
                               inventory.add(new Laptop(id, name, price, rating, screenSize, ram, ssd, processor));
                               break;
                           case 2:
                        	   System.out.println("Enter details for Table:");
                               System.out.print("ID: ");
                               int id1 = Integer.parseInt(scanner.nextLine());
                               System.out.print("Name: ");
                               String name1 = scanner.nextLine();
                               System.out.print("Price: ");
                               double price1 = Double.parseDouble(scanner.nextLine());
                               System.out.print("Rating: ");
                               double length = Double.parseDouble(scanner.nextLine());
                               System.out.print("Length: ");
                               double height = Double.parseDouble(scanner.nextLine());
                               System.out.print("Height: ");
                               double width = Double.parseDouble(scanner.nextLine());
                               System.out.print("Width: ");
                               inventory.add(new Table(id1, name1, price1, length, width, height));
                               break;
                           case 3:
                        	   System.out.println("Enter details for Light:");
                               System.out.print("ID: ");
                               int id2 = Integer.parseInt(scanner.nextLine());
                               System.out.print("Name: ");
                               String name2 = scanner.nextLine();
                               System.out.print("Price: ");
                               double price2 = Double.parseDouble(scanner.nextLine());
                               System.out.print("Watts: ");
                               int watts = Integer.parseInt(scanner.nextLine());
                               System.out.print("Lumens: ");
                               int lumens = Integer.parseInt(scanner.nextLine());
                               inventory.add(new Light(id2, name2, price2, watts, lumens));
                               break;
                           default:
                               System.out.println("Invalid option");
                       }
                       break;
                   case "b":
                       System.out.println("Current Inventory:");
                       break;
                   case "c":
                       System.out.println("Thank you for visiting the store!");
                       return;
                   default:
                       System.out.println("Invalid choice. Please select a, b, or c.");
               }
           }
    }
}
