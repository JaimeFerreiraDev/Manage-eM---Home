package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import pt.iade.ManageeMHome.Main;

public class MenuViewController {
	@FXML
	public void oncKidButtonClicked() {
		Main.openKid();
		System.out.println("KIDS CLICKED");
	}
	
	@FXML
	public void onParentButtonClicked() {
		Main.openParent();
		System.out.println("PARENTS CLICKED");
	}
	
	@FXML
	public void onRewardButtonClicked() {
		Main.openReward();
		System.out.println("REWARDS CLICKED");
	}
	
	
	@FXML
	public void onTaskButtonClicked() {
		Main.openTask();
		System.out.println("TASKS CLICKED");
	}
	
	@FXML
	public void onPlusButtonClicked() {
		Main.openPlus();
		System.out.println("PLUS CLICKED");
	}
	
	public void onPlusTaskButtonClicked() {
		Main.openPlusTask();
		System.out.println("PLUS CLICKED");
	}
	

}
