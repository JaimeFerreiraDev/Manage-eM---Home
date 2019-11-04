package pt.iade.ManageeMHome.controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.kid.Kid;

public class kidTableItemController {
	private Kid kid;
	
public kidTableItemController(Kid kid) {
		this.kid = kid;
	}

@FXML
private Label kidNameLabel;
@FXML
private Label kidAgeLabel;
@FXML
private Label kidPointsLabel;

@FXML
private void giftButtonClick() {
	Main.openGift(this,kid);
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
