package pt.iade.ManageeMHome.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.bcel.internal.generic.Select;

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
import pt.iade.ManageeMHome.models.DAO.JDBC;
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
		Connection conn= JDBC.getCon(); 
		String sql="Select username, password from Parent where username = ? and password = ?;"; 
//		String sqlKid = "Select username, password from Kid where username = ? and password = ?;";
		try {
			PreparedStatement stat = conn.prepareStatement(sql); // erro aqui 		
			String tableName = null;
			stat.setString(1, userText.getText());
			stat.setString(2, passText.getText());
			ResultSet rs = stat.executeQuery();
			
			ResultSetMetaData resultSetMetaData = rs.getMetaData(); //usado para buscar o nome da tabela
			if(rs.next()) { // vai para a primeira row
				tableName = resultSetMetaData.getTableName(rs.getRow());// guarda o nome da tabela 
				if(tableName.equals("Parent")) {
					Main.primaryStage.close();
					Main.changeTab("views/kidView.fxml", new KidViewController());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//		for(Person person : PersonDAO.getPersonList()) {
		//			if(person.getUsername().equals(userText.getText())) {
		//				if(person.getPassword().equals(passText.getText())) {
		//					if(person instanceof Parent) {
		//						PersonDAO.setLoggedParent((Parent)person);
		//						Main.primaryStage.close();
		//						Main.changeTab("views/kidView.fxml", new KidViewController());
		//					}else {
		//						
		//						PersonDAO.setLoggedKid((Kid) person);
		//						if(PersonDAO.getLoggedKid().is_1stTime()==true) {
		//							Main.changeTab("kidPOV/kviews/k1stTimeView.fxml", new K1stTimeController());
		//							Main.primaryStage.close();
		//						}else {
		//							Main.changeTab("kidPOV/kviews/ktaskView.fxml", new KtaskController());
		//							Main.primaryStage.close();
		//						}
		//					}
		//				}
		//			}
		//		}
	}




	public void initialize(){
	}
}
