package ballad.coding.jdbc.oracle;

import java.sql.*;
import java.io.*;
import java.util.*;

public class OracleDemo {
	public static void main (String [] args) throws SQLException, IOException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e){
			System.err.println("NOT LOAD THE DRIVER");
		}
		String user = "system";
		String pwd = "12345678";
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:orcl",user,pwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from test order by score desc,id desc");
		while (rs.next()){
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		stmt.close();
		conn.close();
	}
}
