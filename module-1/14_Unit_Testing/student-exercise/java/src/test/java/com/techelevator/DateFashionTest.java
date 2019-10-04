package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {
	DateFashion df;
	
	@Before
	public void setup() {
		df = new DateFashion();
	}
	
	@Test
	public void one_is_two_or_less() {
		Assert.assertEquals(0, df.getATable(2, 0));
		Assert.assertEquals(0, df.getATable(2, 2));
		Assert.assertEquals(0, df.getATable(2, 10));
		Assert.assertEquals(0, df.getATable(2, Integer.MAX_VALUE));
		Assert.assertEquals(0, df.getATable(0, 0));
		Assert.assertEquals(0, df.getATable(0, 2));
		Assert.assertEquals(0, df.getATable(0, 10));
		Assert.assertEquals(0, df.getATable(0, Integer.MAX_VALUE));
		Assert.assertEquals(0, df.getATable(-2, 0));
		Assert.assertEquals(0, df.getATable(-2, 2));
		Assert.assertEquals(0, df.getATable(-2, 10));
		Assert.assertEquals(0, df.getATable(-2, Integer.MAX_VALUE));

		Assert.assertEquals(0, df.getATable(0, 2));
		Assert.assertEquals(0, df.getATable(2, 2));
		Assert.assertEquals(0, df.getATable(10, 2));
		Assert.assertEquals(0, df.getATable(Integer.MAX_VALUE, 2));
		Assert.assertEquals(0, df.getATable(0, 0));
		Assert.assertEquals(0, df.getATable(2, 0));
		Assert.assertEquals(0, df.getATable(10, 0));
		Assert.assertEquals(0, df.getATable(Integer.MAX_VALUE, 0));
		Assert.assertEquals(0, df.getATable(0, -2));
		Assert.assertEquals(0, df.getATable(2, -2));
		Assert.assertEquals(0, df.getATable(10, -2));
		Assert.assertEquals(0, df.getATable(Integer.MAX_VALUE, -2));
	}
	
	@Test
	public void one_is_eight_or_more() {
		Assert.assertEquals(0, df.getATable(8, 0));
		Assert.assertEquals(0, df.getATable(8, 2));
		Assert.assertEquals(2, df.getATable(8, 10));
		Assert.assertEquals(2, df.getATable(8, Integer.MAX_VALUE));
		Assert.assertEquals(0, df.getATable(Integer.MAX_VALUE, 0));
		Assert.assertEquals(0, df.getATable(Integer.MAX_VALUE, 2));
		Assert.assertEquals(2, df.getATable(Integer.MAX_VALUE, 10));
		Assert.assertEquals(2, df.getATable(Integer.MAX_VALUE, Integer.MAX_VALUE));

		Assert.assertEquals(0, df.getATable(0, 8));
		Assert.assertEquals(0, df.getATable(2, 8));
		Assert.assertEquals(2, df.getATable(10, 8));
		Assert.assertEquals(2, df.getATable(Integer.MAX_VALUE, 8));
		Assert.assertEquals(0, df.getATable(0, Integer.MAX_VALUE));
		Assert.assertEquals(0, df.getATable(2, Integer.MAX_VALUE));
		Assert.assertEquals(2, df.getATable(10, Integer.MAX_VALUE));
		Assert.assertEquals(2, df.getATable(Integer.MAX_VALUE, Integer.MAX_VALUE));
	}
	
	@Test
	public void between_two_and_eight() {
		Assert.assertEquals(1, df.getATable(6, 6));
		Assert.assertEquals(1, df.getATable(7, 7));
		Assert.assertEquals(2, df.getATable(8, 8));
		Assert.assertEquals(0, df.getATable(2, 6));
		Assert.assertEquals(0, df.getATable(6, 2));
		Assert.assertEquals(1, df.getATable(3, 3));
	}
}
