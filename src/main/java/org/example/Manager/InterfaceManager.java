package org.example.Manager;

import org.example.Model.Task;
import org.example.Model.User;

import java.sql.SQLException;

public interface InterfaceManager {


    void addDBO(Object o);

    void deleteDBO(int id);
    void updateDBO(Object object);



}
