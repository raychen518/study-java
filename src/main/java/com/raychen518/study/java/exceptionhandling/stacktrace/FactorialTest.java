package com.raychen518.study.java.exceptionhandling.stacktrace;

public class FactorialTest {

	public static int factorial(int n) {
		System.out.println("factorial(" + n + ")");

		StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			System.out.println(stackTraceElement);
		}

		int result;

		if (n <= 1) {
			result = 1;
		} else {
			result = n * factorial(n - 1);
		}

		return result;
	}

	public static void main(String[] args) {
		factorial(3);
	}

}
