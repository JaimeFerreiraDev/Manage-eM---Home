package pt.iade.ManageeMHome.models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Reward;

public class RewardDAO {
	
	/**
	 * creates a new reward in the database, using the input reward name, points required and to which kid the reward is.
	 * Creates a reward, connected the reward to one or multiple kids and connects the reward to a parent
	 * @param sliderValue
	 * @param rewardName
	 * @param selectedKids
	 */
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

	/**
	 * searches the database for rewards that have been requested by this parents kids.
	 * @return
	 */
	public static ObservableList<Reward> findRequestedRewards() {
		String sql ="select Kid.pts_Kid as Points_Kid, Reward.name as Reward, User.name as Kid, Reward.id_Reward, User.id_User,"
				+ " Reward.pts_required as points from Kid, Family_Relation, Reward, Kids_Reward, User where Family_Relation.parent= ?"
				+ " and Family_Relation.kid= User.id_User and Kids_Reward.kid = User.id_User "
				+ "and Kids_Reward.requested= true and Kids_Reward.reward = Reward.id_Reward and User.id_User = Kid.id_Kid ";
		int parent = 0;
		ObservableList<Reward> requestedRewards= FXCollections.observableArrayList();
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			parent = PersonDAO.getLoggedParent().getId();
			stat.setInt(1, parent);
			stat.executeQuery();
			ResultSet rs = stat.executeQuery();	
			while(rs.next()) {
				requestedRewards.add(new Reward(rs.getString("Reward"),rs.getInt("points"), rs.getInt("id_Reward"), 
						new Kid(rs.getString("Kid"),//Kid
								0, // age
								rs.getInt("id_User"),// id
								rs.getInt("points_Kid"),	//points
								false)// first time
						));


			}
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return requestedRewards;
	}
	
	
	
	/** 
	 * returns a list of all the rewards made by this parent.
	 * @return
	 */
	public static ObservableList<Reward> getRewards() {
		String sql ="Select * from Parents_Reward, Reward where parent = ? and id_Reward = reward;";
		int parent = 0;
		ObservableList<Reward> rewards= FXCollections.observableArrayList();
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			parent = PersonDAO.getLoggedParent().getId();
			stat.setInt(1, parent);
			System.out.println(stat);
			ResultSet rs = stat.executeQuery();	
			
			while(rs.next()) {
				rewards.add(new Reward(rs.getString("name"),
						rs.getInt("pts_required"),
						rs.getInt("Id_Reward"))
						);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rewards;
	}

}
