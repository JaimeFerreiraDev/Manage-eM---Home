package pt.iade.ManageeMHome.models.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdk.nashorn.internal.scripts.JD;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Reward;
import pt.iade.ManageeMHome.models.Task;

public class KidDAO {
	
	/**
	 * This is called when a Parent connects to a new kid, we do this by using both their IDs.
	 * also when a kid is connected to a parent we update a column in their database table 
	 * @param parentID
	 * @param kidID
	 */
	public static void addKidBD(int parentID, int kidID) {

		String sql = "Insert into Family_Relation(kid, parent) values (?,?)";
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			System.out.println("entrei aqui");


			stat.setInt(1,kidID);
			stat.setInt(2,parentID);
			stat.execute();

			PreparedStatement stmt = JDBC.getCon().prepareStatement(" UPDATE Kid SET Connected = true WHERE id_Kid = (SELECT kid FROM" + 
					" Family_Relation WHERE Family_Relation.parent = ? and Family_Relation.kid = Kid.id_Kid);");
			stmt.setInt(1,parentID);
			stmt.execute();
			Main.secondaryStage.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
/**
 * this is used to update a specific Kids points, using intslider to know the amount of points and id to know which kid we're updating.
 * @param intSlider
 * @param id
 */
	public static void giftKidBD(int intSlider, int id) {
		try {
			String sql ="UPDATE Kid SET pts_Kid = pts_Kid + ? WHERE id_Kid = ?;";

			PreparedStatement stmt = JDBC.getCon().prepareStatement(sql);
			stmt.setInt(1,intSlider);
			stmt.setInt(2, id);
			stmt.execute();
			System.out.println(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * searches the database for this specific kids points.
 * @param kid
 * @return
 */
	public static int kidPoints(Kid kid) {
		int points = 0;
		String sql = "select pts_Kid as points from Kid where id_Kid = ?;";
		try {
			PreparedStatement stat = JDBC.getCon().prepareStatement(sql); // erro aqui 		
			stat.setInt(1,kid.getId());
			System.out.println(stat);
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {
				points=rs.getInt("points");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return points;
	}
	
	/**
	 * creates and returns list of Kids of this parent
	 * @return
	 */
	public static ObservableList<Kid> getKidsBD() {
		int parent = 0;
		ObservableList<Kid> kids = FXCollections.observableArrayList();
		String sql ="Select * from Family_Relation, Kid, User where parent = ? and kid = id_Kid and id_Kid = id_User;";
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			parent = PersonDAO.getLoggedParent().getId();
			stat.setInt(1, parent);
			System.out.println(stat);
			ResultSet rs = stat.executeQuery();	


			while(rs.next()) {
				int date = Integer.valueOf(rs.getInt("age")) ;
				int year = Calendar.getInstance().get(Calendar.YEAR);
				int age= year - date;
				kids.add(new Kid(rs.getString("name"), 
						age
						, 
						rs.getInt("id_Kid"),
						rs.getInt("pts_Kid"),
						rs.getBoolean("Connected"))
						);
			}

			System.out.println(kids);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kids; 

	}
 /**
  * used to update the list of rewards when a kid is connected to the app.
  * @param kid
  * @return
  */
	public static  ObservableList<Reward> updateKidPOVRewardBD(int kid) {
		ObservableList<Reward> rewards = FXCollections.observableArrayList();
		String sql ="Select * from Kids_Reward, Reward where kid = ? and id_Reward = reward;";
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			stat.setInt(1, kid);
			System.out.println(stat);
			ResultSet rs = stat.executeQuery();	

			while(rs.next()) {
				rewards.add(new Reward(rs.getString("name"), rs.getInt("pts_required"),rs.getInt("Id_Reward"))
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return rewards;
	}
	
	/**
	 * used to update the list of tasks when a kid is connected to the app.
	 * @param kid
	 * @return
	 */
	public static  ObservableList<Task> updateKidPOVTaskBD(int kid) {
		ObservableList<Task> tasks = FXCollections.observableArrayList();
		String sql ="Select * from Kids_Task, Task where kid = ? and id_Task = task and completed = false;";
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			kid = PersonDAO.getLoggedKid().getId();
			stat.setInt(1, kid);
			System.out.println(stat);
			ResultSet rs = stat.executeQuery();	

			while(rs.next()) {
				tasks.add(new Task(rs.getString("name"),
						rs.getInt("pts_Task"), rs.getInt("id_Task"),
						rs.getString("description"),
						false)
						);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return tasks;
	}

/**
 * whenever a reward from the notification is denied, the kid gets their points back.
 * @param pts
 * @param kid
 * @param id_reward
 */
	public static void returnPoints(int pts,int kid, int id_reward) {

		try {
			String sql ="UPDATE Kid SET pts_Kid = pts_Kid + ? WHERE id_Kid = ?;";

			PreparedStatement stmt = JDBC.getCon().prepareStatement(sql);
			stmt.setInt(1,pts);
			stmt.setInt(2, kid);
			stmt.execute();
			System.out.println(stmt);
			PreparedStatement stat = JDBC.getCon().prepareStatement("UPDATE Kids_Reward set requested = false WHERE kid = ?  and reward = ?");
			stat.setInt(1, kid);
			stat.setInt(2, id_reward);
			stat.execute();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


/**
 * updates this kids reward status whenever it is approved by the parent , the kid still can get it again but it is no longer requested.
 * @param kid
 * @param id_reward
 */
	public static void removeNotifReward(int kid, int id_reward) {
		try {
			PreparedStatement stat = JDBC.getCon().prepareStatement("UPDATE Kids_Reward set requested = false WHERE kid = ?  and reward = ?");
			stat.setInt(1, kid);
			stat.setInt(2, id_reward);
			stat.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * whenever a kid chooses a reward, we deduct the rewards required points from the kids points.
	 * we also set this same reward as requested so it appears in the notification window for the parent.
	 * @param pts
	 * @param kid
	 * @param id_reward
	 */
	public static void buyReward(int pts,int kid, int id_reward) {

		try {
			String sql ="UPDATE Kid SET pts_Kid = pts_Kid - ? WHERE id_Kid = ?;";

			PreparedStatement stmt = JDBC.getCon().prepareStatement(sql);
			stmt.setInt(1,pts);
			stmt.setInt(2, kid);
			stmt.execute();
			System.out.println(stmt);
			PreparedStatement stat = JDBC.getCon().prepareStatement("UPDATE Kids_Reward set requested = true WHERE kid = ?  and reward = ?");
			stat.setInt(1, kid);
			stat.setInt(2, id_reward);
			stat.execute();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	/**
	 * Creates a new User Kid in our database
	 * @param username
	 * @param name
	 * @param password
	 * @param DateOfBirth
	 * @throws SQLException
	 */
	public static void createKidBD(String username, String name, String password,LocalDate DateOfBirth) throws SQLException{
		PreparedStatement stat = JDBC.getCon().prepareStatement("insert into User(role, username, name, age) values(2,?,?,?);");
		stat.setString(1,username);
		stat.setString(2,name);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format = formatter.format(Date.valueOf(DateOfBirth));
		stat.setString(3,format);
		System.out.println("primeira query: "+stat);
		stat.execute();	
		stat.close();
		stat = JDBC.getCon().prepareStatement("insert into Kid (id_Kid, pts_Kid, Connected) "
				+ "values ((select id_User from User where username = ?),0,false);");
		stat.setString(1,username);
		System.out.println("segunda query: "+stat);
		stat.execute();	
		stat.close();
		stat = JDBC.getCon().prepareStatement("insert into Password(id_Password, password) "
				+ "values ((select id_User from User where username = ?), ?);");
		stat.setString(1,username);
		stat.setString(2,password);
		System.out.println("terceirea query: "+stat);
		stat.execute();	
		stat.close();
	}
	/**
	 * returns the code of the kid (the ID) when this kid tries to login without being connected to a parent.
	 * @return
	 */
	public static int firstTimeKidLogin() {
		int id = 0;
		String sql = "select id_User from User, Password where User.id_User = ?";
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			id = PersonDAO.getLoggedKid().getId();
			stat.setInt(1,id);
			stat.execute();		
			System.out.println(stat);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return id;
	}
}