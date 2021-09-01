package com.tutorials.model;

public class Airline {
    public String name;
    private double price;
    private int paymentTerms;

    public Airline(String name, double price, int paymentTerms) {
        this.name = name;
        this.price = price;
        this.paymentTerms = paymentTerms;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price ;
    }

    public int getPaymentTerms() {
        return paymentTerms;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.name + " price terms: " + getPrice() + " , payment terms: " + getPaymentTerms() ;
    }
}
