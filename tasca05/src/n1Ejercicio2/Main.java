package n1Ejercicio2;


public class Main {

	public static void main(String[] args) {
		/*Afegeix a la classe de l�exercici anterior, 
		 * la funcionalitat de llistar un arbre de directoris 
		 * amb el contingut de tots els seus nivells (recursivament) 
		 * de manera que s'imprimeixin en pantalla en ordre alfab�tic 
		 * dins de cada nivell, indicant a m�s si �s un directori 
		 * (D) o un fitxer (F), i la seva �ltima data de modificaci�.
		 */
		
		Files myFiles = new Files();
		myFiles.fileSortedByName("\\Users\\formacio\\eclipse-workspace\\tasca05\\resources");
		

	}

}
