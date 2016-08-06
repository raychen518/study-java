package com.raychen518.study.java.exceptionhandling.catching;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Random;

public class Test {

	public void doSomething1() throws Exception {
		throw new Exception();
	}

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

	public void doSomething3() throws Exception {
		throw new SQLException("Some SQL exception occurred.", new Exception("Some unknow exception occurred."));
	}

	public void doSomething4() throws AdvancedException {
		try {
			throw new Exception("Some exception occurred.");
		} catch (Exception e) {
			// Throwing a new exception instead of the caught exception in the
			// catch block is often used to change the type of the throwing
			// exception for better describing current abnormal situation.

			// The following approach throws the new exception with its message
			// and cause (the caught exception).
			// This approach is a strongly recommended approach,
			// because it does not lose the cause information.
			throw new AdvancedException("Some advanced exception occurred.", e);

			// The following approach loses the cause information thus not
			// recommended.
			// throw new AdvancedException("Some advanced exception occurred.");

			// The following approach has the same effect as the recommended
			// approach.
			// -----------------------------------------------------------------
			// AdvancedException advancedException = new AdvancedException("Some
			// advanced exception occurred.");
			// advancedException.initCause(e);
			// throw advancedException;
			// -----------------------------------------------------------------
		}
	}

	public void doSomething5() throws Exception {
		throw new Exception();
	}

	public static void main(String[] args) throws Exception {
		Test test = new Test();

		// Catch an exception using try/catch block.
		try {
			test.doSomething1();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Catch an exception using try/multi-catch block.
		try {
			test.doSomething2(new Random().nextInt(3) + 1);
		} catch (FileNotFoundException | EOFException | MalformedURLException e) {
			e.printStackTrace();
		}

		// Get more exception information in the catch block.
		try {
			test.doSomething3();
		} catch (Exception e) {
			System.out.println("e: " + e);
			System.out.println("e.getMessage(): " + e.getMessage());
			System.out.println("e.getLocalizedMessage(): " + e.getLocalizedMessage());
			System.out.println("e.getClass().getName(): " + e.getClass().getName());
			System.out.println("e.getCause(): " + e.getCause());
			e.printStackTrace();
		}

		// Catch an exception which has changed the original exception.
		try {
			test.doSomething4();
		} catch (AdvancedException e) {
			e.printStackTrace();
		}

		// Catch an exception, do something about it, and throw it without
		// changing it.
		try {
			test.doSomething5();
		} catch (Exception e) {
			// Do something (such as logging) about the caught exception.
			// ...

			// Throw the caught exception without changing it.
			// Note: Here, the throwing statement is commented out to avoid
			// breaking the demo.
			// throw e;
		}

	}

}
