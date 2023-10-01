package nivel2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada extends Exception{
	/*Crea una classe anomenada "Entrada". Aquesta classe ha 
	 * de servir per controlar les diferents excepcions que 
	 * poden aparèixer en Java a l’hora d’introduir dades per 
	 * teclat utilitzant la classe Scanner.
	 * El primer que s’ha de fer és instanciar un objecte de la 
	 * classe Scanner i a partir d’aquí, crear mètodes estàtics per 
	 * llegir els diferents tipus de dades des del teclat
	 */
	
	/*Tots els mètodes reben un String amb el missatge que es vol 
	 * mostrar a l’usuari/ària, per exemple: “Introdueix la teva edat”, 
	 * i retornen la dada oportuna introduïda per l’usuari/ària en cada 
	 * mètode, per exemple: un byte amb l’edat de l’usuari/ària.
	 * Mètodes a implantar capturant l’excepció de la classe InputMismatchException:
		public static byte llegirByte(String missatge)
		public static int llegirInt(String missatge);
		public static float llegirFloat(String missatge);
		public static double llegirDouble(String missatge);
		
		Mètodes a implantar capturant l’excepció de la classe Exception:
		public static char llegirChar(String missatge);
		public static String llegirString(String missatge);
		public static boolean llegirSiNo(String missatge), 
		si l’usuari/ària introdueix “s”, retorna “true”, si 
		l’usuari introdueix “n”, retorna “false”.
	 */
	public static Scanner input() {

		return new Scanner(System.in);
	}
	
	public static byte llegirByte(String msj) throws InputMismatchException {
		Object num;
		byte numCorrecto;
		System.out.print(msj);
		
		num = input().nextByte();

		if(!(num instanceof Byte)) {
			throw new InputMismatchException();
		}else {
			numCorrecto = (byte) num;
		}
		
		
		return numCorrecto;
	}
	
	public static int llegirInt(String msj) throws InputMismatchException{
		Object obj;
		int num;
		
		System.out.print(msj);
		obj = input().nextInt();
		
		if(!(obj instanceof Integer)) {
			throw new InputMismatchException();
		}else {
			num = (int) obj;
		}

		return num;
	}
	
	public static float llegirFloat(String msj) throws InputMismatchException{
		Object obj;
		float num;
		
		System.out.print(msj);
		obj = input().nextFloat();
		
		if(!(obj instanceof Float)) {
			throw new InputMismatchException();
		}else {
			num = (float) obj;
		}

		return num;
		
	}
	
	public static double llegirDouble(String msj) throws InputMismatchException{
		Object obj;
		double num;
		
		System.out.print(msj);
		obj = input().nextDouble();
		
		if(!(obj instanceof Double)) {
			throw new InputMismatchException();
		}else {
			num = (double) obj;
		}

		return num;
	}
	
	public static char llegirChar(String msj) throws Exception {
		Object obj;
		char ch;
		
		System.out.print(msj);
		obj = input().next();
		
		if(!(obj instanceof String) || obj.toString().length() > 1) {
			throw new Exception();
		}else {
			ch = obj.toString().charAt(0);
		}

		return ch;
	}
	
	public static String llegirString(String msj) {
		//No hace falta excepciones porque siempre va a devolver un String
		System.out.print(msj);
		String texto = input().nextLine();

		return texto;
	}
	
	public static boolean llegirSiNo(String msj) throws Exception{
		/*si l’usuari/ària introdueix “s”, retorna “true”, si 
		l’usuari introdueix “n”, retorna “false”.*/
		
		Object obj;
		char ch;
		boolean chrCorrecto = false;
		
		System.out.print(msj);
		obj = input().next();
		
		
		if(!(obj instanceof String) || 
				obj.toString().length() > 1 || 
				((!(obj.toString().equalsIgnoreCase("s")) && !(obj.toString().equalsIgnoreCase("n"))))) {
			throw new Exception();
		}else {
			ch = obj.toString().charAt(0);
			if(ch == 's') {
				chrCorrecto = true;
			}else chrCorrecto =false;
		}
		System.out.println(chrCorrecto);

		return chrCorrecto;
	}

}
