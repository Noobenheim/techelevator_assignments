package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataPotterTest {
	KataPotter kp;
	int[] input;
	
	@Before
	public void setup() {
		kp = new KataPotter();
	}
	
	@Test
	public void buy_one_book() {
		input = new int[] { 1, 0, 0, 0, 0 };
		Assert.assertEquals(8.0, kp.getCost(input), 0.01);
		input = new int[] { 0, 1, 0, 0, 0 };
		Assert.assertEquals(8.0, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 1, 0, 0 };
		Assert.assertEquals(8.0, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 0, 1, 0 };
		Assert.assertEquals(8.0, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 0, 0, 1 };
		Assert.assertEquals(8.0, kp.getCost(input), 0.01);
	}
	
	@Test
	public void buy_two_same_books() {
		input = new int[] { 2, 0, 0, 0, 0 };
		Assert.assertEquals(16.0, kp.getCost(input), 0.01);
		input = new int[] { 0, 2, 0, 0, 0 };
		Assert.assertEquals(16.0, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 2, 0, 0 };
		Assert.assertEquals(16.0, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 0, 2, 0 };
		Assert.assertEquals(16.0, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 0, 0, 2 };
		Assert.assertEquals(16.0, kp.getCost(input), 0.01);
	}
	
	@Test
	public void buy_two_different_books() {
		double expected = 2 * 8.0 * 0.95; // 5% discount
		input = new int[] { 1, 1, 0, 0, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 0, 1, 0, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 0, 0, 1, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 0, 0, 0, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 1, 1, 0, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 1, 0, 1, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 1, 0, 0, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 1, 1, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 1, 0, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 0, 1, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
	}
	
	@Test
	public void buy_three_different_books() {
		double expected = 3 * 8.0 * .90; // 10% discount
		input = new int[] { 1, 1, 1, 0, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 1, 0, 1, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 1, 0, 0, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 0, 1, 1, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 0, 1, 0, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 0, 0, 1, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 1, 1, 1, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 1, 1, 0, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 1, 0, 1, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 0, 1, 1, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
	}
	
	@Test
	public void buy_four_different_books() {
		double expected = 4 * 8.0 * 0.80; // 20% discount
		input = new int[] { 1, 1, 1, 1, 0 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 1, 1, 0, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 1, 0, 1, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 1, 0, 1, 1, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
		input = new int[] { 0, 1, 1, 1, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
	}
	
	@Test
	public void buy_five_different_books() {
		double expected = 5 * 8.0 * 0.75; // 25% discount
		input = new int[] { 1, 1, 1, 1, 1 };
		Assert.assertEquals(expected, kp.getCost(input), 0.01);
	}
	
	@Test
	public void buy_2_2_2_1_1() {
		input = new int[] { 2, 2, 2, 1, 1 };
		Assert.assertEquals(51.20, kp.getCost(input), 0.01);
	}
}
