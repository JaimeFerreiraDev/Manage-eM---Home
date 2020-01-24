package pt.iade.ManageeMHome;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.iade.ManageeMHome.controllers.LoginViewController;
import pt.iade.ManageeMHome.controllers.Parent.ITab;
import pt.iade.ManageeMHome.controllers.Parent.KidTableItemController;
import pt.iade.ManageeMHome.controllers.Parent.KidViewController;
import pt.iade.ManageeMHome.controllers.Parent.NotificationsController;
import pt.iade.ManageeMHome.controllers.Parent.ParentViewController;
import pt.iade.ManageeMHome.controllers.Parent.RewardViewController;
import pt.iade.ManageeMHome.controllers.Parent.TaskViewController;
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
	public static Stage terciaryStage;
	public static int counter=0;
	public static int kcounter=0;
	/**
	 * This method starts the program by opening the login window
	 * {@link #openLogin()}
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		changeTab("views/LoginView.fxml", new LoginViewController());
	}
	/**
	 * This method is responsible for changing the scene between kids,parents to tasks and rewards
	 * <p>the {@link #counter} is there to make sure a new stage is only created the 1st time, so we 
	 * <p>wouldn't have to create a similar method just for when the program starts.
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
 * this method is responsible for opening the notifications's tab, which is reachable from
 * <p>any of the tabs: kid, parent, task, reward.
 * <p>This method is used to open table views's items respective windows, for all the tabs: kid, parent, task and reward.
 * @param kidView
 * @param FXMLItemLink
 * @param cont
 */
	public static void openTableItemAndNotif(KidViewController kidView,String FXMLItemLink, Object cont) {
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
			if(kidView!=null) kidView.updateTableInfo();
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
			itemKid.updateTableKidInfo();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
/**
 * This method opens all the adding windows for all the tabs: kid, parent, task and reward.
 * @param FXMLPlusLink
 * @param viewController this parameter is used to call the {@link pt.iade.ManageeMHome.controllers.Parent.Itab}
 * @param addController
 */
	public static void openPlus(ITab viewController , String FXMLPlusLink, Object addController) {
		try {

			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLPlusLink));
			loader.setController(addController);
			Pane root = loader.load();	
			scene = new Scene(root);
	
			secondaryStage = new Stage();
			secondaryStage.initOwner(primaryStage);
			secondaryStage.initModality(Modality.APPLICATION_MODAL);
			secondaryStage.setScene(scene);
			secondaryStage.showAndWait();		
			
			if(viewController != null)
				viewController.updateTableInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}


}

