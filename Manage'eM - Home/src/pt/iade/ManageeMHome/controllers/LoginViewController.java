package pt.iade.ManageeMHome.controllers;

import java.io.IOException;



import javafx.fxml.FXML;

import pt.iade.ManageeMHome.Main;



public class LoginViewController {
	

	@FXML
	public void loginButtonOnCLick() {
	
	try {
		Main.openMenu();
		Main.primaryStage.close();
	
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
