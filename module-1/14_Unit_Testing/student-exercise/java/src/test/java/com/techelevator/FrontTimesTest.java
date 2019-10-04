package com.techelevator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class FrontTimesTest {
	FrontTimes ft;
	
	@Before
	public void setup() {
		ft = new FrontTimes();
	}

	@Test
	public void empty_or_null() {
		Assert.assertEquals("", ft.generateString("", 0));
		Assert.assertEquals("", ft.generateString(null, 0));
		Assert.assertEquals("", ft.generateString("", -1));
		Assert.assertEquals("", ft.generateString(null, -1));
	}
	
	@Test
	public void short_string() {
		Assert.assertEquals("aaaaa", ft.generateString("a", 5));
		// this is a long Assert lol
		//Assert.assertEquals("", ft.generateString(new String(new char[Integer.MAX_VALUE]).replace("\0","a");, Integer.MAX_VALUE));
		Assert.assertEquals("", ft.generateString("a", 0));
		Assert.assertEquals("", ft.generateString("a", -100));
	}
	
	@Test
	public void long_string() {
		Assert.assertEquals("abcabcabc", ft.generateString("abc easy as 123", 3));
		Assert.assertEquals("               ", ft.generateString("   helloooo", 5));
	}
}
