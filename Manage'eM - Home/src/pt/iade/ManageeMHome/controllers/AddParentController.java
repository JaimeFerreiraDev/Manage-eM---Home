package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.parent.Parent;

public class AddParentController {
	@FXML
	private TextField nameField;
	@FXML
	public void addButtonOnClick() {

		
		ParentViewController.currentParentList.add(new Parent(3,nameField.getText()));
		System.out.println(nameField.getText());
		Main.plusStage.close();
	}
	@FXML
	public void cancelButtonOnClick() {
	
		Main.plusStage.close();
	
	}	
}




