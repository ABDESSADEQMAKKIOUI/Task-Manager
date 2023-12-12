package org.example.Manager;


import org.example.Model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskManager{

    static Connection connection = DatabaseConnection.getConnection();

    public void add(Task task){
        try{
            String query
                    = "insert into taches(code, "
                    + "nom,"+"priority,"+"id_categorie,"+"id_user,"+"date_creation) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, task.getCode());
            ps.setString(2, task.getLibelle());
            ps.setInt(3, task.getId_category());
            ps.setInt(4, task.getId_user());
            ps.setString(5, task.getDate_creation());
            ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Task added successfully");
        }

    }
}
