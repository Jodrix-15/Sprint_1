package n2Ejercicio1;

import java.util.HashSet;
import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		/*Crea una classe anomenada Restaurant amb dos atributs: nom(String) i puntuació(int). 
		 * Implementa els mètodes necessaris perquè no es puguin introduir objectes Restaurant 
		 * amb el mateix nom i la mateixa puntuació en un HashSet creat en el main() de 
		 * l’aplicació.
		 * 
		 * Pot haver-hi restaurants amb el mateix nom amb diferent puntuació, però no pot haver-hi 
		 * restaurants amb el mateix nom i la mateixa puntuació.*/
		
		HashSet<Restaurante> restaurantes = new HashSet<>();
		Entrada ex = new Entrada();
		
		int opcion = 0;
		
		do {
			System.out.println("Del siguiente menu:\n ");
			menu();
			try {
				opcion = ex.llegirInt("\nElige una opcion: ");
				
				
				if (opcion == 1) {
					Restaurante restaurante = new Restaurante (ex.llegirString("Nombre del restaurante: "), ex.llegirInt("Puntuacion: "));
					introducirRestaurante(restaurante, restaurantes);
				}
				if (opcion == 2) {
					mostrarRestaurantes(restaurantes);
				}
			}catch(Exception e) {
				System.out.println("Debes escribir un numero entero");
				System.exit(0);
			}
			
		}while(opcion != 0);

	}
	
	public static void introducirRestaurante(Restaurante r, HashSet<Restaurante> restaurantes) {
		
		if(buscarRestaurante(r, restaurantes) == false) {
			restaurantes.add(r);
			System.out.println(String.format("El restaurante %s ha sido agregado\n", r.getName()));
			
		}else System.out.println(String.format("El restaurante %s con puntuacion %d ya se encuentra en la base de datos\n", r.getName(), r.getPoints()));
		
	}
	
	public static boolean buscarRestaurante(Restaurante r, HashSet<Restaurante> restaurantes) {
		
		Iterator<Restaurante> it = restaurantes.iterator();
		boolean restauranteRegistrado = false;
		
		if (restaurantes.size() == 0) {
			restauranteRegistrado = false;
		}
		while (it.hasNext()) {
			if(r.equalRestaurante(it.next())) {
				restauranteRegistrado = true;
			}
		}
		
		return restauranteRegistrado;
	}
	
	public static void mostrarRestaurantes(HashSet<Restaurante> restaurantes) {
		Iterator<Restaurante> it = restaurantes.iterator();
		while (it.hasNext()) {
			Restaurante r = it.next();
			System.out.println("Nombre: " + r.getName() + "\tPuntuacion: " + r.getPoints());
		}
	}
	
	public static void menu() {
		
		System.out.println("0. Salir\n"
				+ "1. Introducir Restaurante\n"
				+ "2. Mostrar Restaurantes");
	}

}
