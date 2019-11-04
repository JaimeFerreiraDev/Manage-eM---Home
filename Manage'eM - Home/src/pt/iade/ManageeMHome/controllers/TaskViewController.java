package pt.iade.ManageeMHome.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;
import pt.iade.ManageeMHome.models.task.Task;

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
		Main.changeTab("views/kidView.fxml");
		System.out.println("KIDS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onParentButtonClicked() {
		Main.changeTab("views/ParentView.fxml");
		System.out.println("PARENTS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onRewardButtonClicked() {
		Main.changeTab("views/rewardView.fxml");
		System.out.println("REWARDS CLICKED");
	}
	// Botão de adicionar
	public void onPlusTaskButtonClicked() {
		Main.openPlus("views/addTaskView.fxml");
		System.out.println("PLUS CLICKED");
	}







	@FXML
	private void initialize() {

		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Task>("Name"));
		pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Task>("Points"));
		System.out.println("HERE");
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


//		taskTV.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//			if (newSelection != null) {
//				Task(newSelection);
//			}
//		});

		
		
		

		FXCollections.observableArrayList();
		taskTV.setItems(TaskDAO.getTaskList());
	}
}
