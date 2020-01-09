package pt.iade.ManageeMHome.models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.Kid;

public class RewardDAO {
public static void addRewardBD(int sliderValue, String rewardName, ObservableList<Kid> selectedKids) {
	System.out.println("entrei addreward");
	String sql ="insert into Reward (name, pts_required) values(?,?);";
	try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){	
		int intSlider= sliderValue;
		stat.setString(1,rewardName);
		stat.setInt(2, intSlider);
		stat.execute();
		System.out.println(stat.toString());
		ResultSet rs = stat.getGeneratedKeys();
		
		rs.next();
		int id_Reward = rs.getInt(1);
		for (Kid kid : selectedKids) {
		PreparedStatement stmt =JDBC.getCon().prepareStatement("insert into Kids_Reward (kid, reward)"
				+ " values(?,?);");

		stmt.setInt(1, kid.getId());
		stmt.setInt(2, id_Reward);
		stmt.execute();
		PreparedStatement stment =JDBC.getCon().prepareStatement("insert into Parents_Reward (parent, reward)"
				+ " values(?,?);");
		int parent = 0;
		parent = PersonDAO.getLoggedParent().getId();
		stment.setInt(1, parent);
		stment.setInt(2, id_Reward);
		stment.execute();
		}
	}catch (SQLException e) {
		e.printStackTrace();	
	}

	
}

public static ObservableList<Kid> getRewardsBD() {
		ObservableList<Kid> kids  = FXCollections.observableArrayList();
		int parent = 0;
		String sql ="Select * from Family_Relation, Kid, User where parent = ? and kid = id_Kid and id_Kid = id_User;";
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			parent = PersonDAO.getLoggedParent().getId();
			stat.setInt(1, parent);
			System.out.println(stat);
			ResultSet rs = stat.executeQuery();	

			while(rs.next()) {
				kids.add(new Kid(
						rs.getString("name"), 
						rs.getInt("age"), 
						rs.getInt("id_Kid"),
						rs.getInt("pts_Kid"),
						rs.getBoolean("FirstTime"))
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return kids;
	}
}
