package com.aviationFuelApp.management;

import java.util.Scanner;

/**
 * Main application class to navigate Airline Management or Invoice Management parts of application.
 *
 */
public class Application {

    public static final String APP_MENU =
            """
                   ======= AVIATION FUEL MANAGEMENT ===========
                   ================ MENU ======================
                   Enter an option
                   ===========================================
                   1. Airline management.
                   2. Invoice management.
                   3. Terms and conditions (N/A)
                
                   4. Exit application.
                   ===========================================
            """;

    /**
     * Method for choosing options on main menu.
     */
    public static void startApplication() {

        int option;
        boolean menu = true;

        while (menu) {

            System.out.println(APP_MENU);

            try {
                Scanner input = new Scanner(System.in);
                option = input.nextInt();

                switch (option) {
                    case 1 -> AirlineManagement.runAirlineManagement();
                    case 2 -> InvoiceManagement.runInvoiceManagement();
                    case 3 -> System.out.println("Application User’s Guide \n Not yet provided.");
                    case 4 -> {
                        menu = false;
                        System.out.println("Exit application");
                    }
                    default -> System.out.println("Invalid Option! Please enter again!");
                }

            } catch (Exception e) {
                System.out.println("Application menu exception" + e.getMessage());
            }
        }
    }
}
