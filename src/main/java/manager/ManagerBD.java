package manager;

import data.User;
import driver.LoadDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManagerBD {

    private LoadDriver driver = new LoadDriver();
    private Statement stmt = null;

    public void addUser(String username, String password){



        String sqlStatement = "INSERT INTO users (name, password) values('" + username + "', '" + password + "')";

        try {
            stmt = driver.getConn().createStatement();
           int rs = stmt.executeUpdate(sqlStatement);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public ResultSet getUsers() {

        String sqlStatement = "SELECT * FROM users";
        ResultSet rs = null;

        try {
            stmt = driver.getConn().createStatement();
             rs = stmt.executeQuery(sqlStatement);

             while (rs.next()){
                 User user = new User();
                 user.setId(rs.getInt("id"));
                 user.setUsername(rs.getString("name"));
                 user.setPasssword(rs.getString("password"));
                 System.out.println(user);
             }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return rs;
    }

    public void clean() {

        String sqlStatement = "DELETE FROM users";

        try {
            stmt = driver.getConn().createStatement();
            int rs = stmt.executeUpdate(sqlStatement);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
