package pt.iade.ManageeMHome.controllers.Parent;


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
import pt.iade.ManageeMHome.models.Reward;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
import pt.iade.ManageeMHome.models.DAO.RewardDAO;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;


/**
 * This class is a controller for the "notifications Window", wich displays all the completed tasks from all the
 * <p>kids respective to the logged parent: {@link pt.iade.ManageeMHome.models.DAO.PersonDAO#getLoggedParent()},
 * <p> allowing the parents to confirm if the task has been completed successfully or not.
 * <p>The "new account window" is in this fxml file: {@link pt.iade.ManageeMHome.views#notificationsView.fxml}.
 * @author jaime
 *
 */
public class NotificationsController {


	@FXML
	private TableView<Task> notificationTV;

	@FXML
	private TableView<Reward> notifRewardTV;

	@FXML
	private TableColumn<String, Task> taskColumn;

	@FXML
	private TableColumn<String, Task> kidColumnN;

	@FXML
	private TableColumn<Boolean, Button> noColumn;
	@FXML
	private TableColumn<Boolean, Button> yesColumn;

	@FXML
	private TableColumn<String, Reward> rewardColumn;

	@FXML
	private TableColumn<String, Reward> kidRewardColumn;

	@FXML
	private TableColumn<Boolean, Button> noRewardColumn;

	@FXML
	private TableColumn<Boolean, Button> yesRewardColumn;


	private ObservableList<Task> completedTasks= FXCollections.observableArrayList();
	private ObservableList<Reward> requestedRewards= FXCollections.observableArrayList();

	@FXML
	private void initialize() {
		//tasks 
		completedTasks = TaskDAO.findCompletedTasks();
	
		taskColumn.setCellValueFactory(new PropertyValueFactory<String, Task>("name"));
		kidColumnN.setCellValueFactory(new PropertyValueFactory<String, Task>("kid"));
		FXCollections.observableArrayList();
		notificationTV.setItems(completedTasks);
		noColumn.setCellFactory((tableCol)-> {
			return new TableCell<Boolean, Button> ()  {
				@Override
				protected void updateItem(Button b1, boolean empty) {
					super.updateItem(b1, empty);
					if(!empty){
						Button button = new Button("NO");
						button.setOnAction((event) -> {
							notificationTV.getSelectionModel().select(getTableRow().getIndex());
							Task  selectedItem     =    notificationTV.getSelectionModel().getSelectedItem();
							TaskDAO.taskIsNotCompletedBD(selectedItem.getKid().getId(), selectedItem.getId());
							notificationTV.getItems().remove(selectedItem);
							notificationTV.setItems(completedTasks);

						});
						setGraphic(button);
					} else  {
						setGraphic(null);

					}}

			}; 
		});
		yesColumn.setCellFactory((tableCol)-> {
			return new TableCell<Boolean, Button> ()  {
				@Override
				protected void updateItem(Button b1, boolean empty) {
					super.updateItem(b1, empty);
					if(!empty){
						Button button = new Button("YES");
						button.setOnAction((event) -> { 
							notificationTV.getSelectionModel().select(getTableRow().getIndex());
							Task  selectedItem     =    notificationTV.getSelectionModel().getSelectedItem();

							KidDAO.giftKidBD(selectedItem.getPoints(), selectedItem.getKid().getId());
							TaskDAO.removeNotificationBD(selectedItem, selectedItem.getKid());
							notificationTV.getItems().remove(selectedItem);
							notificationTV.setItems(completedTasks);


						});
						setGraphic(button);
					} else  {
						setGraphic(null);

					}
				}   
			}; 
		});

		//		rewards
		requestedRewards = RewardDAO.findRequestedRewards();
		rewardColumn.setCellValueFactory(new PropertyValueFactory<String, Reward>("name"));
		kidRewardColumn.setCellValueFactory(new PropertyValueFactory<String, Reward>("kid"));

		notifRewardTV.setItems(requestedRewards);

		noRewardColumn.setCellFactory((tableCol)-> {
			return new TableCell<Boolean, Button> ()  {
				@Override
				protected void updateItem(Button b1, boolean empty) {
					super.updateItem(b1, empty);
					if(!empty){
						Button button = new Button("NO");
						button.setOnAction((event) -> {
							notifRewardTV.getSelectionModel().select(getTableRow().getIndex());
							Reward  selectedItem     =    notifRewardTV.getSelectionModel().getSelectedItem();


							KidDAO.returnPoints(selectedItem.getPoints(), selectedItem.getKid().getId(), selectedItem.getId());



							notifRewardTV.getItems().remove(selectedItem);
							notifRewardTV.setItems(requestedRewards);

						});
						setGraphic(button);
					} else  {
						setGraphic(null);

					}}

			}; 
		});
		yesRewardColumn.setCellFactory((tableCol)-> {
			return new TableCell<Boolean, Button> ()  {
				@Override
				protected void updateItem(Button b1, boolean empty) {
					super.updateItem(b1, empty);
					if(!empty){
						Button button = new Button("YES");
						button.setOnAction((event) -> { 
							notifRewardTV.getSelectionModel().select(getTableRow().getIndex());
							Reward  selectedItem     =    notifRewardTV.getSelectionModel().getSelectedItem();
							KidDAO.removeNotifReward(selectedItem.getKid().getId(), selectedItem.getId());

							notifRewardTV.getItems().remove(selectedItem);
							notifRewardTV.setItems(requestedRewards);


						});
						setGraphic(button);
					} else  {
						setGraphic(null);

					}
				}   
			}; 
		});

	}

	

	@FXML
	private void rewardTabClicked() {
		requestedRewards = RewardDAO.findRequestedRewards();
		notifRewardTV.setItems(requestedRewards);
	}
	@FXML
	private void taskTabClicked() {
		completedTasks = TaskDAO.findCompletedTasks();
		notificationTV.setItems(completedTasks);
	}
}


