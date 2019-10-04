package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class StringBitsTest {
	StringBits sb;
	
	@Before
	public void setup() {
		sb = new StringBits();
	}
	
	@Test
	public void bad_strings() {
		Assert.assertEquals("",sb.getBits(null));
		Assert.assertEquals("",sb.getBits(""));
	}
	
	@Test
	public void strings() {
		Assert.assertEquals("Hlo", sb.getBits("Hello"));
		Assert.assertEquals("Hello", sb.getBits("H e l l o"));
		Assert.assertEquals(" hlo", sb.getBits("  hello"));
	}
}
