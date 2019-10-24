package pt.iade.ManageeMHome.models.parent;

import pt.iade.ManageeMHome.Person;

public class Parent extends Person{

	public Parent(int age, String name, String id/*, String username, String password*/) {
		super(age, name, id/*, username, password*/);
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

	@Override
	public String toString() {
		return "("+age+")";
	}
	
}
