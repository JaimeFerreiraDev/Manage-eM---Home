package pt.iade.ManageeMHome.kidPOV.kcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;


public class K1stTimeController {
	@FXML
	private Label codeLabel;
	@FXML
	private void connectClick() {
		for(Parent parent : PersonDAO.getParentList()) {
			for(Kid kid : parent.getKids()) {
				if(kid==PersonDAO.getLoggedKid()) {
					PersonDAO.getLoggedKid().getParents().add(parent);
					Main.changeTab("kidPOV/kviews/ktaskView.fxml", new KtaskController());
					Main.secondaryStage.close();
				}
			}

		}
	}
	private double randomCode;
	@FXML
	private void initialize() {
		codeLabel.setText(PersonDAO.getLoggedKid().getCode());


	}
}
