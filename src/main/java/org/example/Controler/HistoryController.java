package org.example.Controler;

import org.example.DBO.UserDBO;
import org.example.Model.History;
import org.example.Model.User;

import java.util.Scanner;

public class HistoryController implements InterfaceController{
    Scanner scanner = new Scanner(System.in);
    @Override
    public void add()
    {
        History history
        UserDBO.addDBO(user);
        String status = "Added task";
    }


}
