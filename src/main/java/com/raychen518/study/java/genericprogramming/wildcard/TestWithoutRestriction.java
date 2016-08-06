package com.raychen518.study.java.genericprogramming.wildcard;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * This class shows how to use the wildcard without restriction (with the "extends"/"super" keyword).
 * </pre>
 */
public class TestWithoutRestriction {

	private static class SomeObject<T> {

		private T someField;

		public T getSomeField() {
			return someField;
		}

		public void setSomeField(T someField) {
			this.someField = someField;
		}

	}

	public static void doSomethingOnInteger(SomeObject<Integer> someObject) {
		System.out.println("someObject.getSomeField(): " + someObject.getSomeField());
	}

	public static void doSomethingOnString(SomeObject<String> someObject) {
		System.out.println("someObject.getSomeField(): " + someObject.getSomeField());
	}

	/**
	 * <pre>
	 * The methods "doSomethingOnAnyType1" and "doSomethingOnAnyType2"
	 * do the same thing, but the former has better readability.
	 * </pre>
	 */
	public static void doSomethingOnAnyType1(SomeObject<?> someObject) {
		System.out.println("someObject.getSomeField(): " + someObject.getSomeField());
	}

	public static <T> void doSomethingOnAnyType2(SomeObject<T> someObject) {
		System.out.println("someObject.getSomeField(): " + someObject.getSomeField());
	}

	public static <T> void doSomethingOnAnyType3(SomeObject<? extends T> someObject) {
		System.out.println("someObject.getSomeField(): " + someObject.getSomeField());
	}

	public static void main(String[] args) {
		{
			SomeObject<Integer> someObject = new SomeObject<>();
			someObject.setSomeField(123);
			TestWithoutRestriction.doSomethingOnInteger(someObject);
			// The compilation error "Method Not Applicable for the Arguments"
			// occurs when executing the following statement.
			// Test.doSomethingOnString(someObject);
		}

		Utils.printDelimiterLine1();

		{
			SomeObject<String> someObject = new SomeObject<>();
			someObject.setSomeField("abc");
			TestWithoutRestriction.doSomethingOnString(someObject);
			// The compilation error "Method Not Applicable for the Arguments"
			// occurs when executing the following statement.
			// Test.doSomethingOnInteger(someObject);
		}

		Utils.printDelimiterLine1();

		{
			SomeObject<Integer> someObjectUsingInteger = new SomeObject<>();
			someObjectUsingInteger.setSomeField(123);
			TestWithoutRestriction.doSomethingOnAnyType1(someObjectUsingInteger);
			TestWithoutRestriction.doSomethingOnAnyType2(someObjectUsingInteger);
			TestWithoutRestriction.doSomethingOnAnyType3(someObjectUsingInteger);

			SomeObject<String> someObjectUsingString = new SomeObject<>();
			someObjectUsingString.setSomeField("abc");
			TestWithoutRestriction.doSomethingOnAnyType1(someObjectUsingString);
			TestWithoutRestriction.doSomethingOnAnyType2(someObjectUsingString);
			TestWithoutRestriction.doSomethingOnAnyType3(someObjectUsingString);
		}

	}

}
