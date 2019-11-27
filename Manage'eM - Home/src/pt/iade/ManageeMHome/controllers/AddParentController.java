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

public class AddParentController {
	@FXML
	private TextField nameField;
	@FXML
	public void addButtonOnClick() {
		//SET AOS ATRIBUTOS !! AQUIIIIIII ADICIONAR
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




