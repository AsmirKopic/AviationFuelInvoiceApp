package com.tutorials.management;

import com.tutorials.database.AirlineDaoImpl;
import com.tutorials.database.InvoiceDaoImpl;
import com.tutorials.model.Airline;
import com.tutorials.model.Invoice;

import java.util.List;
import java.util.Scanner;

/**
 * Class to navigate Invoice management options
 */
public class InvoiceManagement {

    public static final String INVOICE_MANAGEMENT_MENU =

            """
                    ======= INVOICE MANAGEMENT MENU ===========
                    ===========================================
                    Enter an option
                    ===========================================
                    1. List all invoices.
                    2. List invoices by Airline.
                    3. Find invoice.
                    4. Insert new invoice.
                    5. Update invoice.
                    6. Delete invoice.
                    7. Sum invoice by Airline
                    8. Sum all invoices.
                 
                    9. Exit
                    ===========================================
                    ===========================================""";

    static AirlineDaoImpl airlineImpl = new AirlineDaoImpl();
    static InvoiceDaoImpl invoiceImpl = new InvoiceDaoImpl();

    /**
     * Method for choosing options on Invoice Management menu.
     */
    public static void runInvoiceManagement() {

        int option;
        boolean menu = true;

        while (menu) {

            System.out.println(INVOICE_MANAGEMENT_MENU);

            try {
                Scanner input = new Scanner(System.in);
                option = input.nextInt();

                switch (option) {
                    case 1 -> listAllInvoices();
                    case 2 -> listInvoicesByAirline();
                    case 3 -> findInvoice();
                    case 4 -> insertNewInvoice();
                    case 5 -> updateInvoice();
                    case 6 -> deleteInvoice();
                    case 7 -> sumInvoicesByAirline();
                    case 8 -> sumAllInvoices();
                    case 9 -> {
                        menu = false;
                        System.out.println("Exit Invoice management.");
                    }
                    default -> System.out.println("Invalid Option! Please enter again!");
                }

            } catch (Exception e) {
                System.out.println("Management menu exception" + e.getMessage());
            }
        }
    }

    private static void listAllInvoices(){

        System.out.println("LIST OF ALL INVOICES ");
        List<Invoice> listOfInvoices = invoiceImpl.listAllInvoices();
        listOfInvoices.forEach( invoice -> System.out.println(invoice));

    }

    private static void listInvoicesByAirline() {

        Scanner input = new Scanner(System.in);
        String airlineName;

        System.out.println("LIST OF ALL INVOICES FOR AIRLINE ");
        System.out.println("Please enter name of airline: ");

        airlineName = input.nextLine();

        if (airlineImpl.isInDatabase(airlineName)) {

            List<Invoice> invoices = invoiceImpl.listInvoicesByAirline(airlineName);
            invoices.forEach( invoice -> System.out.println(invoice));

        } else {
            System.out.println("Cant find invoices for entered name: " + airlineName);
        }
    }

    private static void findInvoice() {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter invoice number: ");
        int invoiceNumber = input.nextInt();

        if (invoiceImpl.isInDatabase(invoiceNumber)) {
            Invoice invoice = invoiceImpl.findInvoiceByNum(invoiceNumber);
            System.out.println(invoice);
        } else {
            System.out.println("Cant find entered invoice.");
        }
    }

    private static void insertNewInvoice() {

        Scanner input = new Scanner(System.in);
        Invoice invoice = new Invoice();

        System.out.println("Insert new invoice. ");
        System.out.println("Please enter airline: ");
        String airlineName = input.nextLine();

        if (airlineImpl.isInDatabase(airlineName)) {

            Airline airline = airlineImpl.findAirlineByName(airlineName);

            System.out.println("Please enter date: ");
            String date = input.nextLine();

            System.out.println("Please enter flight number: ");
            String flightNumber = input.nextLine();

            System.out.println("Please enter registration number: ");
            String registrationNumber = input.nextLine();

            System.out.println("Please enter uplift liters: ");
            int upliftLiters;
            do {
                System.out.println("Please enter positive number!");

                while (!input.hasNextInt()) {
                    System.out.println("That's not a number!");
                    input.next();
                }
                upliftLiters = input.nextInt();
                input.nextLine();

            } while (upliftLiters <= 0);

            invoice.setInvoiceNumber(invoiceImpl.lastInvoiceNumber() + 1);
            invoice.setAirlineName(airlineName);
            invoice.setDate(date);
            invoice.setRegistration(registrationNumber);
            invoice.setFlightNumber(flightNumber);
            invoice.setUpliftLiters(upliftLiters);
            invoice.setPrice(airline.getPriceTerms());

            try {
                int status = invoiceImpl.insertInvoice(invoice);
                if (status == 1) {
                    System.out.println("Invoice number " + invoice.getInvoiceNumber() + " added into database.");
                }
            } catch (Exception e) {
                System.out.println("Cant add new invoice " + e.getMessage());
            }

        } else {
            System.out.println("No entered airline into database.");
        }
    }

    private static void updateInvoice() {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter invoice number: ");
        int invoiceNumber = input.nextInt();

        if (invoiceImpl.isInDatabase(invoiceNumber)) {

            Invoice invoice = invoiceImpl.findInvoiceByNum(invoiceNumber);

            System.out.println("Please enter airline: ");
            String airlineName = input.nextLine();
            Airline airline = airlineImpl.findAirlineByName(airlineName);

            System.out.println("Please enter date: ");
            String date = input.nextLine();

            System.out.println("Please enter flight number: ");
            String flightNumber = input.nextLine();

            System.out.println("Please enter registration number: ");
            String registrationNumber = input.nextLine();

            System.out.println("Please enter uplift liters: ");
            int upliftLiters;
            do {
                System.out.println("Please enter positive number!");

                while (!input.hasNextInt()) {
                    System.out.println("That's not a number!");
                    input.next();
                }
                upliftLiters = input.nextInt();
                input.nextLine();

            } while (upliftLiters <= 0);

            invoice.setAirlineName(airlineName);
            invoice.setDate(date);
            invoice.setRegistration(registrationNumber);
            invoice.setFlightNumber(flightNumber);
            invoice.setUpliftLiters(upliftLiters);
            invoice.setPrice(airline.getPriceTerms());

            try {
                int status = invoiceImpl.updateInvoice(invoice);
                if (status == 1) {
                    System.out.println("Invoice number " + invoice.getInvoiceNumber() + " updated.");
                }
            } catch (Exception e) {
                System.out.println("Cant update invoice " + e.getMessage());
            }

        } else {
            System.out.println("No invoice number into database.");
        }
    }

    private static void deleteInvoice() {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter invoice number: ");
        int invoiceNumber = input.nextInt();

        if (invoiceImpl.isInDatabase(invoiceNumber)) {
            Invoice invoice = invoiceImpl.findInvoiceByNum(invoiceNumber);
            invoiceImpl.deleteInvoice(invoice);
            System.out.println("Invoice number: " + invoiceNumber + " deleted.");
        } else {
            System.out.println("Cant find entered invoice.");
        }
    }

    private static void sumInvoicesByAirline() {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter airline name: ");
        String airlineName = input.nextLine();

        if (airlineImpl.isInDatabase(airlineName)) {
            Invoice totalInvoice = invoiceImpl.sumInvoicesByAirline(airlineName);

            if (totalInvoice != null) {
                System.out.println("Airline name: " + airlineName +
                        "Total uplift liters: " + totalInvoice.getUpliftLiters() +
                        "Total uplift kg: " + totalInvoice.getUpliftInKg() +
                        "Total price: " + totalInvoice.getPrice());
            }

        } else {
            System.out.println("No invoices to summarize.");
        }
    }

    private static void sumAllInvoices() {

        Invoice totalInvoice = invoiceImpl.sumAllInvoices();

        if (totalInvoice != null) {

            System.out.println("Total uplift liters: " + totalInvoice.getUpliftLiters() +
                    "Total uplift kg: " + totalInvoice.getUpliftInKg() +
                    "Total price: " + totalInvoice.getPrice());
        }
    }


}
