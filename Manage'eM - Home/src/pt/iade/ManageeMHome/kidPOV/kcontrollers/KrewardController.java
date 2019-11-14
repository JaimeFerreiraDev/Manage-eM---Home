package pt.iade.ManageeMHome.kidPOV.kcontrollers;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;

public class KrewardController {
	@FXML
	private void taskClick() {
		Main.changeTab("kidPOV/kviews/ktaskView.fxml", new KtaskController());
	}
}
