package pt.iade.ManageeMHome.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXDatePicker;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
/**
 * This class is the controller to "kid table item window" that shows info related to the kid selected in the
 * <p>table view in the kid tab: {@link pt.iade.ManageeMHome.controllers.KidViewController#kidTV}.
 * <p>Allowing the user to gift the kid or giving him an allowance.
 * <p>The "kid table item window" is in this fxml file: {@link pt.iade.ManageeMHome.views#kidTableItemView.fxml}.
 * @author jaime
 *
 */
public class KidTableItemController {
	private Kid kid;
	private int points = 0;

	public KidTableItemController(Kid kid) {
		this.kid = kid;
	}

	@FXML
	private Label kidNameLabel;
	@FXML
	private Label kidAgeLabel;
	@FXML
	private Label kidPointsLabel;
	@FXML
	private Label kidAllowanceLabel;

/**
 * This method opens the "gifts window" managed by {@link pt.iade.ManageeMHome.controllers.GiftKidController.java}
 */
	@FXML
	private void giftButtonClick() {
		Main.openGiftOrAllowance(this,kid, "views/giftKidView.fxml", new GiftKidController(kid));
	}
	/**
	 * This method opens the "allowance window" managed by {@link pt.iade.ManageeMHome.controllers.GiftKidController.java}
	 */
	@FXML
	private void allowanceButtonClick() {
		Main.openGiftOrAllowance(this,kid, "views/allowanceKidView.fxml", new AllowanceController(kid));
	}
	/**
	 * This method closes the window.
	 */
	@FXML
	private void okButtonClick() {

		Main.secondaryStage.close();

	}

	@FXML
	public void initialize() {
		updateKidInfo();

	}
	/**
	 * This method is called whenever there is the need to update the content in this window.
	 * <p>This being when the window opens, and when the gift or allowance windows close:
	 * <p>{@link #initialize()}
	 * <p>{@link pt.iade.ManageeMHome.Main#openGiftOrAllowance(KidTableItemController, Kid, String, Object)}
	 */
	public void updateKidInfo() {
		String sql = "select pts_Kid as points from Kid where id_Kid = ?;";
		try {
			PreparedStatement stat = JDBC.getCon().prepareStatement(sql); // erro aqui 		
			stat.setInt(1,kid.getId());
			System.out.println(stat);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				points=rs.getInt("points");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		kidNameLabel.setText(kid.getName()+":");
		kidAgeLabel.setText("Age: "+Integer.toString(kid.getAge()));
		kidPointsLabel.setText("M's: "+points);
	}
}
