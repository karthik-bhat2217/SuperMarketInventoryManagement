package com.mindtree.SuperMarketInventoryManagemant.doa.doaImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mindtree.SuperMarketInventoryManagemant.doa.SuperMarketInventoryManagementDoa;
import com.mindtree.SuperMarketInventoryManagemant.entity.ItemSold;
import com.mindtree.SuperMarketInventoryManagemant.exception.ConnectionUtilityException;
import com.mindtree.SuperMarketInventoryManagemant.exception.DoaException;
import com.mindtree.SuperMarketInventoryManagemant.utility.ConnectionUtility;

public class SuperMarketInventoryManagementDoaImplementation implements SuperMarketInventoryManagementDoa {
	ConnectionUtility utility = new ConnectionUtility();

	public void addItemSold(ItemSold itemSold, int remainingItem) throws DoaException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = utility.getConnection();
			String query = "insert into itemsold values(?,?,?,?)";
			preparedStatement = conn.prepareStatement(query);

			preparedStatement.setInt(1, itemSold.getId());
			preparedStatement.setString(2, itemSold.getName());
			preparedStatement.setFloat(3, itemSold.getPrice());
			preparedStatement.setInt(4, itemSold.getItemSoldCount());
			preparedStatement.execute();

			query = "update supermarket set itemavailablecount=" + remainingItem;
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.execute();

		} catch (ConnectionUtilityException e) {
			System.out.println(e);
			throw new DoaException(e);
		} catch (SQLException e) {

			throw new DoaException("Error in inserting data (itemsold)");
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
