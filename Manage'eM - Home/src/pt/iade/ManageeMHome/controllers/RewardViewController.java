package pt.iade.ManageeMHome.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Reward;
import pt.iade.ManageeMHome.models.DAO.RewardDAO;

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
			Main.openPlus("views/addRewardView.fxml", new AddRewardController());
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
		     rewardTV.setItems(RewardDAO.getRewardList());
		    }
		
}
