package com.raychen518.study.java.genericprogramming.limitations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * This class shows limitations of the type parameters.
 * 
 * Limitations:
 * - The primitive types (e.g. int, double, boolean, etc.) cannot be used as the type parameters.
 *   Solution: Use the wrapper classes of the primitive types.
 * 
 * - The type check only applies to the raw type instead of the generic type (e.g. SomeObject instead of SomeObject<Integer>).
 *   Note: The reason behind is that for a class using type parameter(s) there is only one class file instead multiple class files for every type parameter.
 *   Solution: No solution.
 * 
 * - The arrays containing elements with type parameters cannot be created.
 *   Solution: Use the array list instead of the array to collect elements with type parameters.
 *   
 * - A warning appears if a method parameter is a variable parameter also a type parameter.
 *   Note: The warning is as follows.
 *         -----------------------------------------------------------------------------------------
 *         Type safety: Potential heap pollution via varargs parameter someParameters
 *         -----------------------------------------------------------------------------------------
 *   Solution: Use the @SafeVarargs or @SuppressWarnings ("unchecked") annotation to suppress the warning.
 *   
 * - The type parameters cannot be instantiated.
 *   Solution: Use the Class<T> and its "newInstance()" method.
 * 
 * - The type parameters cannot be used for the static fields/methods.
 *   Note: The corresponding error is as follows.
 *         -----------------------------------------------------------------------------------------
 *         Cannot make a static reference to the non-static type T
 *         -----------------------------------------------------------------------------------------
 *   Solution: No solution.
 * 
 * - The type parameters cannot be caught as exceptions.
 *   Note: Moreover, the generic classes cannot extend the Throwable class directly or indirectly.
 *   Solution: No solution.
 * </pre>
 */
public class Test {

	private static class SomeObject<T> {

		// The type parameters cannot be used as the types of the static fields.
		// private static T someField;

		// The type parameters cannot be used as the types of the returns of the
		// static method.
		// public static T doSomething() {
		// return null;
		// }

		public void doSomething(T someParameter) {
			System.out.println("someParameter: " + someParameter);
		}

		@SafeVarargs
		public final void doSomething21(T... someParameters) {
			System.out.println("someParameters: " + someParameters);
		}

		public void doSomething22(@SuppressWarnings("unchecked") T... someParameters) {
			System.out.println("someParameters: " + someParameters);
		}

		@SuppressWarnings("unchecked")
		public void doSomething23(T... someParameters) {
			System.out.println("someParameters: " + someParameters);
		}

	}

	private static class SomeObject2 {

		public static <T> void doSomething(Class<T> clazz) throws InstantiationException, IllegalAccessException {
			// All the following statements cause the compilation errors.
			// new T();
			// new T[3];
			// T.class;

			T newInstance = clazz.newInstance();
			System.out.println("newInstance.getClass(): " + newInstance.getClass());
			System.out.println("newInstance.hashCode(): " + newInstance.hashCode());
		}

	}

	@SuppressWarnings("unused")
	private static class SomeObject3 {

		// =============================================
		// The type parameters can appear in the "throws" clause.
		// =============================================
		public <T extends Throwable> void doSomething(T someException) throws T {
			// =============================================
			// The type parameters cannot be caught as exceptions.
			// =============================================
			// try {
			// // ...
			// } catch (T e) {
			// e.printStackTrace();
			// }

			// =============================================
			// The type parameters can be thrown.
			// =============================================
			try {
				// ...
			} catch (Throwable throwable) {
				someException.initCause(throwable);
				throw someException;
			}
		}

		@SuppressWarnings("unchecked")
		public static <T extends Throwable> void throwAs(Throwable throwable) throws T {
			throw (T) throwable;
		}

	}

	// The generic classes cannot extend the Throwable class directly or
	// indirectly.
	// private static class SomeProblem<T> extends Exception { // ... }

	@SuppressWarnings("unused")
	private static class SomeProblem<T extends Exception> {
		// ...
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// =================================================
		// The primitive types (e.g. int, double, boolean, etc.)
		// cannot be used as the type parameters.
		// =================================================
		// OK
		{
			SomeObject<Integer> someObject = new SomeObject<>();
			someObject.doSomething(123);
		}

		// NG
		{
			// A compilation error occurs
			// because the primitive type "int" is used as the type parameter.
			// SomeObject1<int> someObject = new SomeObject1<>();
			// someObject.doSomething(123);
		}

		Utils.printDelimiterLine1();

		// =================================================
		// The type check only applies to the raw type instead of
		// the generic type (e.g. SomeObject instead of SomeObject<Integer>).
		// =================================================
		{
			SomeObject<Integer> someObjectUsingInteger = new SomeObject<>();
			someObjectUsingInteger.doSomething(123);

			SomeObject<String> someObjectUsingString = new SomeObject<>();
			someObjectUsingString.doSomething("abc");

			System.out.println();

			/**
			 * <pre>
			 * NG: someObject instanceof SomeObject<Integer>
			 * OK: someObject instanceof SomeObject
			 * OK: someObject instanceof SomeObject<?>
			 * </pre>
			 */
			// System.out.println("someObjectUsingInteger instanceof
			// SomeObject<Integer>:" + (someObjectUsingInteger instanceof
			// SomeObject<Integer>));

			System.out.println(
					"someObjectUsingInteger instanceof SomeObject: " + (someObjectUsingInteger instanceof SomeObject));
			System.out.println(
					"someObjectUsingString instanceof SomeObject: " + (someObjectUsingString instanceof SomeObject));

			/**
			 * <pre>
			 * NG: someObject == SomeObject<Integer>.class
			 * OK: someObject == SomeObject.class
			 * </pre>
			 */
			// System.out.println("someObjectUsingInteger.getClass() ==
			// SomeObject<Integer>.class: " + (someObjectUsingInteger.getClass()
			// == SomeObject<Integer>.class));

			System.out.println("someObjectUsingInteger.getClass() == SomeObject.class: "
					+ (someObjectUsingInteger.getClass() == SomeObject.class));
			System.out.println("someObjectUsingString.getClass() == SomeObject.class: "
					+ (someObjectUsingString.getClass() == SomeObject.class));
		}

		Utils.printDelimiterLine1();

		// =================================================
		// The arrays containing elements with type parameters cannot be
		// created.
		// =================================================
		{
			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			// NG: SomeObject<Integer>[] someObject == new
			// SomeObject<Integer>[3];
			// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			/**
			 * <pre>
			 * NG: SomeObject<Integer>[] someObject == new SomeObject<Integer>[3];
			 * --: SomeObject<Integer>[] someObject == new SomeObject[3];
			 *     Note: But, elements not being SomeObject<Integer> (such as new SomeObject()) can still be stored in the array.
			 * </pre>
			 */
			// SomeObject<Integer>[] someObjectsUsingInteger = new
			// SomeObject<Integer>[3];

			SomeObject<Integer>[] someObjectsUsingInteger = new SomeObject[3];
			someObjectsUsingInteger[0] = new SomeObject<Integer>();
			someObjectsUsingInteger[1] = new SomeObject<Integer>();
			someObjectsUsingInteger[2] = new SomeObject();

			// Use ArrayList to collect elements with type parameters.
			List<SomeObject<Integer>> someObjectsUsingIntegerAsList = new ArrayList<>();
			someObjectsUsingIntegerAsList.add(new SomeObject<Integer>());
			someObjectsUsingIntegerAsList.add(new SomeObject<Integer>());
			someObjectsUsingIntegerAsList.add(new SomeObject<Integer>());
		}

		Utils.printDelimiterLine1();

		// =================================================
		// A warning appears if a method parameter is a variable parameter also
		// a type parameter.
		// =================================================
		{
			SomeObject<Integer> someObjectUsingInteger = new SomeObject<>();
			someObjectUsingInteger.doSomething21(123, 456, 789);
			someObjectUsingInteger.doSomething22(123, 456, 789);
			someObjectUsingInteger.doSomething23(123, 456, 789);
		}

		Utils.printDelimiterLine1();

		// =================================================
		// The type parameters cannot be instantiated.
		// =================================================
		{
			SomeObject2.doSomething(String.class);
			System.out.println();

			SomeObject2.doSomething(ArrayList.class);
			System.out.println();

			SomeObject2.doSomething(HashMap.class);
		}

		Utils.printDelimiterLine1();

		// =================================================
		// The type parameters cannot be used for the static fields/methods.
		// =================================================
		{
			// See the class "SomeObject".
		}

		Utils.printDelimiterLine1();

		// =================================================
		// The type parameters cannot be caught as exceptions.
		// =================================================

		{
			// See the class "SomeObject3".
		}

		{
			// By either of the following statements, the exceptions are thrown
			// as unchecked exceptions.
			SomeObject3.throwAs(new IOException());
			SomeObject3.<RuntimeException> throwAs(new IOException());
		}
	}

}
