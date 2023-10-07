package nivel2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*És important que si en algun mètode salta una 
		 * excepció, la tractem i tornem a demanar la dada a 
		 * l’usuari/ària fins que aquesta estigui ben introduïda. 
		 * Per exemple: Si introdueix un float amb un punt en lloc 
		 * d'amb una coma, ha de mostrar “Error de format”. Fins 
		 * que l’usuari/ària no introdueix un float ben format ha 
		 * de seguir demanant la dada.
		 */
		
		Scanner sc = new Scanner(System.in);
		Entrada ex = new Entrada();
		
		int opcion = -1;
		
		
		do {
			menu();
			try {
				opcion = ex.llegirInt("\nElige una opcion: ");
				
			}catch(InputMismatchException e) {
				System.out.println("Debe ser un numero entero");
			}
			
			switch (opcion) {
			case 1:
				boolean esByte = false;
				byte numByte = 0;
				do {
					try {
						
						numByte = ex.llegirByte("Introduce un numero entre -128 y 127: ");
						System.out.println("Valor introducido correctamente");
						esByte=true;
					}catch (InputMismatchException e) {
						System.out.println("Debe ser un numero entre -128 y 127\n");
						esByte = false;
					}
				}while(esByte == false);
				break;
			case 2:
				boolean esInt = false;
				int numInt = 0;
				
				do {
					try {
						
						numInt = ex.llegirInt("Introduce un numero entre -2.147.483.648 y 2.147.483.649: ");
						System.out.println("Valor introducido correctamente");
						esInt=true;
					}catch (InputMismatchException e) {
						System.out.println("Debe ser un numero entre -2.147.483.648 y 2.147.483.649\n");
						esInt = false;
					}
				}while(esInt == false);
				break;
			case 3:
				boolean esFloat = false;
				float numFloat = 0;
				
				do {
					try {
						
						numFloat = ex.llegirFloat("Introduce un numero entre -3.402823e38 y 3.402823e38: ");
						System.out.println("Valor introducido correctamente");
						esFloat=true;
					}catch (InputMismatchException e) {
						System.out.println("Debe ser un numero entre -3.402823e38 y 3.402823e38\n");
						esFloat = false;
					}
				}while(esFloat == false);
				break;
			case 4:
				boolean esDouble = false;
				double numDouble = 0;
				
				do {
					try {
						
						numDouble = ex.llegirDouble("Introduce un numero entre -1.79769313486232e308 y 3.402823e38: ");
						System.out.println("Valor introducido correctamente");
						esDouble=true;
					}catch (InputMismatchException e) {
						System.out.println("Debe ser un numero entre -1.79769313486232e308 y 1.79769313486232e308\n");
						esDouble = false;
					}
				}while(esDouble == false);
				break;
			case 5:
				boolean esChar = false;
				char chr;
				
				do {
					try {
						
						chr = ex.llegirChar("Introduce una letra: ");
						System.out.println("Valor introducido correctamente");
						esChar=true;
					}catch (Exception e) {
						System.out.println("Debes escribir una caracter\n");
						esChar = false;
					}
				}while(esChar == false);
				break;
			case 6:
				String str;
				
				str = ex.llegirString("Introduce un texto: ");
				System.out.println("Valor introducido correctamente");
				break;
			case 7:
				boolean esBoolean = false;
				boolean esChr;
				
				do {
					try {
						
						esChr = ex.llegirSiNo("Introduce una letra [s]i o [n]o: ");
						System.out.println("Valor introducido correctamente");
						esBoolean = true;
					}catch (Exception e) {
						System.out.println("Debes escribir 's' o 'n'\n");	
						esBoolean = false;
						
					}
				}while(esBoolean == false);
				break;
			}
		}while(opcion != 0);
		

	}
	
	public static void menu() {
		
		System.out.println("De las siguientes opciones:\n"
				+ "\n1. Leer Byte\n"
				+ "2. Leer Int\n"
				+ "3. Leer Float\n"
				+ "4. Leer Double\n"
				+ "5. Leer Char\n"
				+ "6. Leer String\n"
				+ "7. Leer Si No\n"
				+ "0. Salir");
		
	}

}
