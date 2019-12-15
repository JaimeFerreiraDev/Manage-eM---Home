package pt.iade.ManageeMHome.models.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.controllers.NewAccController;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.Person;
import pt.iade.ManageeMHome.models.Task;
/**
 * This class is currently being only used to set and get the currently logged parent or kid
 * @author jaime
 *
 */
public class PersonDAO {
	public static ObservableList<Person> personList = FXCollections.observableArrayList();
	private static Parent loggedParent;
	private static Kid loggedKid;
	public static ObservableList<Person> getPersonList() {
		return personList;
	}
	
	public static ObservableList<Kid> getKids(int id){
		String sql = "SELECT * FROM kids WHERE";
		return null;
	}
	
	public static ObservableList<Kid> getKidList() {

		ObservableList<Kid> kids = FXCollections.observableArrayList();
		for (Person person : personList) {
			if (person instanceof Kid) {
				kids.add((Kid) person);
			}

		}
		return kids;
	}
	
	public static Parent getLoggedParent() {
		return loggedParent;
	}

	public static void setLoggedParent(Parent loggedParent) {
		PersonDAO.loggedParent = loggedParent;
	}
	

	public static Kid getLoggedKid() {
		return loggedKid;
	}

	public static void setLoggedKid(Kid loggedKid) {
		PersonDAO.loggedKid = loggedKid;
	}

	static ObservableList<Task> tasks= FXCollections.observableArrayList();
	void initialize() {
		
	}}
