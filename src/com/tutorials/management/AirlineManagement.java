package com.tutorials.management;

import com.tutorials.database.AirlineDaoImpl;
import com.tutorials.model.Airline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Executable;
import java.sql.SQLException;
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
        Airline airline = new Airline();

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

    public static void insertNewAirline() throws IllegalArgumentException {

        System.out.println("===========================================");
        System.out.println(" Insert new Airline. ");
        Scanner input = new Scanner(System.in);
        Airline airline = new Airline();
        String airlineName;
        double priceTerms;
        int paymentTerms;

        try {

            System.out.println("Please enter airline name:");
            airlineName = input.nextLine();
            airline.setName(airlineName);

            if (airlineImpl.isInDatabase(airline)) {
                throw new IllegalArgumentException("Airline is already in database!");
            } else {

                System.out.println("Please enter airline price terms: ");
                priceTerms = input.nextInt();

                System.out.println("Please enter airline payment terms: ");
                paymentTerms = input.nextInt();

                airline.setPriceTerms(priceTerms);
                airline.setPaymentTerms(paymentTerms);

                try {
                    airlineImpl.insertAirline(airline);
                    System.out.println(airlineName + " added to database!");
                    System.out.println("===========================================");

                } catch (Exception e) {
                    System.out.println("Cant execute database query " + e.getMessage());
                }
            }

        } catch (Exception e1) {
            System.out.println("Cant insert new airline. " + e1.getMessage());
        }
    }

    public static void updateAirline() {
    }

    public static void deleteAirline() {
    }

}
