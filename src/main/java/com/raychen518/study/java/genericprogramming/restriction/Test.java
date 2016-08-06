package com.raychen518.study.java.genericprogramming.restriction;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * This class shows how to restrict the type parameters.
 * 
 * - To restrict a type parameter, use the following syntax.
 *     <T extends BOUND1 & BOUND2 & BOUND3 ...>
 *     OR
 *     <T1 extends BOUND11 & BOUND12 & BOUND13 ..., T2 extends BOUND21 & BOUND22 & BOUND23 ...>
 *   - A BOUND can be a class or interface.
 *   - The "extends" keyword here not only means the type parameter may be a subclass of some class,
 *     but also means the type parameter may be an implementation of some interfaces.
 *   - If a class exists in the BOUND list, that class should be the first bound.
 *   Examples
 *     Example								Description
 *     -------------------------------------------------------------------------
 *     <T extends Number>					The type parameter T should be a subclass of the Number class.
 *     <T extends Comparable<?>>			The type parameter T should be an implementation of the Comparable interface.
 *     <T extends Number & Comparable<?>>	The type parameter T should be a subclass of the Number class,
 *     										and also should be an implementation of the Comparable interface.
 *     <T1 extends Number, T2 extends Comparable<?>>
 *     										The type parameter T1 should be a subclass of the Number class,
 *     										and the type parameter T2 should be an implementation of the Comparable interface.
 * </pre>
 */
public class Test {

	private static class SomeObject1<T> {

		public void doSomething(T someParameter) {
			System.out.println("someParameter: " + someParameter);
		}

	}

	/**
	 * <pre>
	 * The type parameter T should be a subclass of the Number class.
	 * </pre>
	 */
	private static class SomeObject2<T extends Number> {

		public void doSomething(T someParameter) {
			System.out.println("someParameter: " + someParameter);
		}

	}

	/**
	 * <pre>
	 * The type parameter T should be an implementation of the Comparable interface.
	 * </pre>
	 */
	private static class SomeObject3<T extends Comparable<?>> {

		public void doSomething(T someParameter) {
			System.out.println("someParameter: " + someParameter);
		}

	}

	/**
	 * <pre>
	 * The type parameter T should be a subclass of the Number class,
	 * and also should be an implementation of the Comparable interface.
	 * </pre>
	 */
	private static class SomeObject4<T extends Number & Comparable<?>> {

		public void doSomething(T someParameter) {
			System.out.println("someParameter: " + someParameter);
		}

	}

	/**
	 * <pre>
	 * The type parameter T1 should be a subclass of the Number class,
	 * and the type parameter T2 should be an implementation of the Comparable interface.
	 * </pre>
	 */
	private static class SomeObject5<T1 extends Number, T2 extends Comparable<?>> {

		public void doSomething(T1 someParameter1, T2 someParameter2) {
			System.out.println("someParameter1: " + someParameter1);
			System.out.println("someParameter2: " + someParameter2);
		}

	}

	public static void main(String[] args) {
		{
			SomeObject1<Integer> someObject = new SomeObject1<>();
			someObject.doSomething(123);
		}

		{
			SomeObject1<String> someObject = new SomeObject1<>();
			someObject.doSomething("abc");
		}

		Utils.printDelimiterLine1();

		{
			SomeObject2<Integer> someObject = new SomeObject2<>();
			someObject.doSomething(123);
		}

		{
			// The Bound Mismatch compilation error occurs
			// because the String class is not a subclass of the Number class.
			// SomeObject2<String> someObject = new SomeObject2<>();
			// someObject.doSomething("abc");
		}

		Utils.printDelimiterLine1();

		{
			SomeObject3<Boolean> someObject = new SomeObject3<>();
			someObject.doSomething(Boolean.TRUE);
		}

		{
			// The Bound Mismatch compilation error occurs
			// because the Preferences class is not an implementation of the
			// Comparable interface.
			// SomeObject3<Preferences> someObject = new SomeObject3<>();
			// someObject.doSomething(Preferences.userRoot());
		}

		Utils.printDelimiterLine1();

		{
			SomeObject4<Integer> someObject = new SomeObject4<>();
			someObject.doSomething(123);
		}

		{
			// The Bound Mismatch compilation error occurs
			// because the String class is not a subclass of the Number class,
			// although it is an implementation of the Comparable interface.
			// SomeObject4<String> someObject = new SomeObject4<>();
			// someObject.doSomething("abc");
		}

		{
			// The Bound Mismatch compilation error occurs
			// because the AtomicInteger class is not an implementation of the
			// Comparable interface,
			// although it is a subclass of the Number class.
			// SomeObject4<AtomicInteger> someObject = new SomeObject4<>();
			// someObject.doSomething(new AtomicInteger(123));
		}

		Utils.printDelimiterLine1();

		{
			SomeObject5<Integer, Boolean> someObject = new SomeObject5<>();
			someObject.doSomething(123, Boolean.TRUE);
		}

		{
			// The Bound Mismatch compilation error occurs
			// because the String class is not a subclass of the Number class
			// (for the 1st parameter).
			// SomeObject5<String, Boolean> someObject = new SomeObject5<>();
			// someObject.doSomething("abc", Boolean.TRUE);
		}

		{
			// The Bound Mismatch compilation error occurs
			// because the Preferences class is not an implementation of the
			// Comparable interface (for the 2nd parameter).
			// SomeObject5<Integer, Preferences> someObject = new
			// SomeObject5<>();
			// someObject.doSomething(123, Preferences.userRoot());
		}
	}

}
