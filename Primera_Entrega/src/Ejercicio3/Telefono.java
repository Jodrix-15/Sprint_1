package Ejercicio3;

public class Telefono {
	
	private String marca;
	private String modelo;

	public Telefono(String marca, String modelo) {
		/*Crea una classe anomenada "Telèfon" amb els atributs marca i model, i el mètode trucar(). 
		 * Aquest mètode ha de rebre un String amb un número de telèfon. El mètode ha de mostrar per 
		 * consola un missatge dient que s’està trucant al número rebut per paràmetre. */
		
		this.marca = marca;
		this.modelo = modelo;

	}
	
	public void llamar(int numero) {
		System.out.println("Se esta llamando al numero " + numero);
	}

}
