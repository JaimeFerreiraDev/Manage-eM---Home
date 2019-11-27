package pt.iade.ManageeMHome.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class Parent extends Person{
	ObservableList<Kid> kids = FXCollections.observableArrayList();
	
	public Parent(String name, int age, String code, String username, String password, String email,
			String confirmPassword, ObservableList<Kid> kids) {
		super(name, age, code, username, password, email, confirmPassword);
		this.kids = kids;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}


}
