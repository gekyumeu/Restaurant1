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

public class User {

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
    
    public void updateAccount(Account acc) {
    String sql = "UPDATE account SET first_name = ?, last_name = ?, username = ?, password = ?, gender = ?, status = ? WHERE customer_id = ?";

    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setString(1, acc.getFirst_name());
        preparedStatement.setString(2, acc.getLast_name());
        preparedStatement.setString(3, acc.getUsername());
        preparedStatement.setString(4, acc.getPassword());
        preparedStatement.setString(5, acc.getGender());
        preparedStatement.setInt(6, acc.getStatus());
        preparedStatement.setInt(7, acc.getId()); // Assuming the customer_id is the primary key for the account table
        
        // Execute the update statement
        int rowsUpdated = preparedStatement.executeUpdate();
        
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Account Updated Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "No account updated. Please check the ID.");
        }
    } catch (SQLException e) {
        System.err.println("Error updating data: " + e.getMessage());
        e.printStackTrace();
    }
}
    
    public boolean authenticate(String username, String password) {
        try {
            String sql = "SELECT * FROM account WHERE username = ? AND password = ? AND status IN (2, 3)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean authenticate_admin(String admin_username, String admin_password) {
        try {
            String sql = "SELECT * FROM account WHERE username = ? AND password = ? AND status = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, admin_username);
            preparedStatement.setString(2, admin_password);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Account> list() {
        List <Account> list = new ArrayList<Account>();
        
        try {
            String sql = "SELECT * FROM account";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("customer_id"));
                acc.setFirst_name(rs.getString("first_name"));
                acc.setLast_name(rs.getString("last_name"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setGender(rs.getString("gender"));
                acc.setStatus(rs.getInt("status"));
                
                list.add(acc);
            }
        } catch (SQLException e) {
            System.err.println("Error fecthing data: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Account> list1() {
        List <Account> list = new ArrayList<Account>();
        
        try {
            String sql = "SELECT * FROM account";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("customer_id"));
                acc.setFirst_name(rs.getString("first_name"));
                acc.setLast_name(rs.getString("last_name"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setGender(rs.getString("gender"));
                acc.setStatus(rs.getInt("status"));
                
                list.add(acc);
            }
        } catch (SQLException e) {
            System.err.println("Error fecthing data: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Account> Stafflist() {
        List<Account> Stafflist = new ArrayList<>();

        try {
            String sql = "SELECT * FROM account WHERE status = 3"; // Select users with status 2
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("customer_id"));
                acc.setFirst_name(rs.getString("first_name"));
                acc.setLast_name(rs.getString("last_name"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setGender(rs.getString("gender"));
                acc.setStatus(rs.getInt("status"));

                Stafflist.add(acc);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            e.printStackTrace();
        }
        return Stafflist;
    }
    
    public List<Account> Customerlist() {
        List<Account> Customerlist = new ArrayList<>();

        try {
            String sql = "SELECT * FROM account WHERE status = 2"; // Select users with status 2
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("customer_id"));
                acc.setFirst_name(rs.getString("first_name"));
                acc.setLast_name(rs.getString("last_name"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setGender(rs.getString("gender"));
                acc.setStatus(rs.getInt("status"));

                Customerlist.add(acc);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            e.printStackTrace();
        }
        return Customerlist;
    }
    
    /*public List<Account> Stafflist() {
        List <Account> Stafflist = new ArrayList<Account>();
        
        try {
            String sql = "SELECT * FROM account WHERE status = 2;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt("customer_id"));
                acc.setFirst_name(rs.getString("first_name"));
                acc.setLast_name(rs.getString("last_name"));
                acc.setUsername(rs.getString("username"));
                acc.setPassword(rs.getString("password"));
                acc.setGender(rs.getString("gender"));
                acc.setStatus(rs.getInt("status"));
                
                Stafflist.add(acc);
            }
        } catch (SQLException e) {
            System.err.println("Error fecthing data: " + e.getMessage());
            e.printStackTrace();
        }
        return Stafflist;
    }*/
    
    public int RetrieveUserStatus(String username, String password) {
    try {
            String sql = "SELECT status FROM account WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("status");
            } else {
                return -1; // Indicate that no user with the given credentials was found
            }
        } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
    }
    
}
