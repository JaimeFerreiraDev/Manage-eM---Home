package pt.iade.ManageeMHome.controllers;

import java.io.IOException;

import com.jfoenix.controls.JFXDatePicker;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;

public class NewAccController {
	@FXML
	private TextField userText;
	@FXML
	private TextField emailText;
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
	@FXML
	public void okButtonClick() throws IOException {
		if( !userText.getText().isEmpty() &&
				!emailText.getText().isEmpty() &&
				!passText.getText().isEmpty() &&
				!confirmPassText.getText().isEmpty() &&
				passText.getText().equals(confirmPassText.getText()) &&
				userTypeCombo.getValue()!=null) {
			
			if(userTypeCombo.getValue().equals("Parent")) {
				PersonDAO.getPersonList().add(new Parent(nameText.getText(), /*calcular idade apartir da data*/10, null,  userText.getText(), passText.getText(), emailText.getText(),  confirmPassText.getText(), FXCollections.observableArrayList(), FXCollections.observableArrayList()));
			}else {
				PersonDAO.getPersonList().add(new Kid(nameText.getText(), /*calcular idade apartir da data*/10, nameText.getText() + Math.random()*10,  userText.getText(), passText.getText(), emailText.getText(),  confirmPassText.getText(),0,true, FXCollections.observableArrayList(), FXCollections.observableArrayList()));
			}
			

			Main.secondaryStage.close();
			Main.openLogin();
			
		}else {
			//errors
			if(userText.getText().isEmpty()) {
				errorLabel.setText("Please insert an username");
			}else { if(emailText.getText().isEmpty()){
				errorLabel.setText("Please insert an email adress");
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
			if(emailText.getText().isEmpty()) {
				emailText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
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
			if(!emailText.getText().isEmpty()) {
				emailText.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
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
	}
	public void cancelButtonClick() {
		Main.secondaryStage.close();
	}
	@FXML
	public void initialize(){
		userTypeCombo.getItems().addAll("Parent", "Kid");
	}
}