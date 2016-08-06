package com.raychen518.study.java.genericprogramming.wildcard;

/**
 * <pre>
 * This class shows how to use the wildcard with the "extends" keyword (#1).
 * </pre>
 *
 */
public class TestUsingExtends1 {

	private static class NumberContainer<T> {

		T number;

		public NumberContainer(T number) {
			this.number = number;
		}

		public T getNumber() {
			return number;
		}

	}

	public static void printNumber(NumberContainer<Number> number) {
		System.out.println("printNumber - Number: " + number.getNumber());
	}

	public static void printNumber2(NumberContainer<? extends Number> number) {
		System.out.println("printNumber2 - Number: " + number.getNumber());
	}

	public static void main(String[] args) {
		NumberContainer<Integer> numberContainerForInteger = new NumberContainer<>(123);
		System.out.println("numberContainerForInteger.getNumber(): " + numberContainerForInteger.getNumber());

		NumberContainer<Double> numberContainerForDouble = new NumberContainer<>(123.45);
		System.out.println("numberContainerForDouble.getNumber(): " + numberContainerForDouble.getNumber());
		System.out.println();

		// =====================================================================
		// The Method Not Applicable for the Arguments compilation error occurs
		// because the types NumberContainer<Integer> and
		// NumberContainer<Double> are unable to be used as the type
		// NumberContainer<Number>.
		// =====================================================================
		// Test.printNumber(numberContainerForInteger);
		// Test.printNumber(numberContainerForDouble);

		// =====================================================================
		// No error occurs if passing the type NumberContainer<Number> as the
		// method parameter.
		// =====================================================================
		TestUsingExtends1.printNumber(new NumberContainer<Number>(123));
		TestUsingExtends1.printNumber(new NumberContainer<Number>(123.45));
		System.out.println();

		// =====================================================================
		// No error occurs if invoking the method using the wildcard type
		// parameter as the method parameter.
		// =====================================================================
		TestUsingExtends1.printNumber2(numberContainerForInteger);
		TestUsingExtends1.printNumber2(numberContainerForDouble);
	}

}
