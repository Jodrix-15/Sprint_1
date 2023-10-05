package nivel1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ejercicio1 {

	public static void main(String[] args) {
		/*Afegeix 11 objectes Month (cadascun amb el seu atribut diferent) 
		 * en un ArrayList, a excepció de l'objecte amb atribut "Agost". Després, efectua la inserció 
		 * en el lloc que correspon a aquest mes i demostra que l’ArrayList manté l'ordre correcte
		 * Converteix l’ArrayList de l’exercici anterior en un HashSet i assegura’t que no permet duplicats.
			Recorre la llista amb un for i amb un iterador.
		 */
		
		ArrayList<Month> meses = new ArrayList<Month>();
		crearMeses(meses);
		ordenarArrayMes(meses);
		mostrarMesesOrdenados(meses);
		
		
		HashSet<Month> hsMeses = new HashSet<Month>(meses);
		Iterator<Month> it = hsMeses.iterator();
		
		System.out.println("\nIteramos el hashSet con un for:\n");
		for(Month mes : hsMeses) {
			System.out.println(mes.getName());
		}
		
		System.out.println("\nIteramos el hashSet con un Iterator:\n");
		while(it.hasNext()) {
			System.out.println(it.next().getName());
		}
		
	}
	
	public static void crearMeses(ArrayList<Month> meses) {
		Month mes;
		String nombreMes;
		boolean nombreValido = false;
		
		System.out.println("Vamos a aniadir los 12 meses del anio:\n");
		for (int i = 0; i<12; i++) {
			do {
				nombreMes = getString("Escribe el nombre del mes: ").toLowerCase();
				nombreValido = mesValido(nombreMes);
				if(nombreValido == false) {
					System.out.println("Debes introducir el nombre del mes");
					System.exit(0);
				}
				
			}while(nombreValido == false);
			
			if(buscarMes(nombreMes, meses) == false) {
				if(!nombreMes.equalsIgnoreCase("Agosto")) {
					mes = new Month(nombreMes);
					aniadirMes(mes, meses);
				}
				
			}else System.out.println("Este mes ya ha sido agregado\n");
				
		}
				
	}
	
	public static boolean mesValido(String nombre) {
		boolean esValido = false;
		String [] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
		
		for (String m : meses) {
			if(m.equalsIgnoreCase(nombre)) {
				esValido = true;
			}
		}
		return esValido;
	}
	
	public static boolean buscarMes(String nombre, ArrayList<Month> meses) {
		
		boolean mesAgregado = false;
		
		for(Month m : meses) {
			if(m.getName().equalsIgnoreCase(nombre)) {
				mesAgregado = true;
			}
		}
		
		return mesAgregado;
		
	}
	
	public static void aniadirMes(Month m, ArrayList<Month> meses) {
		
		meses.add(m);
	}
	
	public static void ordenarArrayMes(ArrayList<Month> meses) {
		
		Month aux;
		String nombreMes;
		
		for (int i = 0; i<meses.size(); i++) {
			nombreMes = meses.get(i).getName();
			switch (nombreMes) {
			case "enero":
				cambiarPos(i, 0, meses.get(i), meses);
				break;
			case "febrero":
				cambiarPos(i, 1, meses.get(i), meses);
				break;
			case "marzo":
				cambiarPos(i, 2, meses.get(i), meses);
				break;
			case "abril":
				cambiarPos(i, 3, meses.get(i), meses);
				break;
			case "mayo":
				cambiarPos(i, 4, meses.get(i), meses);
				break;
			case "junio":
				cambiarPos(i, 5, meses.get(i), meses);
				break;
			case "julio":
				cambiarPos(i, 6, meses.get(i), meses);
				break;
			case "septiembre":
				cambiarPos(i, 7, meses.get(i), meses);
				break;
			case "octubre":
				cambiarPos(i, 8, meses.get(i), meses);
				break;
			case "noviembre":
				cambiarPos(i, 9, meses.get(i), meses);
				break;
			case "diciembre":
				cambiarPos(i, 10, meses.get(i), meses);
				break;
			}
		}
		
	}
	public static void mostrarMesesOrdenados(ArrayList<Month> meses) {
		
		System.out.println();
		for(Month m: meses) {
			System.out.println(m.getName());
		}
	}
	public static void cambiarPos(int i, int posMes, Month mes, ArrayList<Month> meses) {
		
		Month aux = meses.get(posMes);
		meses.set(posMes, mes);
		meses.set(i, aux);
	}
	
	public static Scanner input() {
		return new Scanner(System.in);
	}
	
	public static String getString(String msj) {
		System.out.println(msj);
		return input().nextLine();
		
	}

}
