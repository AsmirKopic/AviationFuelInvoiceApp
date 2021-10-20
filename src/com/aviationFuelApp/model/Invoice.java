package com.aviationFuelApp.model;

public class Invoice {

    private int invoiceNumber;
    private String airlineName;
    private String date;
    private String flightNumber;
    private String registration;
    private int upliftLiters;
    private double upliftInKg;
    private double price;
    private double totalPrice;
    public static final double SPECIFIC_WEIGHT = 0.795;

    public Invoice() {
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
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

    public int getUpliftLiters() {
        return upliftLiters;
    }

    public void setUpliftLiters(int upliftLiters) {
        this.upliftLiters = upliftLiters;
    }

    public double getUpliftInKg() {
        return this.upliftLiters * SPECIFIC_WEIGHT;
    }

    public void setUpliftInKg(double upliftInKg) {
        this.upliftInKg = upliftInKg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return (getPrice() * getUpliftInKg()) / 1000.0;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString(){
        return String.format("%10d%20s%10s%10s%10s%8d%8f%8f%8f",
            invoiceNumber,
            airlineName,
            date,
            flightNumber,
            registration,
            upliftLiters,
            getUpliftInKg(),
            price,
            getTotalPrice());
    }
}
