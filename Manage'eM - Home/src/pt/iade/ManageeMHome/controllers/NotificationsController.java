package pt.iade.ManageeMHome.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
import pt.iade.ManageeMHome.models.DAO.TaskDAO;



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

		private ObservableList<Task> completedTasks= FXCollections.observableArrayList();
		
		private void findCompletedTasks() {
			for(Kid kid : PersonDAO.getLoggedParent().getKids()) {
				for(Task task:TaskDAO.getTaskList()) {   // kid.getTasks()
					if(task.isComplete()) {
						completedTasks.add(task);
					}
				}
			}
		}
		@FXML
		private void initialize() {
			
			findCompletedTasks();
			taskColumn.setCellValueFactory(new PropertyValueFactory<String, Task>("name"));
			kidColumnN.setCellValueFactory(new PropertyValueFactory<String, Kid>("name"));
			FXCollections.observableArrayList();
			notificationTV.setItems(completedTasks);
			noColumn.setCellFactory((tableCol)-> {
				return new TableCell<Boolean, Button> ()  {
					@Override
					protected void updateItem(Button b1, boolean empty) {
						super.updateItem(b1, empty);
						if(!empty){
							Button button = new Button("NO");
							button.setOnAction((event) -> {
							notificationTV.getSelectionModel().select(getTableRow().getIndex());
								Task  selectedItem 	=	notificationTV.getSelectionModel().getSelectedItem();
								for(Kid kid :  selectedItem.getKidArrayList()) {
                                    kid.setPoints(kid.getPoints()+selectedItem.getPoints());
                                }
								notificationTV.getItems().remove(selectedItem);
								selectedItem.setComplete(false);
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


