package pt.iade.ManageeMHome.models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.Reward;

public class RewardDAO {
public static ObservableList<Reward> rewardList = FXCollections.observableArrayList();
	
	public static ObservableList<Reward> getRewardList() {
		return rewardList;
	}

	static {}
}
