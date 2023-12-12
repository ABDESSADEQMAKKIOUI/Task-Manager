package org.example.Controler;

import org.example.DBO.UserDBO;
import org.example.Model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserController implements InterfaceController {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void add()
    {
        User user = saisie();
        UserDBO.addDBO(user);
        String status = "Added task";
    }

    @Override
    public void update()
    {
        System.out.println("Entrer id de user tu veux modifier:");
        int id = scanner.nextInt();
        User user = saisie();
        UserDBO.updateDOAById(id, user);
        String status = "Update task";
    }

    @Override
    public void delete()
    {
        System.out.println("Entrer id de user tu veux supprimer:");
        int id = scanner.nextInt();
        UserDBO.deleteDOAById(id);
        String status = "Supprimer task";
    }

    @Override
    public boolean exist() throws SQLException
    {
        System.out.println("Entrer id pour check si il existe");
        int id = scanner.nextInt();
        return UserDBO.userExist(id);
    }

    @Override
    public void getAll()
    {
        UserDBO.getAll();
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
}
