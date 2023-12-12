package org.example.Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.example.Model.User;
 

public class UserManager {
static Connection connection = DatabaseConnection.getConnection();

            public static void Add(User user) {
        try {

            // Define the SQL query to insert a contact into the database
            String insertQuery = "INSERT INTO users (login , password , role) VALUES (?, ?, ?)";

            // Create a prepared statement with the query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the values for the parameters in the query
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());

            // Execute the query
            preparedStatement.executeUpdate();

            // Close the resources
            preparedStatement.close();
            connection.close();

            System.out.println("user inserted into the database successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error inserting user into the database.");
        }
    }
        public static void getAllUser() {
            try {
               // Define the SQL query to retrieve all contacts from the database
                String selectQuery = "SELECT * FROM users";
    
                // Create a prepared statement with the query
                PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
    
                // Execute the query and get the result set
                ResultSet resultSet = preparedStatement.executeQuery();
    
                // Display the contacts
                System.out.println("All User in the Database:");
    
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("name: " + resultSet.getString("login"));
                    System.out.println("role: " + resultSet.getString("role"));
                    
                    System.out.println("----------------------------");
                }
    
                // Close the resources
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error retrieving users from the database.");
            }
        }


        public static void deleteUser(int id) {
        try {
            
            String deleteQuery = "DELETE FROM users WHERE id = ?";

            // Create a prepared statement with the query
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);

            // Set the id parameter in the query
            preparedStatement.setInt(1, id);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Close the resources
            preparedStatement.close();
            connection.close();

            if (rowsAffected > 0) {
                System.out.println("user with id '" + id + "' deleted successfully.");
            } else {
                System.out.println("user with id '" + id + "' not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting user from the database.");
        }
    }
     
    public static void searchContactById(int id) {
        try {
           
            // Define the SQL query to search for a contact by id
            String selectQuery = "SELECT * FROM users WHERE id = ?";

            // Create a prepared statement with the query
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Set the email parameter in the query
            preparedStatement.setInt(1, id);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Display the id
            System.out.println("Contact with Email '" + id + "':");

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("name: " + resultSet.getString("login"));
                    System.out.println("role: " + resultSet.getString("role"));
                System.out.println("----------------------------");
            }

            // Close the resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error searching for contact in the database.");
        }
    
}

public static void updateContactByEmail(int id, User userupdater) {
    try {
        // Establish a connection to the database
        // Check if the contact with the provided email exists
        if (userexist(id)) {
            // Define the SQL query to update a contact by email
            String updateQuery = "UPDATE contacts SET nom = ?, tele = ?, email = ?, adress = ?, prenom = ? WHERE email = ?";

            // Create a prepared statement with the query
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            // Set the values for the parameters in the query
            preparedStatement.setString(1, userupdater.getLogin());
            preparedStatement.setString(2, userupdater.getPassword());
            preparedStatement.setString(3, userupdater.getRole());

            // Execute the query
            preparedStatement.executeUpdate();

            // Close the resources
            preparedStatement.close();
            connection.close();

            System.out.println("Contact with email '" + id + "' updated successfully.");
        } else {
            System.out.println("Contact with email '" + id + "' not found.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error updating contact in the database.");
    }
}

private static boolean userexist( int id) throws SQLException {
    String checkQuery = "SELECT COUNT(*) FROM contacts WHERE id = ?";
    PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
    checkStatement.setInt(1, id);

    ResultSet resultSet = checkStatement.executeQuery();
    resultSet.next();

    int count = resultSet.getInt(1);

    checkStatement.close();

    return count > 0;
}

  
}
 
    


