package com.tutorials.database;

import com.tutorials.model.Airline;
import com.tutorials.model.Invoice;

import java.util.List;

public interface InvoiceDAO {

    /**
     * <p>
     * This method by using database query is returning list of all invoices in the database.
     * </p>
     * @return list of Invoice objects (invoices) from database.
     */
    List<Invoice> listAllInvoices();

    /**
     * <p>
     * This method by using database query is returning list of invoices for particular
     * airline in the database.
     * </p>
     * @param airlineName
     *                  this parameter is used to create database query for selecting
     *                  invoices with particular airline name.
     * @return list of Invoice objects (invoices) from database for particular airline name.
     */
    List<Invoice> listInvoicesByAirline(String airlineName);

    /**
     * <p>
     * This method returning Invoice object (invoice) based on invoice number.
     * </p>
     * @param invoiceNumber
     *                  this parameter is used to create database query for selecting
     *                  invoice based on invoice number.
     * @return new Invoice object from database.
     */
    Invoice findInvoiceByNum(int invoiceNumber);

    /**
     * <p>
     * This method returning Invoice object which represents sum of all invoices for
     * particular airline.
     * Returned invoice contains sum of all invoice uplift liters, uplift in kg and
     * sum of total price.
     * </p>
     * @param airlineName
     *                  this parameter is used to create database query for selecting
     *                  invoice to be summarized.
     * @return new Invoice object from database
     */
    Invoice sumInvoicesByAirline(String airlineName);

    /**
     * <p>
     * This method returning Invoice object which represents sum of all invoices.
     * Returned invoice contains sum of all invoice uplift liters, uplift in kg and
     * sum of total price.
     * </p>
     * @return new Invoice object from database
     */
    Invoice sumAllInvoices();

    /**
     * <p>
     * This method is used for adding new Invoice object to database.
     * </p>
     * @param invoice
     *                  this parameter is used to create database query for invoice
     *                  that should be inserted.
     * @return return 1 if new invoice is added or 0 if it is not added to database
     */
    int insertInvoice(Invoice invoice);

    /**
     * <p>
     * This method is used to update Invoice object in database.
     * </p>
     *
     * @param invoice
     *                  this parameter is used to create database query for selecting
     *                  invoice that should be updated.
     * @return return 1 if invoice is updated or 0 if it is not updated in database
     */
    int updateInvoice(Invoice invoice);

    /**
     * <p>
     * This method is used to delete Invoice object from database.
     * </p>
     * @param invoice
     *                  this parameter is used to create database query for selecting
     *                  invoice that should be deleted.
     * @return return 1 if invoice is deleted or 0 if it is not deleted from database
     */
    int deleteInvoice(Invoice invoice);

    /**
     * <p>
     * This method checks is invoice already in database based on provided Invoice object.
     * </p>
     * @param invoice
     *                  this parameter is used to create database query to check is provided
     *                  invoice object in database
     * @return true if provided invoice is in database or false if it is not.
     */
    boolean isInDatabase(Invoice invoice);

    /**
     * <p>
     * This method checks is invoice already in database based on provided invoice number.
     * </p>
     * @param invNumber
     *                  this parameter is used to create database query to check is provided
     *                  invoice number in database
     * @return true if provided invoice is in database or false if it is not.
     */
    boolean isInDatabase(int invNumber);

    /**
     * This method by using database query returns last invoice number from database.
     * @return last invoice number from database
     */
    int lastInvoiceNumber();
}
