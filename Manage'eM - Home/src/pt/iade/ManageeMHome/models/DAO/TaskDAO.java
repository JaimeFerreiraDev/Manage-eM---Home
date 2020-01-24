package pt.iade.ManageeMHome.models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.Task;

public class TaskDAO {
	/**
	 * adds a new task to the database using the input task name, description, points awarded on completion and to which kids it is.
	 * this connects the task to the parent who made it and connected to one or more kids that the parent chose to give the task to.
	 * @param sliderValue
	 * @param nameText
	 * @param descriptionText
	 * @param selectedKids
	 */
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



	/**
	 * whenever a task is completed and reviewed on the notification by the parent, we unlink the kid from this task
	 * @param task
	 * @param kid
	 */
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
	/**
	 * if the task is considered to not be complete we set it back default( not completed)
	 * @param kid
	 * @param task
	 */
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

	/**
	 * returns a list of all the tasks made by this parent.
	 * @param parent
	 * @return
	 */
	public static ObservableList<Task> getTasksBD(int parent) {
		String sql ="Select * from Parents_Task, Task where parent = ? and id_Task = task;";
		ObservableList<Task> tasks = FXCollections.observableArrayList();
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			stat.setInt(1, parent);
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
	 * whenever a kid completes a task we update a variable so it shows up on the notification window for the parent to review.
	 * @param kid
	 * @param task
	 * @throws SQLException
	 */
	public static void setTaskCompleted(int kid, String task) throws SQLException {
		PreparedStatement stmt = JDBC.getCon().prepareStatement(" UPDATE Kids_Task, Task SET completed = true WHERE Kids_Task.kid ="
				+ "? and Task.id_Task = Kids_Task.Task and Task.name = ?;");
		stmt.setInt(1,kid);
		stmt.setString(2, task);
		stmt.execute();
	}
	/**
	 * searches the database for tasks that have been completed by this parents kids.
	 *
	 * @return
	 */
	public static ObservableList<Task> findCompletedTasks() {

		String sql ="Select Task.id_Task, Kid.id_Kid as IdKid,Task.pts_Task as pts_Task ,User.name as Filho, Task.name as Task_Name from User, Task,"
				+ " Kids_Task, Family_Relation, Kid where Family_Relation.kid = Kids_Task.kid and Family_Relation.parent = ? and Task.id_Task = Kids_Task.Task "
				+ "AND Kids_Task.completed = true and User.id_User = Kids_Task.kid and Kid.id_Kid = Family_Relation.kid and Kid.id_Kid = Kids_Task.kid";
		int parent = 0;
		ObservableList<Task> completedTasks= FXCollections.observableArrayList();
		try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
			parent = PersonDAO.getLoggedParent().getId();
			stat.setInt(1, parent);

			stat.executeQuery();
			ResultSet rs = stat.executeQuery();	
			while(rs.next()) {
				completedTasks.add(new Task(rs.getString("Task_Name"),
						rs.getInt("pts_Task"), 
						rs.getInt("id_Task"),
						null,
						false,
						new Kid(rs.getString("Filho"), 0, rs.getInt("IdKid"), 0, false)
						));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} 
		return completedTasks;
	}








}
