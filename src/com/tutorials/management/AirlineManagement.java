package com.tutorials.management;

import com.tutorials.database.AirlineDaoImpl;
import com.tutorials.model.Airline;

import java.util.List;
import java.util.Scanner;

public class AirlineManagement {

    public static final String AIRLINE_MANAGEMENT_MENU =

            """
                    ======= AIRLINE MANAGEMENT MENU ===========
                    ===========================================
                    Enter an option
                    ===========================================
                    1. List all Airlines in database
                    2. Find Airline by name
                    3. Insert new Airline
                    4. Update Airline
                    5. Delete Airline
                    6. Exit
                    ===========================================
                    ===========================================""";

    static AirlineDaoImpl airlineImpl = new AirlineDaoImpl();

    public static void runAirlineManagement() {

        int option;
        boolean menu = true;

        while (menu) {

            System.out.println(AIRLINE_MANAGEMENT_MENU);

            try {
                Scanner input = new Scanner(System.in);
                option = input.nextInt();

                switch (option) {
                    case 1 -> listAllAirlines();
                    case 2 -> findAirlineByName();
                    case 3 -> insertNewAirline();
                    case 4 -> updateAirline();
                    case 5 -> deleteAirline();
                    case 6 -> {
                        menu = false;
                        System.out.println("Exit Airline management.");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Option! Please enter again!");
                }

            } catch (Exception e) {
                System.out.println("Management menu exception" + e.getMessage());
            }

        }
    }

    public static void listAllAirlines() {

        System.out.println("===========================================");

        List<Airline> listOfAirlines = airlineImpl.listAllAirlines();
        listOfAirlines.forEach( airline -> System.out.printf("%-20s $%.2f%n", airline.getName(), airline.getPriceTerms(), airline.getPaymentTerms()));

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
