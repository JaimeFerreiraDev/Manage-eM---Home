package pt.iade.ManageeMHome.controllers;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jfoenix.controls.JFXSlider;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

	ToggleGroup frequency = new ToggleGroup();

	@FXML
	private ComboBox<Kid> kidComboBox;
	private ObservableList<Kid> selectedKids= FXCollections.observableArrayList();

	ObservableList<Kid> kidOList = FXCollections.observableArrayList();
	@FXML
	public void addButtonOnClick() {

		if(!nameField.getText().isEmpty() 
				&& !frequency.getToggles().isEmpty()
				&& String.valueOf(pointsSlider) != null) {
			//			nameField.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");
			//			pointsSilder.setStyle("-fx-effect:dropshadow(three-pass-box, rgba(0,0,0,0), 10, 0, 0, 0)");

			String sql ="insert into Task (name, pts_Task, frequency_type, duration, description) values(?,?,?,?,?);";
			try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){	
				int intSlider= (int)pointsSlider.getValue();
				stat.setString(1,nameField.getText());
				stat.setInt(2, intSlider);
				stat.setString(3,String.valueOf(frequency.toString()));
				stat.setInt(4, 1000);
				stat.setString(5, "descricao teste");
				stat.execute();
				System.out.println(stat.toString());
			}catch (SQLException e) {
				e.printStackTrace();	
			}


			Main.plusStage.close();
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

		Main.plusStage.close();

	}
	@FXML
	public void addKidButtonClick() {
		selectedKids.add(kidComboBox.getSelectionModel().getSelectedItem());
		kidOList.remove(kidComboBox.getSelectionModel().getSelectedItem());
		kidComboBox.setItems(kidOList);
		System.out.println(selectedKids);
	}

	@FXML
	public void initialize() {

		radioOneTime.setToggleGroup(frequency);
		radioWeekly.setToggleGroup(frequency);
		radioDaily.setToggleGroup(frequency);
		radioMonthly.setToggleGroup(frequency);
		for(Kid kid: PersonDAO.getLoggedParent().getKids()) {
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
