package pt.iade.ManageeMHome.models.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RewardDAO {
public static void addRewardBD(int sliderValue, String rewardName) {
	String sql ="insert into Reward (name, pts_required) values(?,?);";
	try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){	
		int intSlider= sliderValue;
		stat.setString(1,rewardName);
		stat.setInt(2, intSlider);
		stat.execute();
		System.out.println(stat.toString());
	}catch (SQLException e) {
		e.printStackTrace();	
	}
}
}
