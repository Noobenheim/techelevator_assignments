package com.techelevator;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {
	WordCount wc;
	Map<String,Integer> empty = new HashMap<>();
	
	@Before
	public void setup() {
		wc = new WordCount();
	}
	
	@Test
	public void bad_arrays() {
		Assert.assertEquals(empty, wc.getCount(null));
		Assert.assertEquals(empty, wc.getCount(new String[] {}));
	}
	
	class PutMap<K,V> extends HashMap<K,V> {
		private static final long serialVersionUID = 4879212424423904150L;
		
		public PutMap<K, V> iput(K key, V val) {
			super.put(key,val);
			return this;
		}
	}
	
	@Test
	public void normal_arrays() {
		PutMap<String,Integer> expected = new PutMap<>();
		expected.iput("ba", 2)
		.iput("ba", 2)
		.iput("black", 1)
		.iput("sheep", 1);
		Assert.assertEquals(expected, wc.getCount("ba ba black sheep".split(" ")));
		
		expected = new PutMap<>();
		expected.iput("a", 1)
		.iput("b", 2)
		.iput("c", 3)
		.iput("d", 1);
		Assert.assertEquals(expected, wc.getCount("c b a b c d c".split(" ")));
	}
}
