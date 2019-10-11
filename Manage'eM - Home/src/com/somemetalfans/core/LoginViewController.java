package com.somemetalfans.core;

import java.io.IOException;

import javafx.fxml.FXML;



public class LoginViewController {
	
	@FXML
	public void loginButtonOnCLick() {
	
	try {
		Main.openMenu();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
