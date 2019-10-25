package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.DAO.ParentDAO;
import pt.iade.ManageeMHome.models.parent.Parent;

public class AddParentController {
	@FXML
	private TextField nameField;
	@FXML
	public void addButtonOnClick() {
		ParentDAO.getParentList().add(new Parent(nameField.getText(),2, "bruh"));
		Main.plusStage.close();
		
	}
	@FXML
	public void cancelButtonOnClick() {
		Main.plusStage.close();
	}	
	@FXML
	public void initialize() {



	}
}




