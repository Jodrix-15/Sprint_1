package n1Ejercicio3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.TreeSet;

public class Files {
	
	public void fileSortedByName(String path) {
		TreeSet<String> res = new TreeSet<String>();
		File directory   = new File(path);
		File[] arrContent = directory.listFiles();
		Date date;
		try {
			FileWriter fw = null;
			
			File file = new File("Ficheros.txt");
			if(!file.exists()) {
				file.createNewFile();
			}else {
				fw = new FileWriter(file.getAbsoluteFile(), true);
				
				for ( int i = 0; i < arrContent.length; i ++ ) {
					 date = new Date(arrContent[i].lastModified());
					 
					 if(arrContent[i].isDirectory()) {
						 fw.write(arrContent[i].getName() + "(D)\t" + date+"\n");
						 res.add( arrContent[i].getName( ) + "(D)\t" + date+"\n");
						 System.out.println(arrContent[i].getName());
						 fileSortedByName(path + "\\"+arrContent[i].getName());
						 
						 
					 }else if (arrContent[i].isFile()) {
						 fw.write(arrContent[i].getName() + "(F)\t" + date+"\n");
				    	 res.add( arrContent[i].getName( ) + "(D)\t" + date+"\n");
				    	 System.out.println(arrContent[i].getName());
				     }
					 
				 }
			}
			
		 fw.close();
		
		}catch(IOException e) {
			System.out.println("Erro con el archivo");
		}
		
	}


	


}
