package com.raychen518.study.java.assertions;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * - The assertion is disabled by default and can only be used in development and testing phases.
 * - The "-ea"/"-enableassertions" VM argument is used to enable the assertion,
 *   the "-da"/"-disableassertions" VM argument is used to disable the assertion.
 * - To run this demo normally (for the method "doSomething2"),
 *   be sure to add the "-ea" VM argument (indicating Enable Assertions) for the run configuration of the application.
 * </pre>
 */
public class Test {

	/**
	 * <pre>
	 * When the method parameter "processId" is invalid,
	 * this method throws an java.lang.Exception.
	 * </pre>
	 */
	public void doSomething1(int processId) throws Exception {
		if (processId < 0) {
			throw new Exception("Invalid process ID: " + processId);
		}

		System.out.println("Doing something...");
	}

	/**
	 * <pre>
	 * When the method parameter "processId" is invalid,
	 * this method throws an java.lang.AssertionError.
	 * </pre>
	 */
	public void doSomething2(int processId) {
		assert processId >= 0;

		System.out.println("Doing something...");
	}

	/**
	 * <pre>
	 * When the method parameter "processId" is invalid,
	 * this method throws an java.lang.AssertionError with the method parameter.
	 * </pre>
	 */
	public void doSomething3(int processId) {
		assert processId >= 0 : processId;

		System.out.println("Doing something...");
	}

	/**
	 * <pre>
	 * When the method parameter "processId" is invalid,
	 * this method throws an java.lang.AssertionError with corresponding message.
	 * </pre>
	 */
	public void doSomething4(int processId) {
		assert processId >= 0 : "Invalid process ID: " + processId;

		System.out.println("Doing something...");
	}

	public static void main(String[] args) {
		Test test = new Test();

		try {
			test.doSomething1(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Utils.printDelimiterLine1();

		try {
			test.doSomething2(-1);
		} catch (AssertionError e) {
			e.printStackTrace();
		}

		Utils.printDelimiterLine1();

		try {
			test.doSomething3(-1);
		} catch (AssertionError e) {
			e.printStackTrace();
		}

		Utils.printDelimiterLine1();

		try {
			test.doSomething4(-1);
		} catch (AssertionError e) {
			e.printStackTrace();
		}
	}

}
