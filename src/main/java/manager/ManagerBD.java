package manager;

import driver.LoadDriver;

import java.sql.SQLException;
import java.sql.Statement;

public class ManagerBD {
    public void addUser(String username, String password){
        LoadDriver driver = new LoadDriver();
        Statement stmt = null;
        int rs;
        String sqlStatement = "INSERT INTO users (name, password) values('" + username + "', '" + password +"')";

        try {
            stmt = driver.getConn().createStatement();
            rs = stmt.executeUpdate(sqlStatement);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
