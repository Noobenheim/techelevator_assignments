package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class Lucky13Test {
	Lucky13 l13;
	
	@Before
	public void setup() {
		l13 = new Lucky13();
	}
	
	@Test
	public void fake_arrays() {
		Assert.assertTrue(l13.getLucky(new int[] {}));
		Assert.assertTrue(l13.getLucky(null));
	}
	
	@Test
	public void small_arrays() {
		Assert.assertFalse(l13.getLucky(new int[] {1,1,1}));
		Assert.assertFalse(l13.getLucky(new int[] {1,Integer.MAX_VALUE,100}));
		Assert.assertTrue(l13.getLucky(new int[] {2,2,2}));
		Assert.assertFalse(l13.getLucky(new int[] {1}));
		Assert.assertFalse(l13.getLucky(new int[] {3}));
		Assert.assertTrue(l13.getLucky(new int[] {5}));
		Assert.assertTrue(l13.getLucky(new int[] {7,9}));
	}
	
	@Test
	public void big_array() {
		Assert.assertFalse(l13.getLucky(new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
		Assert.assertTrue(l13.getLucky(new int[] {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}));
		Assert.assertFalse(l13.getLucky(new int[] {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}));
		Assert.assertTrue(l13.getLucky(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
		Assert.assertFalse(l13.getLucky(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1}));
		Assert.assertTrue(l13.getLucky(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, Integer.MAX_VALUE}));
		Assert.assertFalse(l13.getLucky(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
	}
}
