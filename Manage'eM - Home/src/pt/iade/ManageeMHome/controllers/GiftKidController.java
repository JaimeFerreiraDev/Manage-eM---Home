package pt.iade.ManageeMHome.controllers;

import com.jfoenix.controls.JFXSlider;

import javafx.fxml.FXML;



import javafx.scene.control.Label;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;

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
		Main.giftOrAllowanceStage.close();
	}
	@FXML
	private void giftButtonClick() {
		int intSlider = (int)slider.getValue();
		newPoints = currentPoints+intSlider;
		kid.setPoints(newPoints);
		Main.giftOrAllowanceStage.close();
		
	}
	public void initialize(){	
		
		currentPoints=kid.getPoints();
		kidNameLabel.setText(kid.getName()+":");
	}
}
