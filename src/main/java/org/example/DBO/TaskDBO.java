package org.example.DBO;


import org.example.Model.Task;

import java.sql.*;
import java.time.LocalDate;

public class TaskDBO {
    static Connection connection = DatabaseConnection.getConnection();

    public static void addDBO(Task task)
    {
        try{
            String query
                    = "insert into taches(code, "
                    + "nom,"+"priority,"+"id_categorie,"+"id_user,"+"date_creation) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, task.getCode());
            ps.setString(2, task.getLibelle());
            ps.setInt(3, task.getId_category());
            ps.setInt(4, task.getId_user());
            ps.setDate(5, Date.valueOf(task.getDate_creation()));
            ps.executeUpdate();

            ps.close();
            connection.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteDOAByCode(String code)
    {
        try{
            String deleteQuery = "DELETE FROM taches WHERE code = ?";
            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.setString(1, code);
            int n = ps.executeUpdate();

            ps.close();
            connection.close();

            if (n > 0) {
                System.out.println("task with code '" + code + "' deleted successfully.");
            } else {
                System.out.println("task with code '" + code + "' not found.");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static void updateDBOByCode(String code, Task task)
    {
        try{
            if(taskExist(code))
            {
                String query = "UPDATE taches " +
                        "SET nom = ?, priority = ?, id_categorie = ?, id_user = ?, date_creation = ? " +
                        "WHERE code = ?";

                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, task.getLibelle());
                ps.setString(2, task.getPriority().getName());
                ps.setInt(3, task.getId_category());
                ps.setInt(4,task.getId_user());
                ps.setDate(5, Date.valueOf(task.getDate_creation()));
                ps.executeUpdate();

                ps.close();
                connection.close();
                System.out.println("Task with code:"+ code + "updated successfully");
            }else{
                System.out.println("Task with code:"+ code + "not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean taskExist(String code) throws SQLException {
        String checkQuery = "SELECT COUNT(*) FROM taches WHERE code = ?";
        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
        checkStatement.setString(1, code);

        ResultSet resultSet = checkStatement.executeQuery();
        resultSet.next();

        int count = resultSet.getInt(1);

        checkStatement.close();

        return count > 0;
    }

    public static void getAll()
    {
        try{
            String query = "SELECT * FROM taches";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("All tasks in DataBase :");
            while (rs.next())
            {
                Task.getTasks().put(rs.getString("code"),(Task) rs);
            }

            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
