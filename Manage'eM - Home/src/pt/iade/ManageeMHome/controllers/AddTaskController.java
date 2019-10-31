package pt.iade.ManageeMHome.controllers;


import com.jfoenix.controls.JFXSlider;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;
import pt.iade.ManageeMHome.models.task.Task;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
	private TextField descriptionField;



	@FXML
	public void addButtonOnClick() {


		int intSlider= (int)pointsSilder.getValue();
		TaskDAO.getTaskList().add(new Task(nameField.getText(), intSlider, descriptionField.getText()));
		Main.plusStage.close();

	}
	
	@FXML
	public void cancelButtonOnClick() {

		Main.plusStage.close();

	}

	@FXML
	public void initialize() {
		ToggleGroup frequency = new ToggleGroup();
		radioOneTime.setToggleGroup(frequency);
		radioWeekly.setToggleGroup(frequency);
		radioDaily.setToggleGroup(frequency);
		radioMonthly.setToggleGroup(frequency);
	}

	public TextField getNameField() {
		return nameField;
	}

	public TextField getDescriptionField() {
		return descriptionField;
	}


}
