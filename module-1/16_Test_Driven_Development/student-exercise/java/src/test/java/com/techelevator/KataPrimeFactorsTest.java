package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class KataPrimeFactorsTest {
	KataPrimeFactors kpf;
	List<Integer> expected;
	
	@Before
	public void setup() {
		kpf = new KataPrimeFactors();
		expected = new ArrayList<Integer>();
	}
	
	@Test
	public void two_returns_two() {
		expected.add(2);
		Assert.assertEquals(expected, kpf.factorize(2));
	}
	
	@Test
	public void three_returns_three() {
		expected.add(3);
		Assert.assertEquals(expected, kpf.factorize(3));
	}
	
	@Test
	public void four_returns_two_two() {
		expected.add(2);
		expected.add(2);
		Assert.assertEquals(expected, kpf.factorize(4));
	}
	
	@Test
	public void six_returns_two_three() {
		expected.add(2);
		expected.add(3);
		Assert.assertEquals(expected, kpf.factorize(6));
	}
	
	@Test
	public void seven_returns_seven() {
		expected.add(7);
		Assert.assertEquals(expected, kpf.factorize(7));
	}
	
	@Test
	public void eight_returns_two_two_two() {
		expected.add(2);
		expected.add(2);
		expected.add(2);
		Assert.assertEquals(expected, kpf.factorize(8));
	}
	
	@Test
	public void nine_returns_three_three() {
		expected.add(3);
		expected.add(3);
		Assert.assertEquals(expected, kpf.factorize(9));
	}
	
	@Test
	public void ten_returns_two_five() {
		expected.add(2);
		expected.add(5);
		Assert.assertEquals(expected, kpf.factorize(10));
	}
}
