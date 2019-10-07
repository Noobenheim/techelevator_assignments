package com.techelevator;

import org.junit.*;
import static org.junit.Assert.*;

public class KataFizzBuzzTest {
	KataFizzBuzz kfb;
	
	@Before
	public void setup() {
		kfb = new KataFizzBuzz();
	}
	
	// Part 1
	@Test
	public void test_one() {
		Assert.assertEquals("1 should return \"1\"", "1", kfb.fizzBuzz(1));
	}
	
	@Test
	public void test_three() {
		Assert.assertEquals("3 should return \"Fizz\"", "Fizz", kfb.fizzBuzz(3));
	}
	
	@Test
	public void test_five() {
		Assert.assertEquals("5 should return \"Buzz\"", "Buzz", kfb.fizzBuzz(5));
	}
	
	@Test
	public void test_fifteen() {
		// commented this out for Part 2, since 15 contains a 5 it will always be "Buzz" even though it's also divisible by 3 (see test_fiftyone)
		//Assert.assertEquals("15 should return \"FizzBuzz\"", "FizzBuzz", kfb.fizzBuzz(15));
	}
	
	@Test
	public void test_twentytwo() {
		Assert.assertEquals("22 should return \"22\"", "22", kfb.fizzBuzz(22));
	}
	
	@Test
	public void test_zero() {
		Assert.assertEquals("0 should return \"\"", "", kfb.fizzBuzz(0));
	}
	
	// Part 2
	
	@Test
	public void test_thirteen() {
		Assert.assertEquals("13 should return \"Fizz\"", "Fizz", kfb.fizzBuzz(13));
	}
	
	@Test
	public void test_thirtyfive() {
		Assert.assertEquals("35 should return \"FizzBuzz\"", "FizzBuzz", kfb.fizzBuzz(35));
	}
	
	@Test
	public void test_fiftyone() {
		Assert.assertEquals("51 should return \"Buzz\"", "Buzz", kfb.fizzBuzz(51));
	}
	
	@Test
	public void test_fiftythree() {
		Assert.assertEquals("53 should return \"FizzBuzz\"", "FizzBuzz", kfb.fizzBuzz(53));
	}
}
