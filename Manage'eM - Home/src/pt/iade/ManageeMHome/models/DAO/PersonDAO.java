package pt.iade.ManageeMHome.models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.Person;

public class PersonDAO {
	public static ObservableList<Person> personList = FXCollections.observableArrayList();
	public static Person loggedPerson;
	public static ObservableList<Person> getPersonList() {
		return personList;
	}

	public static ObservableList<Parent> getParentList() {

		ObservableList<Parent> parents = FXCollections.observableArrayList();
		for (Person person : personList) {
			if (person instanceof Parent) {
				parents.add((Parent) person);
			}

		}
		return parents;
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
	
	public static Person getLoggedPerson() {
		return loggedPerson;
	}

	public static void setLoggedPerson(Person loggedPerson) {
		PersonDAO.loggedPerson = loggedPerson;
	}

	static {
	}
}
