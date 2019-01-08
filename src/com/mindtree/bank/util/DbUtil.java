package com.mindtree.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.bank.exception.utilException.DbUtilException;

public class DbUtil {

	public static final String CLASSNAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/kalinga_bank";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Welcome123";

	public static Connection getConnection() throws DbUtilException {
		Connection conn = null;
		try {
			Class.forName(CLASSNAME);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new DbUtilException("Driver not loaded!!", e);
		} catch (SQLException e) {
			throw new DbUtilException("Connection not established!!", e);
		}
		return conn;
	}

	public static void closeConnection(Connection conn) throws DbUtilException {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbUtilException("Connection not established!!", e);
			}
		}
	}
}
