package pt.iade.ManageeMHome.models;

import java.util.ArrayList;

import javafx.collections.ObservableList;

/**
 * This class is what we use to represent tasks.
 * @author jaime
 *
 */
public class Task {
	private int id;
	private String name;
	private int points;
	private String details;
	private boolean isComplete;
	private Kid kid;
	public Task( String name,int points,int id, String details,
			boolean isComplete) {
		this.name = name;
		this.points=points;
		this.id=id;
		this.details=details;
		this.isComplete=isComplete;
	}
	public Task( String name,int points,int id, String details, 
			boolean isComplete, Kid kid) {
		this(name, points,id, details, isComplete);
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
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	public String getKidName() {
		return kid.getName();
	}
	public Kid getKid() {
		return kid;
	}
	public int getId() {
		return id;
	}
	
	
}
