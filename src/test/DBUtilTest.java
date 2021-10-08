package test;

import com.aviationFuelApp.database.DBUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilTest {

    @Test
    void getConnectionTest() {
        Connection conn = DBUtil.getConnection();
        assertNotNull(conn, "Connection should be successful");
    }

    @Test
    void closeConnection() {
        Connection conn = DBUtil.getConnection();
        DBUtil.closeConnection(conn);
        assertNull(conn, "Connection should be closed");
    }
}