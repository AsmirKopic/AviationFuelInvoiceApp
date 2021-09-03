package com.tutorials.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InvoiceDatabase {

    public static final String DB_NAME = "aviationFuelService.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\AviationFuel\\" + DB_NAME;

    public static final String NEW_INVOICE = "INSERT INTO invoices " +
            "(airline, invoice_number, date, flight_number, registration, quantity_lit)" +
            " VALUES(?, ?, ?, ?, ?, ?)";


    private Connection conn;
    private PreparedStatement newInvoice;
    private PreparedStatement queryInvoices;
    private PreparedStatement queryInvoicesByAirline;
    private PreparedStatement queryInvoicesByNumber;
    private PreparedStatement queryInvoicesByDatePeriod;
    private PreparedStatement queryInvoicesByDatePeriodAndAirline;











}
