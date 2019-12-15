package pt.iade.ManageeMHome.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Reward;
/**
 * This class is the controller for the "reward tab" that has:
 * <p>
 * <p> a table view {@link #rewardTV}, that displays the rewards that the logged parent, returned by the method:
 * <p>{@link pt.iade.ManageeMHome.models.DAO.PersonDAO#getLoggedParent()}
* <p>
 * <p>a "plus button" that opens the "add reward window", managed by:
 * <p>{@link pt.iade.ManageeMHome.controllers.AddRewardController.java}
 * <p>
 * <p>a "notifications button" that opens the "notifications window" managed by:
 * <p>{@link pt.iade.ManageeMHome.controllers.NotificationsController.java}
 * <p>
 * <p>buttons to the other tabs: parents, tasks and kids:
 * <p>{@link pt.iade.ManageeMHome.controllers.ParentViewController.java}
 * <p>{@link pt.iade.ManageeMHome.controllers.TaskViewController.java}
 * <p>{@link pt.iade.ManageeMHome.controllers.KidViewController.java}
 * <p>
 * <p>The "reward tab" is in this fxml file: {@link pt.iade.ManageeMHome.views#rewardView.fxml}.
 * @author jaime
 *
 */
public class RewardViewController {
	@FXML
	private TableView<Reward> rewardTV;
	@FXML
	private TableColumn<String, Reward> nameColumn;
	@FXML
	private TableColumn<Integer, Reward> pointsColumn;

	// Outras tabs
	@FXML
	public void onKidButtonClicked() {
		Main.changeTab("views/kidView.fxml", new KidViewController());
		System.out.println("KIDS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onParentButtonClicked() {
		Main.changeTab("views/parentView.fxml", new ParentViewController());
		System.out.println("PARENTS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onTaskButtonClicked() {
		Main.changeTab("views/taskView.fxml", new TaskViewController());
		System.out.println("TASKS CLICKED");
	}
	// Botao de adicionar
		@FXML
		public void onPlusButtonClicked() {
			Main.openPlus(null, null, this, null, "views/addRewardView.fxml", new AddRewardController());
			System.out.println("PLUS CLICKED");
		}
		@FXML
		private void notificationClick() {
			Main.openNotifications("views/notificationsView.fxml", new NotificationsController());
		}
		
		@FXML
		   private void initialize() {
			 
			 nameColumn.setCellValueFactory(new PropertyValueFactory<String, Reward>("Name"));
			 pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Reward>("Points"));
		     FXCollections.observableArrayList();
		     //set items here using the database
		    }
		public void updateRewardInfo() {
			
		}
}
