package com.tutorials.database;

import com.tutorials.model.Airline;
import com.tutorials.model.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvoiceDaoImpl implements InvoiceDAO {

    public static final String NEW_INVOICE = "INSERT INTO invoices " +
            "(airline_name, date, flight_number, reg_number, uplift_liters, uplift_kg, price, total_price )" +
            " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String QUERY_INVOICES = "SELECT * FROM invoices";
    public static final String QUERY_INVOICES_BY_AIRLINE = "SELECT * FROM invoices WHERE airline_name = ?";
    public static final String QUERY_INVOICES_BY_INVOICE_NUMBER = "SELECT * FROM invoices WHERE invoice_number = ?";
    public static final String UPDATE_INVOICE = "UPDATE invoices SET airline_name = ?, date = ?," +
            "flight_number = ?, reg_number = ?, uplift_liters = ?, uplift_kg = ?, price = ?, total_price = ?" +
            "  WHERE invoice_number = ?";
    public static final String DELETE_INVOICE = "DELETE FROM invoices WHERE invoice_number = ?";
    public static final String GET_LAST_INVOICE_NUMBER = "SELECT * FROM invoices ORDER BY invoice_number DESC LIMIT 1";

    @Override
    public List<Invoice> listAllInvoices() {

        List<Invoice> invoices = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(QUERY_INVOICES)) {

            while (results.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceNumber(results.getInt(1));
                invoice.setAirlineName(results.getString(2));
                invoice.setDate(results.getString(3));
                invoice.setFlightNumber(results.getString(4));
                invoice.setRegistration(results.getString(5));
                invoice.setUpliftLiters(results.getInt(6));
                invoice.setUpliftInKg(results.getDouble(7));
                invoice.setPrice(results.getDouble(8));
                invoice.setTotalPrice(results.getDouble(9));

                invoices.add(invoice);
            }

        } catch (SQLException e) {
            System.out.println("Cant execute query " + e.getMessage());
            return Collections.emptyList();
        }
        return invoices;
    }

    @Override
    public List<Invoice> listInvoicesByAirline(String airlineName) {

        List<Invoice> invoices = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement queryInvoicesByAirline = conn.prepareStatement(QUERY_INVOICES_BY_AIRLINE)) {

            queryInvoicesByAirline.setString(1, airlineName);
            ResultSet results = queryInvoicesByAirline.executeQuery();

            while (results.next()) {
                Invoice invoice = new Invoice();
                invoice.setInvoiceNumber(results.getInt(1));
                invoice.setAirlineName(results.getString(2));
                invoice.setDate(results.getString(3));
                invoice.setFlightNumber(results.getString(4));
                invoice.setRegistration(results.getString(5));
                invoice.setUpliftLiters(results.getInt(6));
                invoice.setUpliftInKg(results.getDouble(7));
                invoice.setPrice(results.getDouble(8));
                invoice.setTotalPrice(results.getDouble(9));

                invoices.add(invoice);
            }
            results.close();

        } catch (SQLException e) {
            System.out.println("Cant execute query - List invoices by airline " + e.getMessage());
            return Collections.emptyList();
        }
        return invoices;
    }

    @Override
    public Invoice findInvoiceByNum(int invoiceNumber) {

        Invoice invoice = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement queryInvoiceByInvNumber = conn.prepareStatement(QUERY_INVOICES_BY_INVOICE_NUMBER)) {

            queryInvoiceByInvNumber.setInt(1, invoiceNumber);
            ResultSet results = queryInvoiceByInvNumber.executeQuery();

            while (results.next()) {
                invoice = new Invoice();
                invoice.setInvoiceNumber(results.getInt(1));
                invoice.setAirlineName(results.getString(2));
                invoice.setDate(results.getString(3));
                invoice.setFlightNumber(results.getString(4));
                invoice.setRegistration(results.getString(5));
                invoice.setUpliftLiters(results.getInt(6));
                invoice.setUpliftInKg(results.getDouble(7));
                invoice.setPrice(results.getDouble(8));
                invoice.setTotalPrice(results.getDouble(9));
            }
            results.close();

        } catch (SQLException e) {
            System.out.println("Cant find invoice" + e.getMessage());
        }
        return invoice;
    }

    @Override
    public int insertInvoice(Invoice invoice) {

        int status = 0;

        if (!isInDatabase(invoice)) {
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement newInvoice = conn.prepareStatement(NEW_INVOICE)) {

                newInvoice.setString(1, invoice.getAirlineName());
                newInvoice.setString(2, invoice.getDate());
                newInvoice.setString(3, invoice.getFlightNumber());
                newInvoice.setString(4, invoice.getRegistration());
                newInvoice.setInt(5, invoice.getUpliftLiters());
                newInvoice.setDouble(6, invoice.getUpliftInKg());
                newInvoice.setDouble(7, invoice.getPrice());
                newInvoice.setDouble(8, invoice.getTotalPrice());

                status = newInvoice.executeUpdate();

            } catch (Exception e) {
                System.out.println("Cant insert new Invoice. " + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public int updateInvoice(Invoice invoice) {
        int status = 0;

        if (isInDatabase(invoice)) {
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement updateInvoice = conn.prepareStatement(UPDATE_INVOICE)) {

                updateInvoice.setString(1, invoice.getAirlineName());
                updateInvoice.setString(2, invoice.getDate());
                updateInvoice.setString(3, invoice.getFlightNumber());
                updateInvoice.setString(4, invoice.getRegistration());
                updateInvoice.setInt(5, invoice.getUpliftLiters());
                updateInvoice.setDouble(6, invoice.getUpliftInKg());
                updateInvoice.setDouble(7, invoice.getPrice());
                updateInvoice.setDouble(8, invoice.getTotalPrice());
                updateInvoice.setInt(9, invoice.getInvoiceNumber());

                status = updateInvoice.executeUpdate();

            } catch (SQLException e) {
                System.out.println(" Cant execute query - Update Airline " + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public int deleteInvoice(Invoice invoice) {

        int status = 0;

        if (isInDatabase(invoice)) {
            try (Connection conn = DBUtil.getConnection();
                 PreparedStatement deleteInvoice = conn.prepareStatement(DELETE_INVOICE)) {

                deleteInvoice.setInt(1, invoice.getInvoiceNumber());

                status = deleteInvoice.executeUpdate();

            } catch (Exception e) {
                System.out.println("Cant execute query - Delete Invoice " + e.getMessage());
            }
        }
        return status;
    }

    @Override
    public boolean isInDatabase(Invoice invoice) {

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement prstm = conn.prepareStatement(QUERY_INVOICES_BY_INVOICE_NUMBER)) {

            prstm.setInt(1, invoice.getInvoiceNumber());
            ResultSet results = prstm.executeQuery();

            if (results.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Cant execute query - Is Invoice Number in database " + e.getMessage());
        }
        return false;
    }

    public boolean isInDatabase(int invoiceNumber) {

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement prstm = conn.prepareStatement(QUERY_INVOICES_BY_INVOICE_NUMBER)) {

            prstm.setInt(1, invoiceNumber);
            ResultSet results = prstm.executeQuery();

            if (results.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Cant execute query - Is Invoice Number in database, checked by number " + e.getMessage());
        }
        return false;
    }

    public int lastInvoiceNumber() {

        try (Connection conn = DBUtil.getConnection();
             Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(GET_LAST_INVOICE_NUMBER)) {

            return results.getInt(1);

        } catch (SQLException e) {
            System.out.println("Cant execute query - Get last invoice number. " + e.getMessage());
            return 0;
        }
    }


}
