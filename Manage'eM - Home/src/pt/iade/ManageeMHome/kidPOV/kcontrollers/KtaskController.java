package pt.iade.ManageeMHome.kidPOV.kcontrollers;

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
import pt.iade.ManageeMHome.controllers.AddTaskController;
import pt.iade.ManageeMHome.controllers.KidViewController;
import pt.iade.ManageeMHome.controllers.NotificationsController;
import pt.iade.ManageeMHome.controllers.ParentViewController;
import pt.iade.ManageeMHome.controllers.RewardViewController;
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
		Main.changeTab("kidPOV/kviews/krewardView.fxml", new KrewardController());
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


	private int kid = 0;
	// Outras tabs
	

	@FXML
	private void initialize() {
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

								
                                PreparedStatement stmt = JDBC.getCon().prepareStatement(" UPDATE Kids_Task, Task SET completed = true WHERE Kids_Task.kid ="
                                        + "? and Task.id_Task = Kids_Task.Task and Task.name = ?;");
                                stmt.setInt(1,kid);
                                taskTV.getSelectionModel().select(getTableRow().getIndex());
                                String nome = taskTV.getSelectionModel().getSelectedItem().getName();
                                System.out.println(nome);
                                stmt.setString(2, nome);
                                stmt.execute();
                                tasks.remove(taskTV.getSelectionModel().getSelectedItem());
                                taskTV.setItems(tasks);

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
