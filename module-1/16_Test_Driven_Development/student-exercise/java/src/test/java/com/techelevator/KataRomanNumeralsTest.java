package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataRomanNumeralsTest {
	@Test
	public final void test_for_0_or_less() {
		Assert.assertNull(KataRomanNumerals.convert(0));
		Assert.assertNull(KataRomanNumerals.convert(-1));
		Assert.assertNull(KataRomanNumerals.convert(Integer.MIN_VALUE));
	}
	
	@Test
	public void one_converts_correctly() {
		//Arrange
		final int oneInt = 1;
		final String expectedString = "I";

		//Act
		String output = KataRomanNumerals.convert(oneInt);
        
		//Assert
		Assert.assertEquals("One should convert correctly",expectedString, output);
    }
	
	@Test
	public final void test_for_low_numbers() {
		Assert.assertEquals("II", KataRomanNumerals.convert(2));
		Assert.assertEquals("III", KataRomanNumerals.convert(3));
		Assert.assertEquals("IV", KataRomanNumerals.convert(4));
		Assert.assertEquals("V", KataRomanNumerals.convert(5));
		Assert.assertEquals("VI", KataRomanNumerals.convert(6));
		Assert.assertEquals("VII", KataRomanNumerals.convert(7));
		Assert.assertEquals("VIII", KataRomanNumerals.convert(8));
		Assert.assertEquals("IX", KataRomanNumerals.convert(9));
		Assert.assertEquals("X", KataRomanNumerals.convert(10));
		Assert.assertEquals("XI", KataRomanNumerals.convert(11));
		Assert.assertEquals("XII", KataRomanNumerals.convert(12));
		Assert.assertEquals("XIII", KataRomanNumerals.convert(13));
		Assert.assertEquals("XIV", KataRomanNumerals.convert(14));
		Assert.assertEquals("XV", KataRomanNumerals.convert(15));
		Assert.assertEquals("XVI", KataRomanNumerals.convert(16));
		Assert.assertEquals("XVII", KataRomanNumerals.convert(17));
		Assert.assertEquals("XVIII", KataRomanNumerals.convert(18));
		Assert.assertEquals("XIX", KataRomanNumerals.convert(19));
		Assert.assertEquals("XX", KataRomanNumerals.convert(20));
	}
	
	@Test
	public final void test_for_edge_cases() {
		Assert.assertEquals("XL", KataRomanNumerals.convert(40));
		Assert.assertEquals("XLI", KataRomanNumerals.convert(41));
		Assert.assertEquals("XLII", KataRomanNumerals.convert(42));
		Assert.assertEquals("XL", KataRomanNumerals.convert(40));
		Assert.assertEquals("XLV", KataRomanNumerals.convert(45));
		Assert.assertEquals("L", KataRomanNumerals.convert(50));
		Assert.assertEquals("XC", KataRomanNumerals.convert(90));
		Assert.assertEquals("XCI", KataRomanNumerals.convert(91));
		Assert.assertEquals("XCIV", KataRomanNumerals.convert(94));
		Assert.assertEquals("C", KataRomanNumerals.convert(100));
		Assert.assertEquals("CD", KataRomanNumerals.convert(400));
		Assert.assertEquals("CDX", KataRomanNumerals.convert(410));
		Assert.assertEquals("D", KataRomanNumerals.convert(500));
		Assert.assertEquals("DVI", KataRomanNumerals.convert(506));
		Assert.assertEquals("CM", KataRomanNumerals.convert(900));
		Assert.assertEquals("CML", KataRomanNumerals.convert(950));
		Assert.assertEquals("M", KataRomanNumerals.convert(1000));
		Assert.assertEquals("MMXIX", KataRomanNumerals.convert(2019));
	}
	
	@Test
	public final void test_numerals_to_digits() {
		Assert.assertEquals(24, KataRomanNumerals.convertToDigit("XXIV"));
		Assert.assertEquals(3, KataRomanNumerals.convertToDigit("III"));
		Assert.assertEquals(1998, KataRomanNumerals.convertToDigit("MCMXCVII"));
	}
}
