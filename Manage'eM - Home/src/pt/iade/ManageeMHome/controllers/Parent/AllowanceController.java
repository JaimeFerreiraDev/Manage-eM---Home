package pt.iade.ManageeMHome.controllers.Parent;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSlider;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
/**
 * This class is not complete.
 * <p>It is a controller to the "allowance window" that hasn't been implemented yet.
 * <p>The "allowance window" is in this fxml file: {@link pt.iade.ManageeMHome.views#addKidView.fxml}.
 * @author jaime
 *
 */
public class AllowanceController {

@FXML
private Label kidNameLabel;
@FXML
private JFXSlider slider;
@FXML
private JFXDatePicker date;
private Kid kid;

public AllowanceController(Kid kid) {
	this.kid=kid;
}
/**
 * This method is not complete yet.
 */
@FXML
private void okButtonClick() {
	System.out.println(date.getValue());
	Main.secondaryStage.close();
}
/**
 * This method closes the window.
 */
@FXML
private void cancelButtonClick() {
	
	Main.secondaryStage.close();
	
}
public void initialize() {
	
}
}
