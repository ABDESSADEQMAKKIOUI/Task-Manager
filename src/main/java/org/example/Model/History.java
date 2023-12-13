package org.example.Model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class History {
    private int id;
    private int id_user;
    private int id_task;
    private String libelle;
    private Date date_creation;
    private static ArrayList<History> histories = new ArrayList<History>();


    public History() {
    }

    public History(int id, int id_user, int id_task, String libelle, Date date_creation) {
        this.id = id;
        this.id_user = id_user;
        this.id_task = id_task;
        this.libelle = libelle;
        this.date_creation = date_creation;
        histories.add(this);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }
    public static ArrayList<History> getHistories() {
        return histories;
    }

    public static void setUsers(ArrayList<History> histories) {
        History.histories = histories;
    }
}
