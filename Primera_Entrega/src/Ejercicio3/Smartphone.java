package Ejercicio3;

public class Smartphone extends Telefono implements Camara, Reloj {

	public Smartphone(String marca, String modelo) {
		// TODO Auto-generated constructor stub
		super(marca, modelo);
	}
	
	public void hacerFoto() {
		System.out.println("Se está haciendo una foto.");
	}
	
	public void alarma() {
		System.out.println("Esta sonando la alarma");
	}

}
