package com.raychen518.study.java.multithreading.examples.threadidbythreadlocal;

/**
 * <pre>
 * This class demonstrates how threads get different IDs by same variable, by using the ThreadLocal class.
 * </pre>
 */
public class _Demo {

	private static final int THREAD_COUNT = 100;

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("ThreadId.get(): " + ThreadId.get());
				}

			});
			thread.start();
		}
	}

}
