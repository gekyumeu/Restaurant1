package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConn {
    private static final String JDBCURL = "jdbc:mysql://localhost:3306/java_db1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    private  static Connection connection;
    private  DatabaseConn() {
        
    }
    
    public static Connection getConnection() {
        if(connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            
                connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("Error establishing database connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
}
