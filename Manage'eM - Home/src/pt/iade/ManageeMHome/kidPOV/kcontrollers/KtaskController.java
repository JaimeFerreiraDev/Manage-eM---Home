package pt.iade.ManageeMHome.kidPOV.kcontrollers;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.controllers.KidViewController;

public class KtaskController {
	@FXML
	private void rewardsClick() {
		Main.changeTab("kidPOV/kviews/krewardView.fxml", new KrewardController());
	}
}
