package org.example.Controler;

import org.example.Manager.UserManager;
import org.example.Model.User;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class UserController implements InterfaceController {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        User user = saisie();
        UserManager.addDBO(user);
        String status = "Added user";
    }

    @Override
    public void update() {
        System.out.println("enter id of user to update");
        int id = scanner.nextInt();
        User user = saisie();
        UserManager.updateDOAById(id,user);
    }

    @Override
    public void delete() {
        System.out.println("enter id of user to update");
        int id = scanner.nextInt();
        User user = UserManager.searchDOAById(id);
        User.getUsers().remove(user);
        UserManager.deleteDOAById(id);


    }

    @Override
    public boolean exist() throws SQLException {
        System.out.println("enter id of user to update");
        int id = scanner.nextInt();
      return UserManager.userExist(id);
    }

    @Override
    public void getAll() {
        UserManager.getAll();
    }

    @Override
    public User saisie() {
        System.out.println("Entrer votre login:");
        String login = scanner.next();
        System.out.println("Entrer votre password");
        String password = scanner.next();
        System.out.println("Entrer votre role:");
        String role = scanner.next();
        return new User(login,password,role);
    }
}
