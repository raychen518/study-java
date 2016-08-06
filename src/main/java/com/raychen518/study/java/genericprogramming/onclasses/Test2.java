package com.raychen518.study.java.genericprogramming.onclasses;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * This class shows how to add type parameters to classes (2 type parameters).
 * </pre>
 */
public class Test2<K, V> {

	private Map<K, V> someField;

	public Map<K, V> getSomeField() {
		return someField;
	}

	public void setSomeField(Map<K, V> someField) {
		this.someField = someField;
	}

	public static void main(String[] args) {
		{
			Test2<String, Integer> test = new Test2<>();
			Map<String, Integer> someValue = new HashMap<>();
			someValue.put("item1", 123);
			someValue.put("item2", Integer.valueOf(456));
			someValue.put("item3", null);
			test.setSomeField(someValue);
			System.out.println("test.getSomeField(): " + test.getSomeField());
		}

		{
			Test2<String, Boolean> test = new Test2<>();
			Map<String, Boolean> someValue = new HashMap<>();
			someValue.put("item1", true);
			someValue.put("item2", false);
			someValue.put("item3", null);
			test.setSomeField(someValue);
			System.out.println("test.getSomeField(): " + test.getSomeField());
		}
	}

}
