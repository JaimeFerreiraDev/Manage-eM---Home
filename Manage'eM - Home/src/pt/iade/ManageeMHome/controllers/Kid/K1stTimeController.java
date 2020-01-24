package pt.iade.ManageeMHome.controllers.Kid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;

/**
This class is a controller to the "Kid 1st time login window" that pops up when a kid logs in for the 1st time.
 * <p>The "Kid 1st time login window" is in this fxml file: {@link pt.iade.ManageeMHome.kidPOV.kviews#kid1stTimeView.fxml}.
 * @author jaime
 *
 */
public class K1stTimeController {
	@FXML
	private Label codeLabel;
	/**
	 * This method is not complete.
	 */
	@FXML
	private void connectClick() {

	}
	/**
	 * this method gets the logged kid's ID from the database
	 * <p>{@link pt.iade.ManageeMHome.models.DAO.PersonDAO#getLoggedKid()}
	 */
	@FXML
	private void initialize() {
		codeLabel.setText(""+KidDAO.firstTimeKidLogin());
	}
}
