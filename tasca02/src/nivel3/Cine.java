package nivel3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

public class Cine {
	/*Classe Cine		
			Contindrà tots els mètodes que permeten interactuar a l’usuari/ària amb l’aplicació.	
			*/
	
	private int numFilas;
	private int numAsientosFilas;
	private GestionButacas gb;
	private Entrada ex;
	
	public Cine() {
		this.gb = new GestionButacas();
		this.ex = new Entrada();
		pedirDatosIniciales();
	}
	
	public void inciar() {
		/*iniciar: començarà l’aplicació. Cridarà al mètode menu i en 
		funció del número retornat, cridarà al mètode corresponent.*/
		
		int opcion = 0;
		
		do {
			
			opcion = menu();
	
			switch (opcion) {
				
			case 1:
				mostrarButacas();
				break;
			
			case 2:
				mostrarButacasPersona();
				break;
			
			case 3: 
				reservarButaca();
				break;
			
			case 4:
				anularReserva();
				break;
			
			case 5:
				anularReservaPersona();
				break;
				
			}
	
	
		}while(opcion != 0);
	
	}
	
	public int menu() {
		/*menu: mostrarà les opcions del menú principal a l’usuari/ària, 
			li demanarà el número de l’opció escollida i el retornarà.
			1.- Mostrar totes les butaques reservades.
			
			2.- Mostrar les butaques reservades per una persona.
			
			3.- Reservar una butaca.
			
			4.- Anul·lar la reserva d’una butaca.
			
			5.- Anul·lar totes les reserves d’una persona.
			
			0.- Sortir.*/
		int opcion = -1;
		
		System.out.println("\nDel siguiente menu:\n\n1.- Mostrar todas las butacas reservadas"
				+ "\n2.- Mostrar las butacas reservadas por una persona\n"
				+ "3.- Reservar un butaca\n"
				+ "4.- Anular la reserva de una butaca\n"
				+ "5.- Anular todas las reservas de una persona\n"
				+ "0.- Salir");
		
		
		try {
			opcion = ex.llegirInt("\nEscoge una opcion: ");
			
		}catch(InputMismatchException e) {
			System.out.println("Escoge una opcion entre [0] y [5]");
		}
			

		return opcion;
		
	}
	
	public void mostrarButacas() {
		/*mostrarButaques: Mostra totes les butaques reservades.*/
		
		ArrayList<Butaca> butacas = this.gb.getButacas();
		if (butacas.size()>=1) {
			for (Butaca b : butacas) {
				System.out.println(b.toString());
			}
		}else System.out.println("Primero debes reservar butacas");
		
		
	}
	
	public void mostrarButacasPersona() {
		/*mostrarButaquesPersona: Demana el nom de la persona que ha fet 
		 * la reserva i mostra totes les butaques reservades per aquesta persona.
		 */
		
		ArrayList<Butaca> butacas = this.gb.getButacas();
		String nombre = "";
		
		if (butacas.size() >= 1) {
			try{
				nombre = introducirPersona();
				
			}catch(ExcepcionNombrePersonaIncorrecto e) {
				System.out.println(e.getMessage());
			}
			
			for (Butaca b: butacas) {
				if(b.getNombrePersona().equalsIgnoreCase(nombre)) {
					System.out.println(b.toString());
				}
			}
		}else System.out.println("No hay ninguna butaca reservada");
		
	
	}
	
	public void reservarButaca() {
		/*reservarButaca: Demana a l’usuari/ària un número de fila (crida al mètode
		 *  introduirFila), un número de seient (crida al mètode introduirSeient), el 
		 *  nom de la persona que fa la reserva (crida al mètode introduirPersona) i reserva la butaca.
		 */
		int fila= 0;
		int asiento = 0;
		String nombre ="";
		Butaca butaca;
		
		try {
			fila = introducirFila();
			
		}catch(ExcepcionFilaIncorrecta e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		try {
			asiento = introducirAsiento();
			
		}catch(ExcepcionAsientoIncorrecto e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		try {
			nombre = introducirPersona();
			
		}catch(ExcepcionNombrePersonaIncorrecto e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
	
		butaca = new Butaca(fila, asiento, nombre);
		
		try {
			this.gb.aniadirButacas(butaca);
			
		}catch(ExcepcionButacaOcupada e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
				
	}
	
	public void anularReserva() {
		/*anularReserva: Demana a l’usuari/ària un número de fila (crida al mètode 
		 * introduirFila), un número de seient (crida al mètode introduirSeient) i 
		 * elimina la reserva de la butaca.
		 */
		int fila= 0;
		int asiento = 0;
		int index = 0;
		Butaca butaca = new Butaca();
		
		if(this.gb.getButacas().size() >= 1) {
			try {
				fila = introducirFila();
				
			}catch(ExcepcionFilaIncorrecta e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			
			try {
				asiento = introducirAsiento();
				
			}catch(ExcepcionAsientoIncorrecto e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			
			index = this.gb.buscarButaca(fila, asiento);
			
			if(index != -1) {
				butaca = this.gb.getButacas().get(index);
				
			}
			try {
				this.gb.eliminarButaca(butaca);
				
			}catch(ExcepcionButacaLibre e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
		}else System.out.println("No hay ninguna butaca reservada");
		
	}
	
	public void anularReservaPersona() {
		/*anularReservaPersona: Demana a l’usuari/ària el nom de la persona 
		 * (crida al mètode introduirPersona) i elimina les butaques reservades 
		 * per la persona introduïda.
		 */
		
		String nombre = "";
		ArrayList<Butaca> butacas = this.gb.getButacas();
		Iterator<Butaca> it = butacas.iterator();
		boolean existeReservaPersona = false;
		int index = 0;
		
		if(this.gb.getButacas().size() >= 1) {
			try {
				nombre = introducirPersona();
				
			}catch(ExcepcionNombrePersonaIncorrecto e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}
			while(existeReservaPersona == false && index < butacas.size()) {
				if(butacas.get(index).getNombrePersona().equalsIgnoreCase(nombre)) {
					existeReservaPersona = true;
				}
				index += 1;
			}
			
			if(existeReservaPersona == true) {
				while (it.hasNext()) {
					Butaca b = it.next();
					
					if(b.getNombrePersona().equalsIgnoreCase(nombre)) {
						
						it.remove();
						
						
					}
				}
				System.out.println("Butacas eliminadas");
			}else System.out.println("Esta persona no tiene ninguna reserva");
			
		}else System.out.println("No hay ninguna butaca reservada");
		
		
	
	}
	
	public String introducirPersona() throws ExcepcionNombrePersonaIncorrecto {
		/*introduirPersona: demana a l’usuari/ària el nom de la persona i 
		 * el retorna si és correcte. Si conté números, llença una excepció 
		 * personalitzada ExcepcioNomPersonaIncorrecte.
		 */
		
		String nombre = ex.llegirString("Escribe el nombre de la persona: ").strip();
		String [] nombreSinEspacio = nombre.split(" ");
		String nombreAux = "";
		
		for (String n: nombreSinEspacio) {
			nombreAux += n;
		}
		
		for (int i=0; i<nombreAux.length(); i++) {
			if(nombreAux.matches(".*\\d+.*")) {
				throw new ExcepcionNombrePersonaIncorrecto("El nombre de la persona NO debe contener numeros");		
			}
		}
		
		return nombreAux;
	
	}
	
	public void pedirDatosIniciales() {
		/*demanarDadesInicials: Demana a l’usuari/ària el nombre de files 
		 * i seients i els guarda en els atributs corresponents. 
		 */

		
		try {
			this.numFilas = ex.llegirInt("Introduce el numero de filas que tiene el cine: ");
			this.numAsientosFilas = ex.llegirInt("Introduce el numero de asientos que tiene cada fila: ");
			
		}catch(InputMismatchException e) {
			System.out.println("Deben ser numeros enteros");
			System.exit(0);
		}

		
	}
	
	public int introducirFila() throws ExcepcionFilaIncorrecta {
		/*introduirFila: Demana el nombre de fila, si aquest està entre 1 i 
		 * el nombre de files totals, el retorna. Si no, retorna una excepció 
		 * personalitzada ExcepcioFilaIncorrecta.
		 */
		
		int fila = 0;
		
		try {
			fila = ex.llegirInt("Introduce la fila de la butaca: ");
			if (!(fila>= 1 && fila<=this.numFilas)) {
				throw new ExcepcionFilaIncorrecta(String.format("Las filas disponibles son de la 1 a la %d",this.numFilas));
			}
			
		}catch(InputMismatchException e) {
			System.out.println("Debe ser un numero entre 1 y "+ this.numFilas);
			System.exit(fila);
			
		}

		return fila;
	
	}
	
	public int introducirAsiento() throws ExcepcionAsientoIncorrecto {
		/*introduirSeient: Demana el seient, si el número està entre 1 i el nombre
		 *  total de seients, el retorna. Si no, retorna una excepció del
		 *  tipus ExcepcioSeientIncorrecte.
		 */
		
		int asiento = 0;
		
		try {
			asiento = ex.llegirInt("Introduce el numero de la butaca: ");
			if ((!(asiento>= 1)&& !(asiento<=this.numFilas))) {
				throw new ExcepcionAsientoIncorrecto(String.format("Los asientos disponibles son del 1 al %d",this.numAsientosFilas));
			}
			
		}catch(InputMismatchException e) {
			System.out.println("Debe ser un numero entre 1 y "+ this.numAsientosFilas);
			System.exit(0);
		}

		return asiento;
		
	}
	
}
