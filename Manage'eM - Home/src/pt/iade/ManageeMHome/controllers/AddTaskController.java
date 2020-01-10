package pt.iade.ManageeMHome.controllers;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jfoenix.controls.JFXSlider;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;
/**
 * This class is a controller to the "Add task window" that pops up when the user clicks in the plus button in the task tab, managed
 * <p> by the {@link pt.iade.ManageeMHome.controllers.TaskViewController} class.
 * <p>The add Reward window is in this fxml file: {@link pt.iade.ManageeMHome.views#addTaskView.fxml}.
 * @author jaime
 *
 */
public class AddTaskController {

	@FXML
	private TextField nameField;

	@FXML
	private JFXSlider pointsSlider;

	@FXML
	private Label errorLabel;

	//	@FXML
	//	private JFXTimePicker timeStart;
	//
	//	@FXML
	//	private JFXTimePicker timeEnd;
	//
	@FXML
	private RadioButton radioOneTime;

	@FXML
	private RadioButton radioDaily;

	@FXML
	private RadioButton radioWeekly;

	@FXML
	private RadioButton radioMonthly;

	@FXML
	private TextArea descriptionArea;

	@FXML
	private Label freqLabel;
	
	@FXML
	private ListView<Kid> listView;

	ToggleGroup frequency = new ToggleGroup();

	private ObservableList<Kid> selectedKids= FXCollections.observableArrayList();
	private ObservableList<Kid> kids = FXCollections.observableArrayList();

	@FXML
	private ComboBox<Kid> kidComboBox;

	@FXML
	public void addButtonOnClick()  {
		int parent = 0;
		if(!nameField.getText().isEmpty() 
				&& !frequency.getToggles().isEmpty()
				&& String.valueOf(pointsSlider) != null
				&& selectedKids != null) {

			TaskDAO.addTaskBD((int)pointsSlider.getValue(), nameField.getText(), descriptionArea.getText(), selectedKids);
			System.out.println((int)pointsSlider.getValue());

			Main.secondaryStage.close();
		} else {
			if(nameField.getText().isEmpty()) {
				errorLabel.setText("Please insert an username");
			}else{ if(frequency.getToggles().isEmpty()) {
				errorLabel.setText("Please choose a frequency");
			}
			}

			if(nameField.getText().isEmpty()) {
				nameField.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");;
			}else{ if(frequency.getToggles().isEmpty()) {
				freqLabel.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(255,0,0,0.5), 10, 0, 0, 0)");;
			}
			}
		}
	}

	@FXML
	public void cancelButtonOnClick() {

		Main.secondaryStage.close();

	}
	
	ObservableList<Kid> notSelectedKids  = FXCollections.observableArrayList();
	@FXML
	public void addKidButtonClick() {
		
		selectedKids.add(kidComboBox.getSelectionModel().getSelectedItem());
		
		notSelectedKids.remove(kidComboBox.getSelectionModel().getSelectedItem());
		kidComboBox.setItems(notSelectedKids);
		listView.setItems(selectedKids);
	}

	@FXML
	public void initialize() {
		notSelectedKids=TaskDAO.getTaskKidsBD();
		radioOneTime.setToggleGroup(frequency);
		radioWeekly.setToggleGroup(frequency);
		radioDaily.setToggleGroup(frequency);
		radioMonthly.setToggleGroup(frequency);
		kidComboBox.setItems(notSelectedKids);


	}

	public TextField getNameField() {
		return nameField;
	}

	public TextArea getDescriptionField() {
		return descriptionArea;
	}

	public ObservableList<Kid> getKidList() {
		ObservableList<Kid> kidList = FXCollections.observableArrayList();


		return kidList;

	}

}
