import java.sql.*;

// Notice, do not import com.mysql.cj.jdbc.*
// or you will have problems!

public class LoadDriver {
    public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        } catch (Exception ex) {
            // handle the error
        }


        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false&" + "user=root1&password=root");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM users");

            if (stmt.execute("SELECT * FROM users")){
            rs = stmt.getResultSet();
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}