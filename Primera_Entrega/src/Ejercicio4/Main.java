package Ejercicio4;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		/*En una redacció de notícies esportives tenen les notícies classificades per esports: futbol, bàsquet, tenis, F1 i motociclisme.
			
		A la classe principal s’ha de fer un menú amb les següents opcions:

		1.- Introduir redactor/a.		
		2.- Eliminar redactor/a.		
		3.- Introduir notícia a un redactor/a.		
		4.- Eliminar notícia (ha de demanar redactor/a i titular de la notícia).		
		5.- Mostrar totes les notícies per redactor/a.		
		6.- Calcular puntuació de la notícia.		
		7.- Calcular preu-notícia.*/
		
		ArrayList<Redactor> redactores = new ArrayList<Redactor>();	
		
		Redactor r = new Redactor("", "");
		Noticias n = null;
		ArrayList<Noticias> allNews= new ArrayList<Noticias>();
		int opcion;
		int pos;
		String dni;
		
		
		do {
			menu();
			do {
				try {
					opcion = getInt("\nQue opcion escoges?: ");
					if(opcion < 0 || opcion > 7) {
						System.out.println("Debe ser un valor entre [0] y [7]");
					}
					
				}catch (InputMismatchException e) {
					System.out.println("Debe ser un valor entre [0] y [7]");
					opcion = -1;
				}
				
			}while(opcion<0 || opcion>7);
			
			switch (opcion) {
			case 1:
				crearRedactor(redactores);
				break;
			case 2:
				mostrarRedactores(redactores);
				eliminarRedactor(redactores);
				break;
			case 3: 
				if (redactores.size() > 0) {
					asignarNoticia_Redactor(n, redactores, allNews);
				}else System.out.println("Primero debes aniadir un redactor");
				
				break;
			case 4:
				mostrarRedactores(redactores);
				if(redactores.size()>0 && allNews.size() > 0) {
					System.out.println("A que redactores le quieres eliminar una noticia?: ");
					dni = obtenerDni();
					pos = buscarRedactor(dni, redactores);
					if (pos>-1) {
						if(redactores.get(pos).getNoticias().size()>0) {
							mostrarAllNews(allNews);
							String titular = getString("Introduce el titular de la noticia que desea eliminar: ");
							if(buscarTitular(titular, redactores.get(pos)) > -1){
								eliminarNoticia(titular, redactores.get(pos));
								System.out.println("Noticia eliminada");
								
							}else System.out.println("Titular no encontrado");
							
							
						}else System.out.println("El redactor con DNI: " + dni + " no tiene asignada ninguna noticia");
						
						
					}else System.out.println("Redactor no encontrado");
					
				}else System.out.println("Debes aniador primero un redactor y/o una noticia");
				
				break;
			case 5:
				mostrarRedactores(redactores);
				if(redactores.size() > 0 && allNews.size() > 0) {
					System.out.println("Introduce el DNI del redactor cuyas noticias asignadas quieres ver");
					dni = obtenerDni();
					pos = buscarRedactor(dni, redactores);
					if (pos>-1) {
						if(redactores.get(pos).getNoticias().size()>0) {
							mostrarNoticiasDelRedactor(redactores.get(pos));
						}else System.out.println("El redactor con DNI: " + dni + " no tiene asignada ninguna noticia");
			
					}else System.out.println("Redactor no encontrado");
						
				}else System.out.println("Debes aniador primero un redactor y/o una noticia");
				
				break;
			case 6:
				if(allNews.size() > 0) {
					calcularPuntuacion(allNews);
					
				}else System.out.println("No se ha introducido ninguna noticia todavia");
				
				break;
			case 7:
				if(allNews.size() > 0) {
					calcularPrecio(allNews);
					
				}else System.out.println("No se ha introducido ninguna noticia todavia");
				break;
			}
				
		}while(opcion != 0);
	
	}
	public static void menu() {
		System.out.println("\nDe las siguientes opciones: \n"
				+ "\n[1]. Introducir redactor"
				+ "\n[2]. Eliminar redactor"
				+ "\n[3]. Asignar noticia a un redactor"
				+ "\n[4]. Eliminar noticia"
				+ "\n[5]. Mostrar noticias por redactor"
				+ "\n[6]. Calcular puntuacion de la noticia"
				+ "\n[7]. Calcular precio-noticia");
		
	}
	
	public static void mostrarAllNews(ArrayList<Noticias> allNews) {
		
		int id = 0;
		
		for(Noticias n: allNews) {
			System.out.println("[" + id + "]. " + n.titular);
			id++;
		}
	}
	
	public static int buscarRedactor(String Dni, ArrayList<Redactor> redactores) {
	
		int pos = -1;
		int i = 0;
		
		for (Redactor r: redactores) {
			if(r.getDNI().equalsIgnoreCase(Dni)) {
				pos = i;
			}
			i++;	
		}
		
		return pos;
		
	}
	
	public static void introducirRedactor(Redactor r, ArrayList<Redactor> redactores) {
		
		redactores.add(r);	
	}
	
	public static void crearRedactor(ArrayList<Redactor> redactores) {
		
		
		String dni = obtenerDni();
		
		Redactor redactor = new Redactor(getString("\nNombre del redactor: "), dni);
		int existeRedactor = buscarRedactor(redactor.getDNI(), redactores);
		
		if (existeRedactor == -1) {
			introducirRedactor(redactor, redactores);
			System.out.println("\nEl redactor " + redactor.getNombre() + " se ha aniadido a la base de datos\n");
			
		}else System.out.println("\nEl redactor " + redactor.getNombre() + " ya se encuentra en la base de datos\n");
			
	}
	
	public static String obtenerDni() {
		
		int dniDigitos = 0;
		String dniLetra = "";
		String dni = "";
		boolean esNumCorrecto = false;
		boolean esLetraCorrecta = false;
		
		do {
			do {
				try {
					dniDigitos = getInt("\nEscribe los 8 digitos del DNI: ");
					if(Integer.toString(dniDigitos).length() == 8) {
						esNumCorrecto = true;
					}else {
						System.out.println("8 digitos numericos");
					}
					
				} catch(InputMismatchException e) {
					System.out.println("Debe contener 8 digitos numericos");
					esNumCorrecto = false;
				}
			}while(esNumCorrecto==false);
			
			do {
				try {
					dniLetra = getString("\nIntroduce la letra del DNI: ").toUpperCase();
					if(dniLetra.length() > 1) {
						System.out.println("Debe contener solo UNA letra");
					}else {
						esLetraCorrecta = true;
					}
					
				}catch (InputMismatchException e) {
					System.out.println("Debe contener solo UNA letra");
					esLetraCorrecta = false;
				}
			}while(esLetraCorrecta == false);
			
	
		}while(Integer.toString(dniDigitos).length() != 8 || dniLetra.length() != 1);
		
		dni = Integer.toString(dniDigitos) + dniLetra;
		
		return dni;
		
	}
	
	public static void eliminarRedactor(ArrayList<Redactor> redactores) {
		
		System.out.println("\nIntroduce el DNI del redactor que quieres eliminar");
		String dni = obtenerDni();
		int index = buscarRedactor(dni, redactores);
		
		if(index != -1) {
			System.out.println("El redactor " + redactores.get(index).getNombre() + " ha sido eliminado\n");
			redactores.remove(index);
			
		}else System.out.println("El redactor no se encuentra en la base de datos\n");
	}
	public static Noticias crearNoticia(Noticias n, ArrayList<Noticias> allNews) {
		//cada redactor puede trabajar en más de una noticia
		
		String opcion;
		
		do {
			
			opcion = getString("Ingresa a que categoria pertenece la noticia: [F]utbol, [B]asquet, [T]enis, [M]otociclismo o F[1]: ").toUpperCase();
		
		}while(!opcion.equalsIgnoreCase("F") && !opcion.equalsIgnoreCase("B") && !opcion.equalsIgnoreCase("T") && !opcion.equalsIgnoreCase("M") && !opcion.equalsIgnoreCase("1"));
		
		
		switch(opcion) {
		case "F":
			n = new Futbol(getString("Introduce el titular de la noticia: "), getString("Introduce la competicion: "), getString("Introduce el club: "), getString("Introduce el jugador: "));
			
			break;
		case "B":
			n = new Basquet(getString("Introduce el titular de la noticia: "), getString("Introduce la competicion: "), getString("Introduce el club: "));
			
			break;
		case "T":
			n = new Tenis(getString("Introduce el titular de la noticia: "), getString("Introduce la competicion: "), getString("Introduce el tenista: "));
			
			break;
		case "M": 
			n = new Motociclismo(getString("Introduce el titular de la noticia: "), getString("Introduce el equipo: "));
			
			break;
		case "1":
			n = new F1(getString("Introduce el titular de la noticia: "), getString("Introduce la escuderia: "));
		
			break;

		}
		
		allNews.add(n);
		
		return n;
		
	}

	public static void asignarNoticia_Redactor(Noticias n, ArrayList<Redactor> redactores, ArrayList<Noticias> allNews) {
		
		
		Noticias asignNoticia = crearNoticia(n, allNews);
		String dni = "";
		int posRedactor;
		mostrarRedactores(redactores);
		
		System.out.println("\nA que redactor quieres asignar la noticia con el titular: " +  asignNoticia.titular);
		dni = obtenerDni();
		posRedactor = buscarRedactor(dni, redactores);
		
		if(posRedactor>-1) {
			redactores.get(posRedactor).asignarNoticia(asignNoticia);
			System.out.println("Noticia asignada al redactor " + redactores.get(posRedactor) + " con DNI: " + dni);
		}else System.out.println("Redactor no encontrado en la base de datos");

	}
	public static int buscarTitular(String titular, Redactor r) {
		
		int existeTitular = -1;
		int index = 0;
		
		do {
			if(titular.equalsIgnoreCase(r.getNoticias().get(index).titular)) {
				
				existeTitular = index;
			}
			index++;
			
			
		}while(existeTitular == -1 && index < r.getNoticias().size());
		
		return existeTitular;
	}
	
	public static void eliminarNoticia(String titular, Redactor r) {
		
		int posTitular = buscarTitular(titular, r);
		
		if(posTitular > -1) {
			r.getNoticias().remove(posTitular);
			
		}else System.out.println("Titular no encontrado");
		
		
	}
	
	public static void mostrarRedactores(ArrayList<Redactor> redactores) {
		
		for (Redactor r: redactores) {
			System.out.println("\n" + r.getNombre() + " con DNI: "+ r.getDNI() + "\tNoticias asignadas: " + r.getNoticias().size());
		}
		
	}
	
	public static void mostrarNoticiasDelRedactor(Redactor r) {
		
		int pos = 0;
		int opcion = 0;
		String dni = "";
		
		System.out.println("\nEl redactor " + r.getNombre() + " tiene los siguientes titulares: ");
		for (Noticias n: r.getNoticias()) {
			System.out.println(String.format("[%d]. Titular: %s", pos, n.titular));
			pos++;
		}

	}

	
	public static void calcularPuntuacion(ArrayList<Noticias> noticia) {
		
		int puntuacion;
		
		for(Noticias n : noticia) {
			puntuacion = n.calcularPuntuacion();
			System.out.println(n.titular + ", tiene una puntuacion de " + puntuacion);
		}
		
	}
	
	public static void calcularPrecio(ArrayList<Noticias> noticia) {
		
		int precio;
		
		for(Noticias n : noticia) {
			precio = n.calcularPrecio();
			System.out.println(n.titular + ", tiene una puntuacion de " + precio);
		}
	
	}
	
	public static Scanner input() {
		Scanner sc = new Scanner(System.in);
		return sc;
	}
	
	public static int getInt(String mensaje) {
		System.out.print(mensaje);
		return input().nextInt();
	}
	
	public static String getString(String mensaje) {
		System.out.print(mensaje);
		return input().nextLine();
	}
	

}
