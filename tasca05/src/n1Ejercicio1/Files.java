package n1Ejercicio1;

import java.io.File;
import java.util.TreeSet;

public class Files {
	
	public void fileSortedByName(String path) {
		TreeSet<String> res = new TreeSet<String>();
		File directory   = new File(path);
		File[] arrContent = directory.listFiles();
		

		 for ( int i = 0; i < arrContent.length; i ++ ) {

		     if ( arrContent[ i ].isFile( )) {
		    	 res.add( arrContent[ i ].getName( ));
		     }
		            
		 }
		 
		 for (String file : res) {
			 System.out.println(file);
		 }
	}

}
