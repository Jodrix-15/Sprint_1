package nivel1;
import java.util.ArrayList;

public class Venda {
	
	/*classe anomenada "Venda". Aquesta classe té com a atributs
		 *   una col·lecció de productes i el preu total de la venda.
			La classe "Venda", té un mètode anomenat calcularTotal() que llança 
			l’excepció personalitzada VendaBuidaException i mostra per pantalla 
			“Per fer una venda primer has d’afegir productes” si la col·lecció de
			 productes està buida. Si la col·lecció té productes, llavors ha de 
			 recórrer la col·lecció i guardar la suma de tots els preus dels productes
			  a l’atribut preu total de la venda.*/
	
	private ArrayList<Producte> productes;
	private float preuTotal;
	
	public Venda() {
		this.productes = new ArrayList<Producte>();
	}
	
	public float calcularTotal() throws VendaBuidaException{
		
		if (this.productes.size() == 0) {
			
			throw new VendaBuidaException("Per fer una venda primer has d'afegir productes");
			
		}else {
			
			for (int i = 0; i<productes.size(); i++) {
				this.preuTotal += productes.get(i).getPreu();
			}

		}
		return this.preuTotal;
		
	}
	
	public void afegirProducte(Producte p) {
		productes.add(p);
	}

	public ArrayList<Producte> getProductes() {
		return productes;
	}

}
