package com.raychen518.study.java.multithreading.examples.testingthreadlocal.ok;

import java.text.SimpleDateFormat;

public class SomeObject {

	/**
	 * The java.lang.ThreadLocal<T> class is used here to provide a variable
	 * copy for each thread, thus transforming a thread-unsafe variable into a
	 * thread-safe variable.
	 * 
	 * Here, a thread-unsafe constant (variable) DATE_FORMAT is transformed into
	 * a thread-safe constant (variable).<br />
	 * Note: The java.text.SimpleDateFormat class is not thread-safe.
	 */
	// public static final DateFormat DATE_FORMAT = new
	// SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	public static final ThreadLocal<SimpleDateFormat> DATE_FORMAT = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		}

	};

}
