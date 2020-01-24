package pt.iade.ManageeMHome.controllers.Parent;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.KidDAO;

public interface ITab {

	String kidView = "views/Parent/kidView.fxml";
	String parentView = "views/Parent/parentView.fxml";
	String rewardView = "views/Parent/rewardView.fxml";
	String taskView = "views/Parent/taskView.fxml";
	String add_kidView = "views/Parent/addKidView.fxml";
	String add_parentView = "views/Parent/addParentView.fxml";
	String add_rewardView = "views/Parent/addRewardView.fxml";
	String add_taskView = "views/Parent/addTaskView.fxml";
	String notif_view = "views/Parent/notificationsView.fxml";

	public void onParentButtonClicked();
	
	public void onKidButtonClicked();
	
	public void onTaskButtonClicked();
	
	public void onRewardButtonClicked();
	
	public void notificationClick();
	
	public void onPlusButtonClicked();

	public void updateTableInfo();


	
}
