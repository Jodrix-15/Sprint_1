package n1Ejercicio3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Ejercicio3 {

	public static void main(String[] args) {
		/*Donat el fitxer countrties.txt (revisa l'apartat recursos) 
		 * que cont� pa�sos i capitals. El programa ha de llegir el fitxer 
		 * i guardar les dades en un HashMap<String, String>. El programa 
		 * demana el nom de l�usuari/�ria, i despr�s ha de mostrar un pa�s 
		 * de forma aleat�ria, guardat en el HashMap. Es tracta de qu� l�usuari/�ria 
		 * ha d�escriure el nom de la capital del pa�s en q�esti�. Si l�encerta se 
		 * li suma un punt. Aquesta acci� es repeteix 10 vegades. Un cop demanades 
		 * les capitals de 10 pa�sos de forma aleat�ria, llavors s�ha de guardar en 
		 * un fitxer anomenat classificacio.txt, el nom de l�usuari/�ria i la seva puntuaci�.*/
		
		HashMap<String, String> paisesCapitales = new HashMap<>();
		String cadena = "";
		ArrayList<String> arrayCadena = new ArrayList<>();
		
		
		
		try {
			FileReader f = new FileReader("\\Users\\formacio\\Desktop\\countries.txt");
			BufferedReader b = new BufferedReader(f);
			try {
				while((cadena = b.readLine())!= null){
					System.out.println(cadena.split(" "));
					try {
						arrayCadena.add(cadena.split(" ")[0]);
						arrayCadena.add(cadena.split(" ")[1]);
						paisesCapitales.put(arrayCadena.get(0), arrayCadena.get(1));
					}catch (IndexOutOfBoundsException e) {
						
					}
					
					
				}
				System.out.println(paisesCapitales);
			}catch(IOException e) {
				System.out.println("Sin salida");
			}
		} catch(FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
		
		

	}

}
