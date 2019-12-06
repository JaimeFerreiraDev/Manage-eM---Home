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
		System.out.println(codeField.getText());
		for(Kid kid : PersonDAO.getKidList()) {
			if((String.valueOf(kid.getId())).equals( codeField.getText())) {
				kid.getParents().add( PersonDAO.getLoggedParent()); //ERRO
				PersonDAO.getLoggedParent().getKids().add(kid);
				kid.setId(0);
				kid.set_1stTime(false);
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

