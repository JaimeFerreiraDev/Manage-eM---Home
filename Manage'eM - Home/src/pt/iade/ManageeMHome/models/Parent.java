package pt.iade.ManageeMHome.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class Parent extends Person{

	

	public Parent(String name, int age, int id //,String username/* ,String password,*/
//			, ObservableList<Kid> kids, ObservableList<Task> tasks
			 ) {
		super(name, age, id/*, username/* password*/);


	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}

}
