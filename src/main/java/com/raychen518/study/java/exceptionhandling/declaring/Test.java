package com.raychen518.study.java.exceptionhandling.declaring;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * <pre>
 * - Exception Hierarchy
 *   -----------------------------------------------------------------------------------------------
 *   				1. java.lang.Throwable
 *   1.1 java.lang.Error				1.2 java.lang.Exception
 * 						1.2.1 java.io.IOException			1.2.2 java.lang.RuntimeException	...
 *   -----------------------------------------------------------------------------------------------
 *
 * - Errors (java.lang.Error)
 *   Errors indicate serious problems that a reasonable application should not try to catch,
 *   such as java.lang.NoClassDefFoundError, java.lang.OutOfMemoryError and java.lang.ThreadDeath.
 *
 * - Exceptions (java.lang.Exception)
 *   Exceptions indicate abnormal conditions that a reasonable application might want to catch,
 *   such as java.sql.SQLException, javax.xml.bind.JAXBException and java.lang.CloneNotSupportedException.
 *
 * - I/O Exceptions (java.io.IOException)
 *   I/O exceptions indicate exceptions produced by failed or interrupted I/O operations,
 *   such as java.io.FileNotFoundException, java.io.EOFException and java.net.MalformedURLException.
 *
 * - Runtime Exceptions (java.lang.RuntimeException)
 *   Runtime exceptions indicate exceptions that can be thrown during a normal operation of JVM,
 *   such as java.lang.NullPointerException, java.lang.ClassCastException and java.lang.IndexOutOfBoundsException.
 *
 * - Unchecked Exceptions and Checked Exceptions
 *   Unchecked exceptions are the exceptions not to be checked at compiling time,
 *   while checked exceptions are the exceptions to be checked at compiling time.
 *   
 *   Checked exceptions need to be handled (by the try-catch-finally statement) or propagated (by the throws clause),
 *   while unchecked exceptions have no that requirement.
 *
 *   java.lang.Error, java.lang.RuntimeException and their subclasses are unchecked exceptions.
 *   All other exception classes are checked exceptions.
 *
 * - Unchecked Exceptions VS Checked Exceptions
 *   Here's the bottom line guideline:
 *   If a client can reasonably be expected to recover from an exception, make that exception a checked exception;
 *   otherwise, make that exception an unchecked exception.
 * </pre>
 */
public class Test {

	/**
	 * <pre>
	 * Declare one checked exception.
	 * </pre>
	 */
	public void doSomething1() throws IOException {
		throw new IOException();
	}

	/**
	 * <pre>
	 * Declare multiple checked exceptions.
	 * </pre>
	 */
	public void doSomething2(int processId) throws FileNotFoundException, EOFException, MalformedURLException {
		if (processId == 1) {
			throw new FileNotFoundException();
		}

		if (processId == 2) {
			throw new EOFException();
		}

		if (processId == 3) {
			throw new MalformedURLException();
		}
	}

	/**
	 * <pre>
	 * There is no need to declare one unchecked exception (Error).
	 * </pre>
	 */
	public void doSomething3() {
		throw new Error();
	}

	/**
	 * <pre>
	 * There is no need to declare one unchecked exception (RuntimeException).
	 * </pre>
	 */
	public void doSomething4() {
		throw new RuntimeException();
	}

	/**
	 * <pre>
	 * There is no need to declare one unchecked exception (Subclasses of Error and RuntimeException).
	 * </pre>
	 */
	public void doSomething5(int processId) {
		if (processId == 1) {
			throw new NoClassDefFoundError();
		}

		if (processId == 2) {
			throw new NullPointerException();
		}
	}

}
