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
	static Stage terciaryStage;

	public static Stage plusStage;
	public static Stage tableItemStage;
	public static Stage giftOrAllowanceStage;
	public static Stage notificationStage;

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
	 * this method is responsible for opening the notifications.
	 * @param FXMLTabLink
	 * @param cont
	 */
	public static void openNotifications(String FXMLTabLink, Object cont) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLTabLink));
			loader.setController(cont);
			Pane root = loader.load();
			scene = new Scene(root);

			notificationStage = new Stage();
			notificationStage.initOwner(primaryStage);
			notificationStage.initModality(Modality.APPLICATION_MODAL);
			notificationStage.setScene(scene);
			notificationStage.showAndWait();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
/**
 * 
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


			tableItemStage = new Stage();
			tableItemStage.initOwner(primaryStage);
			tableItemStage.initModality(Modality.APPLICATION_MODAL);
			tableItemStage.setScene(scene);
			tableItemStage.showAndWait();
			kidView.refreshKids();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void openGiftOrAllowance(KidTableItemController itemKid, Kid kid, String FXMLLink,  Object cont) {
		try {

			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLLink));
			loader.setController(cont);

			Pane root = loader.load();	
			scene = new Scene(root);


			giftOrAllowanceStage = new Stage();
			giftOrAllowanceStage.initOwner(primaryStage);
			giftOrAllowanceStage.initModality(Modality.APPLICATION_MODAL);
			giftOrAllowanceStage.setScene(scene);
			giftOrAllowanceStage.showAndWait();
			itemKid.updateKidInfo();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
/**
 * this method opens all the adding windows for 
 * @param FXMLPlusLink
 * @param cont
 */
	public static void openPlus(String FXMLPlusLink, Object cont, KidViewController kvc, TaskViewController tvc, RewardViewController rvc, ParentViewController pvc) {
		try {

			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLPlusLink));
			loader.setController(cont);
			Pane root = loader.load();	
			scene = new Scene(root);

			plusStage = new Stage();
			plusStage.initOwner(primaryStage);
			plusStage.initModality(Modality.APPLICATION_MODAL);
			plusStage.setScene(scene);
			plusStage.showAndWait();
			kvc.refreshKids();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}


}

