package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import pt.iade.ManageeMHome.Main;

public class KidViewController {
	// Outras tabs
	@FXML
	public void onParentButtonClicked() {
		Main.openParent();
		System.out.println("PARENTS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onRewardButtonClicked() {
		Main.openReward();
		System.out.println("REWARDS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onTaskButtonClicked() {
		Main.openTask();
		System.out.println("TASKS CLICKED");
	}
	// Botao de adicionar
	@FXML
	public void onPlusButtonClicked() {
		Main.openPlusKid();
		System.out.println("PLUS CLICKED");
	}
	
}
