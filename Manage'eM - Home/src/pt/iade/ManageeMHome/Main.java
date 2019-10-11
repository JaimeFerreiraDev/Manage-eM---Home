package pt.iade.ManageeMHome;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
static Scene scene;
static Stage secondaryStage;
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
public static void main(String[] args) {
	launch(args);
}

}
