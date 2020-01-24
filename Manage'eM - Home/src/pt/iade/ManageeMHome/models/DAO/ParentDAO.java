package pt.iade.ManageeMHome.models.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ParentDAO {
	/**
	 * creates a new parent in our database
	 * @param username
	 * @param name
	 * @param password
	 * @param DateOfBirth
	 * @throws SQLException
	 */
	public static void createParentBD(String username, String name, String password,LocalDate DateOfBirth) throws SQLException{
		PreparedStatement stat = JDBC.getCon().prepareStatement("insert into User (role, username, name, age) values(1,?,?,?);");
		stat.setString(1,username);
		stat.setString(2,name);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String format =  formatter.format(Date.valueOf(DateOfBirth));
		stat.setString(3, format);
		System.out.println("primeira query: "+stat);
		stat.execute();	
		stat.close();
		stat = JDBC.getCon().prepareStatement("insert into Password(id_Password, password)"
				+ " values ((select id_User from User where username = ?), ?);");
		stat.setString(1,username);
		stat.setString(2,password);
		System.out.println("segunda query: "+stat);
		stat.execute();	
		stat.close();
	}
}
