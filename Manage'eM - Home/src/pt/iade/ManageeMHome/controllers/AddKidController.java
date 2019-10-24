package pt.iade.ManageeMHome.controllers;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;

public class AddKidController {
	@FXML
	TextField nameField;
	@FXML
	public void addButtonOnClick() {
		Main.plusStage.close();
	}
	@FXML
	public void cancelButtonOnClick() {
		Main.plusStage.close();
	}	
}

