package com.tutorials.database;

import com.tutorials.model.Airline;
import com.tutorials.model.Invoice;

import java.util.List;

public interface InvoiceDAO {

    List<Invoice> listAllInvoices();
    List<Invoice> listInvoicesByAirline(String airlineName);
    Invoice findInvoiceByNum(int invoiceNumber);

    int insertInvoice(Invoice invoice);
    int updateInvoice(Invoice invoice);
    int deleteInvoice(Invoice invoice);

    boolean isInDatabase(Invoice invoice);
    boolean isInDatabase(int invNumber);
    int lastInvoiceNumber();

}
