package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class AnimalGroupNameTest {
	AnimalGroupName agn;
	
	@Before
	public void setup() {
		agn = new AnimalGroupName();
	}

	@Test
	public void test_rhino() {
		Assert.assertEquals("Crash", agn.getHerd("rhino"));
		Assert.assertEquals("Crash", agn.getHerd("RHINO"));
		Assert.assertEquals("Crash", agn.getHerd("rHiNo"));
	}
	@Test
	public void test_giraffe() {
		Assert.assertEquals("Tower", agn.getHerd("giraffe"));
		Assert.assertEquals("Tower", agn.getHerd("GIRAFFE"));
		Assert.assertEquals("Tower", agn.getHerd("gIrAfFe"));
	}
	@Test
	public void test_elephant() {
		Assert.assertEquals("Herd", agn.getHerd("elephant"));
		Assert.assertEquals("Herd", agn.getHerd("ELEPHANT"));
		Assert.assertEquals("Herd", agn.getHerd("eLePhAnT"));
	}
	@Test
	public void test_lion() {
		Assert.assertEquals("Herd", agn.getHerd("lion"));
		Assert.assertEquals("Herd", agn.getHerd("LION"));
		Assert.assertEquals("Herd", agn.getHerd("lIoN"));
	}
	@Test
	public void test_crow() {
		Assert.assertEquals("Murder", agn.getHerd("crow"));
		Assert.assertEquals("Murder", agn.getHerd("CROW"));
		Assert.assertEquals("Murder", agn.getHerd("cRoW"));
	}
	@Test
	public void test_pigeon() {
		Assert.assertEquals("Kit", agn.getHerd("pigeon"));
		Assert.assertEquals("Kit", agn.getHerd("PIGEON"));
		Assert.assertEquals("Kit", agn.getHerd("pIgEoN"));
	}
	@Test
	public void test_flamingo() {
		Assert.assertEquals("Pat", agn.getHerd("flamingo"));
		Assert.assertEquals("Pat", agn.getHerd("FLAMINGO"));
		Assert.assertEquals("Pat", agn.getHerd("fLaMiNgO"));
	}
	@Test
	public void test_deer() {
		Assert.assertEquals("Herd", agn.getHerd("deer"));
		Assert.assertEquals("Herd", agn.getHerd("DEER"));
		Assert.assertEquals("Herd", agn.getHerd("dEeR"));
	}
	@Test
	public void test_dog() {
		Assert.assertEquals("Pack", agn.getHerd("dog"));
		Assert.assertEquals("Pack", agn.getHerd("DOG"));
		Assert.assertEquals("Pack", agn.getHerd("dOg"));
	}
	@Test
	public void test_crocodile() {
		Assert.assertEquals("Float", agn.getHerd("crocodile"));
		Assert.assertEquals("Float", agn.getHerd("CROCODILE"));
		Assert.assertEquals("Float", agn.getHerd("cRoCoDiLe"));
	}
	@Test
	public void test_empty() {
		Assert.assertEquals("unknown", agn.getHerd(""));
		Assert.assertEquals("unknown", agn.getHerd(" "));
		Assert.assertEquals("unknown", agn.getHerd(null));
		Assert.assertEquals("unknown", "House Cat");
	}
}
