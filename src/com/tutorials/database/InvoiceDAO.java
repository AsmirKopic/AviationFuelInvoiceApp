package com.tutorials.database;

import com.tutorials.model.Invoice;

import java.sql.SQLException;
import java.util.List;

public interface InvoiceDAO {

    public boolean open();
    public void close();

    List<Invoice> listAllInvoices();
    List<Invoice> listAllInvoicesByAirline();
    Invoice findInvoiceByNum(int invoiceNumber);

    int newInvoice(Invoice invoice) throws SQLException;
    boolean editInvoice(Invoice invoice);
    boolean deleteInvoice(Invoice invoice);

    boolean isInDatabase(Invoice invoice);
    boolean isInDatabase(int invNumber);

}
