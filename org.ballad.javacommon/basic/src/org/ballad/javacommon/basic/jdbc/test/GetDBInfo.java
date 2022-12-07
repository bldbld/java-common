package org.ballad.javacommon.basic.jdbc.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * 
 * @author BALLAD
 * 
 */
public class GetDBInfo {
	public void setJdbcType() {
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver")
					.newInstance();
			String url = "jdbc:microsoft:sqlserver://GAOXIANG:1433;DataBaseName=master";
			String user = "daryl715";
			String pass = "1234";
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public GetDBInfo() {
	}

	public static void main(String[] args) {
		try {		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/autopos";
			String user = "root";
			String pass = "12345678";
			String s;
			Connection con = DriverManager.getConnection(url, user, pass);
			DatabaseMetaData dbmd = con.getMetaData();
			s = dbmd.getDriverName();
			System.out.println("���������������: " + s);
			System.out.println(" ");

			s = dbmd.getDatabaseProductName();
			System.out.println("���ݿ������ǣ�" + s);
			System.out.println(" ");

			ResultSet rs = dbmd.getSchemas();
			System.out.println("ģʽ���У�");
			while (rs.next())
				System.out.print("  " + rs.getString(1));
			System.out.println();

			s = dbmd.getSQLKeywords();
			System.out.println("SQL�еĹؼ���Ϊ: " + s);
			System.out.println(" ");

			int max = dbmd.getMaxColumnNameLength();
			System.out.println("��������󳤶ȿ����ǣ�" + max);
			System.out.println(" ");

			max = dbmd.getMaxTableNameLength();
			System.out.println("��������󳤶ȿ����ǣ�" + max);
			System.out.println(" ");

			max = dbmd.getMaxColumnsInSelect();
			System.out.println("һ��select �Ӿ����ܷ��ص����������������󳤶ȿ����ǣ�" + max);
			System.out.println(" ");

			max = dbmd.getMaxTablesInSelect();
			System.out.println("һ��SELECT��������Է��ʶ��ٸ���" + max);
			System.out.println(" ");

			max = dbmd.getMaxColumnsInTable();
			System.out.println("������������������" + max);
			System.out.println(" ");

			max = dbmd.getMaxConnections();
			System.out.println("�������ʵ��û�������" + max);
			System.out.println(" ");

			max = dbmd.getMaxStatementLength();
			System.out.println("SQL����������ĳ��ȣ�" + max);
			System.out.println(" ");

			s = dbmd.getNumericFunctions();
			System.out.println("���ݿ��������ѧ�������б�: " + s);
			System.out.println(" ");

			s = dbmd.getStringFunctions();
			System.out.println("���ݿ�������ַ����������б�: " + s);
			System.out.println(" ");

			s = dbmd.getSystemFunctions();
			System.out.println("���ݿ������ϵͳ�������б�: " + s);
			System.out.println(" ");

			s = dbmd.getTimeDateFunctions();
			System.out.println("���ݿ����������ʱ�亯�����б�: " + s);
			System.out.println(" ");

			rs = dbmd.getTypeInfo();
			while (rs.next()) {
				System.out.print(" ������������" + rs.getString(1));
				System.out.print("  �������ͣ�" + rs.getString(2));
				System.out.print("  ���ȣ�" + rs.getString(3));
				System.out.println("  ������" + rs.getString(18));
			}
			System.out.println(" ");

			s = dbmd.getURL();
			System.out.println("�����ݿ��url: " + s);
			System.out.println(" ");

			s = dbmd.getUserName();
			System.out.println("�����ݿ���û�: " + s);
			System.out.println(" ");
			
			
			String[] t = { "TABLE", "VIEW" };
			rs = dbmd.getTables(null, null, "%", t);
			while (rs.next()) {
				System.out.print("Ŀ¼����" + rs.getString(1));
				System.out.print(" ģʽ����" + rs.getString(2));
				System.out.print(" ������" + rs.getString(3));
				System.out.print(" ������ͣ�" + rs.getString(4));
				System.out.println(" ע�ͣ�" + rs.getString(5));
			}
			System.out.println(" ");

			rs = dbmd.getPrimaryKeys(null, "HR", "EMPLOYEES");
			while (rs.next()) {
				System.out.print("Ŀ¼����" + rs.getString(1));
				System.out.print(" ģʽ����" + rs.getString(2));
				System.out.print(" ������" + rs.getString(3));
				System.out.print(" ����˳��ţ�" + rs.getString(4));
				System.out.print(" ����˳��ţ�" + rs.getString(5));
				System.out.println(" ��������" + rs.getString(6));
			}
			System.out.println(" ");

			rs = dbmd.getTableTypes();
			System.out.println(" ��������У�");
			while (rs.next())
				System.out.print("  " + rs.getString(1));
			System.out.println();
			System.out.println(" ");

			rs = dbmd.getColumns(null, "HR", "EMPLOYEES", "��");
			System.out.println(" ���� " + " ���� " + "  ��������" + " ����������" + " �еĴ�С"
					+ " С��λ��" + " ���ݻ���" + " �Ƿ�ɿ�" + " ������");
			while (rs.next()) {
				System.out.print(rs.getString(3) + " ");
				System.out.print(rs.getString(4) + " ");
				System.out.print(rs.getString(5) + " ");
				System.out.print(rs.getString(6) + " ");
				System.out.print(rs.getString(7) + " ");
				System.out.print(rs.getString(9) + " ");
				System.out.print(rs.getString(10) + " ");
				System.out.print(rs.getString(11) + " ");
				System.out.println(rs.getString(17) + " ");
			}
			System.out.println(" ");

			rs = dbmd.getIndexInfo(null, "HR", "EMPLOYEES", false, false);

			System.out.println(" ����" + " ������" + " ��������" + " ��������" + " ����˳��"
					+ " С��λ��" + " ���ݻ���" + " �Ƿ�ɿ�" + " ������");
			while (rs.next()) {
				System.out.print(rs.getString(3) + " ");
				System.out.print(rs.getString(6) + " ");
				System.out.print(rs.getString(7) + " ");
				System.out.print(rs.getString(9) + " ");
				System.out.println(rs.getString(10) + " ");
			}
			System.out.println(" ");

			rs.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		new GetDBInfo();
	}
}