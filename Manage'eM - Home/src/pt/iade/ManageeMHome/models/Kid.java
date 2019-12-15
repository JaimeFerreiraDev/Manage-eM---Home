package pt.iade.ManageeMHome.models;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class is what we use to represent kids.
 * @author jaime
 *
 */
public class Kid extends Person{

	private int points;
	private boolean _1stTime;

	
	public Kid(String name, int age,int id, 
			 int points, boolean _1stTime
			 ) {
		super(name, age,id);
		this.points = points;
		this._1stTime = _1stTime;

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


}
