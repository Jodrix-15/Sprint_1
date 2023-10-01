package Ejercicio4;

public class Tenis extends Noticias {
	
	private String competicion;
	private String tenista;
	

	public Tenis(String titular, String competicion, String tenista) {
		/*De les notícies de tenis s’ha de saber de quina competició(String) parlen i de quins tenistes(String).*/
		
		super(titular);
		this.precio = 150;
		this.competicion = competicion;
		this.tenista = tenista;
		this.puntuacion = 4;
	}
	
	public int calcularPrecio() {
		
		int precioTotal = 0;
	
		if(this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal") || this.tenista.equalsIgnoreCase("Djokovic")) {
			precioTotal += 100;
		}
		
		return precioTotal + this.precio;
	}
	
	public int calcularPuntuacion() {
		
		int puntuacionTotal = 0;
		
		if(this.tenista.equalsIgnoreCase("Federer") || this.tenista.equalsIgnoreCase("Nadal") || this.tenista.equalsIgnoreCase("Djokovic")) {
			puntuacionTotal += 3;
		}
		
		return puntuacionTotal + this.puntuacion;
	}

}
