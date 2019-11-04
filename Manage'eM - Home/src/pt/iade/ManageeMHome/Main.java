package pt.iade.ManageeMHome;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.iade.ManageeMHome.controllers.giftKidController;
import pt.iade.ManageeMHome.controllers.kidTableItemController;
import pt.iade.ManageeMHome.models.kid.Kid;

public class Main extends Application {
	static Scene scene;
	static Stage secondaryStage;
	public static Stage primaryStage;
	static Stage terciaryStage;

	public static Stage plusStage;
	public static Stage tableItemStage;
	public static Stage giftStage;




	private static float startTime;
	private static float currentTime;
	private int age;

	@Override
	public void start(Stage primaryStage) throws IOException {
		startTime = System.currentTimeMillis();
		openLogin();


	}
	public static void openMenu() throws IOException {
		try {

			Pane root = FXMLLoader.load(Main.class.getResource("views/kidView.fxml"));

			scene = new Scene(root);
			secondaryStage = new Stage();
			secondaryStage.setScene(scene);
			secondaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}}
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

	public static void changeTab(String FXMLTabLink) {
		try {
			Pane root = FXMLLoader.load(Main.class.getResource(FXMLTabLink));
			scene = new Scene(root);
			secondaryStage.setScene(scene);
			secondaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void openPlus(String FXMLPlusLink) {
		try {
			Pane root = FXMLLoader.load(Main.class.getResource(FXMLPlusLink));	
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
	
	public static void openKidTableItem(Kid kid) {
		try {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/kidTableItem.fxml"));
		loader.setController(new kidTableItemController(kid));
			
		Pane root = loader.load();	
		scene = new Scene(root);
		
		
		tableItemStage = new Stage();
		tableItemStage.initOwner(secondaryStage);
		tableItemStage.initModality(Modality.APPLICATION_MODAL);
		tableItemStage.setScene(scene);
		tableItemStage.showAndWait();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void openGift(kidTableItemController itemKid, Kid kid) {
		try {
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/giftKidView.fxml"));
		giftKidController cont =new giftKidController(kid); 
		loader.setController(cont);
			
		Pane root = loader.load();	
		scene = new Scene(root);
		
		
		giftStage = new Stage();
		giftStage.initOwner(secondaryStage);
		giftStage.initModality(Modality.APPLICATION_MODAL);
		giftStage.setScene(scene);
		giftStage.showAndWait();
		itemKid.updateKidInfo();
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void updateKidTableItem(Kid kid) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("views/kidTableItem.fxml"));
			loader.setController(new kidTableItemController(kid));
				
			Pane root = loader.load();	
			scene = new Scene(root);
			
			tableItemStage.setScene(scene);
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
//	public static void openTableItem() {
//		try {
//			Pane root = FXMLLoader.load(Main.class.getResource());	
//			scene = new Scene(root);
//
//			tableItemStage = new Stage();
//			tableItemStage.initOwner(secondaryStage);
//			tableItemStage.initModality(Modality.APPLICATION_MODAL);
//			tableItemStage.setScene(scene);
//			tableItemStage.showAndWait();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	
	public static void main(String[] args) {
		launch(args);
	}

}

