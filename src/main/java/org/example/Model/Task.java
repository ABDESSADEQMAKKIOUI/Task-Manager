package org.example.Model;

import java.time.LocalDate;
import java.util.HashMap;

import org.example.Controler.Priority;

public class Task {
    private static int id ;
    private String code ;
    private String libelle ;
    private Priority priority ;
    private int id_category ;
     private int id_user ;
     private LocalDate date_creation ;
     private static HashMap<String,Task> tasks ;

     public Task(String code, String libelle, Priority priority, int id_category, int id_user, LocalDate date_creation) {
        this.code = code;
        this.libelle = libelle;
        this.priority = priority;
        this.id_category = id_category;
        this.id_user = id_user;
        this.date_creation = date_creation;
        tasks.put(this.code,this);

        
    }

    public Task() {
   
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Task.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public LocalDate getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDate date_creation) {
        this.date_creation = date_creation;
    }

    public static HashMap<String, Task> getTasks() {
        return tasks;
    }

    public static void setTasks(HashMap<String, Task> tasks) {
        Task.tasks = tasks;
    }
    




    
    


}
