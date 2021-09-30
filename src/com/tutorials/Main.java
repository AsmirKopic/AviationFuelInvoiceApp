package com.tutorials;

import com.tutorials.database.AirlineDaoImpl;
import com.tutorials.database.InvoiceDaoImpl;
import com.tutorials.management.AirlineManagement;
import com.tutorials.management.InvoiceManagement;
import com.tutorials.model.Airline;
import com.tutorials.model.Invoice;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
    AirlineDaoImpl airlineDb = new AirlineDaoImpl();
    InvoiceDaoImpl invoiceDb = new InvoiceDaoImpl();

/**
 * This program represents aviation fueling invoice system
 * Will take input from delivery voucher provided in time of aircraft refueling.
 * Company name, Delivery voucher number, time of refuelling, specific weight of fuel, amount of liters.
 * Quantities will be calculated using specific weight (0.8) on time of refueling.
 *
 */

        // AirlineManagement.runAirlineManagement();
        InvoiceManagement.runInvoiceManagement();


    }
}
