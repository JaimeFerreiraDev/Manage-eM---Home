package pt.iade.ManageeMHome.models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.parent.Parent;
import pt.iade.ManageeMHome.models.task.Task;

public class TaskDAO {
	private static ObservableList<Task> taskList = FXCollections.observableArrayList();

	public static ObservableList<Task> getTaskList() {
		return taskList;
	}

	static {
	}
}
