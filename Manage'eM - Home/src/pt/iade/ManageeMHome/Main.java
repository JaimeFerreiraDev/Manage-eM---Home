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
import pt.iade.ManageeMHome.models.Kid;

public class Main extends Application {
	static Scene scene;
	public static Stage secondaryStage;
	public static Stage primaryStage;
	static Stage terciaryStage;

	public static Stage plusStage;
	public static Stage tableItemStage;
	public static Stage giftOrAllowanceStage;
	public static Stage notificationStage;

	public static int counter=0;
	public static int kcounter=0;

	@Override
	public void start(Stage primaryStage) throws IOException {
		openLogin();

	}
	
	public static void changeTab(String FXMLTabLink, Object cont) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLTabLink));
			loader.setController(cont);
			Pane root = loader.load();
			scene = new Scene(root);
			if(counter<1) {
				secondaryStage = new Stage();
				counter++;
			}
			secondaryStage.setScene(scene);
			secondaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//This method allows the counter to be reset
	public static void setCounter(int counter) {
		Main.counter = counter;
	}
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

	public static void openNotifications(String FXMLTabLink, Object cont) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLTabLink));
			loader.setController(cont);
			Pane root = loader.load();
			scene = new Scene(root);

			notificationStage = new Stage();
			notificationStage.initOwner(secondaryStage);
			notificationStage.initModality(Modality.APPLICATION_MODAL);
			notificationStage.setScene(scene);
			notificationStage.showAndWait();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void openTableItem(KidViewController kidView,String FXMLItemLink, KidTableItemController cont) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLItemLink));
			loader.setController(cont);

			Pane root = loader.load();	
			scene = new Scene(root);


			tableItemStage = new Stage();
			tableItemStage.initOwner(secondaryStage);
			tableItemStage.initModality(Modality.APPLICATION_MODAL);
			tableItemStage.setScene(scene);
			tableItemStage.showAndWait();
			kidView.updateKidInfo();
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
			giftOrAllowanceStage.initOwner(secondaryStage);
			giftOrAllowanceStage.initModality(Modality.APPLICATION_MODAL);
			giftOrAllowanceStage.setScene(scene);
			giftOrAllowanceStage.showAndWait();
			itemKid.updateKidInfo();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void openPlus(String FXMLPlusLink, Object cont) {
		try {

			FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXMLPlusLink));
			loader.setController(cont);
			Pane root = loader.load();	
			scene = new Scene(root);

			plusStage = new Stage();
			plusStage.initOwner(secondaryStage);
			plusStage.initModality(Modality.APPLICATION_MODAL);
			plusStage.setScene(scene);
			plusStage.showAndWait();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}


}

