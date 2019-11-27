package pt.iade.ManageeMHome.controllers;


import java.util.ArrayList;

import com.jfoenix.controls.JFXSlider;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;

public class AddTaskController {

	@FXML
	private TextField nameField;

	@FXML
	private JFXSlider pointsSilder;

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
	private ComboBox<Kid> kidComboBox;
	private ObservableList<Kid> selectedKids= FXCollections.observableArrayList();
	
	ObservableList<Kid> kidOList = FXCollections.observableArrayList();
	@FXML
	public void addButtonOnClick() {


	
		TaskDAO.getTaskList().add(new Task(nameField.getText(), (int)pointsSilder.getValue(), descriptionArea.getText(), selectedKids, false));
		Main.plusStage.close();
		

	}
	
	@FXML
	public void cancelButtonOnClick() {

		Main.plusStage.close();

	}
	@FXML
	public void addKidButtonClick() {
		selectedKids.add(kidComboBox.getSelectionModel().getSelectedItem());
		kidOList.remove(kidComboBox.getSelectionModel().getSelectedItem());
		kidComboBox.setItems(kidOList);
	}

	@FXML
	public void initialize() {
		ToggleGroup frequency = new ToggleGroup();
		radioOneTime.setToggleGroup(frequency);
		radioWeekly.setToggleGroup(frequency);
		radioDaily.setToggleGroup(frequency);
		radioMonthly.setToggleGroup(frequency);
		for(Kid kid: PersonDAO.getKidList()) {
			kidOList.add(kid);
		}
		kidComboBox.setItems(kidOList);
		
	}

	public TextField getNameField() {
		return nameField;
	}

	public TextArea getDescriptionField() {
		return descriptionArea;
	}


}
