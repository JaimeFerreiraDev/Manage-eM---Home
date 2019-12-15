package pt.iade.ManageeMHome.models.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * This class connects the program to the SQL sever.
 * @author jaime
 *
 */
public final class JDBC {
	private static Connection con;
	private static final String URL = "jdbc:mysql://remotemysql.com:3306/5C19vZ5lxD?useSSL=false" ;
	private static final String USER="5C19vZ5lxD";
	private static final String PASS="5OKyj8g5nV";



	public static Connection getCon() {
		try {
			if(con==null) {
				con= DriverManager.getConnection(URL, USER, PASS);
			}		
			return con;
		} catch (SQLException e) {
			System.out.println("foi erro de ligaçao");
			e.printStackTrace();
		}
		return null;
	}


}

