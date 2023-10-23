package n2Ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	
	public static Scanner input() {

		return new Scanner(System.in);
	}
	
	public static byte llegirByte(String msj) throws InputMismatchException {
		Object num;
		byte numCorrecto;
		System.out.print(msj);
		
		num = input().nextByte();
		numCorrecto = (byte) num;

		return numCorrecto;
	}
	
	public static int llegirInt(String msj) throws InputMismatchException{
		Object obj;
		int num;
		
		System.out.print(msj);
		obj = input().nextInt();
		num = (int) obj;

		return num;
	}
	
	public static float llegirFloat(String msj) throws InputMismatchException{
		Object obj;
		float num;
		
		System.out.print(msj);
		obj = input().nextFloat();	
		num = (float) obj;

		return num;
		
	}
	
	public static double llegirDouble(String msj) throws InputMismatchException{
		Object obj;
		double num;
		
		System.out.print(msj);
		obj = input().nextDouble();
		num = (double) obj;

		return num;
	}
	
	public static char llegirChar(String msj) throws Exception {
		Object obj;
		char ch;
		
		System.out.print(msj);
		obj = input().next();
		
		if(obj.toString().length() > 1) {
			throw new Exception();
		}else {
			ch = obj.toString().charAt(0);
		}

		return ch;
	}
	
	public static String llegirString(String msj) {
		
		String texto;
	
		do {
			System.out.print(msj);
			texto = input().nextLine();
			
			if(texto.matches(".*\\d+.*")) {
				System.out.println("No debe contener numeros");
			}
		}while(texto.matches(".*\\d+.*"));

		return texto;
	}
	
	public static boolean llegirSiNo(String msj) throws Exception{
	
		
		Object obj;
		char ch;
		boolean chrCorrecto = false;
		
		System.out.print(msj);
		obj = input().next();
		
		
		if(obj.toString().length() > 1 || 
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