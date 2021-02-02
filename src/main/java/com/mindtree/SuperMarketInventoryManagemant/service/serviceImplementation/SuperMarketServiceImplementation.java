package com.mindtree.SuperMarketInventoryManagemant.service.serviceImplementation;

import java.util.HashMap;
import java.util.Map;
import com.mindtree.SuperMarketInventoryManagemant.doa.SuperMarketDoa;
import com.mindtree.SuperMarketInventoryManagemant.doa.doaImplementation.SuperMarketDoaImplementation;
import com.mindtree.SuperMarketInventoryManagemant.entity.SuperMarket;
import com.mindtree.SuperMarketInventoryManagemant.exception.DoaException;
import com.mindtree.SuperMarketInventoryManagemant.exception.NoSuperMarketFoundException;
import com.mindtree.SuperMarketInventoryManagemant.exception.ServiceLayerException;
import com.mindtree.SuperMarketInventoryManagemant.service.SuperMarketService;

public class SuperMarketServiceImplementation implements SuperMarketService {
	SuperMarketDoa sdoa = new SuperMarketDoaImplementation();
	static Map<Integer, SuperMarket> superMarkets = new HashMap<Integer, SuperMarket>();

	public void deleteSuperMarket(int superMarketID) throws ServiceLayerException {
		// TODO Auto-generated method stub
		boolean found = false;
		try {
			superMarkets = sdoa.getSuperMarket();
			for (int i : superMarkets.keySet()) {
				SuperMarket superMarket = superMarkets.get(i);
				if (superMarket.getId() == superMarketID) {
					found = true;
					sdoa.deleteSuperMarket(superMarketID);
				}
			}
			if (!found) {
				throw new NoSuperMarketFoundException("Super market not found");
			}

		} catch (DoaException e) {
			throw new ServiceLayerException(e);
		}
	}

}
