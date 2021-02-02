package com.mindtree.SuperMarketInventoryManagemant.doa.doaImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.mindtree.SuperMarketInventoryManagemant.doa.ItemSoldDoa;
import com.mindtree.SuperMarketInventoryManagemant.entity.ItemSold;
import com.mindtree.SuperMarketInventoryManagemant.exception.ConnectionUtilityException;
import com.mindtree.SuperMarketInventoryManagemant.exception.DoaException;
import com.mindtree.SuperMarketInventoryManagemant.utility.ConnectionUtility;

public class ItemSoldDoaImplementation implements ItemSoldDoa {
	ConnectionUtility utility = new ConnectionUtility();

	public List<ItemSold> getItemSold() throws DoaException {
		// TODO Auto-generated method stub
		List<ItemSold> items = new ArrayList<ItemSold>();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			conn = utility.getConnection();
			String query = "select * from itemsold";
			preparedStatement = conn.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ItemSold item = new ItemSold(resultSet.getInt(1), resultSet.getString(2), resultSet.getFloat(3),
						resultSet.getInt(4));
				items.add(item);

			}

		} catch (ConnectionUtilityException e) {
			throw new DoaException(e);
		} catch (SQLException e) {
			System.out.println(e);
			throw new DoaException("error in retriving itemsold ");
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

		return items;

	}

}
