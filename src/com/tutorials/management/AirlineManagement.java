package com.tutorials.management;

import com.tutorials.database.AirlineDaoImpl;
import com.tutorials.model.Airline;

import java.util.List;
import java.util.Scanner;

/**
 * Class to navigate Airline management options
 */
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

    /**
     * Method for choosing options on Airline Management menu.
     */
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
                    }
                    default -> System.out.println("Invalid Option! Please enter again!");
                }

            } catch (Exception e) {
                System.out.println("Management menu exception" + e.getMessage());
            }

        }
    }
    // need to fix printing
    public static void listAllAirlines() {

        List<Airline> listOfAirlines = airlineImpl.listAllAirlines();
        listOfAirlines.forEach( airline -> System.out.printf("%-20s $%.2f%n", airline.getName(), airline.getPriceTerms(), airline.getPaymentTerms()));

        System.out.println("===========================================");

    }

    public static void findAirlineByName() {

        Scanner input = new Scanner(System.in);
        Airline airline;

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
    }

    public static void insertNewAirline() throws IllegalArgumentException {

        Scanner input = new Scanner(System.in);
        Airline airline = new Airline();

        String airlineName;
        double priceTerms;
        int paymentTerms;

        try {

            System.out.println("Please enter airline name:");
            airlineName = input.nextLine();

            if (airlineImpl.isInDatabase(airlineName)) {
                throw new IllegalArgumentException("Airline is already in database!");

            } else {

                System.out.println("Please enter airline price terms: ");
                priceTerms = input.nextInt();

                System.out.println("Please enter airline payment terms: ");
                paymentTerms = input.nextInt();

                airline.setName(airlineName);
                airline.setPriceTerms(priceTerms);
                airline.setPaymentTerms(paymentTerms);

                try {
                    int status = airlineImpl.insertAirline(airline);

                    if (status == 1) {
                        System.out.println(airlineName + " added to database!");
                    }

                } catch (Exception e) {
                    System.out.println("Cant execute database query " + e.getMessage());
                }
            }

        } catch (Exception e1) {
            System.out.println("Cant insert new airline. " + e1.getMessage());
        }
    }

    public static void updateAirline() {

        Scanner input = new Scanner(System.in);
        Airline airline = new Airline();

        System.out.println("Please enter name of airline: ");
        String airlineName = input.nextLine();

        if (airlineImpl.isInDatabase(airlineName)) {

            double priceTerms;
            int paymentTerms;

            System.out.println("Please enter new airline price terms: ");
            priceTerms = input.nextDouble();

            System.out.println("Please enter new airline payment terms: ");
            paymentTerms = input.nextInt();

            airline.setName(airlineName);
            airline.setPriceTerms(priceTerms);
            airline.setPaymentTerms(paymentTerms);

            try {
                int status = airlineImpl.updateAirline(airline);

                if (status == 1) {
                    System.out.println(airlineName + " edited in database!");
                }

            } catch (Exception e) {
                System.out.println("Cant execute database query " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Airline is not in database!");
        }
    }

    public static void deleteAirline() {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter airline name: ");
        String airlineName = input.nextLine();

        if (airlineImpl.isInDatabase(airlineName)) {

            try {
                int status = airlineImpl.deleteAirline(airlineName);

                if (status == 1) {
                    System.out.println(airlineName + " deleted from database.");
                }

            } catch (Exception e) {
                System.out.println("Cant execute database query " + e.getMessage());
            }
        }
    }
}
