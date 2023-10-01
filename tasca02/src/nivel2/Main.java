package nivel2;
import java.util.InputMismatchException;

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
		
		Entrada ex = new Entrada();
		boolean esByte = false;
		boolean esInt = false;
		boolean esFloat = false;
		boolean esDouble = false;
		boolean esChar = false;
		boolean esString = false;
		boolean esBoolean = false;
		
		byte numByte = 0;
		int numInt = 0;
		float numFloat = 0;
		double numDouble = 0;
		char chr;
		String str;
		boolean esChr;
		
		
		/*do {
			try {
				
				numByte = ex.llegirByte("Introduce un numero entre -128 y 127: ");
				esByte=true;
			}catch (InputMismatchException e) {
				System.out.println("Debe ser un numero entre -128 y 127\n");
				esByte = false;
			}
		}while(esByte == false);*/
		
		/*do {
			try {
				
				numInt = ex.llegirInt("Introduce un numero entre -2.147.483.648 y 2.147.483.649: ");
				esInt=true;
			}catch (InputMismatchException e) {
				System.out.println("Debe ser un numero entre -2.147.483.648 y 2.147.483.649\n");
				esInt = false;
			}
		}while(esInt == false);*/
		
		/*do {
			try {
				
				numFloat = ex.llegirFloat("Introduce un numero entre -3.402823e38 y 3.402823e38: ");
				esFloat=true;
			}catch (InputMismatchException e) {
				System.out.println("Debe ser un numero entre -3.402823e38 y 3.402823e38\n");
				esFloat = false;
			}
		}while(esFloat == false);*/
		
		/*do {
			try {
				
				numDouble = ex.llegirFloat("Introduce un numero entre -	-1.79769313486232e308 y 3.402823e38: ");
				esDouble=true;
			}catch (InputMismatchException e) {
				System.out.println("Debe ser un numero entre -	-1.79769313486232e308 y 1.79769313486232e308\n");
				esDouble = false;
			}
		}while(esDouble == false);*/
		
		/*do {
			try {
				
				chr = ex.llegirChar("Introduce una letra: ");
				esChar=true;
			}catch (Exception e) {
				System.out.println("Debes escribir una caracter\n");
				esChar = false;
			}
		}while(esChar == false);*/
		
	
		//str = ex.llegirString("Introduce un texto: ");
		
		do {
			try {
				
				esChr = ex.llegirSiNo("Introduce una letra [s]i o [n]o: ");
				esBoolean = true;
			}catch (Exception e) {
				System.out.println("Debes escribir 's' o 'n'\n");	
				esBoolean = false;
				
			}
		}while(esBoolean == false);
		
		

	}
	
	

}
