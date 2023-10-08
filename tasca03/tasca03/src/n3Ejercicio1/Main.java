package n3Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		/*Crea una aplicació capaç de llegir un fitxer CSV. 
		 * Aquest fitxer té 3 camps: nom, cognom i DNI, per cada 
		 * registre. Es tracta d’ordenar les persones llegides del fitxer, 
		 * mitjançant el seu nom, cognom o DNI. Pots fer servir la llista que creguis més adient.
		 *
		
		 */
		
		Set<Person> people = new HashSet<Person>();
		Entrada ex = new Entrada();
		int option;
		
		readFile("\\Users\\Oven\\eclipse-workspace\\tasca03\\src\\n3Ejercicio1\\n3Ejercicio1.csv", people);
		
		
		do {
			option = choiceOption(ex);
			
			switch(option) {
			case 1:
				insertPerson(ex, people);
				break;
			case 2:
				showByName(people);
				break;
			case 3:
				reverseShowByName();
				break;
			case 4:
				showByLastName();
				break;
			case 5:
				reverseShowByLastName();
				break;
			case 6:
				showById();
				break;
			case 7:
				reverseShowById();
				break;
			}
			
		}while(option != 0);
		



	}
	public static void menu() {
		
		System.out.println("Del siguiente menu:\n\n"
				+ "1. Introducir persona"
				+ "\n2. Mostrar las personas ordenadas por nombre (A-Z)\n"
				+ "3. Mostrar las personas ordenadas por nombre (Z-A)\n"
				+ "4. Mostrar las personas ordenadas por apellidos (A-Z)\n"
				+ "5. Mostrar las personas ordenadas por apellidos (Z-A)\n"
				+ "6. Mostrar las personas ordenadas por DNI (1-9)\n"
				+ "7. Mostrar las personas ordenadas por DNI (9-1)\n");
	}
	
	public static void readFile(String fichero, Set<Person> people) {
		String cadena= "";
		String [] cadenaSplit;
		Person p;
		
		
		try {
			FileReader f= new FileReader(fichero);
			BufferedReader b = new BufferedReader(f);
			while (cadena != null) {
				cadena = b.readLine();
			
				if(cadena != null) {
					cadenaSplit = cadena.split(";");
					p =new Person(cadenaSplit[0], cadenaSplit[1], cadenaSplit[2]);
					people.add(p);
					
				}
			}
		
		}catch (IOException e) {
			System.out.println("Fichero no encontrado");
		}
	}
	
	public static void insertPerson(Entrada ex, Set<Person> people) {
		
		Person p = new Person(ex.llegirString("Nombre: "), ex.llegirString("Apellidos: "), ex.llegirString("ID: "));
		
		people.add(p);
	
	}
	
	public static void showByName(Set<Person> people) {
		TreeSet<Person> sort = new TreeSet<Person>(people);
		
		
		
		System.out.println(sort);
	}
	
	public static void reverseShowByName() {
		
	}
	
	public static void showByLastName() {
		
	}
	
	public static void reverseShowByLastName() {
		
	}
	
	public static void showById() {
		
	}
	
	public static void reverseShowById() {
		
	}
	
	public static int choiceOption(Entrada ex) {
		
		int option = 0;
		boolean isInt = false;
		do {
			try {
				option = ex.llegirInt("Escoge una opcion: ");
				isInt = true;
				
			}catch(InputMismatchException e) {
				System.out.println("Debe ser un numero entero\n");
			}
			
		}while(isInt == false);
		
		
		return option;
	}

}
