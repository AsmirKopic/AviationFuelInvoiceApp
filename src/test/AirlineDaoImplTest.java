package test;

import com.tutorials.database.AirlineDAO;
import com.tutorials.database.DBUtil;
import com.tutorials.model.Airline;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AirlineDaoImplTest {

    private static AirlineDAO airlineDao;

    @BeforeAll
    static void init() {
        Connection conn = DBUtil.getConnection();
        try {
            // set auto commit false so any operation in this test will be discarded.
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    static void teardown() {
        Connection conn = DBUtil.getConnection();
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void insertAirlineTest() {

        Airline airline = new Airline();
        airline.setName("Test Airline");
        airline.setPriceTerms(210);
        airline.setPaymentTerms(15);

        airlineDao.insertAirline(airline);
        Airline airlineFromDb = airlineDao.findAirlineByName("Test Airline");
        assertEquals("Test Airline", airlineFromDb.getName(), "Airline name must be equals");
    }

    @Test
    void updateAirlineTest() {

        Airline airline = new Airline();
        airline.setName("Test Airline");
        airline.setPriceTerms(210);
        airline.setPaymentTerms(15);

        airlineDao.insertAirline(airline);
        airline.setPaymentTerms(250);
        airlineDao.updateAirline(airline);

        Airline airlineFromDb = airlineDao.findAirlineByName("Test Airline");
        assertEquals(250, airlineFromDb.getPriceTerms());
    }

    @Test
    void deleteAirlineTest() {

        Airline airline = new Airline();
        airline.setName("Test Airline");
        airline.setPriceTerms(210);
        airline.setPaymentTerms(15);

        airlineDao.deleteAirline("Test Airline");
        Airline airlineFromDb = airlineDao.findAirlineByName("Test Airline");
        assertNull(airlineFromDb.getName(), "Airline name should be null");
    }

    @Test
    void isInDatabaseTest() {

        Airline airline = new Airline();
        airline.setName("Test Airline");
        airline.setPriceTerms(210);
        airline.setPaymentTerms(15);

        assertTrue(airlineDao.isInDatabase(airline), "Should be true");
    }

}