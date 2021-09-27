package com.tutorials.management;

import com.tutorials.database.AirlineDaoImpl;
import com.tutorials.database.InvoiceDaoImpl;

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

    }

    private static void listInvoicesByAirline() {

    }

    private static void findInvoice() {

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
