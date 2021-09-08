package com.tutorials.database;

import com.tutorials.model.Invoice;

import java.util.List;

public interface InvoiceDAO {

    public boolean open();
    public boolean close();

    List<Invoice> listAllInvoices();
    List<Invoice> listAllInvoicesByAirline();
    Invoice findInvoiceByNum(int invoiceNumber);

    boolean newInvoice(Invoice invoice);
    boolean editInvoice(Invoice invoice);
    boolean deleteInvoice(Invoice invoice);

}
