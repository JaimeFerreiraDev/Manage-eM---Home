package pt.iade.ManageeMHome.controllers;


import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.kid.Kid;
import javafx.scene.control.ComboBox;

public class AddKidController {
	@FXML
	private TextField nameField;
	@FXML
	private TextField IDField;
	@FXML
	ComboBox<Integer> ageOptions;
	
	
	@FXML
	public void addButtonOnClick() {
		KidDAO.getKidList().add(new Kid(
				nameField.getText(),
				ageOptions.getSelectionModel().getSelectedItem(),0,
				IDField.getText()));
		Main.plusStage.close();
	}
	@FXML
	public void cancelButtonOnClick() {
		Main.plusStage.close();
	}	
	
	@FXML
	public void initialize(){
		ageOptions.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18);
	}
}

