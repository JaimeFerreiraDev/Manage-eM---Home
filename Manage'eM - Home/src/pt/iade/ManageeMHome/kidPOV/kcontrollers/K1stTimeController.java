package pt.iade.ManageeMHome.kidPOV.kcontrollers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;


public class K1stTimeController {
	@FXML
	private Label codeLabel;
	@FXML
	private void connectClick() {
		////		for(Parent parent : PersonDAO.getParentList()) {
		////			for(Kid kid : parent.getKids()) {
		////				if(kid==PersonDAO.getLoggedKid()) {
		////					PersonDAO.getLoggedKid().getParents().add(parent);
		////					Main.changeTab("kidPOV/kviews/ktaskView.fxml", new KtaskController());
		////					Main.secondaryStage.close();
		////				}
		////			}
		//
		//		}

	}
	private double randomCode;
	@FXML
	private void initialize() {
		Connection conn= JDBC.getCon(); 
		int id = 0;
		String sql = "select id_User from User, Password where User.id_User = ?";
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			id = PersonDAO.getLoggedKid().getId();
			stat.setInt(1,id);
			stat.execute();		
			System.out.println(stat);
			codeLabel.setText(""+id);
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}
}
