package n2Ejercicio2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import n2Ejercicio1.Entrada;
import n2Ejercicio1.Restaurante;

public class main {

	public static void main(String[] args) {
		/*Utilitzant la classe del programa anterior, crea la 
		 * implementació necessària perquè els objectes de la classe 
		 * Restaurant estiguin ordenats per nom i per puntuació en ordre ascendent. 
		 */

		HashSet<Restaurante> restaurantes = new HashSet<>();
		ArrayList<Restaurante> r = new ArrayList<Restaurante>();
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
					r = ordenarRestaurantes(restaurantes);
					//System.out.println("Aquí llego");
				}
				if (opcion == 2) {
					mostrarRestaurantes(r);
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
	
	public static ArrayList<Restaurante> ordenarRestaurantes(HashSet<Restaurante> restaurantes) {
		
		ArrayList<Restaurante> r = new ArrayList<Restaurante>(restaurantes);
		Restaurante rAux;

		for (int i = 0; i<r.size(); i++) {
			for(int j=i+1; j<r.size(); j++) {
				
				
				if(r.get(i).getPoints() < r.get(j).getPoints()) {
					r.add(i, r.get(j));
					System.out.println("aqui llego");
			
				}
			}			
		}
		
		return r;
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
	
	public static void mostrarRestaurantes(ArrayList<Restaurante>  restaurantes) {
		Iterator<Restaurante> it = restaurantes.iterator();
		while (it.hasNext()) {
			Restaurante r = it.next();
			System.out.println("Nombre: " + r.getName() + "\tPuntuacion: " + r.getPoints());
		}
		System.out.println();
	}
	
	public static void menu() {
		
		System.out.println("0. Salir\n"
				+ "1. Introducir Restaurante\n"
				+ "2. Mostrar Restaurantes");
	}

}



