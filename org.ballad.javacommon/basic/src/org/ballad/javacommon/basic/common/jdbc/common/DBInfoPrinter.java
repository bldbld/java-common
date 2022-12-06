package org.ballad.javacommon.basic.common.jdbc.common;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ͨ������̨������ݿ����Ϣ��
 * <p>
 * DBInfo�ĸ������ߡ�
 * </p>
 * 
 * @author BKIN
 * @version 1.0 12/11/2010
 */
public class DBInfoPrinter extends DBInfo {

	/**
	 * ͨ������̨������ݿ��һ����Ϣ��
	 * 
	 * @throws SQLException
	 */
	public void printDbCommonInfo() throws SQLException {
		String s;
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
			System.out.print("-- ������������" + rs.getString(1));
			System.out.print("--  �������ͣ�" + rs.getString(2));
			System.out.print("--  ���ȣ�" + rs.getString(3));
			System.out.println("--  ������" + rs.getString(18));
		}
		System.out.println(" ");

		s = dbmd.getURL();
		System.out.println("�����ݿ��url: " + s);
		System.out.println(" ");

		s = dbmd.getUserName();
		System.out.println("�����ݿ���û�: " + s);
		System.out.println(" ");
		rs.close();
	}

	/**
	 * ͨ������̨������ݿ�� ����Ϣ��
	 * 
	 * @throws SQLException
	 */
	public void printDbTables() throws SQLException {
		String[] types = { "TABLE", "VIEW" };
		ResultSet rs = dbmd.getTables(null, null, "%", types);
		while (rs.next()) {
			System.out.print("Ŀ¼����" + rs.getString(1));
			System.out.print(" ģʽ����" + rs.getString(2));
			System.out.print(" ������" + rs.getString(3));
			System.out.print(" ������ͣ�" + rs.getString(4));
			System.out.println(" ע�ͣ�" + rs.getString(5));
		}
		System.out.println(" ");
		rs.close();
	}

	/**
	 * ͨ������̨������ݿ�� ������Ϣ��
	 * 
	 * @throws SQLException
	 */
	public void printDbPrimaryKeys() throws SQLException {
		ResultSet rs = dbmd.getPrimaryKeys(null, "%", "%");
		while (rs.next()) {
			System.out.print("Ŀ¼����" + rs.getString(1));
			System.out.print(" ģʽ����" + rs.getString(2));
			System.out.print(" ������" + rs.getString(3));
			System.out.print(" ����˳��ţ�" + rs.getString(4));
			System.out.print(" ����˳��ţ�" + rs.getString(5));
			System.out.println(" ��������" + rs.getString(6));
		}
		System.out.println(" ");
		rs.close();
	}

	/**
	 * ͨ������̨������ݿ�ı�����͡�
	 * 
	 * @throws SQLException
	 */
	public void printTableTypes() throws SQLException {
		ResultSet rs = dbmd.getTableTypes();
		System.out.println(" ��������У�");
		while (rs.next())
			System.out.print("  " + rs.getString(1));
		System.out.println();
		System.out.println(" ");
		rs.close();
	}

	/**
	 * ͨ������̨������ݿ�ı��Ԫ�ء�
	 * 
	 * @throws SQLException
	 */
	public void printAllColumns() throws SQLException {
		ResultSet rs = dbmd.getColumns(null, null, "%", "%");
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
		rs.close();
	}

	/**
	 * ͨ������̨������ݿ��������Ϣ��
	 * 
	 * @throws SQLException
	 */
	public void printIndexInfo() throws SQLException {
		ResultSet rs = dbmd.getIndexInfo(null, "%", "%", false, false);

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
	}
	
	
	/*
	 * ���ڲ��Ե�main������
	 */
	public static void main(String[] args) {
		DBInfoPrinter dbip = new DBInfoPrinter();
		dbip.setDbType(1, "jdbc:mysql://localhost:3306/autopos", "root", "12345678");
		try {
			dbip.printAllColumns();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}