package com.raychen518.study.java.genericprogramming.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * This class shows how to utilize the generic reflection feature by the generic Class class.
 * 
 * - The T.class (t.getClass()) is an object of the Class<T> class (actually, the only object).
 * 
 * - The Class<T> class has useful methods containing the type parameters, as follows.
 *   - T java.lang.Class.newInstance()
 *   - Constructor<T> java.lang.Class.getConstructor(Class<?>...)
 *   - Constructor<T> java.lang.Class.getDeclaredConstructor(Class<?>...)
 *   - Class<? super T> java.lang.Class.getSuperclass()
 *   - T java.lang.Class.cast(Object)
 *   - T[] java.lang.Class.getEnumConstants()
 *   - etc.
 * </pre>
 */
public class Test1 {

	private static class SomeObject {

		private int field1;
		private String field2;
		private boolean field3;

		public SomeObject() {
		}

		public SomeObject(int field1, String field2, boolean field3) {
			this.field1 = field1;
			this.field2 = field2;
			this.field3 = field3;
		}

		@Override
		public String toString() {
			String result = "";

			result += this.getClass().getSimpleName() + " [";
			result += "field1: " + field1 + ", ";
			result += "field2: " + field2 + ", ";
			result += "field3: " + field3 + "]";

			return result;
		}

		public String toString(boolean withHashCode) {
			String result = toString();
			return withHashCode ? result + " @" + Integer.toHexString(hashCode()) : result;
		}

	}

	private static enum SomeEnum {

		ITEM_1, ITEM_2, ITEM_3;

	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// =====================================================================
		// The method "T java.lang.Class.newInstance()" creates a new instance
		// of the type T using the default constructor of the type T.
		// =====================================================================
		{
			SomeObject someObject1 = new SomeObject();
			System.out.println("someObject1.toString(true)\t: " + someObject1.toString(true));
			System.out.println("someObject1.toString()\t\t: " + someObject1);

			SomeObject someObject2 = SomeObject.class.newInstance();
			System.out.println("someObject2.toString(true)\t: " + someObject2.toString(true));
			System.out.println("someObject2.toString()\t\t: " + someObject2);

			System.out.println("someObject1.toString().equals(someObject2.toString()): "
					+ (someObject1.toString().equals(someObject2.toString())));
		}

		Utils.printDelimiterLine1();

		// =====================================================================
		// The method "Constructor<T>
		// java.lang.Class.getConstructor(Class<?>...)" returns the specified
		// constructor of the type T and its method
		// "java.lang.reflect.Constructor.newInstance(Object...)" creates a new
		// instance of the type T using the specified constructor arguments on
		// it.
		// Note: The method "Constructor<T>
		// java.lang.Class.getDeclaredConstructor(Class<?>...)" does the same
		// thing as the method "Constructor<T>
		// java.lang.Class.getConstructor(Class<?>...)", the difference between
		// these 2 methods is that the former also returns non-public
		// constructors and constructors from interfaces.
		// =====================================================================
		{
			SomeObject someObject1 = new SomeObject(123, "abc", true);
			System.out.println("someObject1.toString(true)\t: " + someObject1.toString(true));
			System.out.println("someObject1.toString()\t\t: " + someObject1);

			SomeObject someObject2 = SomeObject.class.getConstructor(int.class, String.class, boolean.class)
					.newInstance(123, "abc", true);
			System.out.println("someObject2.toString(true)\t: " + someObject2.toString(true));
			System.out.println("someObject2.toString()\t\t: " + someObject2);

			System.out.println("someObject1.toString().equals(someObject2.toString()): "
					+ (someObject1.toString().equals(someObject2.toString())));
		}

		Utils.printDelimiterLine1();

		// =====================================================================
		// The method "Class<? super T> java.lang.Class.getSuperclass()" returns
		// the superclass of the type T.
		// =====================================================================
		{
			System.out.println("SomeObject.class: " + SomeObject.class);
			System.out.println("SomeObject.class.getSuperclass(): " + SomeObject.class.getSuperclass());
		}

		Utils.printDelimiterLine1();

		// =====================================================================
		// The method "T java.lang.Class.cast(Object)" casts the specified
		// object to the type T.
		// =====================================================================
		{
			SomeObject someObject = new SomeObject();
			Object object = new SomeObject(123, "abc", true);
			System.out.println("someObject.getClass().cast(object): " + someObject.getClass().cast(object));
		}

		Utils.printDelimiterLine1();

		// =====================================================================
		// The method "T[] java.lang.Class.getEnumConstants()" returns the
		// elements of the type T (the type T should be an enum class).
		// =====================================================================
		{
			System.out.println("Arrays.toString(SomeEnum.class.getEnumConstants()): "
					+ Arrays.toString(SomeEnum.class.getEnumConstants()));
		}
	}

}
