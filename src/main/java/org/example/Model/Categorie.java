package org.example.Model;

import java.util.HashMap;

public class Categorie {
    private static int id ;
    private String libelle ;
    private  HashMap<String ,Task> tasks ;

    public Categorie(String libelle)
    {
        id++;
        this.libelle = libelle;
        tasks = new HashMap<String ,Task>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        Categorie.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public HashMap<String ,Task> getTask() {
        return tasks;
    }

    public void setTask(HashMap<String ,Task> task) {
        this.tasks = task;
    } 
}
