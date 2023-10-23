package n2Ejercicio1;

import java.util.Objects;

public class Restaurante {
	
	private String name;
	private int points;
	
	public Restaurante(String name, int points) {
		this.name = name;
		this.points = points;
	}


	public String getName() {
		return name;
	}



	@Override
	public int hashCode() {
		return Objects.hash(points);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurante other = (Restaurante) obj;
		return points == other.points;
	}

	public int getPoints() {
		return points;
	}
	
	
}
