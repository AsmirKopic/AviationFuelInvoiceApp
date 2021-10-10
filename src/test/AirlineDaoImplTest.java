package test;

import com.aviationFuelApp.database.AirlineDaoImpl;
import com.aviationFuelApp.database.DBUtil;
import com.aviationFuelApp.model.Airline;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AirlineDaoImplTest {

    private static AirlineDaoImpl airlineDao;

    /**
     * Test that all inserts, reads, updates and deletes work as expected.
     */
    @Test
    void crudTest() throws SQLException {

        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);

        airlineDao = new AirlineDaoImpl();

        try {
            String airlineName = "Test Airline";
            double priceTerms = 210;
            int paymentTerms = 15;

            Airline airline = new Airline();
            airline.setName(airlineName);
            airline.setPriceTerms(priceTerms);
            airline.setPaymentTerms(paymentTerms);

            // insertAirline method test
            airlineDao.insertAirline(airline);
            Airline airlineFromDb = airlineDao.findAirlineByName(airlineName);

            assertEquals(airlineName, airlineFromDb.getName(), "Airline name must be equals");

            // isInDatabase method test
            assertTrue(airlineDao.isInDatabase(airline), "Is in data base - Should be true");

            // updateAirline method test
            int newPaymentTerms = 250;

            airline.setPaymentTerms(newPaymentTerms);
            airlineDao.updateAirline(airline);
            airlineFromDb = airlineDao.findAirlineByName(airlineName);

            assertEquals(newPaymentTerms, airlineFromDb.getPaymentTerms(), "Update airline - Should be true");

            // deleteAirline method test
            airlineDao.deleteAirline(airlineName);
            assertFalse(airlineDao.isInDatabase(airline));

            // findAirlineByName method test
            assertNull(airlineDao.findAirlineByName(airlineName));

        } finally {
            conn.rollback();
            conn.close();
        }

    }

}