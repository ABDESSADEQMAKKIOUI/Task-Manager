package org.example.Manager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.example.Model.User;

public class UserManager {
            public static void Add(User user) {
        try {

            // Define the SQL query to insert a contact into the database
            String insertQuery = "INSERT INTO users (login , password , role) VALUES (?, ?, ?)";

            // Create a prepared statement with the query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the values for the parameters in the query
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword);
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

        public static void getAllUser() {
            try {
               // Define the SQL query to retrieve all contacts from the database
                String selectQuery = "SELECT * FROM User";
    
                // Create a prepared statement with the query
                PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
    
                // Execute the query and get the result set
                ResultSet resultSet = preparedStatement.executeQuery();
    
                // Display the contacts
                System.out.println("All User in the Database:");
    
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("name: " + resultSet.getString("login"));
                    System.out.println("mot de pass: " + resultSet.getString("password"));
                    System.out.println("role: " + resultSet.getString("role"));
                    
                    System.out.println("----------------------------");
                }
    
                // Close the resources
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error retrieving contacts from the database.");
            }
        }
    }
}
