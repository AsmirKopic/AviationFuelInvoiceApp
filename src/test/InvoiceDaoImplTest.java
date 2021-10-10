package test;

import com.aviationFuelApp.database.AirlineDAO;
import com.aviationFuelApp.database.AirlineDaoImpl;
import com.aviationFuelApp.database.DBUtil;
import com.aviationFuelApp.database.InvoiceDaoImpl;
import com.aviationFuelApp.model.Airline;
import com.aviationFuelApp.model.Invoice;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceDaoImplTest {

    private static InvoiceDaoImpl invoiceDao;
    private static AirlineDaoImpl airlineDao;

    @BeforeAll
    static void init() {
        Connection conn = DBUtil.getConnection();
        try {
            // set auto commit false so any operation in this test will be discarded.
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        invoiceDao = new InvoiceDaoImpl();
        airlineDao = new AirlineDaoImpl();
    }

    @AfterAll
    static void teardown() {
        Connection conn = DBUtil.getConnection();
        try {
            conn.rollback();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void isInDatabase() {
        Airline airline = new Airline();
        airline.setName("Test Airline name");
        airline.setPriceTerms(210);
        airline.setPaymentTerms(15);
        airlineDao.insertAirline(airline);

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(15);
        invoice.setAirlineName("Test Airline name");
        invoice.setDate("10/10/2021");
        invoice.setFlightNumber("testNum");
        invoice.setRegistration("testReg");
        invoice.setUpliftLiters(1000);
        invoiceDao.insertInvoice(invoice);

        assertTrue(invoiceDao.isInDatabase(invoice), "Should be true.");
    }

    @Test
    void findInvoiceByNum() {
        Airline airline = new Airline();
        airline.setName("Test Airline name");
        airline.setPriceTerms(210);
        airline.setPaymentTerms(15);
        airlineDao.insertAirline(airline);

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(15);
        invoice.setAirlineName("Test Airline name");
        invoice.setDate("10/10/2021");
        invoice.setFlightNumber("testNum");
        invoice.setRegistration("testReg");
        invoice.setUpliftLiters(1000);
        invoiceDao.insertInvoice(invoice);

        Invoice invoiceInDb = invoiceDao.findInvoiceByNum(invoice.getInvoiceNumber());
        assertSame(invoiceInDb, invoice, "Should be true");
    }

    @Test
    void insertInvoice() {
        Airline airline = new Airline();
        airline.setName("Test Airline name");
        airline.setPriceTerms(210);
        airline.setPaymentTerms(15);
        airlineDao.insertAirline(airline);

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(15);
        invoice.setAirlineName("Test Airline name");
        invoice.setDate("10/10/2021");
        invoice.setFlightNumber("testNum");
        invoice.setRegistration("testReg");
        invoice.setUpliftLiters(1000);
        invoiceDao.insertInvoice(invoice);

        Invoice invoiceFromDb = invoiceDao.findInvoiceByNum(invoice.getInvoiceNumber());
        assertEquals(invoice.getInvoiceNumber(), invoiceFromDb.getInvoiceNumber());
        assertEquals(invoice.getAirlineName(), invoiceFromDb.getAirlineName());
        assertEquals(invoice.getUpliftInKg(), (invoice.getUpliftLiters() * Invoice.SPECIFIC_WEIGHT));
    }

    @Test
    void updateInvoice() {
        Airline airline = new Airline();
        airline.setName("Test Airline name");
        airline.setPriceTerms(210);
        airline.setPaymentTerms(15);
        airlineDao.insertAirline(airline);

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(15);
        invoice.setAirlineName("Test Airline name");
        invoice.setDate("10/10/2021");
        invoice.setFlightNumber("testNum");
        invoice.setRegistration("testReg");
        invoice.setUpliftLiters(1000);

        invoiceDao.insertInvoice(invoice);
        invoice.setUpliftLiters(2000);
        invoiceDao.updateInvoice(invoice);

        Invoice invoiceFromDb = invoiceDao.findInvoiceByNum(invoice.getInvoiceNumber());
        assertEquals(2000, invoiceFromDb.getUpliftLiters());
    }

    @Test
    void deleteInvoice() {
        Airline airline = new Airline();
        airline.setName("Test Airline name");
        airline.setPriceTerms(210);
        airline.setPaymentTerms(15);
        airlineDao.insertAirline(airline);

        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber(15);
        invoice.setAirlineName("Test Airline name");
        invoice.setDate("10/10/2021");
        invoice.setFlightNumber("testNum");
        invoice.setRegistration("testReg");
        invoice.setUpliftLiters(1000);

        invoiceDao.insertInvoice(invoice);
        assertFalse(invoiceDao.isInDatabase(invoice));
    }
}