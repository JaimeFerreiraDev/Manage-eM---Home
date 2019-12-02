package pt.iade.ManageeMHome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class JDBC {
	private static Connection con;
	private static final String URL = "jdbc:mysql://remotemysql.com:3306/" ;
	private static final String USER="heheboi";
	private static final String PASS="heheheboi";
private void DBConnector() {
	
}
public static Connection getCon() {
	try {
		if(con==null) {
			con= DriverManager.getConnection(URL, USER, PASS);
			return con;
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}




}
