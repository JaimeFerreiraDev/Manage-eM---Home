package pt.iade.ManageeMHome.models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.parent.Parent;

public class ParentDAO {
	private static ObservableList<Parent> parentList = FXCollections.observableArrayList();

	public static ObservableList<Parent> getParentList() {
		return parentList;
	}

	static {
	}
}
