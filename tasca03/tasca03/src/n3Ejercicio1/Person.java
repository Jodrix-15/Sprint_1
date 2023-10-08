package n3Ejercicio1;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparator<Person>{
	

	private String name;
	private String lastName;
	private String id;
	
	public Person(String name, String lastName, String id) {
		
		this.name = name;
		this.lastName = lastName;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public int compare(Person p1, Person p2) {
		// TODO Auto-generated method stub
		
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
	


	
	
	

}
