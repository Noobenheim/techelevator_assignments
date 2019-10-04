package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTest {
	SameFirstLast sfl;
	
	@Before
	public void setup() {
		sfl = new SameFirstLast();
	}
	
	@Test
	public void bad_arrays() {
		Assert.assertFalse(sfl.isItTheSame(null));
		Assert.assertFalse(sfl.isItTheSame(new int[] {}));
		Assert.assertTrue(sfl.isItTheSame(new int[] {1}));
	}
	
	@Test
	public void test_arrays() {
		Assert.assertTrue(sfl.isItTheSame(new int[] {1, 1}));
		Assert.assertTrue(sfl.isItTheSame(new int[] {-1, -1}));
		Assert.assertTrue(sfl.isItTheSame(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}));
		Assert.assertTrue(sfl.isItTheSame(new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE}));
		Assert.assertFalse(sfl.isItTheSame(new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE} ));
		Assert.assertFalse(sfl.isItTheSame(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE} ));
	}
	
	@Test
	public void big_arrays() {
		Assert.assertTrue(sfl.isItTheSame(new int[] {1, 2, 3, 1}));
		Assert.assertTrue(sfl.isItTheSame(new int[] {-1, 2, 8, -1}));
		Assert.assertTrue(sfl.isItTheSame(new int[] {Integer.MAX_VALUE, 9, 4, Integer.MAX_VALUE}));
		Assert.assertTrue(sfl.isItTheSame(new int[] {Integer.MIN_VALUE, 3, 3, Integer.MIN_VALUE}));
		Assert.assertFalse(sfl.isItTheSame(new int[] {Integer.MAX_VALUE, 82, 41, Integer.MIN_VALUE} ));
		Assert.assertFalse(sfl.isItTheSame(new int[] {Integer.MIN_VALUE, 99, 11, Integer.MAX_VALUE} ));
		Assert.assertFalse(sfl.isItTheSame(new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, -1} ));
		Assert.assertFalse(sfl.isItTheSame(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 1} ));
		Assert.assertFalse(sfl.isItTheSame(new int[] {1, 2, 3, 182}));
		Assert.assertFalse(sfl.isItTheSame(new int[] {-1, 2, 8, 55221123}));
	}
}
