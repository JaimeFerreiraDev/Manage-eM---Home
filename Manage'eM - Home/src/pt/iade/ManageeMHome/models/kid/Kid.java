package pt.iade.ManageeMHome.models.kid;

public class Kid {
	private int age;
	private String name;
	private String ID;
	public Kid(String name, int age, String ID) {
		this.age = age;
		this.name = name;
		this.ID = ID;
		
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getID() {
		return ID;
	}

	@Override
	public String toString() {
		return "("+age+")";
	}
	
}
