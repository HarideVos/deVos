package com.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {
	
	public static Connection createConnection() {
		Connection con = null;
		final String DB_NAME ="highschool";
		final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
		final String DB_USERNAME = "root";
		final String DB_PASSWORD = "IkkeIkke#08";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
