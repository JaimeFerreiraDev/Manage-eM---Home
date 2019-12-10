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
		
	
	}

	@FXML
	public void loginButtonOnCLick() {
		Connection conn= JDBC.getCon(); 
		String tableName = null;

//		String sqlParent = "SELECT username, password FROM Parent where username = ? and password = ?";
//		String sqlKid =  "SELECT username, password FROM Kid where username = ? and password = ?";
		String sql="SELECT name, age_parent as age, id_parent as id,0 as 1stTime,0 as points ,'Parent' as Role FROM Parent where username = ? and password = ? "
				+ "UNION"
				+ " SELECT name, age_kid as age, id_kid as id, 1stTime, pts_kid as points ,'Kid' as Role FROM Kid where username = ? and password = ?;"; 

// "SELECT id_parent, name, username, password, age_parent,  'Parent' as Role
// "SELECT id_Kid, name, username, password, pts_Kid, age_kid, 'Kid' as Role
		try {
			PreparedStatement stat = conn.prepareStatement(sql); // erro aqui 		
			stat.setString(1, userText.getText());
			stat.setString(2, passText.getText());
			stat.setString(3, userText.getText());
			stat.setString(4, passText.getText());
			System.out.println(stat.toString());
			ResultSet rs = stat.executeQuery();
//			ResultSetMetaData resultSetMetaData = rs.getMetaData(); //usado para buscar o nome da tabela
			if(rs.next()) {// vai para a primeira row
	
//				tableName = resultSetMetaData.getTableName(1);// guarda o nome da tabela 

				tableName = rs.getString("Role");
				if(tableName.equals("Parent")) {
					System.out.println("sou parent");
					PersonDAO.setLoggedParent(new Parent(
							rs.getString("name"),
							rs.getInt("age"),
							rs.getInt("id")));
//							rs.getString("username")
//							rs.getString("password"),
//							FXCollections.observableArrayList(),
//							FXCollections.observableArrayList()));
					Main.primaryStage.close();
					Main.changeTab("views/kidView.fxml", new KidViewController());
					
				}else if(tableName.equals("Kid")) {
					System.out.println("sou Kid");
					PersonDAO.setLoggedKid(new Kid(
							rs.getString("name"),
							rs.getInt("age"),
							rs.getInt("id"), 
							rs.getInt("points"), 
							rs.getBoolean("1stTime")
							));
					System.out.println(PersonDAO.getLoggedKid().getId());
					Main.primaryStage.close();
					Main.changeTab("kidPOV/kviews/k1stTimeView.fxml", new K1stTimeController());
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
