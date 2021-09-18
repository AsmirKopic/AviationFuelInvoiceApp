package com.tutorials.database;

import com.tutorials.model.Invoice;

import java.sql.SQLException;
import java.util.List;

public interface InvoiceDAO {

    List<Invoice> listAllInvoices();
    List<Invoice> listInvoicesByAirline(String airlineName);
    Invoice findInvoiceByNum(int invoiceNumber);

    int newInvoice(Invoice invoice) throws SQLException;
    boolean updateInvoice(Invoice invoice);
    boolean deleteInvoice(Invoice invoice);

    boolean isInDatabase(Invoice invoice);
    boolean isInDatabase(int invNumber);

}
