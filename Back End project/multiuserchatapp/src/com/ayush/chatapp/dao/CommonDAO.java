package com.ayush.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.ayush.chatapp.utils.ConfigReader.getValue;

//Throw early and catch later

public interface CommonDAO {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		//step - 1 Load a driver
		Class.forName(getValue("DRIVER"));
		
		//step - 2 Making a connection
		final String CONNECTION_STRING = getValue("CONNECTION_URL");
		final String USER_ID = getValue("USER_ID");
		final String PASSWORD = getValue("PASSWORD");
		Connection con = DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
		
		if(con != null) {
			System.out.println("connection Created...");
			//con.close();
		}
//		return null;
		return con;
	}
	
}
