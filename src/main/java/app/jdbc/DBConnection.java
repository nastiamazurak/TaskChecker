package app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String USERNAME = "root";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost/ItAminiProject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
                Connection conn = DriverManager.getConnection(URL, USERNAME, PASS);
                System.out.println("Connection to Store DB succesfull!");
                connection = conn;
            } catch (Exception ex) {
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
        }
        return connection;
    }
}
