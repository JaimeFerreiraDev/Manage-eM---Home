package pt.iade.ManageeMHome.models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Task;

public class TaskDAO {
public static void addTaskBD(int sliderValue, String nameText, String descriptionText, ObservableList<Kid> selectedKids) {
	String sql ="insert into Task (name, frequency_type, description, duration, pts_Task) values(?,?,?,3600,?);";
	try {
		PreparedStatement stat = JDBC.getCon().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stat.setString(1, nameText);
		stat.setString(2,"One Time");
		stat.setString(3,descriptionText);
		stat.setInt(4, sliderValue);
		System.out.println(stat);		
		stat.execute();
		ResultSet rs = stat.getGeneratedKeys();
	
		rs.next();
		int id_Task = rs.getInt(1);
		PreparedStatement stmt = JDBC.getCon().prepareStatement("Insert into Parents_Task (parent, Task)"
				+ " values (?,?);");
			
		
		stmt.setInt(1, PersonDAO.getLoggedParent().getId());
		stmt.setInt(2, id_Task);
		System.out.println("cheguei aqui??????"+stmt);
		stmt.execute();

		for (Kid kid : selectedKids) {

			PreparedStatement kidstask = JDBC.getCon().prepareStatement("Insert into Kids_Task (kid, Task,start_time ,completed)"
					+ " values (?,?,1000,false)");
			System.out.println(kidstask);
			kidstask.setInt(1, kid.getId());
			kidstask.setInt(2, id_Task);
			kidstask.execute();
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public static ObservableList<Kid> getTaskKidsBD() {
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
						rs.getBoolean("Connected"))
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return kids;
	}
	
	public static void removeNotificationBD(Task task, Kid kid) {
		try {
			String sql ="DELETE FROM Kids_Task WHERE Kids_Task.Task=? AND Kids_Task.kid=?";
			
			PreparedStatement stmt = JDBC.getCon().prepareStatement(sql);
			stmt.setInt(1,task.getId());
			stmt.setInt(2,kid.getId());
			stmt.execute();
			System.out.println(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}
	
	public static void taskIsNotCompletedBD(int kid, int task) {
        try {
            String sql = "UPDATE Kids_Task SET completed = false WHERE kid=? and Task = ?;";
            PreparedStatement stmt = JDBC.getCon().prepareStatement(sql);
            stmt.setInt(1, kid);
            stmt.setInt(2, task);
            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
