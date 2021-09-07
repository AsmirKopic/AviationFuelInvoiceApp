package com.tutorials;

import com.tutorials.database.AirlineDatabase;
import com.tutorials.model.Airline;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
    AirlineDatabase airlineDb = new AirlineDatabase();
    if (!airlineDb.open()){
        System.out.println("Cant open datasource");
    }

    // This program represents aviation fueling invoice system
	// Will take input from delivery voucher provided in time of aircraft refueling.
    // Company name, Delivery voucher number, time of refuelling, specific weight of fuel, amount of liters.
    // Quantities will be calculated using specific weight (0.8) on time of refueling.


        // print list of airlines
        List<Airline> airlines = airlineDb.listOfAirlines();
        airlines.forEach(airline -> System.out.println(airline));


        airlineDb.close();
    }
}
