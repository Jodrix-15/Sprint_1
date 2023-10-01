package Ejercicio4;

public class F1 extends Noticias {
	
	private String escuderia;

	public F1(String titular, String escuderia) {
		/*De les notícies d'F1 hem de saber a quina escuderia(String) fan referència.*/
		
		super(titular);
		this.puntuacion = 4;
		this.precio = 100;
		this.escuderia = escuderia;
	}
	
	public int calcularPrecio() {
		
		int precioTotal = 0;
		
		if(this.escuderia.equalsIgnoreCase("Ferrari") || this.escuderia.equalsIgnoreCase("Mercedes")) {
			precioTotal += 50;
		}
		
		return precioTotal + this.precio;
	}
	
	public int calcularPuntuacion() {
		
		int puntuacionTotal = 0;
		
		if(this.escuderia.equalsIgnoreCase("Ferrari") || this.escuderia.equalsIgnoreCase("Mercedes")) {
			puntuacionTotal += 2;
		}
		
		return puntuacionTotal + this.puntuacion;
	}
	

}
