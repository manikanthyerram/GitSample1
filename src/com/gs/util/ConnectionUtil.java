package com.gs.util;


import java.sql.*;


public class ConnectionUtil {
	static Connection con = null;
	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		
		 Class.forName("com.mysql.jdbc.Driver");
              // con=DriverManager.getConnection("jdbc:mysql://localhost/RMDPROD","root","WnDGaSYcQ8");
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rmdprod?autoReconnect=true",
				"root", "root");
		return con;
	}
	public static void close() throws SQLException{
		if(con!=null){
			con.close();
		}
	}

}
