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
import pt.iade.ManageeMHome.controllers.Kid.K1stTimeController;
import pt.iade.ManageeMHome.controllers.Kid.KtaskController;
import pt.iade.ManageeMHome.controllers.Parent.KidViewController;
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
	
	@FXML
	private TextField passText;

	/**
	 * @author 
	 */
	@FXML
	public void newAccButton() {
		Main.changeTab("views/newAccView.fxml", new NewAccController());
	}

	/**
	 * This method gets user inputs on userText and passText fields and compares them to DataBase users to complete the login
	 * @author Fernando
	 * @throws SQLException
	 */
	@FXML
	public void loginButtonOnCLick() throws SQLException {
	PersonDAO.loginBD(userText.getText(),passText.getText());

	}

}
