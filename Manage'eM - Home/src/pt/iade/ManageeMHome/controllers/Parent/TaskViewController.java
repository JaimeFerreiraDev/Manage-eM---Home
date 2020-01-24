package pt.iade.ManageeMHome.controllers.Parent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
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

/**
 * This class is the controller for the "task tab" that has:
 * <p>
 * <p> a table view {@link #taskTV}, that displays the tasks that the logged parent, returned by the method:
 * <p>{@link pt.iade.ManageeMHome.models.DAO.PersonDAO#getLoggedParent()}
* <p>
 * <p>a "plus button" that opens the "add task window", managed by:
 * <p>{@link pt.iade.ManageeMHome.controllers.AddTaskController.java}
 * <p>
 * <p>a "notifications button" that opens the "notifications window" managed by:
 * <p>{@link pt.iade.ManageeMHome.controllers.NotificationsController.java}
 * <p>
 * <p>buttons to the other tabs: parents, kids and rewards:
 * <p>{@link pt.iade.ManageeMHome.controllers.ParentViewController.java}
 * <p>{@link pt.iade.ManageeMHome.controllers.KidViewController.java}
 * <p>{@link pt.iade.ManageeMHome.controllers.RewardViewController.java}
 * <p>
 * <p>The "task tab" is in this fxml file: {@link pt.iade.ManageeMHome.views#taskView.fxml}.
 * @author jaime
 *
 */
public class TaskViewController implements ITab{

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
		ITab.onKidButtonClicked();
	}
	
	@FXML
	public void onTaskButtonClicked() {
		
	}
	// Outras tabs

	@FXML
	public void onParentButtonClicked() {
		ITab.onParentButtonClicked();
	}
	// Outras tabs

	@FXML
	public void onRewardButtonClicked() {
		ITab.onRewardButtonClicked();
	}
	@FXML
	public void notificationClick() {
		ITab.notificationClick();
	}
	// Botão de adicionar
	@Override
	@FXML
	public void onPlusButtonClicked() {
		Main.openPlus(this, add_taskView, new AddTaskController());
		System.out.println("PLUS CLICKED");
	}
	
	



	int parent = 0;



	@FXML
	private void initialize() {
		
		parent = PersonDAO.getLoggedParent().getId();
		updateTableInfo();
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
	

	}
	@Override
	public void updateTableInfo() {
		taskTV.setItems(TaskDAO.getTasksBD(parent));
	}

}
