package Ejercicio2;

public class Main {

	public static void main(String[] args) {
		/*Crea una classe "Cotxe" amb els atributs: marca, model i potència. La marca ha
		 *  de ser estàtic final, el model estàtic i la potència final. Demostra la diferència entre els tres. 
		 *  N’hi ha algun que es pugui inicialitzar al constructor de la classe?
			Afegeix dos mètodes a la classe "Cotxe". Un mètode estàtic anomenat frenar() i 
			un altre no estàtic anomenat accelerar(). El mètode accelerar ha de mostrar per consola: 
			“El vehicle està accelerant” i el mètode frenar() ha de mostrar: “El vehicle està frenant”. 
			Demostra com invocar el mètode estàtic i el no estàtic des del main() de la classe principal.*/
		
		Coche c = new Coche();
		Coche c2 = new Coche();
		
		
		System.out.println("Si el atributo es public:\n");
		
		//si la variable es public, podemos llamarla desde otra clase invocándola con el 
		//nombre de la clase. Y al ser final no podremos cambiar el valor		
		System.out.println("Mostramos la marca del coche invocandola con el nombre de la clase, "
				+ "ya que este atributo es de la clase y no del objeto\nMarca = "+ Coche.marca); 
		
		System.out.println("Si intentaramos llamar el atributo marca con un objeto de la clase nos daria error\n");
		//c.marca //En cambio si intentamos invocarla haciendo una instancia de la clase nos da error
		
		
		System.out.println("Si los atributos son private:\n");
		System.out.println("No podremos acceder a ningún atributo de forma directa. Ni llamandola con la clase ni con una instancia de la misma");
		//en este caso no podremos acceder a ningún atributo, la razón es que a tener el modificador de acceso "private" no podemos
		//modificar el valor desde otra clase que no sea donde se ubica
		
		
		
		System.out.println("\nSolo el atributo 'final static': no puede inicializarse en el constructor, Es una constante de clase.\n "
				+ "atributo final: puede inicializarse en el constructor. No se puede modificar su valor una vez inicializado\n"
				+ "atributo static: puede inicializarse en el constructor. Todos los objetos de la clase tendrían el mismo valor. \nsi se modifica el de uno, se modifican todos"
				+ "por tanto, aunque se pueda incializar en el constructor no es recomendable\n");
		
		System.out.println("Ejemplo: ");
		System.out.println("Modelo coche 2 = "+c2.getModelo());
		
		System.out.println("Modifico el model del coche 2 que es una variable declarada como static");
		c2.setModelo(54321);
		System.out.println("Ahora el modelo del coche 2 es: "+c2.getModelo());
		System.out.println("Y el modelo del coche 1 es: "+c.getModelo() + "\nSe observa que aunque haya modificado el model del coche 2\nen realidad se han modificado el modelo de todos los objetos");
		
		System.out.println("Metodos: ");
		System.out.println("\nLlamo al metodo acelarar con una instancia de la clase:");
		c.acelerar(); //Lo invocamos desde la instancia a la clase
		
		System.out.println("\nllamo al metodo frenar con una instancia de la clase: ");
		c.frenar();
	

		System.out.println("\nLlamo al metodo frenar con la propia clase:");
		Coche.frenar();//Tenemos que invocarlo con el nombre de la clase
		
		System.out.println("\nSin embargo no puedo llamar a un metodo no static con la propia clase");
		System.out.println("\nEn un método static solo podremos usar atributos statics y llamar únicamente a métodos staticos");
		
		
		

	}

}
