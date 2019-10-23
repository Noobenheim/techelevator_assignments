package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.item.Drink;
import com.techelevator.item.Gum;
import com.techelevator.item.Candy;
import com.techelevator.item.Chip;
import com.techelevator.item.Item;

public class VendingMachineSlotTest {
	
	VendingMachineSlot testVMS;
	String testName = "Test Name";
	int testPrice = 250;
	int testQty = 100;
	Item testDrink = new Drink("Four Loko");
	Item testGum = new Gum("Hubba Bubba");
	Item testCandy = new Candy("Eye Candy");
	Item testChips = new Chip("Poker Chips");
	String testType = "Drink";
	

	@Test
	public void test_bad_constructor() {
		int before = -10;
		testVMS = new VendingMachineSlot(testName, testDrink, before, testPrice);		
		int after = testVMS.getQty();
		
		Assert.assertEquals(0, after);
	}

	@Test
	public void test_decrement_one() {
		int before = 10;
		testVMS = new VendingMachineSlot(testName, testDrink, before, testPrice);
		testVMS.decrement();
		int after = testVMS.getQty();
		
		Assert.assertEquals(before - 1, after);
	}

	@Test
	public void test_decrement_none() {
		int before = 0;
		testVMS = new VendingMachineSlot(testName, testDrink, before, testPrice);
		testVMS.decrement();		
		int after = testVMS.getQty();
		
		Assert.assertEquals(before, after);
	}
	
	@Test
	public void there_is_no_need_to_test_setters_and_getters_but_i_want_one_hundred_percent_coverage() {
		testVMS = new VendingMachineSlot(testName, testDrink, testQty, testPrice);		
		
		VendingMachineSlot testVMS1 = new VendingMachineSlot(testName, testDrink, testQty, testPrice);
		VendingMachineSlot testVMS2 = new VendingMachineSlot(testName, testGum, testQty, testPrice);
		VendingMachineSlot testVMS3 = new VendingMachineSlot(testName, testCandy, testQty, testPrice);
		VendingMachineSlot testVMS4 = new VendingMachineSlot(testName, testChips, testQty, testPrice);
		
		Assert.assertEquals(testName, testVMS.getName());
		Assert.assertEquals(testQty, testVMS.getQty());
		Assert.assertEquals(testPrice, testVMS.getPriceInCents());
		Assert.assertEquals(testType, testVMS.getItem().getType());

		Assert.assertEquals(testDrink.getName(), testVMS1.getItem().getName());
		Assert.assertEquals(testDrink.consume(), testVMS1.getItem().consume());

		Assert.assertEquals(testGum.getName(), testVMS2.getItem().getName());
		Assert.assertEquals(testGum.consume(), testVMS2.getItem().consume());
		
		Assert.assertEquals(testCandy.getName(), testVMS3.getItem().getName());
		Assert.assertEquals(testCandy.consume(), testVMS3.getItem().consume());
		
		Assert.assertEquals(testChips.getName(), testVMS4.getItem().getName());
		Assert.assertEquals(testChips.consume(), testVMS4.getItem().consume());
	}
	
}
