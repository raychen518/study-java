package com.raychen518.study.java.multithreading.examples.testingthreadlocal.ok;

import java.util.Date;

public class SomeObjectProcess implements Runnable {

	private static int THREAD_DELAY = 1000;

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("[" + Thread.currentThread().getName() + "] "
						+ SomeObject.DATE_FORMAT.get().format(new Date()));
				Thread.sleep(THREAD_DELAY);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
