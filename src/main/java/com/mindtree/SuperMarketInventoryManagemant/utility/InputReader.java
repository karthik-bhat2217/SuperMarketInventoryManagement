package com.mindtree.SuperMarketInventoryManagemant.utility;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mindtree.SuperMarketInventoryManagemant.entity.ItemSold;
import com.mindtree.SuperMarketInventoryManagemant.exception.ServiceLayerException;

public class InputReader {
	Scanner s;

	public InputReader(Scanner s) {
		this.s = s;
	}

	public Byte readChoice() {

		byte input = -1;
		do {
			try {

				input = s.nextByte();
			} catch (InputMismatchException e) {
				System.out.println("Wrong input");
				s.next();
			}
		} while (input == -1);

		return input;

	}

	public ItemSold readItemSoldDetails() throws ServiceLayerException {
		ItemSold itemSold = new ItemSold();

		try {

			System.out.println("Enter the super Market ID");
			itemSold.setId(s.nextInt());
			System.out.println("Enter the item name");
			itemSold.setName(s.next());
			System.out.println("Enter the item  price");
			itemSold.setPrice(s.nextFloat());
			System.out.println("Enter the no of item sold");
			itemSold.setItemSoldCount(s.nextInt());

		} catch (InputMismatchException e) {
			throw new ServiceLayerException("Invalid input");
		}

		return itemSold;
	}

	public int readId() {
		int input = -1;
		do {
			try {
				System.out.println("Enter the id of the SuperMarket");
				input = s.nextByte();
			} catch (InputMismatchException e) {
				System.out.println("Wrong input");
			}
		} while (input == -1);
		return input;
	}
}
