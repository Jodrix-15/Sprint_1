package Ejercicio2;

public class Coche {
	
	/* rea una classe "Cotxe" amb els atributs: marca, model i potència. La marca ha
	   de ser estàtic final, el model estàtic i la potència final. Demostra la diferència entre els tres.
	   N’hi ha algun que es pugui inicialitzar al constructor de la classe?
			Afegeix dos mètodes a la classe "Cotxe". Un mètode estàtic anomenat frenar() i 
			un altre no estàtic anomenat accelerar(). El mètode accelerar ha de mostrar per consola: */
	
	public final static  String marca = "Renault"; 
	private static int modelo; //esta variable se puede modificar, pero forma parte de la clase y no del objeto que se crea al instanciar una clase
	private final float potencia; //una vez que se le asigna una valor no puede ser cambiado

	
		
	public Coche() {
		// TODO Auto-generated constructor stub
		potencia = 350;
		modelo = 345234;
		
	}



	public static int getModelo() {
		return modelo;
	}



	public static void setModelo(int modelo) {
		Coche.modelo = modelo; //debemos invocar el atributo "modelo" a traves del nombre de la clase, ya que cuando un atributo es static 
								// no forma parte del objeto, sino de la clase
	}


	
	/*public float setPotenica(float potencia) {
		this.potencia = potencia; //como potencia es un atributo final y está inicializado en el constructor, no podemos modificar su valor
								 // es por ello que nos da error
	}*/
	
	public void acelerar() {
		
		System.out.println("El coche está acelerando");
		
		
	}
	
	public static void frenar() {
		System.out.println("El coche está frenando");
		
		
	}
	
	

}
