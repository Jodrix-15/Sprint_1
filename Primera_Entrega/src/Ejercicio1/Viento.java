package Ejercicio1;

public class Viento extends Instrumento {
	
	public Viento(String n, int pre) {
		super(n, pre);
	}
	
	public void tocar() {
		System.out.println("Estas tocando un instrumento de viento");
	}
	
	{
		System.out.println("Bloquue de inicialización de un Instrumento de viento");
	}

}
