package com.tutorials.management;

import com.tutorials.database.AirlineDaoImpl;
import com.tutorials.database.InvoiceDaoImpl;
import com.tutorials.model.Invoice;

import java.util.List;
import java.util.Scanner;

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
                    case 7 -> printSumInvoicesByAirline();
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

    }

    private static void updateInvoice() {

    }

    private static void deleteInvoice() {

    }

    private static void printSumInvoicesByAirline() {

    }

    private static void sumAllInvoices() {

    }

}
