package pt.iade.ManageeMHome.controllers;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.kid.Kid;

public class AddKidController {
	@FXML
	private TextField nameField;
	@FXML
	public void addButtonOnClick() {
	
		KidViewController.currentKidList.add(new Kid(3,nameField.getText()));
		System.out.println(nameField.getText());
		Main.plusStage.close();
	}
	@FXML
	public void cancelButtonOnClick() {
		Main.plusStage.close();
	}	
}

