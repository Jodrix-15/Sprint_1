package n1Ejercicio1;

import java.util.ArrayList;

public class NoGenericMethods {
	/*/*Crea una classe anomenada NoGenericMethods que emmagatzemi 
		 * tres objectes del mateix tipus, juntament amb els mètodes 
		 * per a emmagatzemar i extreure aquests objectes i un constructor 
		 * per a inicialitzar els tres. Comprova que els arguments es poden 
		 * posar en qualsevol posició en la crida al constructor.
		 */
	
	private ArrayList<String> objList;
	private String obj1;
	private String obj2;
	private String obj3;
	
	public NoGenericMethods(String obj1, String obj2, String obj3) {
		this.objList = new ArrayList<String>();
		this.obj1 = obj1;
		this.obj2 = obj2;
		this.obj3 = obj3;
	}
	
	public void addString(String obj) {
		this.objList.add(obj);
	}
	
	public void removeString(String obj) {
		this.objList.remove(obj);
	}

	public ArrayList<String> getObjList() {
		return objList;
	}

	public String getObj1() {
		return obj1;
	}

	public String getObj2() {
		return obj2;
	}

	public String getObj3() {
		return obj3;
	}
	
	

}
