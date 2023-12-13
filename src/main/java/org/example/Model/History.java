package org.example.Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class History {
    private static int id;
    private User user;
    private Task task;
    private String libelle;
    private LocalDate date_creation;
    private static ArrayList<History> histories = new ArrayList<History>();


    public History() {
    }

    public History(User user, Task task, String libelle, LocalDate date_creation) {
        id++;
        this.user = user;
        this.task = task;
        this.libelle = libelle;
        this.date_creation = date_creation;
        histories.add(this);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        History.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public LocalDate getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }
    public static ArrayList<History> getHistories() {
        return histories;
    }

    public static void setUsers(ArrayList<History> histories) {
        History.histories = histories;
    }
}
