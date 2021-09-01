package com.tutorials.model;

public class Invoice {
    private int invoiceNumber;
    private int upliftQuantity;
    private Airline airline;

    public Invoice(int invoiceNumber, int upliftQuantity, Airline airline) {
        this.invoiceNumber = invoiceNumber;
        this.upliftQuantity = upliftQuantity;
        this.airline = airline;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getUpliftQuantity() {
        return upliftQuantity;
    }

    public void setUpliftQuantity(int upliftQuantity) {
        this.upliftQuantity = upliftQuantity;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
