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
		 * que conté països i capitals. El programa ha de llegir el fitxer 
		 * i guardar les dades en un HashMap<String, String>. El programa 
		 * demana el nom de l’usuari/ària, i després ha de mostrar un país 
		 * de forma aleatòria, guardat en el HashMap. Es tracta de què l’usuari/ària 
		 * ha d’escriure el nom de la capital del país en qüestió. Si l’encerta se 
		 * li suma un punt. Aquesta acció es repeteix 10 vegades. Un cop demanades 
		 * les capitals de 10 països de forma aleatòria, llavors s’ha de guardar en 
		 * un fitxer anomenat classificacio.txt, el nom de l’usuari/ària i la seva puntuació.*/
		
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
