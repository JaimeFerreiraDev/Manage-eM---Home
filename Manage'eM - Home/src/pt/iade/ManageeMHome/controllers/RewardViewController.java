package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;

public class RewardViewController {

	// Outras tabs
	@FXML
	public void onKidButtonClicked() {
		Main.openKid();
		System.out.println("KIDS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onParentButtonClicked() {
		Main.openParent();
		System.out.println("PARENTS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onTaskButtonClicked() {
		Main.openTask();
		System.out.println("TASKS CLICKED");
	}
}
