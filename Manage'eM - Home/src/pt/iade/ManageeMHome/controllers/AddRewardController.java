package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;

public class AddRewardController {

	@FXML
	public void addButtonOnClick() {

		Main.rewardPlusStage.close();
	}
	@FXML
	public void cancelButtonOnClick() {
	
		Main.rewardPlusStage.close();
	
	}	
}
