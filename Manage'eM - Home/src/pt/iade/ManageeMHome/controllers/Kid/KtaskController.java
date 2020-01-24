package pt.iade.ManageeMHome.controllers.Kid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.controllers.Parent.AddTaskController;
import pt.iade.ManageeMHome.controllers.Parent.KidViewController;
import pt.iade.ManageeMHome.controllers.Parent.NotificationsController;
import pt.iade.ManageeMHome.controllers.Parent.ParentViewController;
import pt.iade.ManageeMHome.controllers.Parent.RewardViewController;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;

/**
This class is a controller to the "kid tasks window".
 * <p>The "kid tasks window" is in this fxml file: {@link pt.iade.ManageeMHome.kidPOV.kviews#kktaskView.fxml}.
 * <p> This class displays all the currently available tasks to complete in a table view: #taskTV.
 * @author jaime
 *
 */
public class KtaskController {
	@FXML
	private void rewardsClick() {
		Main.changeTab("views/Kid/krewardView.fxml", new KrewardController());
	}
	@FXML
	private TableView<Task> taskTV;
	private ObservableList<Task> tasks = FXCollections.observableArrayList();
	@FXML
	private TableColumn<String, Task> nameColumn;

	@FXML
	private TableColumn<Integer, Task> pointsColumn;

	@FXML
	private TableColumn<Boolean, Task> statusColumn;
	
	@FXML
	private Label pointsLabel;


	private int kid = 0;
	// Outras tabs
	

	@FXML
	private void initialize() {
		pointsLabel.setText(""+KidDAO.checkPoints());  
		kid =    PersonDAO.getLoggedKid().getId();
		updateKidPOVTask();
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
							try {

                                taskTV.getSelectionModel().select(getTableRow().getIndex());
                                String nome = taskTV.getSelectionModel().getSelectedItem().getName();
                                TaskDAO.setTaskCompleted(kid,nome);
                                tasks.remove(taskTV.getSelectionModel().getSelectedItem());
                                updateKidPOVTask();

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						});
						setGraphic(button);
					} else  {
						setGraphic(null);

					}
				}   
			}; 
		});
		
	}
     public void updateKidPOVTask(){
    	 taskTV.setItems(KidDAO.updateKidPOVTaskBD(kid));
	}
	
}
