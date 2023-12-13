package org.example.DAO;

import org.example.Model.History;

import java.sql.*;

public class HistoryDAO {
    static Connection connection = DatabaseConnection.getConnection();
    public static void addHistory(History history)
    {
        try{
            String insertQuery = "INSERT INTO historiques (id_user,id_tache,libelle,date_creation)VALUES (?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setInt(1,history.getUser().getId());
            preparedStatement.setInt(2,history.getTask().getId());
            preparedStatement.setString(3,history.getLibelle());
            preparedStatement.setDate(4, Date.valueOf(history.getDate_creation()));


            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            System.out.println("history inserted into the database successfully.");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void getAll()
    {
        try {
            String selectQuery = "SELECT * FROM historiques";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next())
            {
                History.getHistories().add((History) resultSet);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
