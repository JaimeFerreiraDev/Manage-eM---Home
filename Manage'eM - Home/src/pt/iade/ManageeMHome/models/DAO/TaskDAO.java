package pt.iade.ManageeMHome.models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.Task;

public class TaskDAO {
	public static ObservableList<Task> taskList = FXCollections.observableArrayList();
	
	public static ObservableList<Task> getTaskList() {
		return taskList;
	}


}
