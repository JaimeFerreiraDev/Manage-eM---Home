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
import javafx.stage.Stage;

public class Main extends Application {
static Scene scene;
static Stage secondaryStage;
static Stage kidPlusStage;

static Stage terciaryStage;



	@Override
	public void start(Stage primaryStage) throws IOException {

		Pane root = FXMLLoader.load(getClass().getResource("views/LoginView.fxml"));
		
		scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
public static void openMenu() throws IOException {
	try {
		
		Pane root = FXMLLoader.load(Main.class.getResource("views/kidView.fxml"));
		
		scene = new Scene(root);
		secondaryStage = new Stage();
		secondaryStage.setScene(scene);
		secondaryStage.show();
		} catch(Exception e) {
		System.out.println(e);
		}
	
}
// TESTE1
public static void openKid() {
	try {
	Pane root = FXMLLoader.load(Main.class.getResource("views/kidView.fxml"));
	scene = new Scene(root);
	secondaryStage.setScene(scene);
	secondaryStage.show();
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
}

public static void openParent() {
	try {
	Pane root = FXMLLoader.load(Main.class.getResource("views/parentView.fxml"));
	scene = new Scene(root);
	secondaryStage.setScene(scene);
	secondaryStage.show();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	
}

public static void openTask() {
	try {
	Pane root = FXMLLoader.load(Main.class.getResource("views/taskView.fxml"));
	scene = new Scene(root);
	secondaryStage.setScene(scene);
	secondaryStage.show();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	
}

public static void openReward() {
	try {
	Pane root = FXMLLoader.load(Main.class.getResource("views/rewardView.fxml"));
	scene = new Scene(root);
	secondaryStage.setScene(scene);
	secondaryStage.show();
	
	} catch (Exception e) {
		System.out.println(e);
	}
	
}

public static void openPlus() {
	try {
	Pane root = FXMLLoader.load(Main.class.getResource("views/addKidView.fxml"));
	scene = new Scene(root);
	kidPlusStage = new Stage();
	kidPlusStage.setScene(scene);
	kidPlusStage.show();

	} catch (Exception e) {
		System.out.println(e);
	}
	
}

public static void main(String[] args) {
	launch(args);
}

}
