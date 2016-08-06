package com.raychen518.study.java.genericprogramming.onmethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * This class shows how to add type parameters to methods.
 * 
 * - When adding type parameters to a method,
 *   the type parameters should be put before the return type of a method.
 * </pre>
 */
public class Test {

	/**
	 * <pre>
	 * There is 1 method parameter, and it is a type parameter.
	 * </pre>
	 */
	public <T> void doSomething1(T parameter) {
		System.out.println("parameter: " + parameter);
	}

	/**
	 * <pre>
	 * There are 2 method parameters, and they are both type parameters.
	 * </pre>
	 */
	public <T1, T2> void doSomething2(T1 parameter1, T2 parameter2) {
		System.out.println("parameter1: " + parameter1);
		System.out.println("parameter2: " + parameter2);
	}

	/**
	 * <pre>
	 * There are 3 method parameters, and 2 of them are type parameters.
	 * </pre>
	 */
	public <T1, T3> void doSomething3(T1 parameter1, String parameter2, T3 parameter3) {
		System.out.println("parameter1: " + parameter1);
		System.out.println("parameter2: " + parameter2);
		System.out.println("parameter3: " + parameter3);
	}

	/**
	 * <pre>
	 * There is 1 method parameter, and it is a type parameter, furthermore, the method return is that type parameter.
	 * </pre>
	 */
	public <T> T doSomething4(T parameter1) {
		System.out.println("parameter1: " + parameter1);
		return parameter1;
	}

	/**
	 * <pre>
	 * There is 1 method parameter, and it is a type parameter and a variable parameter,
	 * furthermore, the method return is that type parameter.
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public <T> T doSomething5(T... parameter1) {
		System.out.println("parameter1: " + parameter1);
		System.out.println("Arrays.toString(parameter1): " + Arrays.toString(parameter1));
		return (parameter1 == null || parameter1.length == 0) ? null : parameter1[0];
	}

	public static void main(String[] args) {
		{
			Test test = new Test();
			test.doSomething1(123);
			test.doSomething1("abc");
		}

		Utils.printDelimiterLine1();

		{
			Test test = new Test();
			test.doSomething2(123, "abc");
			System.out.println();
			test.doSomething2(true, new HashMap<String, Double>());
			System.out.println();
		}

		Utils.printDelimiterLine1();

		{
			Test test = new Test();
			test.doSomething3(123, "abc", true);
			System.out.println();
			test.doSomething3(new ArrayList<String>(), "abc", null);
		}

		Utils.printDelimiterLine1();

		{
			Test test = new Test();
			System.out.println("test.doSomething4(123): " + test.doSomething4(123));
			System.out.println();
			System.out.println("test.doSomething4(\"abc\"): " + test.doSomething4("abc"));
		}

		Utils.printDelimiterLine1();

		{
			Test test = new Test();
			System.out.println("test.doSomething5(123, 456, 789): " + test.doSomething5(123, 456, 789));
			System.out.println();
			System.out
					.println("test.doSomething5(\"abc\", \"def\", \"ghi\"): " + test.doSomething5("abc", "def", "ghi"));
		}
	}

}
