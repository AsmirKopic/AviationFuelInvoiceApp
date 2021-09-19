package com.tutorials.management;

import com.tutorials.database.AirlineDaoImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AirlineManagement {

    public static final String AIRLINE_MANAGEMENT_MENU =

                    "======= AIRLINE MANAGEMENT MENU ===========\");\n" +
                    "===========================================\");\n" +
                    "Enter an option\");\n" +
                    "===========================================\");\n" +
                    "1. List all Airlines in database\");\n" +
                    "2. Find Airline by name\");\n" +
                    "3. Insert new Airline\");\n" +
                    "4. Update Airline\");\n" +
                    "5. Delete Airline\");\n" +
                    "6. Exit\");\n" +
                    "===========================================\");\n" +
                    "===========================================\")";

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static AirlineDaoImpl airlineImpl = new AirlineDaoImpl();

    public static void runAirlineManagement() {

        System.out.println(AIRLINE_MANAGEMENT_MENU);
        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        do {
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
                    System.out.println("Exit Airline management.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Option! Please enter again");
                    break;
            }


        } while (option != 6);
    }

    public static void listAllAirlines() {
    }

    public static void findAirlineByName() {
    }

    public static void insertNewAirline() {
    }

    public static void updateAirline() {
    }

    public static void deleteAirline() {
    }

}
