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


	@FXML
	private void giftButtonClick() {
		Main.openGiftOrAllowance(this,kid, "views/giftKidView.fxml", new GiftKidController(kid));
	}
	@FXML
	private void allowanceButtonClick() {
		Main.openGiftOrAllowance(this,kid, "views/allowanceKidView.fxml", new AllowanceController(kid));
	}
	@FXML
	private void okButtonClick() {

		Main.tableItemStage.close();

	}

	@FXML
	public void initialize() {
		updateKidInfo();

	}
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
