package com.somemetalfans.core;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MenuViewController {
	@FXML
	public void oncKidButtonClicked() {
		Main.openKid();
		System.out.println("KIDS CLICKED");
	}
	
	@FXML
	public void onRewardButtonClicked() {
	
		System.out.println("REWARDS CLICKED");
	}
	
	
	@FXML
	public void onTaskButtonClicked() {
	
		System.out.println("TASKS CLICKED");
	}
	@FXML
	public void onParentButtonClicked() {
	
		System.out.println("PARENTS CLICKED");
	}

}
