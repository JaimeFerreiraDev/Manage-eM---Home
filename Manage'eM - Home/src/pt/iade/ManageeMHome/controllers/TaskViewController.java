package pt.iade.ManageeMHome.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;


public class TaskViewController {

	@FXML
	private TableView<Task> taskTV;

	@FXML
	private TableColumn<String, Task> nameColumn;

	@FXML
	private TableColumn<Integer, Task> pointsColumn;

	@FXML
	private TableColumn<Boolean, Task> statusColumn;

	// Outras tabs
	@FXML
	public void onKidButtonClicked() {
		Main.changeTab("views/kidView.fxml", new KidViewController());
		System.out.println("KIDS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onParentButtonClicked() {
		Main.changeTab("views/ParentView.fxml", new ParentViewController());
		System.out.println("PARENTS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onRewardButtonClicked() {
		Main.changeTab("views/rewardView.fxml", new RewardViewController());
		System.out.println("REWARDS CLICKED");
	}
	// Botão de adicionar
	@FXML
	public void onPlusTaskButtonClicked() {
		Main.openPlus("views/addTaskView.fxml", new AddTaskController());
		System.out.println("PLUS CLICKED");
	}
	@FXML
	private void notificationClick() {
		Main.openNotifications("views/notificationsView.fxml", new NotificationsController());
	}







	@FXML
	private void initialize() {

		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Task>("Name"));
		pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Task>("Points"));
		statusColumn.setCellFactory((tableCol)-> {
			return new TableCell<Boolean, Task> ()  {
				@Override
				protected void updateItem(Task task, boolean empty) {
					super.updateItem(task, empty);
					if(!empty){
						Button button = new Button("DONE");
						button.setOnAction((event) -> {

						});
						setGraphic(button);
					} else  {
						setGraphic(null);

					}
				}   
			}; 
		});
		FXCollections.observableArrayList();
		taskTV.setItems(TaskDAO.getTaskList());
	}
}
