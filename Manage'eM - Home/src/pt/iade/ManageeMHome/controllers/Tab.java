package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.controllers.Parent.AddParentController;
import pt.iade.ManageeMHome.controllers.Parent.ITab;
import pt.iade.ManageeMHome.controllers.Parent.KidViewController;
import pt.iade.ManageeMHome.controllers.Parent.NotificationsController;
import pt.iade.ManageeMHome.controllers.Parent.ParentViewController;
import pt.iade.ManageeMHome.controllers.Parent.RewardViewController;
import pt.iade.ManageeMHome.controllers.Parent.TaskViewController;

public abstract class Tab implements ITab{

	@Override
	public void onParentButtonClicked(String view) {
		Main.changeTab(view, new ParentViewController());
		System.out.println("PARENTS CLICKED");
	}
	
	@Override
	public void onKidButtonClicked(String view) {
		Main.changeTab(view, new KidViewController());
		System.out.println("KIDS CLICKED");
	}
	// Outras tabs
	@Override

	public void onTaskButtonClicked(String view) {
		Main.changeTab(view, new TaskViewController());
		System.out.println("TASKS CLICKED");
	}
	// Outras tabs
	@Override
	public void onRewardButtonClicked(String view) {
		Main.changeTab(view, new RewardViewController());
		System.out.println("REWARDS CLICKED");
	}
	// Botao de adicionar

	@Override
	public void onPlusButtonClicked(Object viewCont,String view, Object addCont) {
		Main.openPlus(viewCont,view, addCont);
		System.out.println("PLUS CLICKED");
	}
	
	
	
	@Override
	public void notificationClick(KidViewController kidView, String view, Object cont) {
		Main.openNotifications(kidView, view, new NotificationsController());
	}
	
	
	
}
