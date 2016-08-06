package com.raychen518.study.java.exceptionhandling.tryclause;

public class Test {

	/**
	 * <pre>
	 * This method contains the normal approach to close a opened resource.
	 * i.e., put the statements to close the resource in the "finally" clause.
	 * </pre>
	 */
	public void doSomething1() {

		SomeResource someResource = new SomeResource();

		try {
			someResource.process();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				someResource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * <pre>
	 * This method contains a new approach to close a opened resource.
	 * First, the resource class should implement the java.lang.AutoCloseable interface.
	 * Then, put the resource instantiation statement into the "try(...)" clause.
	 * The "close()" method of the resource class will be automatically invoked when quitting the "try" clause.
	 * </pre>
	 */
	public void doSomething2() {
		try (SomeResource someResource = new SomeResource()) {
			someResource.process();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Test test = new Test();

		test.doSomething1();
		System.out.println();

		test.doSomething2();
		System.out.println();
	}

}
