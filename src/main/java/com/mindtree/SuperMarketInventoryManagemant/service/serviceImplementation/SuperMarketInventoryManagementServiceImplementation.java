package com.mindtree.SuperMarketInventoryManagemant.service.serviceImplementation;

import java.util.HashMap;
import java.util.Map;

import com.mindtree.SuperMarketInventoryManagemant.doa.SuperMarketDoa;
import com.mindtree.SuperMarketInventoryManagemant.doa.SuperMarketInventoryManagementDoa;
import com.mindtree.SuperMarketInventoryManagemant.doa.doaImplementation.SuperMarketDoaImplementation;
import com.mindtree.SuperMarketInventoryManagemant.doa.doaImplementation.SuperMarketInventoryManagementDoaImplementation;
import com.mindtree.SuperMarketInventoryManagemant.entity.ItemSold;
import com.mindtree.SuperMarketInventoryManagemant.entity.SuperMarket;
import com.mindtree.SuperMarketInventoryManagemant.exception.DoaException;
import com.mindtree.SuperMarketInventoryManagemant.exception.ItemNotAvailableException;
import com.mindtree.SuperMarketInventoryManagemant.exception.NoSuperMarketFoundException;
import com.mindtree.SuperMarketInventoryManagemant.exception.ServiceLayerException;
import com.mindtree.SuperMarketInventoryManagemant.service.SuperMarketInventoryManagementService;

public class SuperMarketInventoryManagementServiceImplementation implements SuperMarketInventoryManagementService {
	SuperMarketDoa sdoa = new SuperMarketDoaImplementation();
	SuperMarketInventoryManagementDoa idoa = new SuperMarketInventoryManagementDoaImplementation();
	static Map<Integer, SuperMarket> superMarkets = new HashMap<Integer, SuperMarket>();

	public void addItemSoldDetails(ItemSold itemSold) throws ServiceLayerException {
		// TODO Auto-generated method stub
		boolean superMarketFound = false;
		boolean itemAvailable = false;
		try {
			superMarkets = sdoa.getSuperMarket();
			for (int i : superMarkets.keySet()) {
				SuperMarket superMarket = superMarkets.get(i);
				if (superMarket.getId() == itemSold.getId()) {
					superMarketFound = true;
					if (itemSold.getItemSoldCount() < superMarket.getItemAvailableCount()) {
						itemAvailable = true;
						int remainingItem = superMarket.getItemAvailableCount() - itemSold.getItemSoldCount();
						idoa.addItemSold(itemSold, remainingItem);
					}
				}
			}
			if (superMarketFound && !itemAvailable) {
				throw new ItemNotAvailableException("Item not available");
			} else if (!superMarketFound) {
				throw new NoSuperMarketFoundException("super market not found");
			}

		} catch (DoaException e) {
			// TODO Auto-generated catch block
			throw new ServiceLayerException(e);
		}
	}

}
