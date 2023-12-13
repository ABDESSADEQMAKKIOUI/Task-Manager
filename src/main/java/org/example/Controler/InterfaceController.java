package org.example.Controler;

import java.sql.SQLException;

public interface InterfaceController {

    	 void add();
	    
	     void update();
	    
	     void delete();

         boolean exist() throws SQLException;
	    
	     void getAll();
		 Object saisie();

}
