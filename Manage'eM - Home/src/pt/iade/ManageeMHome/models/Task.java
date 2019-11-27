package pt.iade.ManageeMHome.models;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Task {
	private String name;
	private int points;
	private String details;
	private boolean isComplete;
	private static ObservableList<Kid> kidOArrayList = FXCollections.observableArrayList();
	public Task( String name,int points, String details, ObservableList<Kid> kidOArrayList, boolean isComplete/*, String username, String password*/) {
		this.kidOArrayList=kidOArrayList;
		this.name = name;
		this.points=points;
		this.details=details;
		this.isComplete=isComplete;
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
	public static ObservableList<Kid> getKidArrayList() {
		return kidOArrayList;
	}
	
}
