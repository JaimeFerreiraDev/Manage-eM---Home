package pt.iade.ManageeMHome.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

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



/**
 * This class is a controller to the "login window" which is the 1st window of the program, and allows
 * <p>the user to log in, with a previously created account, or create a new one.
 * <p>The "login window" is in this fxml file: {@link pt.iade.ManageeMHome.views#LoginView.fxml}.
 * @author jaime
 *
 */
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
	public void loginButtonOnCLick() throws SQLException {
		Connection conn= JDBC.getCon(); 
			int role = 0;

		String sql = "select * from User, Password where username = ? and password = ? and id_User = id_Password;";
		PreparedStatement stat = conn.prepareStatement(sql); // erro aqui 		
		stat.setString(1, userText.getText());
		stat.setString(2, passText.getText());
		System.out.println(stat);
		ResultSet rs = stat.executeQuery();
		if(rs.next()) {
			role = rs.getInt("role");
			if (role ==1) {
				PersonDAO.setLoggedParent(new Parent(
						rs.getString("name"),
						rs.getInt("age"),
						rs.getInt("id_User")));
				Main.primaryStage.close();
				Main.changeTab("views/kidView.fxml", new KidViewController());
			}
			else if(role == 2) {
				PreparedStatement statement = conn.prepareStatement("Select * from Kid , User where username = ? and Kid.id_Kid = User.id_User");
				statement.setString(1, userText.getText());
				ResultSet kids = statement.executeQuery();
				System.out.println(statement);
				if(kids.next()) {
					PersonDAO.setLoggedKid(new Kid(
							kids.getString("name"),
							kids.getInt("age"),
							kids.getInt("id_Kid"),
							kids.getInt("pts_Kid"),
							kids.getBoolean("Connected")
							));
					System.out.println(PersonDAO.getLoggedKid().toString());
					Main.primaryStage.close();
					
					if(!kids.getBoolean("Connected")) {
						Main.changeTab("kidPOV/kviews/k1stTimeView.fxml", new K1stTimeController());
					
					}
					else if(kids.getBoolean("Connected")) {
						Main.changeTab("kidPOV/kviews/ktaskView.fxml", new KtaskController());
					}
					
					
				}

			}
		}

	}






	public void initialize(){
	}
}
