package pt.iade.ManageeMHome.models.kid;

public class Kid {
	private int age;
	private String name;
	public Kid(int age, String name) {
		this.age = age;
		this.name = name;
		
	}
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "("+age+")";
	}
	
}
