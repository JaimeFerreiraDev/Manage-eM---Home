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
import pt.iade.ManageeMHome.models.DAO.KidDAO;
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
	private TableView<Reward> rewardTV;
	private ObservableList<Reward> rewards = FXCollections.observableArrayList();
	@FXML
	private TableColumn<String, Reward> nameColumn;

	@FXML
	private TableColumn<Integer, Reward> pointsColumn;

	@FXML
	private TableColumn<Boolean, Reward> getColumn;
	private Reward selectedItem;
	private int kid, points, id_reward = 0;
	@FXML
	private void initialize() {
		kid = PersonDAO.getLoggedKid().getId();
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
							 rewardTV.getSelectionModel().select(getTableRow().getIndex());
                             
							points = rewardTV.getSelectionModel().getSelectedItem().getPoints();
							id_reward = rewardTV.getSelectionModel().getSelectedItem().getId();
							System.out.println("é isto: " +points);
							//mandar notificação de reward ao pai
							KidDAO.buyReward(points, kid,id_reward);
						});
						setGraphic(button);
					} else  {
						setGraphic(null);

					}
				}   
			}; 
		});
	
	}
	public void updateKidPOVReward(){
		rewardTV.setItems(KidDAO.updateKidPOVRewardBD(kid));
	}
}
