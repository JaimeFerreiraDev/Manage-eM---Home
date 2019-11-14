package pt.iade.ManageeMHome.models.users;

public class User {
	public static String username;
	public String email;
	public static String password;
	public String confirmPassword;
	public static boolean parentBool;
	
	
	public User(  String username, String email, String password, String confirmPassword, boolean parentBool) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.parentBool=parentBool;
	}


	public static String getUsername() {
		return username;
	}


	public static String getPassword() {
		return password;
	}


	public static boolean isParentBool() {
		return parentBool;
	}
	
	
}
