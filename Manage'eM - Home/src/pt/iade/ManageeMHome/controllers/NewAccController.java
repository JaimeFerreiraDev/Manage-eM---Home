package pt.iade.ManageeMHome.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
import pt.iade.ManageeMHome.models.DAO.PersonDAO;

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
	@FXML
	public void okButtonClick() throws IOException {
		if( !userText.getText().isEmpty() &&
				!passText.getText().isEmpty() &&
				!confirmPassText.getText().isEmpty() &&
				passText.getText().equals(confirmPassText.getText()) &&
				userTypeCombo.getValue()!=null && 
				!nameText.getText().isEmpty() &&
				Date.valueOf(datePicker.getValue()) != null) {

			if(userTypeCombo.getValue().equals("Parent")) {
				String sql ="insert into Parent (name, username, password, age_parent) values(?,?,?,?);";
				try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
					
					stat.setString(1,nameText.getText());
					stat.setString(2,userText.getText());
					stat.setString(3,passText.getText());
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String format = formatter.format(Date.valueOf(datePicker.getValue()));
					stat.setString(4,format);
					stat.execute();		

				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}else {

				String sql ="insert into Kid (name, username, password, pts_Kid, age_Kid) values(?,?,?,?,?);";
				try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
//			
					stat.setString(1,nameText.getText());
					stat.setString(2,userText.getText());
					stat.setString(3,passText.getText());
					stat.setInt(4,0);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String format = formatter.format(Date.valueOf(datePicker.getValue()));
					stat.setString(5,format);
					System.out.println(stat.toString());
					stat.execute();

				} catch (SQLException e) {
					e.printStackTrace();
				} 	


				Main.secondaryStage.close();
				Main.openLogin();
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
		Main.secondaryStage.close();
	}
	@FXML
	public void initialize(){
		userTypeCombo.getItems().addAll("Parent", "Kid");
	}
}