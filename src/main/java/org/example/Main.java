package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db-task-manager";
        String user = "root";
        String pass = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("good");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Can't connect to DB !");
        }
    }
}