package com.tutorials.database;

import com.tutorials.model.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class InvoiceDatabase implements InvoiceDAO {

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


    @Override
    public boolean open() {
        return false;
    }

    @Override
    public boolean close() {
        return false;
    }

    @Override
    public List<Invoice> listAllInvoices() {
        return null;
    }

    @Override
    public List<Invoice> listAllInvoicesByAirline() {
        return null;
    }

    @Override
    public Invoice findInvoiceByNum(int invoiceNumber) {
        return null;
    }

    @Override
    public boolean newInvoice(Invoice invoice) {
        return false;
    }

    @Override
    public boolean editInvoice(Invoice invoice) {
        return false;
    }

    @Override
    public boolean deleteInvoice(Invoice invoice) {
        return false;
    }
}
