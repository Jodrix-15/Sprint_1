package n3Ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		
		
		Set<Person> people = new HashSet<Person>();
		TreeSet<Person> listPerson;
		int option;
		
		if (readFile("n3Ejercicio1.csv", people) == true) {
			do {
				menu();
				option = choiceOption();
				
				switch(option) {
				case 1:
					insertPerson(people);
					break;
				case 2:
					showByName(people, false);
					break;
				case 3:
					showByName(people, true);
					break;
				case 4:
					showByLastName(people, false);
					break;
				case 5:
					showByLastName(people, true);
					break;
				case 6:
					showById(people, false);
					break;
				case 7:
					showById(people, true);
					break;
				}
				
			}while(option != 0);
		}

	}
	public static void menu() {
		
		System.out.println("Del siguiente menu:\n\n"
				+ "1. Introducir persona"
				+ "\n2. Mostrar las personas ordenadas por nombre (A-Z)\n"
				+ "3. Mostrar las personas ordenadas por nombre (Z-A)\n"
				+ "4. Mostrar las personas ordenadas por apellidos (A-Z)\n"
				+ "5. Mostrar las personas ordenadas por apellidos (Z-A)\n"
				+ "6. Mostrar las personas ordenadas por DNI (1-9)\n"
				+ "7. Mostrar las personas ordenadas por DNI (9-1)\n"
				+ "0. Salir\n");
	}
	
	public static boolean readFile(String fichero, Set<Person> people) {
		String cadena= "";
		String [] cadenaSplit;
		Person p;
		boolean existeFichero = false;
		
		
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
			existeFichero = true;
		
		}catch (IOException e) {
			System.out.println("Fichero no encontrado");
			existeFichero = false;
		}
		
		return existeFichero;
	}
	
	public static void insertPerson(Set<Person> people) {
		
		Person p = new Person(Entrada.llegirString("Nombre"), Entrada.llegirString("Apellidos"), Entrada.llegirString("ID"));
		
		people.add(p);
	
	}
	
	public static void showByName(Set<Person> people, boolean bol) {
		
		TreeSet<Person> sort = new TreeSet<Person>(new Comparator<Person>() {
			
			public int compare(Person p1, Person p2) {
				String name1 = p1.getName();
				String name2 = p2.getName();
				
				return name1.compareToIgnoreCase(name2);
				
			}
		});
		if (bol == true) {
			showTreeSet(sort.descendingSet(), people);
			
		}else showTreeSet(sort, people);
		
	}
	
	
	public static void showByLastName(Set<Person> people, boolean bol) {
		
		TreeSet<Person> sort = new TreeSet<Person>(new Comparator<Person>() {
			
			public int compare(Person p1, Person p2) {
				String name1 = p1.getLastName();
				String name2 = p2.getLastName();
				
				return name1.compareToIgnoreCase(name2);
				
			}
		});
		
		if (bol == true) {
			showTreeSet(sort.descendingSet(), people);
			
		}else showTreeSet(sort, people);
		
	}
	
	public static void showById(Set<Person> people,  boolean bol) {
		
		TreeSet<Person> sort = new TreeSet<Person>(new Comparator<Person>() {
			
			public int compare(Person p1, Person p2) {
				String name1 = p1.getId();
				String name2 = p2.getId();
				
				return name1.compareTo(name2);
				
			}
		});
		
		if (bol == true) {
			showTreeSet(sort.descendingSet(), people);
			
		}else showTreeSet(sort, people);
	}
	
	public static void showTreeSet(NavigableSet<Person> sort, Set<Person> people) {
		
		for (Person p : people) {
			sort.add(p);
		}
		
		System.out.println("__NOMBRE__\t__APELLIDOS__\t__DNI__");
		for (Person p : sort) {
			System.out.println(p.getName() + "\t   " + p.getLastName() + "  \t" + p.getId());
		}
		System.out.println();
		
	}
	
	public static int choiceOption() {
		
		int option = 0;
		boolean isInt = false;
		do {
			try {
				option = Entrada.llegirInt("Escoge una opcion: ");
				System.out.println();
				isInt = true;
				
			}catch(InputMismatchException e) {
				System.out.println("Debe ser un numero entero\n");
			}
			
		}while(isInt == false);
		
		
		return option;
	}

}