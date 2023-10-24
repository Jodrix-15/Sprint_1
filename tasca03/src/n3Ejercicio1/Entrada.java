package n3Ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada{

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
		Object obj;
		Object ch;
		int num;
		String dni="";
		String dniLetra= "";
		String texto = "";
		String [] nombreApellidos;
		String apellidos;
		boolean isCorrect = false;
		
		switch (msj.toLowerCase()) {
		case "nombre":
			do {
				System.out.print("Nombre: ");
				texto = input().nextLine();
				
				if(texto.matches(".*\\d+.*")) {
					System.out.println("No debe contener numeros");
				}
			}while(texto.matches(".*\\d+.*"));
			
			break;
		case "apellidos":
			do {
				do {
					System.out.print("Apellidos: ");
					texto = input().nextLine();
					nombreApellidos = texto.split(" ");
					
					if(texto.matches(".*\\d+.*")) {
						System.out.println("No debe contener numeros");
					}
					if(nombreApellidos.length != 2) {
						System.out.println("Debes poner los 2 apellidos");
					}
				}while(texto.matches(".*\\d+.*"));
				
	
			}while(nombreApellidos.length != 2);
			
			break;
		case "id":
			do {
				try {
					do {
						num = llegirInt("Introduce los digitos del DNI: ");
						dni = Integer.toString(num); 
						if (dni.length() !=8) {
							System.out.println("Debe contener 8 digitos");
						}
						isCorrect = true;
						
					}while(dni.length() != 8);
					
				}
				catch(InputMismatchException e) {
					System.out.println("Debe ser un numero y contener 8 digitos");
					
				}
			}while(isCorrect == false);
			
			do {
				isCorrect =false;
				try {
					do {
						obj = llegirChar("Introduce la letra del DNI: ");
						dniLetra = obj.toString().toUpperCase();
						if((dniLetra.codePointAt(0) < 65 || dniLetra.codePointAt(0)>90)){
							System.out.println("Debe ser una letra (A-Z)");
						}
						isCorrect = true;
		
					}while(dniLetra.toUpperCase().codePointAt(0) < 65 || dniLetra.toUpperCase().codePointAt(0)>90);
					
				}catch (Exception e) {
					System.out.println("Debe ser una letra");
				}
			}while(isCorrect == false);
			
			texto = dni + dniLetra;
			break;
		}

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
