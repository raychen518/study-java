package com.raychen518.study.java.multithreading.examples.threadidbythreadlocal;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {

	// The atomic integer containing the next thread ID to be assigned.
	private static final AtomicInteger nextThreadId = new AtomicInteger(0);

	// The thread-local variable containing each thread's ID.
	private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			return nextThreadId.getAndIncrement();
		}

	};

	// Return current thread's ID.
	public static int get() {
		return threadId.get();
	}
}