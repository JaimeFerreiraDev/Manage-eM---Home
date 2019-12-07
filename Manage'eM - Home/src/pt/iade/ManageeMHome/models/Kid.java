package pt.iade.ManageeMHome.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Kid extends Person{

	private int points;
	private boolean _1stTime;
	
	ObservableList<Parent> parents;
	ObservableList<Task> tasks;
	public Kid(String name, int age, String code, String username, String password, String email,
			String confirmPassword, int points, boolean _1stTime, ObservableList<Parent> parents, ObservableList<Task> tasks) {
		super(name, age, code, username, password, email);
		this.points = points;
		this._1stTime = _1stTime;
		this.parents = parents;
		this.tasks=tasks;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

	public String toString() {
		return name;
	}
	public boolean is_1stTime() {
		return _1stTime;
	}
	
	public void set_1stTime(boolean _1stTime) {
		this._1stTime = _1stTime;
	}
	public ObservableList<Parent> getParents() {
		return parents;
	}
	public ObservableList<Task> getTasks() {
		return tasks;
	}

	
}
