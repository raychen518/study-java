package com.raychen518.study.java.arraylist;

import java.util.ArrayList;
import java.util.List;

public class A {

	private int field1;
	private String field2;
	private boolean field3;

	public A(int field1, String field2, boolean field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	@Override
	public String toString() {
		String content = "";

		content += "field1=" + field1 + ", ";
		content += "field2=\"" + (field2 == null ? "" : field2) + "\", ";
		content += "field3=" + field3;

		return getClass().getName() + "[" + content + "]";
	}

	public int getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public boolean isField3() {
		return field3;
	}

	public static void main(String[] args) {
		List<A> aList = new ArrayList<>();

		// java.util.List.add()
		aList.add(new A(111, "string_111", true));
		aList.add(new A(222, "string_222", false));
		aList.add(new A(333, "string_333", true));

		// java.util.List.size()
		System.out.println(aList.size());
		System.out.println();

		for (A a : aList) {
			System.out.println(a.toString());
		}
		System.out.println();

		aList.add(1, new A(1111, "string_1111", false));

		for (A a : aList) {
			System.out.println(a.toString());
		}
		System.out.println();

		// java.util.List.remove()
		aList.remove(1);

		for (A a : aList) {
			System.out.println(a.toString());
		}
		System.out.println();

		// java.util.List.get() and java.util.List.set()
		System.out.println(aList.get(1));
		aList.set(1, new A(2222, "string_2222", true));
		System.out.println(aList.get(1));
		System.out.println();

		// java.util.List.toArray()
		A[] aArray = new A[aList.size()];
		aList.toArray(aArray);

		for (A a : aArray) {
			System.out.println(a.toString());
		}
		System.out.println();
	}

}
