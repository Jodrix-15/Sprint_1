package n1Ejercicio2;

import java.io.File;
import java.util.Date;
import java.util.TreeSet;

public class Files {
	
	public void fileSortedByName(String path) {
		TreeSet<String> res = new TreeSet<String>();
		File directory   = new File(path);
		File[] arrContent = directory.listFiles();
		Date date;
		

		 for ( int i = 0; i < arrContent.length; i ++ ) {
			 date = new Date(arrContent[i].lastModified());
			 
			 if(arrContent[i].isDirectory()) {
				 System.out.println(arrContent[i].getName() + "(D)\t" + date);
				 fileSortedByName(path + "\\"+arrContent[i].getName());
				 
			 }else if (arrContent[i].isFile()) {
				 System.out.println(arrContent[i].getName() + "(F)\t" +date);
		    	 res.add( arrContent[i].getName( ));
		     }
           
		 }
	
	}
	
	

}
