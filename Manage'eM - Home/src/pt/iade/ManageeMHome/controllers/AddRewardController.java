package pt.iade.ManageeMHome.controllers;

import com.jfoenix.controls.JFXSlider;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.RewardDAO;
import pt.iade.ManageeMHome.models.reward.Reward;

public class AddRewardController {
	@FXML
	private TextField nameField;
	@FXML
	private JFXSlider slider;
	@FXML
	public void addButtonOnClick() {
		int intSlider= (int)slider.getValue();
		RewardDAO.getRewardList().add(new Reward(nameField.getText(), intSlider));
		
		Main.plusStage.close();
	}
	@FXML
	public void cancelButtonOnClick() {
	
		Main.plusStage.close();
	
	}	
}
