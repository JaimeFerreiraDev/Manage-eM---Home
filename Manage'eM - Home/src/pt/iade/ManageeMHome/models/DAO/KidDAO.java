package pt.iade.ManageeMHome.models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.Main;
import pt.iade.ManageeMHome.models.Kid;

public class KidDAO {
public static void addKidBD(int parentID, int kidID) {
	


	String sql = "Insert into Family_Relation(kid, parent) values (?,?)";
	try (PreparedStatement stat = JDBC.getCon().prepareStatement(sql)){
		System.out.println("entrei aqui");

	
		stat.setInt(1,kidID);
		stat.setInt(2,parentID);
		stat.execute();
		
		PreparedStatement stmt = JDBC.getCon().prepareStatement(" UPDATE Kid SET FirstTime = false WHERE id_Kid = (SELECT kid FROM" + 
				" Family_Relation WHERE Family_Relation.parent = ? and Family_Relation.kid = Kid.id_Kid);");
		stmt.setInt(1,parentID);
		stmt.execute();
		Main.secondaryStage.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} 
}

public static void giftKidBD(int intSlider, Kid kid) {
	try {
		String sql ="UPDATE Kid SET pts_Kid = pts_Kid + ? WHERE id_Kid = ?;";
		
		PreparedStatement stmt = JDBC.getCon().prepareStatement(sql);
		stmt.setInt(1,intSlider);
		stmt.setInt(2, kid.getId());
		stmt.execute();
		System.out.println(stmt);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

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
					rs.getBoolean("FirstTime"))
					);
		}
		
		System.out.println(kids);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return kids; 
	
}

}
