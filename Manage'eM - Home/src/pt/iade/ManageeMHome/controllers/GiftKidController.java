package pt.iade.ManageeMHome.controllers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jfoenix.controls.JFXSlider;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.DAO.JDBC;
/**
 * This class is the controller to "gift kid window" that allows the user to select an amount of points, using
 * <p>the {@link #slider}, to gift the kid that was selected in the kid tab:
 * <p>{@link pt.iade.ManageeMHome.controllers.KidViewController#kidTV.java}.
 * @author jaime
 *
 */
public class GiftKidController {
	private int currentPoints;
	@FXML
	private JFXSlider slider;

	private int newPoints;
	@FXML
	private Label kidNameLabel;
	private Kid kid;
	public GiftKidController(Kid kid) {
		this.kid = kid;
	}
	
	
	public Kid getKid() {
		return kid;
	}


	@FXML
	private void cancelButtonClick() {
		Main.secondaryStage.close();
	}
	@FXML
	private void giftButtonClick() {
		int intSlider = (int)slider.getValue();

	try {
		String sql ="UPDATE Kid SET pts_Kid = pts_Kid + ? WHERE id_Kid = ?;";
		
		PreparedStatement stmt = JDBC.getCon().prepareStatement(sql);
		stmt.setInt(1,intSlider);
		stmt.setInt(2, kid.getId());
		stmt.execute();
		System.out.println(stmt);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		Main.secondaryStage.close();
		
	}
	public void initialize(){	
		
//		currentPoints=kid.getPoints();
		kidNameLabel.setText(kid.getName()+":");
	}
}
