package pt.iade.ManageeMHome.controllers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Reward;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;

/**
 * This class is the controller for the "kid tab" that has:
 * <p>
 * <p> a table view {@link #kidTV}, that displays the kids that the logged parent, returned by the method:
 * <p>{@link pt.iade.ManageeMHome.models.DAO.PersonDAO#getLoggedParent()}
 * <p>
 * <p>a "plus button" that opens the "add kid window", managed by:
 * <p>{@link pt.iade.ManageeMHome.controllers.AddKidController}
 * <p>
 * <p>a "notifications button" that opens the "notifications window" managed by:
 * <p>{@link pt.iade.ManageeMHome.controllers.NotificationsController}
 * <p>
 * <p>buttons to the other tabs: parents, tasks and rewards:
 * <p>{@link pt.iade.ManageeMHome.controllers.ParentViewController}
 * <p>{@link pt.iade.ManageeMHome.controllers.TaskViewController}
 * <p>{@link pt.iade.ManageeMHome.controllers.RewardViewController}
 * <p>
 * <p>The "kid tab" is in this fxml file: {@link pt.iade.ManageeMHome.views#kidView.fxml}.
 * @author jaime
 *
 */
public class KidViewController {
	// Paraa apagar quando tivermos BD
	public static KidViewController kvc = new KidViewController();
	@FXML
	public TableView<Kid> kidTV;
	@FXML
	private TableColumn<String, Kid> nameColumn;
	@FXML
	private TableColumn<Integer, Kid> ageColumn;
	@FXML
	private TableColumn<Integer, Kid> pointsColumn;

	@FXML
	public void onParentButtonClicked() {

		Main.changeTab("views/parentView.fxml", new ParentViewController());
	}
	// Outras tabs
	@FXML
	public void onRewardButtonClicked() {
		Main.changeTab("views/rewardView.fxml", new RewardViewController());
	}
	// Outras tabs
	@FXML
	public void onTaskButtonClicked() {
		Main.changeTab("views/taskView.fxml", new TaskViewController());
	}
	// Botao de adicionar
	@FXML
	public void onPlusButtonClicked() {
		Main.openPlus(this,null, null, null, "views/addKidView.fxml", new AddKidController());

	}

	@FXML
	private void notificationClick() {
		Main.openNotifications(this, "views/notificationsView.fxml", new NotificationsController());
	}


	@FXML
	private void initialize() {
		updateKidInfo();
		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Kid>("name"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("age"));
		pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("points"));
		kidTV.setOnMouseClicked(
				(event)-> {
					System.out.println("cliquei na TV");
					Kid kid = kidTV.getSelectionModel().getSelectedItem();
					kidTV.getSelectionModel().clearSelection();
					if (kid != null)
					Main.openTableItem(this, "views/kidTableItemView.fxml", new KidTableItemController(kid));
					});

	}

	
	public void updateKidInfo() {
		kidTV.setItems( KidDAO.getKidsBD());
	}
	
	
	
	
	
}
