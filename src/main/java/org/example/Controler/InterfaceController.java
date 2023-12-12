package org.example.Controler;

import java.sql.SQLException;
import java.util.List;

import org.example.Model.Categorie;
import org.example.Model.Priority;
import org.example.Model.Task;

public interface InterfaceController {

    	 void add();
	    
	     void update();
	    
	     void delete();

         boolean exist() throws SQLException;
	    
	     void getAll();
		 Object saisie();

}
