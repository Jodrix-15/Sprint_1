package nivel1;

public class Producte{
	/*Crea una classe anomenada "Producte" amb els atributs nom i preu*/
	
	private String nom;
	private float preu;
	
	public Producte(String nom, float preu) {
		this.nom = nom;
		this.preu = preu;
	}


	public String getNom() {
		return nom;
	}

	public float getPreu() {
		return preu;
	}

}