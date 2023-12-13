package org.example.DBO;

import org.example.Model.History;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HistoryDBO {
    static Connection connection = DatabaseConnection.getConnection();
    public static void addHistory(History history)
    {
        try{
            String insertQuery = "INSERT INTO historque (id_user,id_tache,libelle)VALUES (?,?,?) ";
            // Create a prepared statement with the query
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Set the values for the parameters in the query
            preparedStatement.setInt(1,history.getId_user());
            preparedStatement.setInt(2,history.getId_task());
            preparedStatement.setString(3,history.getLibelle());

            // Execute the query
            preparedStatement.executeUpdate();

            // Close the resources
            preparedStatement.close();
            connection.close();

            System.out.println("history inserted into the database successfully.");

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error inserting History into the database.");
        }
    }
    public static void getAll()
    {
        try {
            // Define the SQL query to retrieve all histories from the database
            String selectQuery = "SELECT * FROM historique";

            // Create a prepared statement with the query
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                History.getHistories().add((History) resultSet);
            }

            // Close the resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving histories from the database.");
        }
    }


}
