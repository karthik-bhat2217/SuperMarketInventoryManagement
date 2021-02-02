package com.mindtree.SuperMarketInventoryManagemant.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mindtree.SuperMarketInventoryManagemant.exception.ConnectionUtilityException;

public class ConnectionUtility {
	private static final String URL = "jdbc:mysql://localhost:3306/InventoryManagement?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root123";
	Connection conn;

	public Connection getConnection() throws ConnectionUtilityException {

		try {

			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); // For MySQL only

		} catch (SQLException e) {
			throw new ConnectionUtilityException("Could not make connection");
		}
		return conn;

	}

	public void closeConnection(Connection conn) throws ConnectionUtilityException {

		try {
			if (conn != null)

				conn.close();

		} catch (SQLException e) {
			throw new ConnectionUtilityException("Could not close Connection");
		}

	}

	public void closeConnection(PreparedStatement preparedStatement) throws ConnectionUtilityException {
		try {
			{
				if (preparedStatement != null)
					preparedStatement.close();
			}
		} catch (SQLException e) {
			throw new ConnectionUtilityException("Could not close prepared statement");

		}
	}

	public void closeConnection(ResultSet resultSet) throws ConnectionUtilityException {
		try {
			if (resultSet != null)
				resultSet.close();

		} catch (SQLException e) {
			throw new ConnectionUtilityException("Could not close prepared statement");

		}
	}
}
