package controller;

import model.Account;
import database.DatabaseConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class Ordering {
    
    Connection connection = DatabaseConn.getConnection();
    
    public void register(Account acc) {
        String sql = "INSERT INTO account (first_name, last_name, username, password, gender, status)" + "VALUES" + "( ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, acc.getFirst_name());
            preparedStatement.setString(2, acc.getLast_name());
            preparedStatement.setString(3, acc.getUsername());
            preparedStatement.setString(4, acc.getPassword());
            preparedStatement.setString(5, acc.getGender());
            preparedStatement.setInt(6, acc.getStatus());
            //Execute the insert statement
            preparedStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Account Added Successfully");
            //DatabaseConn.closeConnection();
        } catch(SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
