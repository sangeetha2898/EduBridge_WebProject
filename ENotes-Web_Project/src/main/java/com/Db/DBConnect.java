package com.Db;

import java.sql.Connection;
import java.sql.*;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn;

	public static Connection getConn() throws ClassNotFoundException
	{
		try {
			
		
		if(conn==null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes","root","Root@123");
			
		}
		
	} catch(Exception e) {
		e.printStackTrace();
	}
		
		return conn;
		

}
}
