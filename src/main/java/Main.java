import driver.LoadDriver;

import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        LoadDriver driver = new LoadDriver();
        Statement stmt = null;
        int rs;

        try {
            stmt = driver.getConn().createStatement();
            rs = stmt.executeUpdate("INSERT INTO users (name, password) values('Den1', '123')");


            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

//            if (stmt.execute("SELECT foo FROM bar")) {
//                rs = stmt.getResultSet();
//            }

            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}