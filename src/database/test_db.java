package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test_db {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/java_db1";
        String username = "root";
        String password  = "";
        
        //Establishing connection
        try(Connection connection = DriverManager.getConnection(jdbcUrl, username,  password)) {
            //Connection successful
            System.out.println("Connected to the database!");
            //You can perform database operations here
        } catch (SQLException e) {
            //Connection failed
            System.err.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    } 
}
