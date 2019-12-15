package pt.iade.ManageeMHome;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.iade.ManageeMHome.controllers.KidTableItemController;
import pt.iade.ManageeMHome.controllers.KidViewController;
import pt.iade.ManageeMHome.controllers.ParentViewController;
import pt.iade.ManageeMHome.controllers.RewardViewController;
import pt.iade.ManageeMHome.controllers.TaskViewController;
import pt.iade.ManageeMHome.models.Kid;
/**
 * This is the class responsible for managing the windows in the project.
 * @author jaime
 *
 */
public class Main extends Application {
	static Scene scene;
	public static Stage primaryStage;
	public static Stage secondaryStage;
	static Stage terciaryStage;
	public static int counter=0;
	public static int kcounter=0;
	/**
	 * This method starts the program by opening the login window
	 * {@link #openLogin()}
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		openLogin();

	}
	/**
	 * This method is responsible for changing the scene betweenkids,parents to tasks and rewards
	 * @param FXMLTabLink is the fxml link 
	 * @param cont is the controller for the window that is oppened
	 */
	public static void changeTab(String FXMLTabLink, Object cont) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLTabLink));
			loader.setController(cont);
			Pane root = loader.load();
			scene = new Scene(root);
			if(counter<1) {
				primaryStage = new Stage();
				counter++;
			}

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * This method opens the 1st window of the program: the login window
	 * @throws IOException
	 */
	public static void openLogin() throws IOException {
		try {
			Pane root = FXMLLoader.load(Main.class.getResource("views/LoginView.fxml"));

			scene = new Scene(root);
			primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is responsible for opening the notifications's tab, which is reachable from
	 * <p>any of the tabs: kid, parent, task, reward.
	 * @param FXMLTabLink
	 * @param cont
	 */
	public static void openNotifications(String FXMLTabLink, Object cont) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLTabLink));
			loader.setController(cont);
			Pane root = loader.load();
			scene = new Scene(root);

			secondaryStage = new Stage();
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.APPLICATION_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.showAndWait();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
/**
 * This method is used to open table views's items respective windows, for all the tabs: kid, parent, task and reward.
 * @param kidView
 * @param FXMLItemLink
 * @param cont
 */
	public static void openTableItem(KidViewController kidView,String FXMLItemLink, KidTableItemController cont) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLItemLink));
			loader.setController(cont);

			Pane root = loader.load();	
			scene = new Scene(root);


			secondaryStage = new Stage();
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.APPLICATION_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.showAndWait();
			kidView.updateKidInfo();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
/**
 * @param itemKid
 * @param kid
 * @param FXMLLink
 * @param cont
 */
	public static void openGiftOrAllowance(KidTableItemController itemKid, Kid kid, String FXMLLink,  Object cont) {
		try {

			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLLink));
			loader.setController(cont);

			Pane root = loader.load();	
			scene = new Scene(root);


			terciaryStage = new Stage();
			terciaryStage.initOwner(primaryStage);
			terciaryStage.initModality(Modality.APPLICATION_MODAL);
			terciaryStage.setScene(scene);
			terciaryStage.showAndWait();
			itemKid.updateKidInfo();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
/**
 * this method opens all the adding windows for all the tabs: kid, parent, task and reward.
 * @param FXMLPlusLink
 * @param cont
 */
	public static void openPlus(KidViewController kidController,TaskViewController taskController,
			RewardViewController rewardController, ParentViewController parentController, String FXMLPlusLink, Object cont) {
		try {

			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLPlusLink));
			loader.setController(cont);
			Pane root = loader.load();	
			scene = new Scene(root);

			secondaryStage = new Stage();
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.APPLICATION_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.showAndWait();
			
			if(kidController != null)
			kidController.updateKidInfo();
			else if (taskController!=null )taskController.updateTaskInfo();
			else if (rewardController!=null )rewardController.updateRewardInfo();
			else if (parentController!=null )parentController.updateParentInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}


}

