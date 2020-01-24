package pt.iade.ManageeMHome.controllers.Parent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Reward;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
import pt.iade.ManageeMHome.models.DAO.RewardDAO;
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
public class RewardViewController  implements ITab{
	@FXML
	private TableView<Reward> rewardTV;
	@FXML
	private TableColumn<String, Reward> nameColumn;
	@FXML
	private TableColumn<Integer, Reward> pointsColumn;
	@FXML
	private Label notifiNumber;
	private ObservableList<Reward> rewards= FXCollections.observableArrayList();

	@FXML
	public void onKidButtonClicked() {
		ITab.onKidButtonClicked();
	}

	@FXML
	public void onTaskButtonClicked() {
		ITab.onTaskButtonClicked();
	}
	// Outras tabs

	@FXML
	public void onParentButtonClicked() {
		ITab.onParentButtonClicked();
	}
	// Outras tabs

	@FXML
	public void onRewardButtonClicked() {

	}
	@FXML
	public void notificationClick() {
		ITab.notificationClick();
	}
	// Botao de adicionar
	@Override
	@FXML
	public void onPlusButtonClicked() {
		Main.openPlus( this, add_rewardView, new AddRewardController());
		System.out.println("PLUS CLICKED");
	}
	int num = 0 ;
	@FXML
	private void initialize() throws SQLException {

		num = PersonDAO.getNumberOfNotif();
		notifiNumber.setText(""+num);

		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Reward>("Name"));
		pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Reward>("Points"));
		FXCollections.observableArrayList();
		updateTableInfo();
		//set items here using the database
	}

	@Override
	public void updateTableInfo() {
		rewards = RewardDAO.getRewards();
		rewardTV.setItems(rewards);
	}


}
