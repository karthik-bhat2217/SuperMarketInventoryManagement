package com.mindtree.SuperMarketInventoryManagemant.service.serviceImplementation;

import java.util.Collections;
import java.util.List;

import com.mindtree.SuperMarketInventoryManagemant.doa.ItemSoldDoa;
import com.mindtree.SuperMarketInventoryManagemant.doa.doaImplementation.ItemSoldDoaImplementation;
import com.mindtree.SuperMarketInventoryManagemant.entity.ItemSold;
import com.mindtree.SuperMarketInventoryManagemant.exception.DoaException;
import com.mindtree.SuperMarketInventoryManagemant.exception.ServiceLayerException;
import com.mindtree.SuperMarketInventoryManagemant.service.ItemSoldService;

public class ItemSoldServiceImplementation implements ItemSoldService {
	ItemSoldDoa idoa = new ItemSoldDoaImplementation();

	public void sortItemSold() throws ServiceLayerException {
		// TODO Auto-generated method stub
		try {
			List<ItemSold> items = idoa.getItemSold();
			Collections.sort(items);
			displayItemSold(items);
		} catch (DoaException e) {
			// TODO Auto-generated catch block
			throw new ServiceLayerException(e);
		}

	}

	private void displayItemSold(List<ItemSold> items) {
		// TODO Auto-generated method stub
		for (ItemSold itemSold : items) {

			System.out.println("item name" + itemSold.getName());
			System.out.println("item price" + itemSold.getPrice());
			System.out.println("item soldcount" + itemSold.getItemSoldCount());
			System.out.println("----------------------------------------------------------------");
		}
	}

}
