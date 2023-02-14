package org.ballad.javacommon.utils.jdbc.common.mysql;

import java.io.IOException;
import java.sql.*;

public class MysqlDemo {
	public static void main (String [] args) throws SQLException, IOException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			System.err.println("NOT LOAD THE DRIVER");
		}
		String user = "webber";
		String pwd = "12345678";
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web",user,pwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Dota order by id desc");
		while (rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
		stmt.close();
		conn.close();
	}
}
