package pt.iade.ManageeMHome.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.DAO.ParentDAO;
import pt.iade.ManageeMHome.models.parent.Parent;


public class ParentViewController {
	
	// Outras tabs
	private ObservableList<Parent> parentList;
	@FXML
	private TableView<Parent> ParentTV;
	@FXML
	private TableColumn<String, Parent> nameColumn;
	// Outras tabs
	@FXML
	public void onKidButtonClicked() {
		Main.changeTab("views/kidView.fxml", new KidViewController());
		System.out.println("KIDS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onTaskButtonClicked() {
		Main.changeTab("views/taskView.fxml", new TaskViewController());
		System.out.println("TASKS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onRewardButtonClicked() {
		Main.changeTab("views/rewardView.fxml", new RewardViewController());
		System.out.println("REWARDS CLICKED");
	}
	// Botao de adicionar
	@FXML
	public void onPlusButtonClicked() {
		Main.openPlus("views/addParentView.fxml");
		System.out.println("PLUS CLICKED");
	}
	@FXML
	public void listClick() {
		
	}

	@FXML
	private void initialize() {
		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Parent>("name"));
		parentList = FXCollections.observableArrayList();
		ParentTV.setItems(ParentDAO.getParentList());
	}
}
