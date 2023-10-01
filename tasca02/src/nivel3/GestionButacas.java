package nivel3;
import java.util.ArrayList;

public class GestionButacas {
	/*Classe GestioButaques
			
			Contindrà un ArrayList de butaques i els mètodes necessaris per afegir, 
			eliminar i cercar les butaques a l’ArrayList.

			*/
	
	private ArrayList<Butaca> butacas;
	
	public GestionButacas () {
		this.butacas = new ArrayList<Butaca>();
	}
	
	public ArrayList<Butaca> getButacas() {
		/*Retornarà l’atribut butaques.*/
		
		return this.butacas;
		
	}
	
	public void aniadirButacas(Butaca b) throws ExcepcionButacaOcupada{
		/*serà l’encarregat d’afegir una butaca al vector de butaques. 
		Rebrà com a paràmetre un objecte de la classe Butaca i l’afegirà a l’ArrayList. 
		Si la fila i el seient de la butaca rebuda com a paràmetre coincideixen amb el d’una 
		butaca que ja es trobi a l’ArrayList (s’utilitzarà el mètode cercarButaca), es llençarà 
		l’excepció personalitzada ExcepcioButacaOcupada.*/
		
		if(buscarButaca(b.getNumFila(), b.getNumAsiento()) != -1) {
			throw new ExcepcionButacaOcupada("La butaca ingresada ya esta reservada");
			
		}else this.butacas.add(b); System.out.println("Butaca aniadida");

	}
	
	public void eliminarButaca(Butaca b) throws ExcepcionButacaLibre {
		/*serà l’encarregat d’eliminar una butaca de l’ArrayList de butaques. 
		Rebrà com a paràmetres el número de fila i el seient i l’eliminarà de l’ArrayList. Si la 
		fila i el seient no coincideixen amb el d’una butaca reservada (s’utilitzarà el mètode cercarButaca), 
		llençarà una excepció personalitzada ExcepcioButacaLliure.*/
		
		int posButaca = buscarButaca(b.getNumFila(), b.getNumAsiento());
		if (posButaca == -1) {
			throw new ExcepcionButacaLibre("La butaca ingresada esta libre, por favor ingresa una butaca que este reservada");
			
		}else {
			this.butacas.remove(posButaca);
			System.out.println("Butaca eliminada");
		}
		
		
	}
	
	public int buscarButaca(int fila, int butaca) {
		/*Cerca a l’ArrayList de butaques, la butaca que coincideixi amb les 
		dades rebudes com a paràmetre (fila i seient). Si la troba retornarà la posició de la 
		butaca a l’ArrayList i si no la troba retornarà -1.*/
		
		int butacaEncontrada = -1;
		int index = 0;
		
		while (butacaEncontrada == -1 && index < this.butacas.size()) {
			if(this.butacas.get(index).equals(fila, butaca)) {
				butacaEncontrada = index;
			}
			index +=1;
		}
		
		return butacaEncontrada;
			
	}

}
