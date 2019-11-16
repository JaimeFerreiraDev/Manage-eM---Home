package pt.iade.ManageeMHome.models.kid;
import pt.iade.ManageeMHome.Person;

public class Kid extends Person{

	private int points;

	public Kid( String name, int age, int points, String id/*, String username, String password*/) {
		super(name, age ,id/*, username, password*/);
		this.name = name;
		this.age = age;
		this.points=points;
		
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	public String toString() {
		return name;
	}

	
}
