package com.raychen518.study.java.multithreading.examples.randombythreadlocal;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.raychen518.study.java._util.Utils;

/**
 * <pre>
 * This class demonstrates how to use the java.util.concurrent.ThreadLocalRandom class to get random values.
 * Note: Though the java.util.Random class is thread-safe, it is not efficient in multi-threading.
 * </pre>
 */
public class _Demo {

	private static final int THREAD_COUNT = 100;
	private static final String THREAD_NAME_PREFIX = "Thread ";

	// The java.util.Random class is not efficient in multi-threading.
	private static final Random RANDOM = new Random();

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					StringBuilder result = new StringBuilder();

					result.append("[");
					result.append(Thread.currentThread().getName());
					result.append("] ");
					result.append("RANDOM.nextInt(1000): ");
					result.append(RANDOM.nextInt(1000));
					result.append(" | ");
					result.append("ThreadLocalRandom.current().nextInt(1000): ");
					result.append(ThreadLocalRandom.current().nextInt(1000));

					System.out.println(result);
				}

			}, THREAD_NAME_PREFIX + Utils.padNumberString(i + 1, String.valueOf(THREAD_COUNT).length())).start();
		}
	}

}
