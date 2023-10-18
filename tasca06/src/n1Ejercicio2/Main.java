package n1Ejercicio2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericMethods gm = new GenericMethods();
		gm.showAttributes(new Person(), 3, "Hola");
		gm.showAttributes(new Person().getName(), 'h', new Person().getyOld());

	}

}
