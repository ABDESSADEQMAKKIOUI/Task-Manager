package org.example.Controler;

import org.example.DBO.HistoryDBO;
import org.example.DBO.UserDBO;
import org.example.Model.History;
import org.example.Model.User;

import java.sql.Date;
import java.util.Scanner;

public class HistoryController {
    Scanner scanner = new Scanner(System.in);

    public void addHistory(int id_user, int id_task, String libelle, Date date_creation)
    {
        History history = new History( id_user, id_task,  libelle,  date_creation);
        HistoryDBO.addHistory(history);

    }
    


}
