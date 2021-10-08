package com.aviationFuelApp;

import com.aviationFuelApp.management.Application;

/**
 * Main class for starting application.
 */
public class Main {

    public static void main(String[] args) {

        /**
         * This application represents aviation fueling invoice system.
         *
         * Application have 2 main parts:
         *      - Airline Management system - with following options to navigate:
         *                     1. List all Airlines in database
         *                     2. Find Airline by name
         *                     3. Insert new Airline
         *                     4. Update Airline
         *                     5. Delete Airline
         *
         *      - Invoice management system - with following options to navigate:
         *                     1. List all invoices.
         *                     2. List invoices by Airline.
         *                     3. Find invoice.
         *                     4. Insert new invoice.
         *                     5. Update invoice.
         *                     6. Delete invoice.
         *                     7. Sum invoice by Airline
         *                     8. Sum all invoices.
         *
         * Application take input from delivery voucher provided in time of aircraft refueling.
         * Invoice include:
         *      - invoice number
         *      - company name
         *      - date of refuelling
         *      - specific weight of fuel
         *      - amount of litters uplifted
         *      - amount of kg (calculated using specific weight (0.8) on time of refueling
         *      - aviation fuel price per kg (depends on airline price terms have)
         *      - total price calculated
         */

        Application.startApplication();

    }
}

