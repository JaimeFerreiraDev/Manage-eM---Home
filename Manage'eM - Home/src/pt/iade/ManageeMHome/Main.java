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
	public static Stage primaryStage;
	static Stage terciaryStage;
	
	public static Stage plusStage;

	@Override
	public void start(Stage primaryStage) throws IOException {

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
            System.out.println(e);
        }}
	public static void openLogin() throws IOException {
		try {
			Pane root = FXMLLoader.load(Main.class.getResource("views/LoginView.fxml"));

			scene = new Scene(root);
			primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			System.out.println(e);	
		}
	}

	public static void changeTab(String FXMLTabLink) {
		try {
			Pane root = FXMLLoader.load(Main.class.getResource(FXMLTabLink));
			scene = new Scene(root);
			secondaryStage.setScene(scene);
			secondaryStage.show();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void openPlus(String FXMLPlusLink) {
		try {
			Pane root = FXMLLoader.load(Main.class.getResource(FXMLPlusLink));	
			scene = new Scene(root);

			plusStage = new Stage();
			plusStage.setScene(scene);
			plusStage.show();


		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public static void main(String[] args) {
		launch(args);
	}

}
