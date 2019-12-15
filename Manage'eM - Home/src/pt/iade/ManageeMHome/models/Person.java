package pt.iade.ManageeMHome.models;

/**
 * This class is what we use to represent kids.
 * @author jaime
 *
 */
public abstract class Person {
	protected String name;
	protected int age;
	protected int id;
	protected String username;
//	protected String password;
	protected String email;

	protected String confirmPassword;
	public Person(String name, int age, int id//, String username /*String password*/
			) {

		super();
		this.name = name;
		this.age = age;
		this.id = id;

//		this.username = username;
//		this.password = password;
	
		
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
//	public String getPassword() {
//		return password;
//	}
	public void setId(int id) {
		this.id= id;
	}
	

	
	
}
