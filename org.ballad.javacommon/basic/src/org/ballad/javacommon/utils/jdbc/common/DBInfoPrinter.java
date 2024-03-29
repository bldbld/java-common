package org.ballad.javacommon.utils.jdbc.common;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 通过控制台输出数据库的信息。
 * <p>
 * DBInfo的辅助工具。
 * </p>
 * 
 * @author BKIN
 * @version 1.0 12/11/2010
 */
public class DBInfoPrinter extends DBInfo {

	/**
	 * 通过控制台输出数据库的一般信息。
	 * 
	 * @throws SQLException
	 */
	public void printDbCommonInfo() throws SQLException {
		String s;
		s = dbmd.getDriverName();
		System.out.println("驱动程序的名称是: " + s);
		System.out.println(" ");

		s = dbmd.getDatabaseProductName();
		System.out.println("数据库名称是：" + s);
		System.out.println(" ");

		ResultSet rs = dbmd.getSchemas();
		System.out.println("模式名有：");
		while (rs.next())
			System.out.print("  " + rs.getString(1));
		System.out.println();

		s = dbmd.getSQLKeywords();
		System.out.println("SQL中的关键词为: " + s);
		System.out.println(" ");

		int max = dbmd.getMaxColumnNameLength();
		System.out.println("列名的最大长度可以是：" + max);
		System.out.println(" ");

		max = dbmd.getMaxTableNameLength();
		System.out.println("表名的最大长度可以是：" + max);
		System.out.println(" ");

		max = dbmd.getMaxColumnsInSelect();
		System.out.println("一个select 子句所能返回的最多列数列名的最大长度可是是：" + max);
		System.out.println(" ");

		max = dbmd.getMaxTablesInSelect();
		System.out.println("一个SELECT语句最多可以访问多少个表：" + max);
		System.out.println(" ");

		max = dbmd.getMaxColumnsInTable();
		System.out.println("表中允许的最多列数：" + max);
		System.out.println(" ");

		max = dbmd.getMaxConnections();
		System.out.println("并发访问的用户个数：" + max);
		System.out.println(" ");

		max = dbmd.getMaxStatementLength();
		System.out.println("SQL语句最大允许的长度：" + max);
		System.out.println(" ");

		s = dbmd.getNumericFunctions();
		System.out.println("数据库的所有数学函数的列表: " + s);
		System.out.println(" ");

		s = dbmd.getStringFunctions();
		System.out.println("数据库的所有字符串函数的列表: " + s);
		System.out.println(" ");

		s = dbmd.getSystemFunctions();
		System.out.println("数据库的所有系统函数的列表: " + s);
		System.out.println(" ");

		s = dbmd.getTimeDateFunctions();
		System.out.println("数据库的所有日期时间函数的列表: " + s);
		System.out.println(" ");

		rs = dbmd.getTypeInfo();
		while (rs.next()) {
			System.out.print("-- 数据类型名：" + rs.getString(1));
			System.out.print("--  数据类型：" + rs.getString(2));
			System.out.print("--  精度：" + rs.getString(3));
			System.out.println("--  基数：" + rs.getString(18));
		}
		System.out.println(" ");

		s = dbmd.getURL();
		System.out.println("此数据库的url: " + s);
		System.out.println(" ");

		s = dbmd.getUserName();
		System.out.println("此数据库的用户: " + s);
		System.out.println(" ");
		rs.close();
	}

	/**
	 * 通过控制台输出数据库的 表信息。
	 * 
	 * @throws SQLException
	 */
	public void printDbTables() throws SQLException {
		String[] types = { "TABLE", "VIEW" };
		ResultSet rs = dbmd.getTables(null, null, "%", types);
		while (rs.next()) {
			System.out.print("目录名：" + rs.getString(1));
			System.out.print(" 模式名：" + rs.getString(2));
			System.out.print(" 表名：" + rs.getString(3));
			System.out.print(" 表的类型：" + rs.getString(4));
			System.out.println(" 注释：" + rs.getString(5));
		}
		System.out.println(" ");
		rs.close();
	}

	/**
	 * 通过控制台输出数据库的 主键信息。
	 * 
	 * @throws SQLException
	 */
	public void printDbPrimaryKeys() throws SQLException {
		ResultSet rs = dbmd.getPrimaryKeys(null, "%", "%");
		while (rs.next()) {
			System.out.print("目录名：" + rs.getString(1));
			System.out.print(" 模式名：" + rs.getString(2));
			System.out.print(" 表名：" + rs.getString(3));
			System.out.print(" 列名顺序号：" + rs.getString(4));
			System.out.print(" 列名顺序号：" + rs.getString(5));
			System.out.println(" 主键名：" + rs.getString(6));
		}
		System.out.println(" ");
		rs.close();
	}

	/**
	 * 通过控制台输出数据库的表的类型。
	 * 
	 * @throws SQLException
	 */
	public void printTableTypes() throws SQLException {
		ResultSet rs = dbmd.getTableTypes();
		System.out.println(" 表的类型有：");
		while (rs.next())
			System.out.print("  " + rs.getString(1));
		System.out.println();
		System.out.println(" ");
		rs.close();
	}

	/**
	 * 通过控制台输出数据库的表的元素。
	 * 
	 * @throws SQLException
	 */
	public void printAllColumns() throws SQLException {
		ResultSet rs = dbmd.getColumns(null, null, "%", "%");
		System.out.println(" 表名 " + " 列名 " + "  数据类型" + " 本地类型名" + " 列的大小"
				+ " 小数位数" + " 数据基数" + " 是否可空" + " 索引号");
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
	 * 通过控制台输出数据库的索引信息。
	 * 
	 * @throws SQLException
	 */
	public void printIndexInfo() throws SQLException {
		ResultSet rs = dbmd.getIndexInfo(null, "%", "%", false, false);

		System.out.println(" 表名" + " 索引名" + " 索引类型" + " 索引列名" + " 索引顺序"
				+ " 小数位数" + " 数据基数" + " 是否可空" + " 索引号");
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
	 * 用于测试的main函数。
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