package n1Ejercicio1;

public class Main {

	public static void main(String[] args) {
		/*Crea una classe anomenada NoGenericMethods que emmagatzemi 
		 * tres objectes del mateix tipus, juntament amb els mètodes 
		 * per a emmagatzemar i extreure aquests objectes i un constructor 
		 * per a inicialitzar els tres. Comprova que els arguments es poden 
		 * posar en qualsevol posició en la crida al constructor.
		 */
		
		NoGenericMethods ngm = new NoGenericMethods("Objeto 1", "Objeto 2", "Objeto 3");
		NoGenericMethods ngm2 = new NoGenericMethods("Objeto 2", "Objeto 3", "Objeto 1");
		
		System.out.println(ngm.getObj1()+ "; " + ngm2.getObj1());
		

	}

}
