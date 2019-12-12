package pt.iade.ManageeMHome.models;

import java.util.ArrayList;

import javafx.collections.ObservableList;


public class Task {
	private String name;
	private int points;
	private String details;
	private boolean isComplete;
<<<<<<< HEAD
	public Task( String name,int points, String details,  boolean isComplete) {
=======
	private Kid kid;

	public Task( String name,int points, String details, //ObservableList<Kid> kidOArrayList,
			boolean isComplete/*, String username, String password*/) {
	//	Task.kidOArrayList=kidOArrayList;
>>>>>>> a54b48a2815c5554f7cef9118600a1b44f8b2fbe
		this.name = name;
		this.points=points;
		this.details=details;
		this.isComplete=isComplete;
	}
	public Task( String name,int points, String details, 
			boolean isComplete, Kid kid) {
		this(name, points, details, isComplete);
		this.kid= kid;
	}
	
	public String getName() {
		return name;
	}
	public int getPoints() {
		return points;
	}
	public String getDetails() {
		return details;
	}
<<<<<<< HEAD
=======

>>>>>>> a54b48a2815c5554f7cef9118600a1b44f8b2fbe
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	public String getKidName() {
		return kid.getName();
	}
	
}
