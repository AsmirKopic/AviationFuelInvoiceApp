package com.tutorials.model;

public class Airline {
    public String name;
    private double priceTerms;
    private int paymentTerms;

//    public Airline(){
//    }
//    public Airline(String name, double priceTerms, int paymentTerms) {
//        this.name = name;
//        this.priceTerms = priceTerms;
//        this.paymentTerms = paymentTerms;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceTerms() {
        return priceTerms;
    }

    public void setPriceTerms(double priceTerms) {
        this.priceTerms = priceTerms;
    }

    public int getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(int paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.name + " price terms: " + getPriceTerms() + " , payment terms: " + getPaymentTerms() ;
    }
}
