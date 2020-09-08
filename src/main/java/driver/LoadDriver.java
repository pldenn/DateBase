package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

public class LoadDriver {

    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public LoadDriver() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception ex) {
            // handle the error
        }

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false&" + "user=root1&password=root");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}