package pt.iade.ManageeMHome.kidPOV.kcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.controllers.AddTaskController;
import pt.iade.ManageeMHome.controllers.KidViewController;
import pt.iade.ManageeMHome.controllers.NotificationsController;
import pt.iade.ManageeMHome.controllers.ParentViewController;
import pt.iade.ManageeMHome.controllers.RewardViewController;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;


public class KtaskController {
	@FXML
	private void rewardsClick() {
		Main.changeTab("kidPOV/kviews/krewardView.fxml", new KrewardController());
	}
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
		
		taskTV.setItems(PersonDAO.getLoggedKid().getTasks());//QUERO A LISTA DE TASKS DO KIL LOGGADO
	}
}
