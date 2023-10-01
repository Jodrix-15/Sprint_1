package Ejercicio4;
import java.util.ArrayList;

abstract public class Noticias {
	
	protected String titular;
	protected String txt;
	protected int puntuacion;
	protected int precio;
	//private ArrayList<Noticias> allNews= new ArrayList<Noticias>();

	public Noticias(String titular) {
		/* Cada redactor/a pot treballar en més d’una notícia. Les notícies han de tenir un titular, un text, una puntuació 
		i un preu. En el moment de crear-se, el text ha d’estar buit.
		Les notícies es venen a diferents mitjans. Per saber el preu de cada notícia hem d'implementar un mètode que es diu 
		calcularPreuNoticia().*/
		
		this.titular = titular;
		this.txt = "";
	
	}
	/*public void aniadirNoticia(Noticias n) {
		allNews.add(n);
	}
	public void mostrarNoticias (Noticias n) {
		
		for (Noticias noticia : n.allNews) {
			System.out.println(noticia.titular);
			
		}
	}*/
	
	
	abstract public int calcularPrecio();
	abstract public int calcularPuntuacion();
	
	

}
