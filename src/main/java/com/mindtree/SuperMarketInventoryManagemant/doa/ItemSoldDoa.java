package com.mindtree.SuperMarketInventoryManagemant.doa;

import java.util.List;

import com.mindtree.SuperMarketInventoryManagemant.entity.ItemSold;
import com.mindtree.SuperMarketInventoryManagemant.exception.DoaException;

public interface ItemSoldDoa {
	public List<ItemSold> getItemSold() throws DoaException ;

}
