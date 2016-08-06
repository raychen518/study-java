package com.raychen518.study.java.interface_.examples.comparable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SomeClass implements Comparable<SomeClass> {
	private static final int FIELD_1_LENGTH = 5;

	private String field1 = "";
	private double field2 = 0;

	public SomeClass(String value1, double value2) {
		this.field1 = value1;
		this.field2 = value2;
	}

	public String getField1() {
		return field1;
	}

	public double getField2() {
		return field2;
	}

	@Override
	public String toString() {
		String content = "";

		content += field1;
		content += ", ";
		content += field2;

		return content;
	}

	private static final String ALL_CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static String generateRandomString(int length) {
		String result = "";

		for (int i = 0; i < length; i++) {
			result += ALL_CHARACTERS.charAt(new Random().nextInt(ALL_CHARACTERS.length()));
		}

		return result;
	}

	@Override
	public int compareTo(SomeClass anotherSomeObject) {
		if (anotherSomeObject == null) {
			return 1;
		} else {
			return Double.compare(field2, anotherSomeObject.field2);
		}
	}

	private static class ComparatorByField1 implements Comparator<SomeClass> {
		@Override
		public int compare(SomeClass someObject1, SomeClass someObject2) {
			if (someObject1 == null) {
				if (someObject2 == null) {
					return 0;
				} else {
					return -1;
				}
			} else {
				if (someObject2 == null) {
					return 1;
				} else {
					return someObject1.field1.compareTo(someObject2.field1);
				}
			}
		}
	}

	private static class ComparatorByField2 implements Comparator<SomeClass> {
		@Override
		public int compare(SomeClass someObject1, SomeClass someObject2) {
			if (someObject1 == null) {
				if (someObject2 == null) {
					return 0;
				} else {
					return -1;
				}
			} else {
				if (someObject2 == null) {
					return 1;
				} else {
					return Double.compare(someObject1.field2, someObject2.field2);
				}
			}
		}
	}

	public static void main(String[] args) {
		int someObjectCount = 7; // new Random().nextInt(20);
		SomeClass[] someObjects = new SomeClass[someObjectCount];

		for (int i = 0; i < someObjects.length; i++) {
			someObjects[i] = new SomeClass(generateRandomString(FIELD_1_LENGTH),
					Math.round(new Random().nextDouble() * 1000000) / 1000000D);
		}

		// List values before sorting.
		System.out.println("BEFORE SORTING");
		System.out.println("--------------------------------");
		for (SomeClass someObject : someObjects) {
			System.out.println(someObject);
		}
		System.out.println("--------------------------------");
		System.out.println();

		{
			SomeClass[] someObjectsForTesting = someObjects.clone();

			// Sort values by default comparator.
			Arrays.sort(someObjectsForTesting);

			// List values after sorting by default comparator.
			System.out.println("AFTER SORTING BY DEFAULT COMPARATOR");
			System.out.println("--------------------------------");
			for (SomeClass someObject : someObjectsForTesting) {
				System.out.println(someObject);
			}
			System.out.println("--------------------------------");
			System.out.println();
		}

		{
			SomeClass[] someObjectsForTesting = someObjects.clone();

			// Sort values by the comparator for field1.
			Arrays.sort(someObjectsForTesting, new ComparatorByField1());

			// List values after sorting by the comparator for field1.
			System.out.println("AFTER SORTING BY THE COMPARATOR FOR FIELD1");
			System.out.println("--------------------------------");
			for (SomeClass someObject : someObjectsForTesting) {
				System.out.println(someObject);
			}
			System.out.println("--------------------------------");
			System.out.println();
		}

		{
			SomeClass[] someObjectsForTesting = someObjects.clone();

			// Sort values by the comparator for field2.
			Arrays.sort(someObjectsForTesting, new ComparatorByField2());

			// List values after sorting by the comparator for field2.
			System.out.println("AFTER SORTING BY THE COMPARATOR FOR FIELD2");
			System.out.println("--------------------------------");
			for (SomeClass someObject : someObjectsForTesting) {
				System.out.println(someObject);
			}
			System.out.println("--------------------------------");
			System.out.println();
		}
	}

}
