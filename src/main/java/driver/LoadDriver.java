package driver;

import java.sql.*;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

public class LoadDriver {
//    public static void main(String[] args) {
    public LoadDriver(){
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        } catch (Exception ex) {
            // handle the error
        }


        Connection conn = null;
        Statement stmt = null;
//        ResultSet rs;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false&" + "user=root1&password=root");
//            stmt = conn.createStatement();

//            rs = stmt.executeUpdate("INSERT INTO users (name, password) values('Denis34', '123')");
//            rs = stmt.executeQuery("select * from users");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}