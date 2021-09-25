package com.tutorials.management;

import com.tutorials.database.AirlineDaoImpl;
import com.tutorials.model.Airline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Executable;
import java.util.List;
import java.util.Scanner;

public class AirlineManagement {

    public static final String AIRLINE_MANAGEMENT_MENU =

                    "======= AIRLINE MANAGEMENT MENU ===========\n" +
                    "===========================================\n" +
                    "Enter an option\n" +
                    "===========================================\n" +
                    "1. List all Airlines in database\n" +
                    "2. Find Airline by name\n" +
                    "3. Insert new Airline\n" +
                    "4. Update Airline\n" +
                    "5. Delete Airline\n" +
                    "6. Exit\n" +
                    "===========================================\n" +
                    "===========================================";

    static AirlineDaoImpl airlineImpl = new AirlineDaoImpl();

    public static void runAirlineManagement() {

        int option = 0;
        boolean menu = true;

        while (menu) {

            System.out.println(AIRLINE_MANAGEMENT_MENU);

            try {
                Scanner input = new Scanner(System.in);
                option = input.nextInt();

                switch (option) {
                    case 1:
                        listAllAirlines();
                        break;

                    case 2:
                        findAirlineByName();
                        break;

                    case 3:
                        insertNewAirline();
                        break;

                    case 4:
                        updateAirline();
                        break;

                    case 5:
                        deleteAirline();
                        break;

                    case 6:
                        menu = false;
                        System.out.println("Exit Airline management.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Option! Please enter again!");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Management menu exception" + e.getMessage());
                //input.nextLine();
            }

        }
    }

    public static void listAllAirlines() {

        System.out.println("===========================================");

        List<Airline> listOfAirlines = airlineImpl.listAllAirlines();

        listOfAirlines.forEach( airline -> {
            System.out.printf("%-20s $%.2f%n", airline.getName(), airline.getPriceTerms(), airline.getPaymentTerms());
        });

        System.out.println("===========================================");

    }

    public static void findAirlineByName() {

        Scanner input = new Scanner(System.in);
        Airline airline;

        System.out.println("===========================================");

        try {
            System.out.println("Please enter airline name:");
            String name = input.nextLine();

            airline = airlineImpl.findAirlineByName(name);

            if (airline != null) {
                System.out.println(airline);
            } else {
                System.out.println("Cant find entered airline..");
            }

        } catch (Exception e) {
            System.out.println("Error - Find airline." + e.getMessage());
        }

        System.out.println("===========================================");

    }

    public static void insertNewAirline() {
    }

    public static void updateAirline() {
    }

    public static void deleteAirline() {
    }

}
