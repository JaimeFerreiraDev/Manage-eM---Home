package pt.iade.ManageeMHome.controllers.Parent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;


/**
 * This class is the controller for the "parent tab" that has:
 * <p>
 * <p> a table view {@link #parentTV}, that displays the other parents that are part of the family of 
 * <p>the logged parent, returned by the method:
 * <p>{@link pt.iade.ManageeMHome.models.DAO.PersonDAO#getLoggedParent()}
* <p>
 * <p>a "plus button" that opens the "add parent window", managed by:
 * <p>{@link pt.iade.ManageeMHome.controllers.AddParentController.java}
 * <p>
 * <p>a "notifications button" that opens the "notifications window" managed by:
 * <p>{@link pt.iade.ManageeMHome.controllers.NotificationsController.java}
 * <p>
 * <p>buttons to the other tabs: kids, tasks and rewards:
 * <p>{@link pt.iade.ManageeMHome.controllers.KidViewController.java}
 * <p>{@link pt.iade.ManageeMHome.controllers.TaskViewController.java}
 * <p>{@link pt.iade.ManageeMHome.controllers.RewardViewController.java}
 * <p>
 * <p>The "parent tab" is in this fxml file: {@link pt.iade.ManageeMHome.views#parentView.fxml}.
 * @author jaime
 *
 */
public class ParentViewController implements ITab {
	
	// Outras tabs
	private ObservableList<Parent> parentList;
	@FXML
	private TableView<Parent> parentTV;
	@FXML
	private TableColumn<String, Parent> nameColumn;
	// Outras tabs
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
	// Botao de adicionar
	@Override
	@FXML
	public void onPlusButtonClicked() {
		Main.openPlus(this,add_parentView, new AddParentController());
		System.out.println("PLUS CLICKED");
	}

	@FXML
	private void initialize() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Parent>("name"));
		parentList = FXCollections.observableArrayList();
	}
	@Override
	public void updateTableInfo() {}

}
