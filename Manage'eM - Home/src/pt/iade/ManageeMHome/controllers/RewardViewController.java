package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;

public class RewardViewController {

	// Outras tabs
	@FXML
	public void onKidButtonClicked() {
		Main.changeTab("views/kidView.fxml");
		System.out.println("KIDS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onParentButtonClicked() {
		Main.changeTab("views/parentView.fxml");
		System.out.println("PARENTS CLICKED");
	}
	// Outras tabs
	@FXML
	public void onTaskButtonClicked() {
		Main.changeTab("views/taskView.fxml");
		System.out.println("TASKS CLICKED");
	}
	// Botao de adicionar
		@FXML
		public void onPlusButtonClicked() {
			Main.openPlus("views/addRewardView.fxml");
			System.out.println("PLUS CLICKED");
		}
		
}
