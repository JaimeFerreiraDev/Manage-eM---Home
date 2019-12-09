package pt.iade.ManageeMHome.models.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.Kid;
import pt.iade.ManageeMHome.models.Parent;
import pt.iade.ManageeMHome.models.Person;
import pt.iade.ManageeMHome.models.Task;

public class PersonDAO {
	public static ObservableList<Person> personList = FXCollections.observableArrayList();
	public static Parent loggedParent;
	public static Kid loggedKid;
	public static ObservableList<Person> getPersonList() {
		return personList;
	}

//	public static ObservableList<Parent> getParentList() {
//
//		ObservableList<Parent> parents = FXCollections.observableArrayList();
//		for (Person person : personList) {
//			if (person instanceof Parent) {
//				parents.add((Parent) person);
//			}
//
//		}
//		return parents;
//	}
//	
//	public static ObservableList<Parent> getParentList() {
//
//        ObservableList<Parent> parents = FXCollections.observableArrayList();
//        Connection conn = JDBC.getCon();
//        String sql = "SELECT id_parent, name, username, age_parent FROM parent ";
//        try(Statement stat = conn.createStatement();
//        		ResultSet rs = stat.executeQuery(sql)){
//            while(rs.next()) {
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                int  id= rs.getInt("id");
//                String username= rs.getString("username");
//                String password= rs.getString("password");
//                String email= rs.getString("email");
//                 ObservableList<Kid> kids = null;
//                 ObservableList<Task> tasks = null;
//
//                parents.add(new Parent(name, age, id, username, /*password,*/
//                    kids,tasks  ));
//            }
//        }catch(SQLException e) {
//            e.printStackTrace();
//        }
//        return parents;
//}
	
	
	public static ObservableList<Kid> getKidList() {

		ObservableList<Kid> kids = FXCollections.observableArrayList();
		for (Person person : personList) {
			if (person instanceof Kid) {
				kids.add((Kid) person);
			}

		}
		return kids;
	}
	
	public static Parent getLoggedParent() {
		return loggedParent;
	}

	public static void setLoggedParent(Parent loggedParent) {
		PersonDAO.loggedParent = loggedParent;
	}
	

	public static Kid getLoggedKid() {
		return loggedKid;
	}

	public static void setLoggedKid(Kid loggedKid) {
		PersonDAO.loggedKid = loggedKid;
	}


//	static {
////		personList.add(new Parent("Fernando", 24, 34, "f", "f", FXCollections.observableArrayList(), FXCollections.observableArrayList()));
////		personList.add(new Parent("jaime", 23, "aaa", "a", "a", "a", FXCollections.observableArrayList(), FXCollections.observableArrayList()));
////		personList.add(new Kid("aurora", 2, "aurora"+ ((int)(Math.random()*100)+100), "b", "b", "b", 1, true, FXCollections.observableArrayList(), FXCollections.observableArrayList()));
////		personList.add(new Kid("filhaex", 3, ""+5, "c", "c",  "c", 3, true, FXCollections.observableArrayList(), FXCollections.observableArrayList()));
////		personList.add(new Kid("filHOex", 4, ""+4, "c", "c", "c", 30, true, FXCollections.observableArrayList(), FXCollections.observableArrayList()));
//	}
}
