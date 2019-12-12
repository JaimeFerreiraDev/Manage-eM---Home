package pt.iade.ManageeMHome.models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.Task;

public class TaskDAO {
	public static ObservableList<Task> taskList = FXCollections.observableArrayList();
	
	public static ObservableList<Task> getTaskList() {
		return taskList;
	}
<<<<<<< HEAD
=======


>>>>>>> a54b48a2815c5554f7cef9118600a1b44f8b2fbe
}
