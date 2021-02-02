package com.mindtree.SuperMarketInventoryManagemant.service;

import com.mindtree.SuperMarketInventoryManagemant.entity.ItemSold;
import com.mindtree.SuperMarketInventoryManagemant.exception.ServiceLayerException;

public interface SuperMarketInventoryManagementService {

	public void addItemSoldDetails(ItemSold itemSold) throws ServiceLayerException;
}
