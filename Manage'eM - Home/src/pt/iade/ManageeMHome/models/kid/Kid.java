package pt.iade.ManageeMHome.models.kid;
import pt.iade.ManageeMHome.Person;

public class Kid extends Person{

	private int points;

	public Kid( String name, int age, String id/*, String username, String password*/) {
		super(name, age ,id/*, username, password*/);
		this.name = name;
		this.age = age;
		this.id=id;

	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getID() {
		return id;
	}

	@Override
	public String toString() {
		return "("+age+")";
	}
	
}
