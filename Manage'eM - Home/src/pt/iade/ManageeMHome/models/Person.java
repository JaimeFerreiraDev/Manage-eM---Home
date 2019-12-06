package pt.iade.ManageeMHome.models;


public class Person {
	protected String name;
	protected int age;
	protected int id;
	protected String username;
	protected String password;
	protected String email;

	public Person(String name, int age, int id, String username, String password
			) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.username = username;
		this.password = password;
	
		
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id= id;
	}
	

	
	
}
