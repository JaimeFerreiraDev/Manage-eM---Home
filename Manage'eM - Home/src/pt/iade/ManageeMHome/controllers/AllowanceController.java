package pt.iade.ManageeMHome.controllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSlider;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.kid.Kid;

public class AllowanceController {

@FXML
private Label kidNameLabel;
@FXML
private JFXSlider slider;
@FXML
private JFXDatePicker date;
private Kid kid;

public AllowanceController(Kid kid) {
	this.kid=kid;
}
@FXML
private void okButtonClick() {
	System.out.println(date.getValue());
	Main.giftOrAllowanceStage.close();
}
@FXML
private void cancelButtonClick() {
	
	Main.giftOrAllowanceStage.close();
	
}
public void initialize() {
	
}
}
