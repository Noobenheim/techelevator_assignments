package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.item.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineTest {

	private final int FULL_CAPACITY = VendingMachine.FULL_CAPACITY;
	private final String VALID_SLOT = "A1";
	private final String INVALID_SLOT = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890";
	
	private VendingMachine testVM;
	
	
	@Before
	public void setup_vm() throws FileNotFoundException, IOException {
		File inventoryFile = new File("vendingmachine.csv");
		testVM = new VendingMachine(inventoryFile, false); // disable logging for Unit Testing (we aren't using log4j yet)
	}
	
	@Test(expected = IOException.class)
	public void test_vending_machine_constructor_throws_IOException() throws FileNotFoundException, IOException {
		File systemFile = new File("/.file");
		VendingMachine badTestVM = new VendingMachine(systemFile);
	}
	
	@Test(expected = FileNotFoundException.class)
	public void test_vending_machine_constructor_throws_FileNotFoundException() throws FileNotFoundException, IOException {
		File systemFile = new File("/.thisfilecouldnotpossiblyexistcouldit");
		VendingMachine badTestVM = new VendingMachine(systemFile);
	}

	@Test
	public void test_display_menu_should_return_a_valid_string() {
		String testString = testVM.getMenu();
		
		Assert.assertNotNull(testString);
		Assert.assertNotEquals(0, testString.length());
	}
	
	
	@Test
	public void test_valid_slot_with_money_returns_item() {
		testVM.addMoney(10000);
		
		Item vendedItem = testVM.vend(VALID_SLOT);
		
		Assert.assertNotNull(vendedItem);
	}

	@Test
	public void test_valid_slot_with_no_quantity_returns_null() {
		testVM.addMoney(999999);
		int itemsRemainingInValidSlot = testVM.getQty(VALID_SLOT);
		
		for(int i = 0; i < itemsRemainingInValidSlot; i++) {
			testVM.vend(VALID_SLOT);
		}

		Item vendedItem = testVM.vend(VALID_SLOT);
		
		Assert.assertNull(vendedItem);
	}

	@Test
	public void test_valid_slot_without_money_returns_null() {
		Item vendedItem = testVM.vend(VALID_SLOT);
		
		Assert.assertNull(vendedItem);
	}
	
	@Test
	public void test_invalid_slot_returns_null() {
		Item vendedItem = testVM.vend(INVALID_SLOT);
		
		Assert.assertNull(vendedItem);
	}
	
	@Test
	public void test_full_qty_for_valid_slot() {
		int qty = testVM.getQty(VALID_SLOT);
		
		Assert.assertEquals(FULL_CAPACITY, qty);
	}

	@Test
	public void test_empty_qty_for_invalid_slot() {
		int qty = testVM.getQty(INVALID_SLOT);
		
		Assert.assertEquals(0, qty);		
	}
	
	@Test
	public void test_get_money() {
		String sessionMoney = testVM.getSessionMoney();
		
		Assert.assertNotNull(sessionMoney);
		Assert.assertNotEquals(0, sessionMoney);
	}

	@Test
	public void test_consume_three_valid_items() {
		testVM.addMoney(10000);			

		testVM.vend(VALID_SLOT);
		testVM.vend(VALID_SLOT);
		testVM.vend(VALID_SLOT);

		String consume = testVM.consumeItems();
		Assert.assertNotNull(consume);
		
		int countLines = consume.length() - consume.replace("\n", "").length();
		Assert.assertEquals(3, countLines);
	}

	@Test
	public void test_add_money() {
		String before = testVM.getSessionMoney();
		
		testVM.addMoney(100);
		
		String after = testVM.getSessionMoney();
		
		Assert.assertNotEquals(before, after);		
	}

	@Test
	public void test_give_change() {
		String result = testVM.giveChange();
		
		Assert.assertNotNull(result);
	}
	
	@Test
	public void test_static_give_change() {
		Map<Integer, String> changeMap = new HashMap<Integer, String>();

		changeMap.put(0,  "0 Quarters, 0 Dimes, 0 Nickels");
		changeMap.put(5,  "0 Quarters, 0 Dimes, 1 Nickel");
		changeMap.put(10, "0 Quarters, 1 Dime, 0 Nickels");
		changeMap.put(15, "0 Quarters, 1 Dime, 1 Nickel");
		changeMap.put(20, "0 Quarters, 2 Dimes, 0 Nickels");
		changeMap.put(25, "1 Quarter, 0 Dimes, 0 Nickels");
		changeMap.put(30, "1 Quarter, 0 Dimes, 1 Nickel");
		changeMap.put(35, "1 Quarter, 1 Dime, 0 Nickels");
		changeMap.put(40, "1 Quarter, 1 Dime, 1 Nickel");
		changeMap.put(45, "1 Quarter, 2 Dimes, 0 Nickels");
		changeMap.put(50, "2 Quarters, 0 Dimes, 0 Nickels");
		changeMap.put(55, "2 Quarters, 0 Dimes, 1 Nickel");
		changeMap.put(60, "2 Quarters, 1 Dime, 0 Nickels");
		changeMap.put(65, "2 Quarters, 1 Dime, 1 Nickel");
		changeMap.put(70, "2 Quarters, 2 Dimes, 0 Nickels");
		changeMap.put(75, "3 Quarters, 0 Dimes, 0 Nickels");

		changeMap.put(150, "6 Quarters, 0 Dimes, 0 Nickels");
		changeMap.put(155, "6 Quarters, 0 Dimes, 1 Nickel");
		changeMap.put(160, "6 Quarters, 1 Dime, 0 Nickels");
		changeMap.put(165, "6 Quarters, 1 Dime, 1 Nickel");
		
		for(Integer i : changeMap.keySet()) {
			static_change_helper(i, changeMap.get(i));
		}
	}
	
	private void static_change_helper(int amount, String expected) {
		String actual = VendingMachine.giveChange(amount);		

		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);
	}
	
}
