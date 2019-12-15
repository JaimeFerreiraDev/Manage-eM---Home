package pt.iade.ManageeMHome.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
/**
 * This class is in early stages.
 * @author jaime
 *
 */
public class TaskTableItemController {

	@FXML
	private Text taskTableItemName;

	@FXML
	private Text taskTableDescription;
	
	private String taskTableItemNameAux;
	private String taskTableDescriptionAux;

	
	public void setTaskTableItemNameAux(String taskTableItemNameAux) {
		this.taskTableItemNameAux = taskTableItemNameAux;
	}

	public void setTaskTableDescriptionAux(String taskTableDescriptionAux) {
		this.taskTableDescriptionAux = taskTableDescriptionAux;
	}





	public void initialize(){
//		System.out.println("teste tasktableitem");
//
//		taskTableItemName.setText(Task.getName.toString()); 
//		System.out.println(taskTableItemName.toString());
//		taskTableDescription.setText(Task.getName.toString()); 
//		System.out.println(taskTableDescription.toString());

		
	}
}