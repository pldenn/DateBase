package manager;

import domain.User;
import driver.LoadDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManagerBdSQL {

    private LoadDriver driver = new LoadDriver();
    private Statement stmt = null;

    public void addUser(String username, String password) {

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

    public ArrayList getUsers() {

        String sqlStatement = "SELECT * FROM users";
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            stmt = driver.getConn().createStatement();
            rs = stmt.executeQuery(sqlStatement);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return users;
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
