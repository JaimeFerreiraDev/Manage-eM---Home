package pt.iade.ManageeMHome.controllers.Parent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Reward;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
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

	// Outras tabs
	@Override
	@FXML
	public void onKidButtonClicked() {
		Main.changeTab(kidView, new KidViewController());
		System.out.println("KIDS CLICKED");
	}
	// Outras tabs
	@Override
	@FXML
	public void onParentButtonClicked() {
		Main.changeTab(parentView, new ParentViewController());
		System.out.println("PARENTS CLICKED");
	}
	// Outras tabs
	@Override
	@FXML
	public void onTaskButtonClicked() {
		Main.changeTab(taskView, new TaskViewController());
		System.out.println("TASKS CLICKED");
	}
	// Botao de adicionar
	@Override
		@FXML
		public void onPlusButtonClicked() {
			Main.openPlus( this, add_rewardView, new AddRewardController());
			System.out.println("PLUS CLICKED");
		}
	@Override
		@FXML
		public void notificationClick() {
			Main.openNotifications(null, notif_view, new NotificationsController());
		}
		
		@FXML
		   private void initialize() {
			 
			 nameColumn.setCellValueFactory(new PropertyValueFactory<String, Reward>("Name"));
			 pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Reward>("Points"));
		     FXCollections.observableArrayList();
		     updateTableInfo();
		     //set items here using the database
		    }
		int parent = 0;
		@Override
		public void updateTableInfo() {

			String sql ="Select * from Parents_Reward, Reward where parent = ? and id_Reward = reward;";
			try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
				parent = PersonDAO.getLoggedParent().getId();
				stat.setInt(1, parent);
				System.out.println(stat);
				ResultSet rs = stat.executeQuery();	
				ObservableList<Reward> rewards= FXCollections.observableArrayList();
				while(rs.next()) {
					rewards.add(new Reward(rs.getString("name"),
							rs.getInt("pts_required"),
							rs.getInt("Id_Reward"))
							);
				}
				rewardTV.setItems(rewards);
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		@Override
		public void onRewardButtonClicked() {
			// TODO Auto-generated method stub
			
		}

}
