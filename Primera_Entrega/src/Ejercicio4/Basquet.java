package Ejercicio4;

public class Basquet extends Noticias {
	
	private String competicion;
	private String club;

	public Basquet(String titular, String competicion, String club) {
		/*De les notícies de bàsquet s’ha d’indicar a quina competició fa referència(String) i a quin club(String).*/
		
		super(titular);
		this.precio = 250;
		this.puntuacion = 4;
		this.competicion = competicion;
		this.club = club;
	}
	
	public int calcularPrecio() {
		
		int precioTotal = 0;
		
		if(this.competicion.equalsIgnoreCase("Euroliga")) {
			precioTotal += 75;
		}
		if(this.club.equalsIgnoreCase("Barca") || this.club.equalsIgnoreCase("Madrid")) {
			precioTotal += 75;
		}
		
		return precioTotal + this.precio;
		
	}
	
	public int calcularPuntuacion() {
		
		int puntuacionTotal = 0;
		
		if(this.competicion.equalsIgnoreCase("Euroliga")) {
			puntuacionTotal += 3;
		}else if(this.competicion.equalsIgnoreCase("ACB")) {
			puntuacionTotal += 2;
		}
		if(this.club.equalsIgnoreCase("Barca") || this.club.equalsIgnoreCase("Madrid")) {
			puntuacionTotal += 1;
		}
		
		return puntuacionTotal + this.puntuacion;
	}

}
