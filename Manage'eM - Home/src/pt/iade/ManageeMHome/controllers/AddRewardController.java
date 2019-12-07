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
import pt.iade.ManageeMHome.models.DAO.RewardDAO;

public class AddRewardController {
	@FXML
	private TextField nameField;
	@FXML
	private JFXSlider slider;
	@FXML
	private Label errorLabel;

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
			
			
			Main.plusStage.close();
		} else {
			errorLabel.setText("Please insert a reward name");
			nameField.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
		}

	


	//		int intSlider= (int)slider.getValue();
	//		RewardDAO.getRewardList().add(new Reward(nameField.getText(), intSlider));
	//		

}
@FXML
public void cancelButtonOnClick() {

	Main.plusStage.close();

}	
}
