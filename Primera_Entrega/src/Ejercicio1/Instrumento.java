package Ejercicio1;

public abstract class Instrumento {
	
	protected String nombre;
	protected int precio;
	
	
	public Instrumento(String n, int p) {
		this.nombre = n;
		this.precio = p;
		
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public abstract void tocar();

}
