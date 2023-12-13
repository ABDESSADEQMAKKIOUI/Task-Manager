package org.example.Controler;

import org.example.DBO.TaskDBO;
import org.example.DBO.UserDBO;
import org.example.Model.Priority;
import org.example.Model.Task;
import org.example.Model.User;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskController implements InterfaceController{

    Scanner scanner = new Scanner(System.in);
    @Override
    public void add()
    {
        Task task = saisie();
        TaskDBO.addDBO(task);
        String status = "Ajouter tache";
        HistoryController H = new HistoryController()
    }

    @Override
    public void update()
    {
        Task task = saisie();
        TaskDBO.updateDBOByCode(task.getCode(), task);
        String status = "Modifier tache";
    }

    @Override
    public void delete()
    {
        System.out.println("Entrer code de tache");
        String code = scanner.next();
        TaskDBO.deleteDOAByCode(code);
        String status = "Supprimer tache";
    }

    @Override
    public boolean exist() throws SQLException
    {
        System.out.println("Entrer code de tache:");
        String code = scanner.next();
        return TaskDBO.taskExist(code);
    }

    @Override
    public void getAll()
    {
        TaskDBO.getAll();
    }

    @Override
    public Task saisie()
    {
        if (User.getUserConnect() != null) {
            System.out.println("Entrer code de tache:");
            String code = scanner.next();
            System.out.println("Entrer libelle de tache:");
            String libelle = scanner.next();
            System.out.println("Entrer tache priority 1-HIGH 2-MEDIUM 3-LOW:");
            Priority priority = Priority.valueOf(scanner.next().toUpperCase());
            System.out.println("Entrer tache id categorie:");
            int idCategory = scanner.nextInt();
            LocalDate dateCreationFormat = LocalDate.now();
            return new Task(code, libelle, priority, null, User.getUserConnect(), dateCreationFormat);
        }
    }

}
