package com.mindtree.SuperMarketInventoryManagemant.client;

import java.util.Scanner;
import com.mindtree.SuperMarketInventoryManagemant.exception.SuperMarketInventoryManagementException;
import com.mindtree.SuperMarketInventoryManagemant.service.ItemSoldService;
import com.mindtree.SuperMarketInventoryManagemant.service.SuperMarketInventoryManagementService;
import com.mindtree.SuperMarketInventoryManagemant.service.SuperMarketService;
import com.mindtree.SuperMarketInventoryManagemant.service.serviceImplementation.ItemSoldServiceImplementation;
import com.mindtree.SuperMarketInventoryManagemant.service.serviceImplementation.SuperMarketInventoryManagementServiceImplementation;
import com.mindtree.SuperMarketInventoryManagemant.service.serviceImplementation.SuperMarketServiceImplementation;
import com.mindtree.SuperMarketInventoryManagemant.utility.InputReader;

public class SuperMarketInventoryManagemantApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuperMarketInventoryManagemantApplication app = new SuperMarketInventoryManagemantApplication();
		Scanner s = new Scanner(System.in);
		InputReader reader = new InputReader(s);
		SuperMarketService superMarketimpl = new SuperMarketServiceImplementation();
		ItemSoldService soldimpl = new ItemSoldServiceImplementation();
		SuperMarketInventoryManagementService inventoryimpl = new SuperMarketInventoryManagementServiceImplementation();
		boolean exit = false;
		do {
			app.displayMenu();
			byte choice = reader.readChoice();
			switch (choice) {
			case 1:
				try {
					inventoryimpl.addItemSoldDetails(reader.readItemSoldDetails());
				} catch (SuperMarketInventoryManagementException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					superMarketimpl.deleteSuperMarket(reader.readId());
				} catch (SuperMarketInventoryManagementException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					soldimpl.sortItemSold();
				} catch (SuperMarketInventoryManagementException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Thank you!!");
				exit = true;
				break;
			default:
				System.out.println("Wrong input");
			}

		} while (!exit);

	}

	private void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.Add itemsold\n2.Delete supermarket\n3.Sort item sold based on price\n4:Exit");

	}

}
