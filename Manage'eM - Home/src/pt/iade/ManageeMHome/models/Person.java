package pt.iade.ManageeMHome.models;


public class Person {
	protected String name;
	protected int age;
	protected String code;
	protected String username;
	protected String password;
	protected String email;
	protected String confirmPassword;
	public Person(String name, int age, String code, String username, String password, String email,
			String confirmPassword) {
		super();
		this.name = name;
		this.age = age;
		this.code = code;
		this.username = username;
		this.password = password;
		this.email = email;
		this.confirmPassword = confirmPassword;
	}
	public String getCode() {
		return code;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

	
	
}
