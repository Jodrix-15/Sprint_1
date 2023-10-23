package n3Ejercicio1;

public class Person {
	

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
}
