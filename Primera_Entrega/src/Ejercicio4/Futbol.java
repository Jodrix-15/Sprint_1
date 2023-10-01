package Ejercicio4;

public class Futbol extends Noticias{
	
	private String competicion;
	private String club;
	private String jugador;
	

	public Futbol(String titular, String competicion, String club, String jugador) {
		/*A més, de les notícies de futbol s’ha de saber a quina competició fa referència(String), a quin club(String) i a 
		quin jugador(String).
		
		Preu inicial: 300 €
		Lliga de Campions: 100 €		
		Barça o Madrid: 100 €		
		Ferran Torres o Benzema: 50 €
		
		5 Punts.

		Lliga de Campions: 3 punts		
		Lliga: 2 punts		
		Barça o Madrid: 1 punt
		Ferran Torres o Benzema: 1 punt
		
		*/
		super(titular);
		this.precio = 300;
		this.puntuacion = 5;
		this.competicion = competicion;
		this.club = club;
		this.jugador = jugador;
	
	}
	
	public int calcularPrecio() {
		
		int precioTotal = 0;
		
		if(this.competicion.equalsIgnoreCase("Liga de campeones")) {
			precioTotal = precioTotal + 100;
		}
		if(this.club.equalsIgnoreCase("Barca") || this.club.equalsIgnoreCase("Madrid")) {
			precioTotal = precioTotal + 100;
		}
		if(this.jugador.equalsIgnoreCase("Ferran Torres") || this.jugador.equalsIgnoreCase("Benzema")) {
			precioTotal = precioTotal + 50;
		}
		
		return precioTotal + this.precio;
	}
	
	public int calcularPuntuacion() {
		
		int puntuacionTotal = 0;
		
		if(this.competicion.equalsIgnoreCase("Liga de campeones")) {
			puntuacionTotal += 3;
		}else if(this.competicion.equalsIgnoreCase("Liga")) {
			puntuacionTotal += 2;
		}
		if(this.club.equalsIgnoreCase("Barca") || this.club.equalsIgnoreCase("Madrid")) {
			puntuacionTotal += 1;
		}
		if(this.jugador.equalsIgnoreCase("Ferran Torres") || this.jugador.equalsIgnoreCase("Benzema")) {
			puntuacionTotal += 1;
		}
		
		return puntuacionTotal + this.puntuacion;
		
	}

}
