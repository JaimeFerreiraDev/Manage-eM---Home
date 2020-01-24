package pt.iade.ManageeMHome.models.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.controllers.NewAccController;
import pt.iade.ManageeMHome.controllers.Kid.K1stTimeController;
import pt.iade.ManageeMHome.controllers.Kid.KtaskController;
import pt.iade.ManageeMHome.controllers.Parent.KidViewController;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.Person;
import pt.iade.ManageeMHome.models.Task;
/**
 * This class is currently being only used to set and get the currently logged parent or kid
 * @author jaime
 *
 */
public class PersonDAO {
	public static ObservableList<Person> personList = FXCollections.observableArrayList();
	
	
	private static Parent loggedParent;
	private static Kid loggedKid;
	private static Connection conn= JDBC.getCon();

	public static Parent getLoggedParent() {
		return loggedParent;
	}
	private static String usernamePD;
/**
 * sets a parent as the curent user of the application
 * @param loggedParent
 */
	public static void setLoggedParent(Parent loggedParent) {
		PersonDAO.loggedParent = loggedParent;
	}


	public static Kid getLoggedKid() {
		return loggedKid;
	}
	/**
	 * sets a kid as the curent user of the application
	 * @param loggedParent
	 */
	public static void setLoggedKid(Kid loggedKid) {
		PersonDAO.loggedKid = loggedKid;
	}

	
	
	/**
	 * compares user input (username and password) with database users to start using the application
	 * it checks a column in the table user named Role to check if its a Parent or kid
	 * If its a Kid it has extra steps, it checks if the kid is already connected to a parent, depending on that, opens a diferent scene
	 *
	 * @param username
	 * @param password
	 * @throws SQLException
	 */

	public static void loginBD(String username, String password) throws SQLException {
		 
		int role = 0;

	String sql = "select * from User, Password where username = ? and password = ? and id_User = id_Password;";
	PreparedStatement stat = conn.prepareStatement(sql); // erro aqui 		
	stat.setString(1, username);
	stat.setString(2, password);
	System.out.println(stat);
	ResultSet rs = stat.executeQuery();
	if(rs.next()) {
		role = rs.getInt("role");
		if (role ==1) {
			PersonDAO.setLoggedParent(new Parent(
					rs.getString("name"),
					rs.getInt("age"),
					rs.getInt("id_User")));
			Main.primaryStage.close();
			Main.changeTab("views/Parent/kidView.fxml", new KidViewController());
		}
		else if(role == 2) {
			usernamePD=username;
			theLoggedKid();

		}
	}

}
	/**
	 * This method is just make the {@link #loginBD(String, String)} lighter in terms of reading.
	 */
	public static void theLoggedKid() {
		try {
			PreparedStatement statement = conn.prepareStatement("Select * from Kid , User where username = ? and Kid.id_Kid = User.id_User");
			statement.setString(1, usernamePD);
			ResultSet kids = statement.executeQuery();
			System.out.println(statement);
			if(kids.next()) {
				PersonDAO.setLoggedKid(new Kid(
						kids.getString("name"),
						kids.getInt("age"),
						kids.getInt("id_Kid"),
						kids.getInt("pts_Kid"),
						kids.getBoolean("Connected")
						));
				System.out.println(PersonDAO.getLoggedKid().toString());
				Main.primaryStage.close();
				
				if(!kids.getBoolean("Connected")) {
					Main.changeTab("views/Kid/k1stTimeView.fxml", new K1stTimeController());
				
				}
				else if(kids.getBoolean("Connected")) {
					Main.changeTab("views/Kid/ktaskView.fxml", new KtaskController());
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int getNumberOfNotif() throws SQLException {
        int parent = 0;
        int num = 0;
        PreparedStatement stmt = JDBC.getCon().prepareStatement("select COUNT(Kids_Task.Task)as num from Kids_Task, User, Family_Relation where User.id_User =?"
                + " and User.id_User = Family_Relation.parent and Family_Relation.kid = Kids_Task.kid and completed = true ");
        stmt.setInt(1,parent);
        stmt.executeQuery();
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) num += rs.getInt("num");
        PreparedStatement stat = JDBC.getCon().prepareStatement("select COUNT(Kids_Reward.reward)as num from Kids_Reward, User, "
                + "Family_Relation where User.id_User = ? and User.id_User = Family_Relation.parent "
                + "and Family_Relation.kid = Kids_Reward.kid and Kids_Reward.requested = true;");
        stat.setInt(1,parent);
        stat.executeQuery();
        ResultSet rSet = stat.executeQuery();
        if(rSet.next()) num += rs.getInt("num");

        return num;

    }
}
