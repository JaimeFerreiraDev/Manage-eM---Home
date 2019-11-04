package pt.iade.ManageeMHome.controllers;

import com.jfoenix.controls.JFXSlider;

import javafx.fxml.FXML;



import javafx.scene.control.Label;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.kid.Kid;

public class giftKidController {
	private int currentPoints;
	@FXML
	private JFXSlider slider;

	private int newPoints;
	@FXML
	private Label kidNameLabel;
	private Kid kid;
	public giftKidController(Kid kid) {
		this.kid = kid;
	}
	
	
	public Kid getKid() {
		return kid;
	}


	@FXML
	private void cancelButtonClick() {
		Main.giftStage.close();
	}
	@FXML
	private void giftButtonClick() {
		int intSlider = (int)slider.getValue();
		newPoints = currentPoints+intSlider+1;
		kid.setPoints(newPoints);
	//	Main.updateKidTableItem(kid);
		Main.giftStage.close();
		
	}
	public void initialize(){	
		
		currentPoints=kid.getPoints();
		kidNameLabel.setText(kid.getName()+":");
	}
}
