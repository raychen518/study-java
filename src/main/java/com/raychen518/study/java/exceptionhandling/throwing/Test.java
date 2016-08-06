package com.raychen518.study.java.exceptionhandling.throwing;

import java.io.IOException;

public class Test {

	/**
	 * <pre>
	 * Throw one checked exception.
	 * </pre>
	 */
	public void doSomething1() throws IOException {
		throw new IOException();
	}

	/**
	 * <pre>
	 * Throw one checked exception with detail message.
	 * </pre>
	 */
	public void doSomething2() throws IOException {
		throw new IOException("Detail Message");
	}

	/**
	 * <pre>
	 * Throw one checked exception which cause is null.
	 * </pre>
	 */
	public void doSomething3() throws IOException {
		Throwable cause = null;
		throw new IOException(cause);
	}

	/**
	 * <pre>
	 * Throw one checked exception which cause is not null.
	 * </pre>
	 */
	public void doSomething4() throws IOException {
		Throwable cause = new Throwable("Detail Message in Cause");
		throw new IOException(cause);
	}

	/**
	 * <pre>
	 * Throw one checked exception with detail message and which cause is not null.
	 * </pre>
	 */
	public void doSomething5() throws IOException {
		Throwable cause = new Throwable("Detail Message in Cause");
		throw new IOException("Detail Message", cause);
	}

	public static void main(String[] args) {
		Test test = new Test();

		try {
			test.doSomething1();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();

		try {
			test.doSomething2();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();

		try {
			test.doSomething3();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();

		try {
			test.doSomething4();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();

		try {
			test.doSomething5();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

}
