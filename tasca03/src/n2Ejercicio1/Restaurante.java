package n2Ejercicio1;

public class Restaurante {
	
	private String name;
	private int points;
	
	public Restaurante(String name, int points) {
		this.name = name;
		this.points = points;
	}
	
	public boolean equalRestaurante(Restaurante r) {
		boolean restauranteEqual = false;
		
		if(equalsName(r) && equalsPoints(r)) {
			restauranteEqual = true;
		}
		
		return restauranteEqual;
	}
	
	public boolean equalsName(Restaurante r) {
		boolean nameEqual = false;
		
		if(this.name.equalsIgnoreCase(r.getName())) {
			nameEqual = true;
		}
		
		return nameEqual;
	}
	
	public boolean equalsPoints(Restaurante r) {
		boolean pointEqual = false;
		
		if(this.points == r.getPoints()) {
			pointEqual = true;
		}
		
		return pointEqual;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
	
	
}
