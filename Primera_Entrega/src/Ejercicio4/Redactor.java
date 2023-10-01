package Ejercicio4;
import java.util.ArrayList;

public class Redactor {
	
	private final String nombre;
	private final String DNI;
	private static int salario = 1500;
	private ArrayList<Noticias> noticiasAsignadas = new ArrayList<Noticias>();

	public Redactor(String nombre, String DNI) {
		/*La redacció pot tenir més d’un redactor/a, i de cadascun d’ells volem saber el seu nom, el DNI i el sou. 
		Un cop assignat un DNI, aquest no podrà canviar mai. Tots els redactors/es tenen el mateix sou, i si en un futur 
		l’empresa pot incrementar-lo, ho farà a tothom per igual. De moment el sou actual és de 1500 €.*/
		
		this.nombre = nombre;
		this.DNI = DNI;
		
	}
	
	public int aumentarSalario(int incrementoSalario) {
		
		Redactor.salario = Redactor.salario + incrementoSalario;
		
		return Redactor.salario;
		
	}
	public void asignarNoticia(Noticias n) {
		noticiasAsignadas.add(n);
	}
	
	public ArrayList<Noticias> getNoticias(){
		return noticiasAsignadas;
	}

	public String getNombre() {
		return nombre;
	}

	public static int getSalario() {
		return salario;
	}

	public String getDNI() {
		return DNI;
	}

}
