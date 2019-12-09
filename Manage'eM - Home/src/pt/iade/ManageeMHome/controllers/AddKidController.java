package pt.iade.ManageeMHome.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;

public class AddKidController {
	@FXML
	private TextField codeField;

	@FXML
	public void addButtonOnClick() {

		if(!codeField.getText().isEmpty()){
			Connection conn= JDBC.getCon(); 
			int parent = 0;
			int kid = 0;
			String sql = "Insert into Family_Relation(kid, parent) values (?,?)";
			try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
				System.out.println("entrei aqui");
			
				stat.setInt(1,Integer.valueOf(codeField.getText()));
				parent = PersonDAO.getLoggedParent().getId();
				stat.setInt(2,parent);
				stat.execute();		
				Main.plusStage.close();
				KidViewController.updateKidInfo();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}


		


	}
	@FXML
	public void cancelButtonOnClick() {
		Main.plusStage.close();
	}	

	@FXML
	public void initialize(){

	}
}

