package org.example.DBO;

import org.example.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDBO {
    static Connection connection = DatabaseConnection.getConnection();

    public static void addDBO(User user)
    {
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

    public static void deleteDOAById(int id)
    {
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

    public static void updateDOAById(int id, User userUpdate)
    {
        try {
            // Establish a connection to the database
            // Check if the contact with the provided email exists
            if (userExist(id)) {
                // Define the SQL query to update a contact by email
                String updateQuery = "UPDATE users SET login = ?, password = ?, role = ? WHERE id = ?";

                // Create a prepared statement with the query
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

                // Set the values for the parameters in the query
                preparedStatement.setString(1, userUpdate.getLogin());
                preparedStatement.setString(2, userUpdate.getPassword());
                preparedStatement.setString(3, userUpdate.getRole());

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

    public static boolean userExist(int id) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM contacts WHERE id = ?";
        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
        checkStatement.setInt(1, id);

        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();

        int count = resultSet.getInt(1);

        checkStatement.close();

        return count > 0;
    }
    public static void getAll()
    {
        try {
            // Define the SQL query to retrieve all contacts from the database
            String selectQuery = "SELECT * FROM users";

            // Create a prepared statement with the query
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                User.getUsers().add((User) resultSet);
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

    public static User searchDOAById(int id) {
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
            System.out.println("User with id '" + id + "':");

            User user = null;
            while (resultSet.next()) {
                user = (User) resultSet;
            }
            return user;
            // Close the resources
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error searching for user in the database.");
        }
        return null;
    }
    public static User login(String login , String motpass){
        try {
            String selectQuery = "SELECT * FROM users WHERE login = ? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Set the email parameter in the query
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, motpass);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()){
                user = (User) resultSet;
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}
