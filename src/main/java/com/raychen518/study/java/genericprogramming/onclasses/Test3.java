package com.raychen518.study.java.genericprogramming.onclasses;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * This class shows how to add type parameters to classes (2 type parameters).
 * Note: Type parameters can be named without following the naming convention, like "A", "Bc" and "DefGhi" here.
 * </pre>
 */
public class Test3<A, Bc, DefGhi> {

	private A someField1;
	private List<Bc> someField2;
	private DefGhi someField3;

	public A getSomeField1() {
		return someField1;
	}

	public void setSomeField1(A someField1) {
		this.someField1 = someField1;
	}

	public List<Bc> getSomeField2() {
		return someField2;
	}

	public void setSomeField2(List<Bc> someField2) {
		this.someField2 = someField2;
	}

	public DefGhi getSomeField3() {
		return someField3;
	}

	public void setSomeField3(DefGhi someField3) {
		this.someField3 = someField3;
	}

	public static void main(String[] args) {
		{
			Test3<Integer, String, Boolean> test = new Test3<>();
			test.setSomeField1(123);
			test.setSomeField2(Arrays.asList("abc", "def", "ghi"));
			test.setSomeField3(Boolean.TRUE);
			System.out.println("test.getSomeField1(): " + test.getSomeField1());
			System.out.println("test.getSomeField2(): " + test.getSomeField2());
			System.out.println("test.getSomeField3(): " + test.getSomeField3());
			System.out.println();
		}

		{
			Test3<Double, Integer, Map<String, Object>> test = new Test3<>();
			test.setSomeField1(123.45);
			test.setSomeField2(Arrays.asList(123, 456, 789));
			Map<String, Object> someValue3 = new HashMap<>();
			someValue3.put("item1", "abc");
			someValue3.put("item2", Boolean.FALSE);
			someValue3.put("item3", null);
			test.setSomeField3(someValue3);
			System.out.println("test.getSomeField1(): " + test.getSomeField1());
			System.out.println("test.getSomeField2(): " + test.getSomeField2());
			System.out.println("test.getSomeField3(): " + test.getSomeField3());
		}
	}

}
