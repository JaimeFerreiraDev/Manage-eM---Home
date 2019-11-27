package pt.iade.ManageeMHome.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Kid extends Person{

	private int points;
	private boolean _1stTime;
	
	ObservableList<Parent> parents = FXCollections.observableArrayList();
	
	public Kid(String name, int age, String code, String username, String password, String email,
			String confirmPassword, int points, boolean _1stTime, ObservableList<Parent> parents) {
		super(name, age, code, username, password, email, confirmPassword);
		this.points = points;
		this._1stTime = _1stTime;
		this.parents = parents;
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
	public ObservableList<Parent> getParents() {
		return parents;
	}

	
}
