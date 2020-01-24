package pt.iade.ManageeMHome.controllers.Parent;

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
import javafx.scene.control.Tab;
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
 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.AddKidController}
 * <p>
 * <p>a "notifications button" that opens the "notifications window" managed by:
 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.NotificationsController}
 * <p>
 * <p>buttons to the other tabs: parents, tasks and rewards:
 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.ParentViewController}
 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.TaskViewController}
 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.RewardViewController}
 * <p>
 * <p>The "kid tab" is in this fxml file: {@link pt.iade.ManageeMHome.views#kidView.fxml}.
 * @author jaime
 *
 */
public class KidViewController implements ITab{
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
		Main.openPlus( this,add_kidView, new AddKidController());
		System.out.println("PLUS CLICKED");
	}
	

	
	
	
	@FXML
	private void initialize() {
		
		updateTableInfo();
		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Kid>("name"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("age"));
		pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("points"));
		kidTV.setOnMouseClicked(
				(event)-> {
					System.out.println("cliquei na TV");
					Kid kid = kidTV.getSelectionModel().getSelectedItem();
					kidTV.getSelectionModel().clearSelection();
					if (kid != null)
					Main.openTableItemAndNotif(this, "views/Parent/kidTableItemView.fxml", new KidTableItemController(kid));
					});

	}
	
	@Override
	public void updateTableInfo() {
		kidTV.setItems( KidDAO.getKidsBD());
	}
	
	
	
	
	
}
