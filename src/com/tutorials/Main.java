package com.tutorials;

import com.tutorials.database.AirlineDatabase;
import com.tutorials.database.InvoiceDatabase;
import com.tutorials.model.Airline;
import com.tutorials.model.Invoice;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
    AirlineDatabase airlineDb = new AirlineDatabase();
    InvoiceDatabase invoiceDb = new InvoiceDatabase();

    //checking connection
    if (!airlineDb.open() || !invoiceDb.open() ){
        System.out.println("Cant open datasource");
    }


    // This program represents aviation fueling invoice system
	// Will take input from delivery voucher provided in time of aircraft refueling.
    // Company name, Delivery voucher number, time of refuelling, specific weight of fuel, amount of liters.
    // Quantities will be calculated using specific weight (0.8) on time of refueling.


        // print list of airlines
        List<Airline> airlines = airlineDb.findAllAirlines();
        airlines.forEach(airline -> System.out.println(airline));

        // insert airlines
        Airline flyNas = new Airline("Fly Nas", 215, 15);
        airlineDb.insertAirline(flyNas);
        System.out.println(airlineDb.isInDatabase(flyNas));

        //checking method
        System.out.println(invoiceDb.isInDatabase(1));












        airlineDb.close();
        invoiceDb.close();
    }
}
