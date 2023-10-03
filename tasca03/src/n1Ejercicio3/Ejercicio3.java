package n1Ejercicio3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


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
	
		int puntuacion = 0;
		int numRandom = 0;
		String [] opcionRandom;
		String nombreUsuario = null;
		String respuestaUsuario;
		FileWriter clasificacion;

		leerFichero("\\Users\\formacio\\Desktop\\countries.txt", paisesCapitales);
			
		nombreUsuario = getString("Nombre usuario: ");
		
		for (int i=0; i<10; i++) {
			numRandom = numRandom(paisesCapitales);
			opcionRandom = paisCapitalRandom(numRandom, paisesCapitales);
			respuestaUsuario = getString("\nLa capital de " +opcionRandom[0]+" es: " );
			if(respuestaUsuario.equalsIgnoreCase(opcionRandom[1])) {
				System.out.println("Respuesta Correcta");
				puntuacion ++;
				
			}else System.out.println("Respuesta Incorrecta");
		}
		
		System.out.println("\nHas obtenido una puntuacion de: " + puntuacion + " puntos"); 
		try {
			clasificacion = new FileWriter("Clasificacion.txt");
			clasificacion.write(nombreUsuario + ": "+ puntuacion + " puntos");
		}catch(IOException e) {
			
		}
		
	
		
		
	}
	
	public static void leerFichero(String fichero, HashMap<String, String> paisesCapitales) {
		
		String cadena = "";
		String [] paisCapital = null;
		
		try {
			FileReader f = new FileReader(fichero);
			BufferedReader b = new BufferedReader(f);
			
			while (cadena != null) {
				cadena = b.readLine();

				if (cadena != null ){
					paisCapital = cadena.split(" ");

					paisesCapitales.put(paisCapital[0], paisCapital[1]);
				}			
			}
	
		} catch(IOException e) {
			System.out.println("Archivo no encontrado");
		}
		
	}
	
	public static int numRandom(HashMap<String, String> paisesCapitales) {
		
		Random r = new Random();
	
		return r.nextInt(paisesCapitales.size()) + 1;
	}
	
	public static String[] paisCapitalRandom(int numRandom, HashMap<String, String> paisesCapitales) {
		int index = 0;
		String [] opcionRandom = {"", ""};
		
		for (HashMap.Entry<String, String> pais : paisesCapitales.entrySet()) {
			if(index == numRandom) {
				opcionRandom[0] = pais.getKey();
				opcionRandom[1] = pais.getValue();
			}
			index ++;
		}
		
		return opcionRandom;
		
	}
	
	public static Scanner input() {
		return new Scanner(System.in);
	}
	
	public static String getString(String msj) {
		System.out.print(msj);
		return input().nextLine();
		
	}


}
