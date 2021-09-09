package com.tutorials.model;

public class Invoice {
    private int invoiceNumber;
    private Airline airline;
    private String date;
    private String flightNumber;
    private String registration;
    public static final double SPECIFIC_WEIGHT = 0.795;
    private int upliftLiters;

    public Invoice(Airline airline, int invoiceNumber, String date, String flightNumber, String registration, int upliftLiters) {
        this.airline = airline;
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.flightNumber = flightNumber;
        this.registration = registration;
        this.upliftLiters = upliftLiters;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public static double getSpecificWeight() {
        return SPECIFIC_WEIGHT;
    }

    public int getUpliftLiters() {
        return upliftLiters;
    }

    public void setUpliftLiters(int upliftLiters) {
        this.upliftLiters = upliftLiters;
    }

    public double getUpliftInKg() {
        return upliftLiters * SPECIFIC_WEIGHT;
    }

}
