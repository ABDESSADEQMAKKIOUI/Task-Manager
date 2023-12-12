package org.example.Model;

import java.sql.Date;
import java.time.LocalDate;

public class History {
    private int id;
    private int id_user;
    private int id_task;
    private String libelle;
    private Date date_creation;

    public History() {
    }

    public History(int id, int id_user, int id_task, String libelle, Date date_creation) {
        this.id = id;
        this.id_user = id_user;
        this.id_task = id_task;
        this.libelle = libelle;
        this.date_creation = date_creation;
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
}
