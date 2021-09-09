package com.tutorials.model;

public class Invoice {
    private int invoiceNumber;
    private String airlineName;
    private String date;
    private String flightNumber;
    private String registration;
    public static final double SPECIFIC_WEIGHT = 0.795;
    private int upliftLiters;
    private double upliftInKg;
    private double price;
    private double totalPrice;

    public Invoice() {
    }

//    public Invoice(int invoiceNumber,String airline, String date, String flightNumber, String registration, int upliftLiters) {
//        this.airlineName = airline;
//        this.invoiceNumber = invoiceNumber;
//        this.date = date;
//        this.flightNumber = flightNumber;
//        this.registration = registration;
//        this.upliftLiters = upliftLiters;
//        this.upliftInKg = upliftLiters * SPECIFIC_WEIGHT;
//    }

    public String getAirline() {
        return airlineName;
    }

    public void setAirline(String airline) {
        this.airlineName = airline;
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

    public int getUpliftLiters() {
        return upliftLiters;
    }

    public void setUpliftLiters(int upliftLiters) {
        this.upliftLiters = upliftLiters;
    }

    public double getUpliftInKg() {
        return upliftLiters * SPECIFIC_WEIGHT;
    }

    public void setUpliftInKg(double upliftInKg) {
        this.upliftInKg = upliftInKg;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNumber=" + invoiceNumber +
                ", airlineName='" + airlineName + '\'' +
                ", date='" + date + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", registration='" + registration + '\'' +
                ", upliftLiters=" + upliftLiters +
                ", upliftInKg=" + upliftInKg +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
