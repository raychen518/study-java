package com.raychen518.study.java.exceptionhandling.finallyclause;

public class Test {

	public void doSomething1(boolean processFlag) {
		try {
			System.out.println("Doing something...");

			if (processFlag) {
				throw new SomeException();
			}
		} catch (SomeException e) {
			System.out.println("Handling the exception...");
		} finally {
			System.out.println("Performing the cleanup...");
		}
	}

	public void doSomething2() {
		System.out.println("Doing something...");

		try {
			System.out.println("Handling the exception (Start)...");
			System.out.println(1 / 0);
			System.out.println("Handling the exception (End)...");
		} finally {
			System.out.println("Performing the cleanup...");
		}
	}

	public void doSomething3() {
		System.out.println("Doing something...");

		try {
			throw new SomeException();
		} catch (SomeException e) {
			System.out.println("Handling the exception (Start)...");
			System.out.println(1 / 0);
			System.out.println("Handling the exception (End)...");
		} finally {
			System.out.println("Performing the cleanup...");
		}
	}

	public void doSomething4() {
		System.out.println("Doing something...");

		try {
			throw new SomeException();
		} catch (SomeException e) {
			System.out.println("Handling the exception...");
		} finally {
			System.out.println("Performing the cleanup (Start)...");
			System.out.println(1 / 0);
			System.out.println("Performing the cleanup (End)...");
		}
	}

	public void doSomething5() {
		System.out.println("Doing something...");

		// An external try-catch block includes an internal try-finally block.
		// This approach makes the code clearer, and the exceptions thrown in
		// the internal finally clause will also be caught.
		try {
			try {
				throw new SomeException();
			} finally {
				System.out.println("Performing the cleanup...");
			}
		} catch (SomeException e) {
			System.out.println("Handling the exception...");
		}
	}

	public static void main(String[] args) {
		Test test = new Test();

		// Case: The "catch" clause is bypassed.
		test.doSomething1(false);
		System.out.println();

		// Case: The "catch" clause is executed.
		test.doSomething1(true);
		System.out.println();

		// Case: There is no "catch" clause.
		try {
			test.doSomething2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();

		// Case: The "catch" clause is executed, and a new exception is thrown
		// from the "catch" clause.
		try {
			test.doSomething3();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();

		// Case: The "catch" clause is executed, and a new exception is thrown
		// from the "finally" clause.
		try {
			test.doSomething4();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();

		// Case: The "catch" clause is executed, after the "finally" clause is
		// executed.
		test.doSomething5();
	}

}
