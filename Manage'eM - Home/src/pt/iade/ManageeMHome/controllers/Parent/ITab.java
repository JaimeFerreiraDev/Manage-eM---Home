package pt.iade.ManageeMHome.controllers.Parent;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
/**
 * This class is an interface to hold the FXML strings and the shared methods between the tabs:
 * The controller's that implement this interface are:
 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.KidViewController}
 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.ParentViewController}
 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.TaskViewController}
 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.RewardViewController}
 * @author jaime
 *
 */
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

	/**
	 * This method is used by all the tab's controllers, to open the parent's tab.
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.KidViewController #onParentButtonClicked()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.TaskViewController #onParentButtonClicked()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.RewardViewController #onParentButtonClicked()}
	 */
	public static void onParentButtonClicked() {
		Main.changeTab( parentView, new ParentViewController());
		System.out.println("PARENTS CLICKED");
	}
	/**
	 * This method is used by all the other tab's controllers, to open the kid's tab.
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.ParentViewController #onKidButtonClicked()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.TaskViewController #onKidButtonClicked()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.RewardViewController #onKidButtonClicked()}
	 */
	public static void onKidButtonClicked() {
		Main.changeTab(kidView, new KidViewController());
		System.out.println("KIDS CLICKED");
	}
	/**
	 * This method is used by all the other tab's controllers, to open the task's tab.
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.KidViewController #onTaskButtonClicked()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.ParentViewController #onTaskButtonClicked()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.RewardViewController #onTaskButtonClicked()}
	 */
	public static void onTaskButtonClicked() {
		Main.changeTab(taskView, new TaskViewController());
		System.out.println("TASKS CLICKED");
	}
	/**
	 * This method is used by all the other tab's controllers, to open the reward's tab.
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.KidViewController #onRewardButtonClicked()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.ParentViewController #onRewardButtonClicked()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.TaskViewController #onRewardButtonClicked()}
	 */
	public static void onRewardButtonClicked(){
		Main.changeTab(rewardView, new RewardViewController());
		System.out.println("REWARDS CLICKED");
	}
	/**
	 * This method is used by all the tab's controllers, to open the notification's window.
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.KidViewController #notificationClick()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.ParentViewController #notificationClick()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.TaskViewController #notificationClick()}
	 * <p>{@link pt.iade.ManageeMHome.controllers.Parent.RewardViewController #notificationClick()}
	 */
	public static void notificationClick(){
		Main.openTableItemAndNotif(null,notif_view, new NotificationsController());
	}
	
	public void onPlusButtonClicked();

	public void updateTableInfo();


	
}
