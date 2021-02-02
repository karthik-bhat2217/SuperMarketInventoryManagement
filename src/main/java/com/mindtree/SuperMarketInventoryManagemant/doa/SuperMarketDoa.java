package com.mindtree.SuperMarketInventoryManagemant.doa;

import java.util.Map;

import com.mindtree.SuperMarketInventoryManagemant.entity.SuperMarket;
import com.mindtree.SuperMarketInventoryManagemant.exception.DoaException;

public interface SuperMarketDoa {
	public Map<Integer, SuperMarket> getSuperMarket() throws DoaException ;
	public void deleteSuperMarket(int superMarketID) throws DoaException;
}
