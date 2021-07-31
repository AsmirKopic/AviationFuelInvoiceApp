package com.tutorials;

public class Main {

    private static AvioService avioService = new AvioService();
    public static void main(String[] args) {
	// This program will take input from delivery voucher provided in time of aircraft refueling.
    // Company name, Delivery voucher number, time of refuelling, specific weight of fuel, amount of liters.
    // Quantities will be calculated using specific weight (0.8) on time of refueling.


        Airline temp = new Airline("Turkish Airlines", 210, 15);
        avioService.addAirline(temp);
        temp = new Airline("Austrian airlines", 205, 7);
        avioService.addAirline(temp);

        temp = new Airline("Kuwait Airways", 215, 15);
        avioService.addAirline(temp);

        avioService.listOfAirlines();




    }
}
