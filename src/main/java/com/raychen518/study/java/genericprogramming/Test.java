package com.raychen518.study.java.genericprogramming;

import java.util.ArrayList;

public class Test {

	/**
	 * <pre>
	 * Without type parameters/arguments specified, references to generic type objects 
	 * - may cause Raw Types and Type Safety warnings.
	 *   Note: To remove these warnings, the @SuppressWarnings annotation (targets: "rawtypes" and "unchecked") should be used.
	 * - may cause Type Mismatch (Convert Object to the type Xxxxx) errors.
	 *   Note: To remove these errors, the corresponding type casting becomes necessary.
	 * </pre>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void testNgWithoutTypeParametersSpecified() {
		ArrayList list = new ArrayList();
		list.add("abc");
		list.add("def");
		list.add("ghi");

		String firstElement = (String) list.get(0);
		System.out.println("firstElement: " + firstElement);
	}

	public static void testOkWithTypeParametersSpecified() {
		ArrayList<String> list = new ArrayList<>();
		list.add("abc");
		list.add("def");
		list.add("ghi");

		String firstElement = list.get(0);
		System.out.println("firstElement: " + firstElement);
	}

	public static void main(String[] args) {
		testNgWithoutTypeParametersSpecified();
		testOkWithTypeParametersSpecified();
	}

}
