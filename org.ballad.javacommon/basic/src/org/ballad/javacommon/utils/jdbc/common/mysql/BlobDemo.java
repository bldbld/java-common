package org.ballad.javacommon.utils.jdbc.common.mysql;

import java.io.*;
import java.sql.*;

public class BlobDemo {
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
		String insert = "insert into Dish values (?,?)";
		PreparedStatement stmt = conn.prepareStatement(insert);
		
		File f = new File("25812956211141.jpg");
		FileInputStream fin = new FileInputStream(f);
		stmt.setString(1,String.valueOf(1));
        stmt.setBinaryStream(2,fin,(int)f.length());//向数据库里插入是很简单的，就一行，但这种方法只有mysql可以用
        stmt.executeUpdate();
        
        Statement st = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from Dish");
		while (rs.next()){
			System.out.println(rs.getString(1));
			java.sql.Blob blob = (java.sql.Blob)rs.getBlob("photo");
			BufferedInputStream input = new BufferedInputStream(blob.getBinaryStream());
			File fout = new File("out.jpg");
			OutputStream out = new FileOutputStream(fout);
			byte [] buf = new byte [4*1024];
			int len; 
		    
		    while((len = input.read (buf, 0, buf.length)) != -1)
		     out.write (buf, 0, len);
		    out.close();
		    fout.canExecute();
		}
		stmt.close();
		conn.close();
	}
}
