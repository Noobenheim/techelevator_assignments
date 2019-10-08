package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class MaxEnd3Test {
	MaxEnd3 me;
	
	@Before
	public void setup() {
		me = new MaxEnd3();
	}
	
	@Test
	public void bad_arrays() {
		// this fails (NullPointerException)
		//Assert.assertEquals(0, me.makeArray(null));
		// this fails (IndexOutOfBoundsException)
		//Assert.assertEquals(0, me.makeArray(new int[] {}));
		Assert.assertArrayEquals(new int[] { 3 }, me.makeArray(new int[] { 3 }));
		Assert.assertArrayEquals(new int[] { 6, 6 }, me.makeArray(new int[] { 3, 6 }));
		Assert.assertArrayEquals(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE }, me.makeArray(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE }));
		Assert.assertArrayEquals(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE }, me.makeArray(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE }));
	}
	
	@Test
	public void normal_arrays() {
		Assert.assertArrayEquals(new int[] { 3, 3, 3 }, me.makeArray(new int[] { 3, 3, 3 }));
		Assert.assertArrayEquals(new int[] { 3, 3, 3 }, me.makeArray(new int[] { 1, 6, 3 }));
		Assert.assertArrayEquals(new int[] { 3, 3, 3 }, me.makeArray(new int[] { 3, 6, 1 }));
		Assert.assertArrayEquals(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }, me.makeArray(new int[] { Integer.MIN_VALUE, 1, Integer.MAX_VALUE }));
		Assert.assertArrayEquals(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }, me.makeArray(new int[] { Integer.MAX_VALUE, -1, Integer.MIN_VALUE }));
		Assert.assertArrayEquals(new int[] { 1, 1, 1 }, me.makeArray(new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, 1 }));
		Assert.assertArrayEquals(new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE }, me.makeArray(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 1 }));
	}
}
