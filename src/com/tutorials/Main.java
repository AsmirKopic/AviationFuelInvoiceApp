package com.tutorials;


import com.tutorials.management.Application;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         * This application represents aviation fueling invoice system
         * Will take input from delivery voucher provided in time of aircraft refueling.
         * Company name, Delivery voucher number, time of refuelling, specific weight of fuel, amount of liters.
         * Quantities will be calculated using specific weight (0.8) on time of refueling.
         *
         */

        Application.startApplication();

    }
}

