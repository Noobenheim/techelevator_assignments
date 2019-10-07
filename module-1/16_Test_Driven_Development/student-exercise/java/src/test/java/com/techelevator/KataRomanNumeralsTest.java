package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataRomanNumeralsTest {
	@Test
	public final void test_for_0_or_less() {
		Assert.assertNull(RomanNumeral.convert(0));
		Assert.assertNull(RomanNumeral.convert(-1));
		Assert.assertNull(RomanNumeral.convert(Integer.MIN_VALUE));
	}
	
	@Test
	public void one_converts_correctly() {
		//Arrange
		final int oneInt = 1;
		final String expectedString = "I";

		//Act
		String output = RomanNumeral.convert(oneInt);
        
		//Assert
		Assert.assertEquals("One should convert correctly",expectedString, output);
    }
	
	@Test
	public final void test_for_low_numbers() {
		Assert.assertEquals("II", RomanNumeral.convert(2));
		Assert.assertEquals("III", RomanNumeral.convert(3));
		Assert.assertEquals("IV", RomanNumeral.convert(4));
		Assert.assertEquals("V", RomanNumeral.convert(5));
		Assert.assertEquals("VI", RomanNumeral.convert(6));
		Assert.assertEquals("VII", RomanNumeral.convert(7));
		Assert.assertEquals("VIII", RomanNumeral.convert(8));
		Assert.assertEquals("IX", RomanNumeral.convert(9));
		Assert.assertEquals("X", RomanNumeral.convert(10));
		Assert.assertEquals("XI", RomanNumeral.convert(11));
		Assert.assertEquals("XII", RomanNumeral.convert(12));
		Assert.assertEquals("XIII", RomanNumeral.convert(13));
		Assert.assertEquals("XIV", RomanNumeral.convert(14));
		Assert.assertEquals("XV", RomanNumeral.convert(15));
		Assert.assertEquals("XVI", RomanNumeral.convert(16));
		Assert.assertEquals("XVII", RomanNumeral.convert(17));
		Assert.assertEquals("XVIII", RomanNumeral.convert(18));
		Assert.assertEquals("XIX", RomanNumeral.convert(19));
		Assert.assertEquals("XX", RomanNumeral.convert(20));
	}
	
	@Test
	public final void test_for_edge_cases() {
		Assert.assertEquals("XL", RomanNumeral.convert(40));
		Assert.assertEquals("XLI", RomanNumeral.convert(41));
		Assert.assertEquals("XLII", RomanNumeral.convert(42));
		Assert.assertEquals("XL", RomanNumeral.convert(40));
		Assert.assertEquals("XLV", RomanNumeral.convert(45));
		Assert.assertEquals("L", RomanNumeral.convert(50));
		Assert.assertEquals("XC", RomanNumeral.convert(90));
		Assert.assertEquals("XCI", RomanNumeral.convert(91));
		Assert.assertEquals("XCIV", RomanNumeral.convert(94));
		Assert.assertEquals("C", RomanNumeral.convert(100));
		Assert.assertEquals("CD", RomanNumeral.convert(400));
		Assert.assertEquals("CDX", RomanNumeral.convert(410));
		Assert.assertEquals("D", RomanNumeral.convert(500));
		Assert.assertEquals("DVI", RomanNumeral.convert(506));
		Assert.assertEquals("CM", RomanNumeral.convert(900));
		Assert.assertEquals("CML", RomanNumeral.convert(950));
		Assert.assertEquals("M", RomanNumeral.convert(1000));
		Assert.assertEquals("MMXIX", RomanNumeral.convert(2019));
	}
}
