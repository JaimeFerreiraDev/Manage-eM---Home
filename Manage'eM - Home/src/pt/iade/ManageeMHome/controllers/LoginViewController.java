package pt.iade.ManageeMHome.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.kidPOV.kcontrollers.KtaskController;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.DAO.UserDAO;
import pt.iade.ManageeMHome.models.users.User;



public class LoginViewController {
	
	@FXML
	private TextField userText;
	private String username;
	@FXML
	private TextField passText;
	private String password;
	private User user;
	private ObservableList<User> userList = FXCollections.observableArrayList();
	
	@FXML
	public void newAccButton() {
		Main.changeTab("views/newAccView.fxml", new NewAccController());
		Main.setCounter(0);
		Main.primaryStage.close();
	}

	@FXML
	public void loginButtonOnCLick() {
	for(User user : userList) {
		if(User.getUsername().equals(userText.getText())) {
			if(User.getPassword().equals(passText.getText())) {
				if(User.isParentBool()==true) {
					Main.primaryStage.close();
					Main.changeTab("views/kidView.fxml", new KidViewController());
				}
				if(User.isParentBool()==false) {
					Main.primaryStage.close();
					Main.changeTab("kidPOV/kviews/ktaskView.fxml", new KtaskController());
				}
			}
		}
	}
		
	
	}
	
	
	
	
	public void initialize(){
		
		userList=UserDAO.userList;
	}
}
