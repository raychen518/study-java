package com.raychen518.study.java.multithreading.examples.testingthreadlocal.ng;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * This class demonstrates the Some Object process.
 * 
 * In this demonstration, the data corruption issue (1) in multi-threading scenario is expected to be observed but actually not.
 * Further effort should be spent to make the data corruption issue occur.
 * 1. About the DATE_FORMAT constant in the SomeObject class.
 * </pre>
 */
public class _Demo {

	private static final String THREAD_BASE_NAME = "Thread-";
	private static final int THREAD_COUNT = 100;

	private static String getThreadName(int threadNumber) {
		return THREAD_BASE_NAME + Utils.padNumberString(threadNumber, String.valueOf(THREAD_COUNT).length());
	}

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread thread = new Thread(new SomeObjectProcess(), getThreadName(i + 1));
			thread.start();
		}
	}

}
