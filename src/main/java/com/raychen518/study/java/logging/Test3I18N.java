package com.raychen518.study.java.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.raychen518.study.java._util.Randoms;

public class Test3I18N {

	// TODO Example of the localization of the Java logging fails here due to
	// unknown reason.
	public static void test() {
		Logger logger = Logger.getLogger(Randoms.generateRandomString(5), "messages");
		logger.info("message_1");
		logger.log(Level.INFO, "message_2", new Object[] { 123, "abc", true });
	}

	public static void main(String[] args) {
		test();
	}

}
