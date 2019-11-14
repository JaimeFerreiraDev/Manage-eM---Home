package pt.iade.ManageeMHome.controllers;

import com.jfoenix.controls.JFXDatePicker;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.kid.Kid;

public class KidTableItemController {
	private Kid kid;
	
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
	kidNameLabel.setText(kid.getName()+":");
	kidAgeLabel.setText("Age: "+Integer.toString(kid.getAge()));
	kidPointsLabel.setText("M's: "+Integer.toString(kid.getPoints()));
}
}
