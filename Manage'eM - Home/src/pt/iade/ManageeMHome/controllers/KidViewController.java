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
import pt.iade.ManageeMHome.models.DAO.PersonDAO;


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
<<<<<<< HEAD
		Main.openPlus("views/addKidView.fxml", new AddKidController(), this, null, null, null);
=======
		Main.openPlus(this,null, null, null, "views/addKidView.fxml", new AddKidController());
>>>>>>> a54b48a2815c5554f7cef9118600a1b44f8b2fbe
	}

	@FXML
	private void notificationClick() {
		Main.openNotifications("views/notificationsView.fxml", new NotificationsController());
	}


	@FXML
	private void initialize() {
<<<<<<< HEAD
		refreshKids();
		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Kid>("name"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("age"));
		pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("points"));



		//		kidTV.setItems(PersonDAO.getLoggedParent().getKids());

=======
		
		updateKidInfo();
		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Kid>("name"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("age"));
		pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("points"));
		
//		kidTV.setItems(PersonDAO.getLoggedParent().getKids()); querry a familyrelation do id do logged paret para buscar kid
>>>>>>> a54b48a2815c5554f7cef9118600a1b44f8b2fbe
		kidTV.setOnMouseClicked(
				(event)-> {
					System.out.println("cliquei na TV");
					Kid kid = kidTV.getSelectionModel().getSelectedItem();
					kidTV.getSelectionModel().clearSelection();
					if (kid != null)
					Main.openTableItem(this, "views/kidTableItemView.fxml", new KidTableItemController(kid));
					});

	}
<<<<<<< HEAD
	public void refreshKids() {
		int parent = 0;
		String sql ="Select * from Family_Relation, Kid where parent = ? and kid = id_Kid;";
=======
	
	
	
	
	
	
	public void updateKidInfo() {
		int parent = 0;
		String sql ="Select * from Family_Relation, Kid, User where parent = ? and kid = id_Kid and id_Kid = id_User;";
>>>>>>> a54b48a2815c5554f7cef9118600a1b44f8b2fbe
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			parent = PersonDAO.getLoggedParent().getId();
			stat.setInt(1, parent);
			System.out.println(stat);
			ResultSet rs = stat.executeQuery();	
			ObservableList<Kid> kids = FXCollections.observableArrayList();
			while(rs.next()) {
				kids.add(new Kid(rs.getString("name"), 
<<<<<<< HEAD
						rs.getInt("age_Kid"), 
						rs.getInt("id_Kid"),
						rs.getInt("pts_Kid"),
						rs.getBoolean("1stTime"))
						);
				System.out.println(kids.toString());
			}
		kidTV.setItems(kids);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
=======
						rs.getInt("age"), 
						rs.getInt("id_Kid"),
						rs.getInt("pts_Kid"),
						rs.getBoolean("FirstTime"))
						);
			}
			kidTV.setItems( kids);
			System.out.println(kids);
		} catch (SQLException e) {
			e.printStackTrace();
		} 

>>>>>>> a54b48a2815c5554f7cef9118600a1b44f8b2fbe
	}

}
