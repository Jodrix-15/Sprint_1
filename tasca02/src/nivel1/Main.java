package nivel1;

public class Main {
	
	public static void main(String[] args) {
		
		Producte p = new Producte("PS5", 549.99f);
		Producte p2 = new Producte("Switch-2", 349.99f);
		Venda v = new Venda();
		Venda v2 = new Venda();
		float preuTotal;
		float preuTotal2;
		
		v2.afegirProducte(p);
		v2.afegirProducte(p2);
		
		try {
			
			preuTotal = v.calcularTotal();
			
			System.out.println("El preu total de la venda 1 es de: " + preuTotal);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {

			preuTotal2 = v2.calcularTotal();
			System.out.println("\nEl preu total de la venda 2 es de: " + preuTotal2);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			v.getProductes().get(2);
		}catch (IndexOutOfBoundsException e) {
			System.out.println("Primer Has d'afegir productes");
		}
		


	}

}
