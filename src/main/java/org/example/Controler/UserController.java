package org.example.Controler;

import org.example.DAO.UserDAO;
import org.example.Model.User;

import java.util.Scanner;

public class UserController implements InterfaceController {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void add()
    {
        User user = saisie();
        UserDAO.addDBO(user);
        String status = "Added user";
    }

    @Override
    public void update()
    {
        System.out.println("Entrer id de user tu veux modifier:");
        int id = scanner.nextInt();
        User user = saisie();
        UserDAO.updateDOAById(id, user);
        String status = "Update user";
    }

    @Override
    public void delete()
    {
        System.out.println("Entrer id de user tu veux supprimer:");
        int id = scanner.nextInt();
        UserDAO.deleteDOAById(id);
        String status = "Supprimer user";
    }

    @Override
    public void getAll()
    {
        UserDAO.getAll();
    }

    @Override
    public User saisie() {
        System.out.println("Entrer votre login:");
        String login = scanner.next();
        System.out.println("Entrer votre mot de passe:");
        String password = scanner.next();
        System.out.println("Entrer votre role:");
        String role = scanner.next();
        return new User(login, password, role);
    }

    public void login()
    {
        System.out.println("Entrer votre login:");
        String login = scanner.next();
        System.out.println("Entrer votre mot de passe:");
        String password = scanner.next();
        User.setUserConnect(UserDAO.login(login,password));
    }
}
