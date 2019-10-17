package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;

public class ParentViewController {

	// Outras tabs
	@FXML
	public void onKidButtonClicked() {
		Main.openKid();
		System.out.println("KIDS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onTaskButtonClicked() {
		Main.openTask();
		System.out.println("TASKS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onRewardButtonClicked() {
		Main.openReward();
		System.out.println("REWARDS CLICKED");
	}
}
