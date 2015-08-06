package com.gs.servlets;

import java.sql.*;

import com.gs.util.ConnectionUtil;

public class LoginDao {

public static boolean validate(String name,String pass){
boolean status=false;
try{
	
	Connection con=ConnectionUtil.getConnection();
	
	PreparedStatement ps=con.prepareStatement("select * from userreg where name=? and pass=?");
	ps.setString(1,name);
	ps.setString(2,pass);
	
	ResultSet rs=ps.executeQuery();
	status=rs.next();
	
	
}catch(Exception e){System.out.println(e);}
return status;
}
}
