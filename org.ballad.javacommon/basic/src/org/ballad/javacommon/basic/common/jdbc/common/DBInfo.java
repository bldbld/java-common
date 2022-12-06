package org.ballad.javacommon.basic.common.jdbc.common;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * ������ݿ����Ϣ��
 * 
 * @author BKIN
 * @version 1.0 12/11/2010
 */
public class DBInfo {

	protected Connection con;

	protected DatabaseMetaData dbmd;

	/**
	 * ���DBInfo���е�DatabaseMetaData����
	 */
	public DatabaseMetaData getDbmd() {
		return dbmd;
	}

	/**
	 * ���캯����
	 */
	public DBInfo() {

	}

	/**
	 * ����Database�����͡�
	 * <p>
	 * type���÷���
	 * </p>
	 * <ol>
	 * <li>
	 * MySQL: jdbc:mysql://URL:3306/DBNAME</li>
	 * <li>
	 * Oracle: jdbc:oracle:thin:orcl</li>
	 * <li>
	 * SQL-Server: jdbc:microsoft:sqlserver://URL:1433;DataBaseName=DBNAME</li>
	 * </ol>
	 * 
	 * @param dbType
	 * @param url
	 * @param user
	 * @param pwd
	 */
	public void setDbType(int dbType, String url, String user, String pwd) {
		try {
			switch (dbType) {
			case 1:
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				break;
			case 2:
				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
				break;
			case 3:
				Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver")
						.newInstance();
				break;
			default:
				Exception e = new Exception("Invalid DB Driver Type");
				throw e;
			}
			con = DriverManager.getConnection(url, user, pwd);
			dbmd = con.getMetaData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}