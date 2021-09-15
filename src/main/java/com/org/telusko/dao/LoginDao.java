package com.org.telusko.dao;

import java.sql.*;

public class LoginDao {
	
	String sql="select * from Login where uname=? and password=?";
	public boolean check(String uname, String password) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginCredentials?user=root&password=Mysql");
		PreparedStatement st=con.prepareStatement(sql);
		st.setString(1,uname);
		st.setString(2,password);
		ResultSet rs= st.executeQuery();
		if(rs.next())
			return true;
		else return false;
	}
}
