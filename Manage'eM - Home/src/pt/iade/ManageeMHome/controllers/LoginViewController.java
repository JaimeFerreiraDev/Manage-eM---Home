package pt.iade.ManageeMHome.controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.kidPOV.kcontrollers.K1stTimeController;
import pt.iade.ManageeMHome.kidPOV.kcontrollers.KtaskController;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.Person;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;




public class LoginViewController {

	@FXML
	private TextField userText;
	private String username;
	@FXML
	private TextField passText;
	private String password;
	private Kid kid;

	@FXML
	public void newAccButton() {
		Main.changeTab("views/newAccView.fxml", new NewAccController());
		Main.setCounter(0);
		Main.primaryStage.close();
	}

	@FXML
	public void loginButtonOnCLick() {
		for(Person person : PersonDAO.getPersonList()) {
			if(person.getUsername().equals(userText.getText())) {
				if(person.getPassword().equals(passText.getText())) {
					if(person instanceof Parent) {
						PersonDAO.setLoggedPerson(person);
						Main.primaryStage.close();
						Main.changeTab("views/kidView.fxml", new KidViewController());
					}else {
						Kid kid = (Kid) person;
						if(kid.is_1stTime()==true) {
							Main.changeTab("kidPOV/kviews/k1stTimeView.fxml", new K1stTimeController());
							
							Main.primaryStage.close();
						}else {
							Main.changeTab("kidPOV/kviews/ktaskView.fxml", new KtaskController());
							
							Main.primaryStage.close();
						}
					}
				}
			}
		}
	}




	public void initialize(){
	}
}
