package nivel3;

public class Butaca {
	
	private int numFila;
	private int numAsiento;
	private String nombrePersona;
	
	public Butaca() {}
	
	public Butaca(int nombre, int asiento, String nombrePersona) {
		
		this.numFila = nombre;
		this.numAsiento = asiento;
		this.nombrePersona = nombrePersona;
		
	}
	
	public boolean equals(int fila, int butaca) {
		/*Equals: retornarà que dues butaques són iguales si la fila i el seient són iguals.*/
		
		boolean sonIguales = false;
		
		if(this.numFila == fila && this.numAsiento == butaca) {
			sonIguales = true;
		}
		
		return sonIguales;
		
	}
	
	public String toString() {
		/*toString: retornarà un String amb el següent format: “Fila: 5, Seient: 20, Persona: Maria Febrer”*/
		
		return String.format("Fila: %d, Asiento: %d, Persona: %s", this.numFila, this.numAsiento, this.nombrePersona);
		
	}

	public int getNumFila() {
		return this.numFila;
	}


	public int getNumAsiento() {
		return this.numAsiento;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	
	
	
	
	
}
