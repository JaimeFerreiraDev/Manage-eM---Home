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
/**
 * This class is a controller to the "Add Kid window" that pops up when the user clicks in the plus button in the kid tab, managed
 * <p> by the {@link pt.iade.ManageeMHome.controllers.KidViewController.java} class.
 * <p>The add "Add Kid window" is in this fxml file: {@link pt.iade.ManageeMHome.views#addKidView.fxml}.
 * @author jaime
 *
 */
public class AddKidController {
	@FXML
	private TextField codeField;
	/**
	 * This method adds a kid to the kid table, by checking if the code the user wrote in the
	 * <p>{@link #codeField} matches any ID that is currently in the database.
	 */
	@FXML
	public void addButtonOnClick() {
		
		if(!codeField.getText().isEmpty()){
	
			int parent = 0;

			String sql = "Insert into Family_Relation(kid, parent) values (?,?)";
			try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
				System.out.println("entrei aqui");

				stat.setInt(1,Integer.valueOf(codeField.getText()));
				parent = PersonDAO.getLoggedParent().getId();
				stat.setInt(2,parent);
				stat.execute();
				
				PreparedStatement stmt = JDBC.getCon().prepareStatement(" UPDATE Kid SET FirstTime = false WHERE id_Kid = (SELECT kid FROM" + 
						" Family_Relation WHERE Family_Relation.parent = ? and Family_Relation.kid = Kid.id_Kid);");
				stmt.setInt(1,parent);
				stmt.execute();
				Main.secondaryStage.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}





	}
	/**
	 * This method closes the window.
	 */
	@FXML
	public void cancelButtonOnClick() {
		Main.secondaryStage.close();
	}	

	@FXML
	public void initialize(){
		
	}
}

