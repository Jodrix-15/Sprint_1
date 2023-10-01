package Ejercicio1;

public class App {
	
	static {
		System.out.println("Bloque static en el mismo archivo que el main");
	}

	public static void main(String[] args) {
		/* En un grup de música hi ha diferents tipus d’instruments musicals. Hi ha instruments de vent, de corda i de percussió.
		Tots els instruments tenen com a atributs el seu nom, i el seu preu. A més, tenen un mètode anomenat tocar(). Aquest, és abstracte a 
		la classe instrument i, per tant, s’ha d’implementar a les classes filles. Si s’està tocant un instrument de vent, el mètode ha de 
		mostrar per consola: "Està sonant un instrument de vent", si s’està tocant un instrument de corda: “Està sonant un instrument de corda” 
		i si s’està tocant un instrument de percussió: “Està sonant un instrument de percussió”.
		El procés de càrrega d'una classe només té lloc una vegada. Demostra que la càrrega pot ser provocada per la creació de la primera
		 instància d'aquesta classe o per l'accés a un membre estàtic d'aquesta. 
		Cerca informació sobre els blocs d'inicialització i blocs estàtics en Java.*/
		
		
		//Un bloque de inicialización static se inicializa cuando la clase es cargada. si está en el mismo archivo que el main
		//se ejecuta antes que el propio main, si no lo está entonces se ejecutará la primera vez que sea instanciada
		System.out.println("Main");
		
		//si en una misma clase hay una bloque static y un bloque simple, primero se ejecutarán los static
		Instrumento guitarra = new Cuerda("Guitarra", 180);
		Instrumento flauta = new Viento("Flauta", 40);
		Instrumento bateria = new Percusion("Bateria", 500);
		
		flauta.tocar();
		guitarra.tocar();
		bateria.tocar();
		
		
	}

}
