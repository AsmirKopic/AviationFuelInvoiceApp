package com.tutorials;

import com.tutorials.database.AirlineDaoImpl;
import com.tutorials.database.InvoiceDaoImpl;
import com.tutorials.management.AirlineManagement;
import com.tutorials.model.Airline;
import com.tutorials.model.Invoice;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
    AirlineDaoImpl airlineDb = new AirlineDaoImpl();
    InvoiceDaoImpl invoiceDb = new InvoiceDaoImpl();

//    // This program represents aviation fueling invoice system
//	// Will take input from delivery voucher provided in time of aircraft refueling.
//    // Company name, Delivery voucher number, time of refuelling, specific weight of fuel, amount of liters.
//    // Quantities will be calculated using specific weight (0.8) on time of refueling.
//
//
//        // print list of airlines
//        List<Airline> airlines = airlineDb.listAllAirlines();
//        airlines.forEach(airline -> System.out.println(airline));
//
//        // insert airlines
//        Airline flyNas = new Airline("Fly Nas", 215, 15);
//        airlineDb.insertAirline(flyNas);
//        System.out.println(airlineDb.isInDatabase(flyNas));
//
////           airlineDb.deleteAirline(flyNas);
//
////       checking method
////       System.out.println(invoiceDb.isInDatabase(1));
//
////        public Invoice(int invoiceNumber, String airlineName, String date, String flightNumber, String registration, int upliftLiters, double upliftInKg, double price, double totalPrice) {
////        Invoice invoice1 = new Invoice(3, "Fly Nas", "20.09.", "123", "reg", 300, 45.50, 200, 450);
////
////        System.out.println(invoice1);
////        invoiceDb.newInvoice(invoice1);
////
////        checking statements
////        List<Invoice> invoices = invoiceDb.listAllInvoices();
////        invoices.forEach( invoice -> System.out.println(invoice));

//        System.out.println("Insert name of airline customer");
//        Scanner input = new Scanner(System.in);
//
//        String airlineName = input.nextLine();
//
//
//        Airline airline = airlineDb.findAirlineByName(airlineName);
//        Invoice invoice = new Invoice();
//        if (airline != null) {
//
//            invoice.setAirlineName(airline.getName());
//            invoice.setPrice(airline.getPriceTerms());
//            invoice.setUpliftLiters(1234);
//            invoice.setRegistration("REG123");
//            invoice.setFlightNumber("56789");
//            invoice.setDate("19/9/2021");
//        }
//
//
//        System.out.println(invoice.toString());
//
//        invoiceDb.insertInvoice(airline, invoice);

        AirlineManagement.runAirlineManagement();


    }
}
