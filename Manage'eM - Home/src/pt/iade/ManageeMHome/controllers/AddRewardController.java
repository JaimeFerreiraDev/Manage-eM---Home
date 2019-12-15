package pt.iade.ManageeMHome.controllers;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXSlider;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Reward;
import pt.iade.ManageeMHome.models.DAO.JDBC;
/**
 * This class is a controller to the "Add Reward window" that pops up when the user clicks in the plus button in the Reward tab, managed
 * <p> by the {@link pt.iade.ManageeMHome.controllers.rewardViewController.java} class.
 * <p>The add Reward window is in this fxml file: {@link pt.iade.ManageeMHome.views#addRewardView.fxml}.
 * @author jaime
 *
 */
public class AddRewardController {
	@FXML
	private TextField nameField;
	@FXML
	private JFXSlider slider;
	@FXML
	private Label errorLabel;
	/**
	 * This method adds a reward to the reward table
	 */
	@FXML
	public void addButtonOnClick() throws IOException{
		if(!nameField.getText().isEmpty()) {
			nameField.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
			
			
			String sql ="insert into Reward (name, pts_required) values(?,?);";
			try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){	
				int intSlider= (int)slider.getValue();
				stat.setString(1,nameField.getText());
				stat.setInt(2, intSlider);
				stat.execute();
				System.out.println(stat.toString());
			}catch (SQLException e) {
				e.printStackTrace();	
			}
			
			
			Main.secondaryStage.close();
		} else {
			errorLabel.setText("Please insert a reward name");
			nameField.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
		}
}
@FXML
public void cancelButtonOnClick() {

	Main.secondaryStage.close();

}	
}
