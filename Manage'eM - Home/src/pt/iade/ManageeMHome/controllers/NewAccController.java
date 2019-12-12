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

<<<<<<< HEAD
				userTypeCombo.getValue()!=null &&
				datePicker.getValue() != null) {

			if(userTypeCombo.getValue().equals("Parent")) {
				//PersonDAO.getPersonList().add(new Parent(nameText.getText(), /*calcular idade apartir da data*/10, null,  userText.getText(), passText.getText(),  emailText.getText(), FXCollections.observableArrayList(), FXCollections.observableArrayList()));
			}else {
				//	PersonDAO.getPersonList().add(new Kid(nameText.getText(), /*calcular idade apartir da data*/10, nameText.getText() + ((int)(Math.random()*100)+100),  userText.getText(), passText.getText(),  confirmPassText.getText(),emailText.getText(),0,true, FXCollections.observableArrayList(), FXCollections.observableArrayList()));


				String sql ="insert into Kid (name, username, password, pts_Kid, age_Kid, 1stTime) values(?,?,?,?,?,?);";
				try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
//			
					stat.setString(1,nameText.getText());
					stat.setString(2,userText.getText());
					stat.setString(3,passText.getText());
					stat.setInt(4,0);
=======
			
			if(userTypeCombo.getValue().equals("Parent")) {
//				String sql ="insert into User (username, role) values(?,1);"
//						+ "insert into Parent (id_Parent, name, age) values ((select id_User from User where username = ? ,?, ?;"
//						+ "insert into Password(id_Password, password) values ((select id_User from User where username = ?), ?);";
				try {
					System.out.println("Sou parent");
					PreparedStatement stat = JDBC.getCon().prepareStatement("insert into User (role, username, name, age) values(1,?,?,?);");
					stat.setString(1,userText.getText());
					stat.setString(2,nameText.getText());
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String format = formatter.format(Date.valueOf(datePicker.getValue()));
					stat.setString(3,format);
					System.out.println("primeira query: "+stat);
					stat.execute();	
					stat.close();
					stat = JDBC.getCon().prepareStatement("insert into Password(id_Password, password)"
							+ " values ((select id_User from User where username = ?), ?);");
					stat.setString(1,userText.getText());
					stat.setString(2,passText.getText());
					System.out.println("segunda query: "+stat);
					stat.execute();	
					stat.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}else if(userTypeCombo.getValue().equals("Kid")){
				try {
					System.out.println("Sou Kid");
					PreparedStatement stat = JDBC.getCon().prepareStatement("insert into User(role, username, name, age) values(2,?,?,?);");
					stat.setString(1,userText.getText());
					stat.setString(2,nameText.getText());
>>>>>>> a54b48a2815c5554f7cef9118600a1b44f8b2fbe
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String format = formatter.format(Date.valueOf(datePicker.getValue()));
					stat.setString(3,format);
					System.out.println("primeira query: "+stat);
					stat.execute();	
					stat.close();
					stat = JDBC.getCon().prepareStatement("insert into Kid (id_Kid, pts_Kid, FirstTime) "
							+ "values ((select id_User from User where username = ?),0,true);");
					stat.setString(1,userText.getText());
					System.out.println("segunda query: "+stat);
					stat.execute();	
					stat.close();
					stat = JDBC.getCon().prepareStatement("insert into Password(id_Password, password) "
							+ "values ((select id_User from User where username = ?), ?);");
					stat.setString(1,userText.getText());
					stat.setString(2,passText.getText());
					System.out.println("terceirea query: "+stat);
					stat.execute();	
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 

<<<<<<< HEAD
				Main.primaryStage.close();
				Main.openLogin();

			}


			if(	userTypeCombo.getValue()!=null && 
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


					Main.primaryStage.close();
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
=======
				System.out.println("consigo fechar");
			
//				Main.openLogin();
//				Main.changeTab("views/LoginView.fxml", new LoginViewController());
			}
			Main.primaryStage.close();
		}else {
			//errors
>>>>>>> a54b48a2815c5554f7cef9118600a1b44f8b2fbe
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
			}}
		}
		public void cancelButtonClick() {
			Main.primaryStage.close();
		}
		@FXML
		public void initialize(){
			userTypeCombo.getItems().addAll("Parent", "Kid");
		}

	}

	

