package com.tutorials.database;

import com.tutorials.model.Invoice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InvoiceDatabase implements InvoiceDAO {

    public static final String DB_NAME = "aviationFuelService.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\AviationFuel\\" + DB_NAME;

    public static final String NEW_INVOICE = "INSERT INTO invoices " +
            "(airline, invoice_number, date, flight_number, registration, quantity_lit)" +
            " VALUES(?, ?, ?, ?, ?, ?)";
    public static final String QUERY_INVOICES = "SELECT * FROM invoices";
    public static final String QUERY_INVOICES_BY_AIRLINE = "SELECT * FROM invoices WHERE airline = ?";
    public static final String QUERY_INVOICES_BY_INVOICE_NUMBER = "SELECT * FROM invoices WHERE invoice_number = ?";

    private Connection conn;
    private PreparedStatement newInvoice;
    private PreparedStatement queryInvoices;
    private PreparedStatement queryInvoicesByAirline;
    private PreparedStatement queryInvoicesByInvNumber;
    private PreparedStatement queryInvoicesByDatePeriod;            // needs to be implemented
    private PreparedStatement queryInvoicesByDatePeriodAndAirline;  // needs to be implemented


    @Override
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            newInvoice = conn.prepareStatement(NEW_INVOICE);
            queryInvoices = conn.prepareStatement(QUERY_INVOICES);
            queryInvoicesByAirline = conn.prepareStatement(QUERY_INVOICES_BY_AIRLINE);
            queryInvoicesByInvNumber = conn.prepareStatement(QUERY_INVOICES_BY_INVOICE_NUMBER);
            return true;

        } catch (SQLException e) {
            System.out.println("Couldn't open connection." + e.getMessage());
            return false;
        }
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
