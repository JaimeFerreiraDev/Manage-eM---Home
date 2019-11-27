package pt.iade.ManageeMHome.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Task;



public class NotificationsController {


		@FXML
		private TableView<Task> notificationTV;

		@FXML
		private TableColumn<String, Task> taskColumn;

		@FXML
		private TableColumn<String, Kid> kidColumnN;

		@FXML
		private TableColumn<Boolean, Button> noColumn;
		
		@FXML
		private TableColumn<Boolean, Button> yesColumn;

		@FXML
		private void initialize() {

			taskColumn.setCellValueFactory(new PropertyValueFactory<String, Task>("name"));
			kidColumnN.setCellValueFactory(new PropertyValueFactory<String, Kid>("name"));
			System.out.println("HERE");
			noColumn.setCellFactory((tableCol)-> {
				return new TableCell<Boolean, Button> ()  {
					@Override
					protected void updateItem(Button b1, boolean empty) {
						super.updateItem(b1, empty);
						if(!empty){
							Button button = new Button("NO");
							button.setOnAction((event) -> {

							});
							setGraphic(button);
						} else  {
							setGraphic(null);

						}}
					
				}; 
			});
			yesColumn.setCellFactory((tableCol)-> {
				return new TableCell<Boolean, Button> ()  {
					@Override
					protected void updateItem(Button b1, boolean empty) {
						super.updateItem(b1, empty);
						if(!empty){
							Button button = new Button("YES");
							button.setOnAction((event) -> {

							});
							setGraphic(button);
						} else  {
							setGraphic(null);

						}
					}   
				}; 
			});
			
		}
	}


