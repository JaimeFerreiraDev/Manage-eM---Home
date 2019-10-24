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
	ObservableList<Kid> kidList;
	@FXML
	private TableView<Kid> tableView;
	@FXML
	private TableColumn<String, Kid> nameColumn;
	
	@FXML
	private TableColumn<Integer, Kid> ageColumn;
	
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
    	
    	tableView.getItems().setAll(getItems());
	}
	
	
	
    //List view


	    @FXML
	    private Label nameL;
	 
	    public ObservableList<Kid> getItems(){
	    	kidList.add(new Kid(3, "noob"));
	    	return kidList;
	    }
	 @FXML
	   private void initialize() {
		 nameColumn.setCellValueFactory(new PropertyValueFactory<String, Kid>("Name"));
	     ageColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("Age"));
	     kidList = FXCollections.observableArrayList();
	    }

	
}
