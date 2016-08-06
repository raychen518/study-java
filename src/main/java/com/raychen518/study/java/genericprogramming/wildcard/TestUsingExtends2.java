package com.raychen518.study.java.genericprogramming.wildcard;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * This class shows how to use the wildcard with the "extends" keyword (#2).
 * </pre>
 *
 */
public class TestUsingExtends2 {

	public static List<Number> processNumbers1(List<Number> numbers) {
		// Processing the numbers...
		return numbers;
	}

	public static <T> List<T> processNumbers2(List<T> numbers) {
		// Processing the numbers...
		return numbers;
	}

	public static <T extends Number> List<T> processNumbers3(List<T> numbers) {
		// Processing the numbers...
		return numbers;
	}

	public static List<?> processNumbers4(List<?> numbers) {
		// Processing the numbers...
		return numbers;
	}

	public static List<? extends Number> processNumbers5(List<? extends Number> numbers) {
		// Processing the numbers...
		return numbers;
	}

	public static void main(String[] args) {
		System.out.println(TestUsingExtends2.processNumbers1(Arrays.asList(123, 456, 789)));
		System.out.println(TestUsingExtends2.processNumbers1(Arrays.asList(1.23, 4.56, 7.89)));
		System.out.println();

		System.out.println(TestUsingExtends2.processNumbers2(Arrays.asList(123, 456, 789)));
		System.out.println(TestUsingExtends2.processNumbers2(Arrays.asList(1.23, 4.56, 7.89)));
		System.out.println();

		System.out.println(TestUsingExtends2.processNumbers3(Arrays.asList(123, 456, 789)));
		System.out.println(TestUsingExtends2.processNumbers3(Arrays.asList(1.23, 4.56, 7.89)));
		System.out.println();

		System.out.println(TestUsingExtends2.processNumbers4(Arrays.asList(123, 456, 789)));
		System.out.println(TestUsingExtends2.processNumbers4(Arrays.asList(1.23, 4.56, 7.89)));
		System.out.println();

		System.out.println(TestUsingExtends2.processNumbers5(Arrays.asList(123, 456, 789)));
		System.out.println(TestUsingExtends2.processNumbers5(Arrays.asList(1.23, 4.56, 7.89)));
		System.out.println();
	}

}
