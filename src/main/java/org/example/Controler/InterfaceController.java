package org.example.Controler;

import java.util.List;

import org.example.Model.Categorie;
import org.example.Model.Task;

public interface InterfaceController {

    	public void add();
	    
	    public void update();
	    
	    public void delete();

        public void changeTaskCategory();

        //po teste l'exstence des object
        public boolean exist(Object object);
	    
	    public List<Object> getAll();
	    
	    public void show();

        public void showcodeTask();
	    
	    public void showTasksbycategoy(Categorie categorie);
	    
	    public void assignCategory(Task task, Categorie category);
	    
	    public List<Task> filterByCategory(Categorie category);
	    //priority will be enum
	    public void setPriority(Task task, Priority priority);
	    
	     public List<Task> sortByPriority();

	    public List<Task> sortByCreationDate();

	    public List<String> getActionHistory();
	  
        //fichier
	    public void exportTasks(String path); 
	    public void importTasks(String path);
}
