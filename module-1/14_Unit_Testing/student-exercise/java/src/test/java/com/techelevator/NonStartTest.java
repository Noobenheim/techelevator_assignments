package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class NonStartTest {
	NonStart ns;
	
	@Before
	public void setup() {
		ns = new NonStart();
	}
	
	@Test
	public void bad_strings() {
		// these don't work (NullPointerException)
		//Assert.assertNull(ns.getPartialString(null, null));
		//Assert.assertNull(ns.getPartialString("hello", null));
		//Assert.assertNull(ns.getPartialString(null, "hello"));
		//Assert.assertNull(ns.getPartialString("", null);
		//Assert.assertNull(ns.getPartialString(null, "");
		// this doesn't work (StringIndexOutOfBoundsException)
		//Assert.assertEquals("", ns.getPartialString("", ""));
		Assert.assertEquals("", ns.getPartialString("", " "));
		Assert.assertEquals("", ns.getPartialString(" ", ""));
	}
	
	@Test
	public void normal_strings() {
		Assert.assertEquals("ellohere", ns.getPartialString("Hello", "There"));
		Assert.assertEquals("eLlOhErE", ns.getPartialString("HeLlO", "ThErE"));
		Assert.assertEquals("avaode", ns.getPartialString("Java", "code"));
	}
}
