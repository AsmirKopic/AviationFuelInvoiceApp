package test;

import com.aviationFuelApp.database.DBUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DBUtilTest {

    @Test
    void getConnectionTest() {
        Connection conn = DBUtil.getConnection();
        assertNotNull(conn, "Connection should be successful");
    }
}