package pt.iade.ManageeMHome.controllers.Parent;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXSlider;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Reward;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.KidDAO;
import pt.iade.ManageeMHome.models.DAO.RewardDAO;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;
/**
 * This class is a controller to the "Add Reward window" that pops up when the user clicks in the plus button in the Reward tab, managed
 * <p> by the {@link pt.iade.ManageeMHome.controllers.Parent.RewardViewController} class.
 * <p>The add Reward window is in this fxml file: {@link pt.iade.ManageeMHome.views#addRewardView.fxml}.
 * @author jaime
 *
 */
public class AddRewardController {
	@FXML
	public  TextField nameField;
	@FXML
	public  JFXSlider slider;
	@FXML
	private Label errorLabel;
	@FXML
	private ComboBox<Kid> kidComboBox;
	@FXML
	private ListView<Kid> listView;
	/**
	 * This method adds a reward to the reward table
	 */
	@FXML
	public void createButtonOnClick() throws IOException{
		if(!nameField.getText().isEmpty()) {
			nameField.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
			
			
			RewardDAO.addRewardBD((int)slider.getValue(), nameField.getText(), selectedKids);
			
			
			Main.secondaryStage.close();
		} else {
			errorLabel.setText("Please insert a reward name");
			nameField.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");
		}
}
	
@FXML
public void cancelButtonOnClick() {
	Main.secondaryStage.close();
}	

@FXML
public void addKidButtonClick() {
	
	selectedKids.add(kidComboBox.getSelectionModel().getSelectedItem());
	
	notSelectedKids.remove(kidComboBox.getSelectionModel().getSelectedItem());
	kidComboBox.setItems(notSelectedKids);
	listView.setItems(selectedKids);
}

private ObservableList<Kid> notSelectedKids  = FXCollections.observableArrayList();
private ObservableList<Kid> selectedKids  = FXCollections.observableArrayList();

public void initialize() {
	notSelectedKids=KidDAO.getKidsBD();
	kidComboBox.setItems(notSelectedKids);
}
}
