package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;

public class AddKidController {
	@FXML
	private TextField codeField;
	
	@FXML
	public void addButtonOnClick() {
		for(Kid kid : PersonDAO.getKidList()) {
			if(kid.getCode()== codeField.getText()) {
				kid.getParents().add((Parent) PersonDAO.getLoggedPerson());
				Main.plusStage.close();
			}
		}
		
	
	}
	@FXML
	public void cancelButtonOnClick() {
		Main.plusStage.close();
	}	
	
	@FXML
	public void initialize(){
	}
}

