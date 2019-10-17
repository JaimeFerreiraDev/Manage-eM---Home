package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;

public class TaskViewController {
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
	public void onRewardButtonClicked() {
		Main.openReward();
		System.out.println("REWARDS CLICKED");
	}
	// Botão de adicionar
	public void onPlusTaskButtonClicked() {
		Main.openPlusTask();
		System.out.println("PLUS CLICKED");
	}
}
