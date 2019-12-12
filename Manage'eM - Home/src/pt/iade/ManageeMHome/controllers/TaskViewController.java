package pt.iade.ManageeMHome.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
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
	
	int parent = 0;

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
		Main.openPlus(null, this, null, null, "views/addTaskView.fxml", new AddTaskController());
		System.out.println("PLUS CLICKED");
	}
	@FXML
	private void notificationClick() {
		Main.openNotifications("views/notificationsView.fxml", new NotificationsController());
	}







	@FXML
	private void initialize() {
		
		updateTaskInfo();
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
//			taskTV.setOnMouseClicked(
//					(event)-> {
//						System.out.println("cliquei na TV");
//						Task task = taskTV.getSelectionModel().getSelectedItem();
//						taskTV.getSelectionModel().clearSelection();
//					//	if (task != null)
//					//	Main.openTableItem(this, "views/kidTableItemView.fxml", new KidTableItemController(kid));
//						}
//					);
		});
		FXCollections.observableArrayList();

	}
	public void updateTaskInfo() {
		String sql ="Select * from Parents_Task, Task where parent = ? and id_Task = task;";
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			parent = PersonDAO.getLoggedParent().getId();
			stat.setInt(1, parent);
			System.out.println(stat);
			ResultSet rs = stat.executeQuery();	
			ObservableList<Task> tasks = FXCollections.observableArrayList();
			while(rs.next()) {
				tasks.add(new Task(rs.getString("name"),
						rs.getInt("pts_Task"), 
						rs.getString("description"),
						false)
						);
			}
			taskTV.setItems(tasks);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
