package org.example.Controler;

import org.example.Manager.UserManager;
import org.example.Model.User;

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

    }

    @Override
    public void delete() {

    }

    @Override
    public boolean exist(Object object) {
        return false;
    }

    @Override
    public List<Object> getAll() {
        return null;
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
