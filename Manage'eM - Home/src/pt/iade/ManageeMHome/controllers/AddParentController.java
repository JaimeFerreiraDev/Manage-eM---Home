package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pt.iade.ManageeMHome.Main;
/**
 * This class is a controller to the "Add Parent window" that pops up when the user clicks in the plus button in the parent tab, managed
 * <p> by the {@link pt.iade.ManageeMHome.controllers.ParentViewController} class.
 * <p>The "add parent window" is in this fxml file: {@link pt.iade.ManageeMHome.views#addParentView.fxml}.
 * @author jaime
 *
 */
public class AddParentController {
	@FXML
	private TextField nameField;
	/**
	 * This method is not complete.
	 */
	@FXML
	public void addButtonOnClick() {
		Main.secondaryStage.close();
		
	}
	/**
	 * This method just closes the window.
	 */
	@FXML
	public void cancelButtonOnClick() {
		Main.secondaryStage.close();
	}	
	@FXML
	public void initialize() {



	}
}




