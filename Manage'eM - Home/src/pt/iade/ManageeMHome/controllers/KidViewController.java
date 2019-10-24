package pt.iade.ManageeMHome.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.kid.Kid;
import pt.iade.ManageeMHome.models.kid.KidListView;

public class KidViewController {
	// Outras tabs
	private ObservableList<Kid> kidList;
	// Paraa apagar quando tivermos BD
	public static ObservableList<Kid> currentKidList;
	@FXML
	private TableView<Kid> tableView;
	@FXML
	private TableColumn<String, Kid> nameColumn;
	@FXML
	private TableColumn<Integer, Kid> ageColumn;
	@FXML
	private TableColumn<String, Kid> IDColumn;
	
	@FXML
	public void onParentButtonClicked() {
		Main.changeTab("views/parentView.fxml");
		System.out.println("PARENTS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onRewardButtonClicked() {
		Main.changeTab("views/rewardView.fxml");
		System.out.println("REWARDS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onTaskButtonClicked() {
		Main.changeTab("views/taskView.fxml");
		System.out.println("TASKS CLICKED");
	}
	// Botao de adicionar
	@FXML
	public void onPlusButtonClicked() {
		Main.openPlus("views/addKidView.fxml");
		System.out.println("PLUS CLICKED");

	}
	 

	 @FXML
	   private void initialize() {
		 
		 nameColumn.setCellValueFactory(new PropertyValueFactory<String, Kid>("Name"));
		 ageColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("Age"));
		 IDColumn.setCellValueFactory(new PropertyValueFactory<String, Kid>("ID"));
	     kidList = FXCollections.observableArrayList();
	     currentKidList = kidList;
	     tableView.setItems(kidList);
	    }

	
}
