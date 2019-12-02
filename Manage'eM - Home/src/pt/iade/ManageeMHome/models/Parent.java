package pt.iade.ManageeMHome.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class Parent extends Person{
	ObservableList<Kid> kids;
	ObservableList<Task> tasks;
	
	public Parent(String name, int age, String code, String username, String password,String confirmPassword, String email,
			 ObservableList<Kid> kids, ObservableList<Task> tasks) {
		super(name, age, code, username, password,confirmPassword, email);
		this.kids = kids;
		this.tasks=tasks;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public ObservableList<Kid> getKids() {
		return kids;
	}
	public ObservableList<Task> getTasks() {
		return tasks;
	}


}
