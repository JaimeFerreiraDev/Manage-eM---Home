package pt.iade.ManageeMHome.models.notification;

public class Notification {
	public Notification( String name,int age, String id/*, String username, String password*/) {


		this.name = name;
		this.age=age;
		this.id=id;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}

}
