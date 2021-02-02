package com.mindtree.SuperMarketInventoryManagemant.doa.doaImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import com.mindtree.SuperMarketInventoryManagemant.doa.SuperMarketDoa;
import com.mindtree.SuperMarketInventoryManagemant.entity.SuperMarket;
import com.mindtree.SuperMarketInventoryManagemant.exception.ConnectionUtilityException;
import com.mindtree.SuperMarketInventoryManagemant.exception.DoaException;
import com.mindtree.SuperMarketInventoryManagemant.utility.ConnectionUtility;

public class SuperMarketDoaImplementation implements SuperMarketDoa {
	ConnectionUtility utility = new ConnectionUtility();

	public Map<Integer, SuperMarket> getSuperMarket() throws DoaException {
		// TODO Auto-generated method stub
		Map<Integer, SuperMarket> superMarkets = new HashMap<Integer, SuperMarket>();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			conn = utility.getConnection();
			String query = "select * from supermarket";
			preparedStatement = conn.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SuperMarket superMarket = new SuperMarket(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getFloat(3), resultSet.getInt(4));
				superMarkets.put(superMarket.getId(), superMarket);

			}

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			System.out.println("error in retriving the supermarket data ");
			throw new DoaException(e);
		} finally {
			try {
				utility.closeConnection(resultSet);
				utility.closeConnection(preparedStatement);
				utility.closeConnection(conn);
			} catch (ConnectionUtilityException e) {
				// TODO Auto-generated catch block
				throw new DoaException(e);
			}
		}

		return superMarkets;

	}

	public void deleteSuperMarket(int superMarketID) throws DoaException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = utility.getConnection();
			String query = "delete from supermarket where id=" + superMarketID;
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.executeUpdate();

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			throw new DoaException("error while deleting the supermarket");
		} finally {
			try {

				utility.closeConnection(preparedStatement);
				utility.closeConnection(conn);
			} catch (ConnectionUtilityException e) {
				// TODO Auto-generated catch block
				throw new DoaException(e);
			}
		}

	}

}
