package com.tutorials;

import com.tutorials.model.Airline;

public class Main {

    private static AvioService avioService = new AvioService();
    public static void main(String[] args) {

	// This program will take input from delivery voucher provided in time of aircraft refueling.
    // Company name, Delivery voucher number, time of refuelling, specific weight of fuel, amount of liters.
    // Quantities will be calculated using specific weight (0.8) on time of refueling.


        //testing object

        Airline temp = new Airline("Turkish Airlines", 210, 15);
        avioService.addAirline(temp);
        temp = new Airline("Austrian airlines", 205, 7);
        avioService.addAirline(temp);

        temp = new Airline("Kuwait Airways", 215, 15);
        avioService.addAirline(temp);

        avioService.listOfAirlines();
        System.out.println("..............................");

        try {
            avioService.removeAirline(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        avioService.listOfAirlines();

    }
}
