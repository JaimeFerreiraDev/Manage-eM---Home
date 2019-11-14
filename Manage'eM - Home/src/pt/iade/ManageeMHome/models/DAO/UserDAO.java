package pt.iade.ManageeMHome.models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.parent.Parent;
import pt.iade.ManageeMHome.models.users.User;

public class UserDAO {
	public static ObservableList<User> userList = FXCollections.observableArrayList();
	public static ObservableList<User> getUserList() {
		return userList;
	}

	static {
	}
}
