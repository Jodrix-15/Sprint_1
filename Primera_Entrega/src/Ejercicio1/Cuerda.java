package Ejercicio1;

public class Cuerda extends Instrumento {
	
	
	public Cuerda(String n, int pre) {
		super(n, pre);
	}
	public void tocar() {
		System.out.println("Estas tocando un instrumento de cuerda");
	}
	
	{
		System.out.println("Bloque de inicialización de Instrumento de cuerda");
	}
	static {
		System.out.println("Bloque Static de un instrumento de cuerda");
	}
}
