import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Main {
    private  static final String URL = "jbdc:mysql://localhost:3306/mydbtest??useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private  static final String USERNAME = "root";
    private  static final String PASSWORD = "root";

//Class.forName("com.mysql.jdbc.Driver");
    public static void main(String[] args) {
    Connection conn1 = null;
    Connection conn2 = null;
    Connection conn3 = null;
        try {
            conn1 = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (conn1 != null)
                System.out.println("Connected to the database test1");

            String url2 = "jdbc:mysql://localhost:3306/aavikme?user=root&password=aa";
            conn2 = DriverManager.getConnection(url2);
            if (conn2 != null) {
                System.out.println("Connected to the database test2");
            }

            String url3 = "jdbc:mysql://localhost:3306/aavikme";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "aa");

            conn3 = DriverManager.getConnection(url3, info);
            if (conn3 != null) {
                System.out.println("Connected to the database test3");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
    }
