package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractDao {
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost/tsubuyaki";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "";

	protected static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected void close(Connection conn){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	protected void close(PreparedStatement pStmt){
		if (pStmt != null) {
			try {
				pStmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	protected void close(ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}