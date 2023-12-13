package org.example.Controler;

import org.example.DAO.TaskDAO;
import org.example.Model.Priority;
import org.example.Model.Task;
import org.example.Model.User;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TaskController implements InterfaceController{

    Scanner scanner = new Scanner(System.in);
    @Override
    public void add() throws SQLException {
        Task task = saisie();
        TaskDAO.addDBO(task);
        String status = "Ajouter tache";
        task.getCategorie().getTasks().put(task.getCode(), task);
        HistoryController.addHistory(User.getUserConnect(),task,status,LocalDate.now());
    }

    @Override
    public void update() throws SQLException {
        Task task = saisie();
        TaskDAO.updateDBOByCode(task.getCode(), task);
        String status = "Modifier tache";
        HistoryController.addHistory(User.getUserConnect(),task,status,LocalDate.now());
    }

    @Override
    public void delete()
    {
        System.out.println("Entrer code de tache");
        String code = scanner.next();
        Task task  = TaskDAO.searchDAOByCode(code);
        TaskDAO.deleteDOAByCode(code);
        String status = "Supprimer tache";
        HistoryController.addHistory(User.getUserConnect(), task, status , LocalDate.now());
    }

    @Override
    public void getAll()
    {
        Task.getTasks().forEach((s, task) -> System.out.println(task.toString()));
    }

    public void trieTaskWithDate()
    {
        System.out.println("Cherchez tache par date :");
        LocalDate date = LocalDate.parse(scanner.next());
        List<Task> task = TaskDAO.searchDAOByDate(date);
        assert task != null;
        task.forEach(task1 -> System.out.println(task1.toString()));
    }

    @Override
    public Task saisie() throws SQLException
    {
        System.out.println("Entrer code de tache:");
        String code = scanner.next();
        if (User.getUserConnect() != null && !TaskDAO.taskExist(code))
        {
            System.out.println("Entrer libelle de tache:");
            String libelle = scanner.next();
            System.out.println("Entrer tache priority 1-HIGH 2-MEDIUM 3-LOW:");
            Priority priority = Priority.valueOf(scanner.next().toUpperCase());
            System.out.println("Entrer tache id categorie:");
            int idCategory = scanner.nextInt();
            return new Task(code, libelle, priority, null, User.getUserConnect(), LocalDate.now());
        }
        return null;
    }

}
