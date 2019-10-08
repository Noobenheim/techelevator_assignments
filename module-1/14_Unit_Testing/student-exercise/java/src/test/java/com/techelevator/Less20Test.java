package com.techelevator;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class Less20Test {
	Less20 l2;
	
	@Before
	public void setup() {
		l2 = new Less20();
	}
	
	@Test
	public void low_numbers() {
		Assert.assertFalse(l2.isLessThanMultipleOf20(0));
		Assert.assertFalse(l2.isLessThanMultipleOf20(2));
		Assert.assertFalse(l2.isLessThanMultipleOf20(3));
		Assert.assertFalse(l2.isLessThanMultipleOf20(4));
		Assert.assertFalse(l2.isLessThanMultipleOf20(7));
		Assert.assertFalse(l2.isLessThanMultipleOf20(10));
		Assert.assertFalse(l2.isLessThanMultipleOf20(12));
		Assert.assertFalse(l2.isLessThanMultipleOf20(17));
		Assert.assertTrue(l2.isLessThanMultipleOf20(18));
		Assert.assertTrue(l2.isLessThanMultipleOf20(19));
		Assert.assertFalse(l2.isLessThanMultipleOf20(20));
		Assert.assertFalse(l2.isLessThanMultipleOf20(220));
		Assert.assertFalse(l2.isLessThanMultipleOf20(100));
		Assert.assertFalse(l2.isLessThanMultipleOf20(18*27));
		Assert.assertFalse(l2.isLessThanMultipleOf20(19*19));
		Assert.assertTrue(l2.isLessThanMultipleOf20(20*100 - 1));
	}
	
	@Test
	public void large_numbers() {
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE));
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-1));
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-2));
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-3));
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-4));
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-5));
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-6));
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-7));
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-10));
		Assert.assertFalse(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-11));
		Assert.assertTrue(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-8));
		Assert.assertTrue(l2.isLessThanMultipleOf20(Integer.MAX_VALUE-9));
	}
	
	@Test
	public void negative_numbers() {
		Assert.assertFalse(l2.isLessThanMultipleOf20(-1));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-2));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-3));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-4));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-5));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-6));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-7));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-8));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-9));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-18));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-19));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-20));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-21));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-22));
		Assert.assertFalse(l2.isLessThanMultipleOf20(-23));
	}
}
