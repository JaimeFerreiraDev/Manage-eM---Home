package pt.iade.ManageeMHome.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;

import com.jfoenix.controls.JFXDatePicker;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.DAO.ParentDAO;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
/**
 * This class is a controller to the "new account window" which allows the user to create a new account.
 * <p>The "new account window" is in this fxml file: {@link pt.iade.ManageeMHome.views#newAccView.fxml}.
 * @author jaime
 *
 */
public class NewAccController {
	@FXML
	private TextField userText;
	@FXML
	private TextField passText;
	@FXML
	private TextField confirmPassText;
	@FXML
	private TextField nameText;
	@FXML
	private JFXDatePicker  datePicker;
	@FXML
	private Label errorLabel;



	@FXML 
	private ComboBox<String> userTypeCombo;
	/**
	 * This method completes the process of creating a new User. 
	 * <p> If the user fills all the fields:
	 * <p> {@link #nameText} {@link #passText} {@link #userText} {@link #confirmPassText} {@link #datePicker} {@link #userTypeCombo}
	 * <p> A new user is added to the database.
	 * @throws IOException
	 */
	@FXML
	public void okButtonClick() throws SQLException {
		if( !userText.getText().isEmpty() &&
				!passText.getText().isEmpty() &&
				!confirmPassText.getText().isEmpty() &&
				passText.getText().equals(confirmPassText.getText()) &&
				userTypeCombo.getValue()!=null && 
				!nameText.getText().isEmpty() &&
				Date.valueOf(datePicker.getValue()) != null) {
						
			if(userTypeCombo.getValue().equals("Parent")) {	
					System.out.println("Sou parent");
					ParentDAO.createParentBD(userText.getText(), nameText.getText(), passText.getText(), datePicker.getValue());
					Main.changeTab("views/LoginView.fxml", new LoginViewController());
			}else if(userTypeCombo.getValue().equals("Kid")){
					System.out.println("Sou Kid");
					KidDAO.createKidBD(userText.getText(), nameText.getText(), passText.getText(), datePicker.getValue());
					Main.changeTab("views/LoginView.fxml", new LoginViewController());
			}
			
		}else {
			//errors
			if(userText.getText().isEmpty()) {
				errorLabel.setText("Please insert an username");
			}else{ if(passText.getText().isEmpty()) {
				errorLabel.setText("Please insert a password");
			}else {if(confirmPassText.getText().isEmpty()) {
				errorLabel.setText("Please confirm your password");
			}else{if(!passText.getText().equals(confirmPassText.getText())) {
				errorLabel.setText("Your passwords must match");
			}else{if(userTypeCombo.getValue()==null) {
				errorLabel.setText("Please say if you're a parent or a kid");
			}else{if(nameText.getText()==null) {
				errorLabel.setText("Please insert your name");
			}else{if(datePicker.getValue()==null) {
				errorLabel.setText("Please insert your date of birth");
			}}}}}}}}

		//make red
		if(userText.getText().isEmpty()) {
			userText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
		}
		if(passText.getText().isEmpty()) {
			passText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
		}
		if(confirmPassText.getText().isEmpty()) {
			confirmPassText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
		}
		if(userTypeCombo.getValue()==null) {
			userTypeCombo.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
		}
		if(nameText.getText()!=null) {
			nameText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
		}
		if(datePicker.getValue()!=null) {
			datePicker.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
		}

		//make normal
		if(!userText.getText().isEmpty()) {
			userText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
		}

		if(!passText.getText().isEmpty()) {
			passText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
		}
		if(!confirmPassText.getText().isEmpty()) {
			confirmPassText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
		}
		if(userTypeCombo.getValue()!=null) {
			userTypeCombo.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
		}
		if(nameText.getText()!=null) {
			nameText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
		}
		if(datePicker.getValue()!=null) {
			datePicker.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
		}
	}
	public void cancelButtonClick() {
		Main.primaryStage.close();
	}
	@FXML
	public void initialize(){
		userTypeCombo.getItems().addAll("Parent", "Kid");
	}
}