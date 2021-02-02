package com.mindtree.SuperMarketInventoryManagemant.doa;

import com.mindtree.SuperMarketInventoryManagemant.entity.ItemSold;
import com.mindtree.SuperMarketInventoryManagemant.exception.DoaException;

public interface SuperMarketInventoryManagementDoa {
	public void addItemSold(ItemSold itemSold, int item) throws DoaException ;
}
