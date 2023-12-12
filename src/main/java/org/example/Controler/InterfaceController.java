package org.example.Controler;

import java.util.List;

import org.example.Model.Categorie;
import org.example.Model.Priority;
import org.example.Model.Task;

public interface InterfaceController {

    	 void add();
	    
	     void update();
	    
	     void delete();

         boolean exist(Object object);
	    
	     List<Object> getAll();
		 Object saisie();

}
