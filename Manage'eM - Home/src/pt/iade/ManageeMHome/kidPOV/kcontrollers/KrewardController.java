package pt.iade.ManageeMHome.kidPOV.kcontrollers;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Reward;
import pt.iade.ManageeMHome.models.Task;
import pt.iade.ManageeMHome.models.DAO.JDBC;
import pt.iade.ManageeMHome.models.DAO.PersonDAO;
/**
 * This class is not functional yet.
 * This class is a controller to the "kid reward window".
 * <p>The "Kid 1st time login window" is in this fxml file: {@link pt.iade.ManageeMHome.kidPOV.kviews#krewardView.fxml}.
 * @author jaime
 *
 */
public class KrewardController {
	@FXML
	private void taskClick() {
		Main.changeTab("kidPOV/kviews/ktaskView.fxml", new KtaskController());
	}
	@FXML
	private TableView<Reward> taskTV;
	private ObservableList<Reward> rewards = FXCollections.observableArrayList();
	@FXML
	private TableColumn<String, Reward> nameColumn;

	@FXML
	private TableColumn<Integer, Reward> pointsColumn;

	@FXML
	private TableColumn<Boolean, Reward> getColumn;

	@FXML
	private void initialize() {
		updateKidPOVReward();
		nameColumn.setCellValueFactory(new PropertyValueFactory<String, Reward>("Name"));
		pointsColumn.setCellValueFactory(new PropertyValueFactory<Integer,  Reward>("Points"));
		getColumn.setCellFactory((tableCol)-> {
			return new TableCell<Boolean,  Reward> ()  {
				@Override
				protected void updateItem( Reward reward, boolean empty) {
					super.updateItem(reward, empty);
					if(!empty){
						Button button = new Button("GET");
						button.setOnAction((event) -> {
							//mandar notificação de reward ao pai

						});
						setGraphic(button);
					} else  {
						setGraphic(null);

					}
				}   
			}; 
		});
		
	}
	private void updateKidPOVReward(){
		
	}
}
