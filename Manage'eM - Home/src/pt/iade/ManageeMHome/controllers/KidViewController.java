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
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.kid.Kid;
import pt.iade.ManageeMHome.models.kid.KidListView;

public class KidViewController {
	// Paraa apagar quando tivermos BD
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
		Main.openPlus("views/addKidView.fxml", new AddKidController());
	}
	
	@FXML
	private void notificationClick() {
		Main.openNotifications("views/notificationsView.fxml", new NotificationsController());
	}


	@FXML
	private void initialize() {

		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Kid>("name"));
		ageColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("age"));
		pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer, Kid>("points"));
		kidTV.setItems(KidDAO.getKidList());
		kidTV.getSelectionModel().selectedItemProperty().addListener(
				(obs,oldVal,newVal)-> {
					
					Main.openTableItem(this, "views/kidTableItemView.fxml", new KidTableItemController(newVal));
					});

	}
	public void updateKidInfo() {
		kidTV.refresh();
		
	}

}
