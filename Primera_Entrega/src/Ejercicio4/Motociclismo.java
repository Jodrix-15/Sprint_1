package Ejercicio4;

public class Motociclismo extends Noticias {
	
	private String equipo;

	public Motociclismo(String titular, String equipo) {
		/*De les notícies de motociclisme s’ha d’indicar de quin equip(String) són.*/
		
		super(titular);
		this.puntuacion = 3;
		this.precio = 100;
		this.equipo = equipo;
	}
	
	public int calcularPrecio() {
		
		int precioTotal = 0;
		
		if(this.equipo.equalsIgnoreCase("Honda") || this.equipo.equalsIgnoreCase("Yamaha")) {
			precioTotal += 50;
		}
		
		return precioTotal + this.precio;
	}
	
	public int calcularPuntuacion() {
		
		int puntuacionTotal = 0;
		
		if(this.equipo.equalsIgnoreCase("Honda") || this.equipo.equalsIgnoreCase("Yamaha")) {
			puntuacionTotal += 3;
		}
		
		return puntuacionTotal + this.puntuacion;
	}

}
