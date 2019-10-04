package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class CigarPartyTest {
	CigarParty cp;
	
	@Before
	public void setup() {
		cp = new CigarParty();
	}
	
	@Test
	public void test_party_negatives() {
		Assert.assertFalse(cp.haveParty(-10, false));
		Assert.assertFalse(cp.haveParty(-10, true));
	}
	
	@Test
	public void test_party_zero() {
		Assert.assertFalse(cp.haveParty(0, false));
		Assert.assertFalse(cp.haveParty(0, true));
	}
	
	@Test
	public void test_party_low() {
		Assert.assertFalse(cp.haveParty(20, false));
		Assert.assertFalse(cp.haveParty(20, true));
	}
	
	@Test
	public void test_party_forty() {
		Assert.assertTrue(cp.haveParty(40, false));
		Assert.assertTrue(cp.haveParty(40, true));
	}
	
	@Test
	public void test_party_sixty() {
		Assert.assertTrue(cp.haveParty(60, false));
		Assert.assertTrue(cp.haveParty(60, true));
	}
	
	@Test
	public void test_party_high() {
		Assert.assertFalse(cp.haveParty(80, false));
		Assert.assertTrue(cp.haveParty(80, true));
		Assert.assertFalse(cp.haveParty(120, false));
		Assert.assertTrue(cp.haveParty(120, true));
	}
}
