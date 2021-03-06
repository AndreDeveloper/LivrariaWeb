package br.com.edu.livraria.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://sql9.freemysqlhosting.net/sql9146968?useUnicode=yes&amp;characterEncoding=UTF8";
	private static String JDBC_USER = "sql9146968";
	private static String JDBC_PASSWORD = "fGQcxs2tey";

//	private static String JDBC_URL = "jdbc:mysql://localhost/livraria_l";
//	private static String JDBC_USER = "root";
//	private static String JDBC_PASSWORD = "sql1234";


	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException {
		if (driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			} catch (Exception e) {
				System.out.println("Failed to initialise JDBC driver");
				e.printStackTrace();
			}
		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
