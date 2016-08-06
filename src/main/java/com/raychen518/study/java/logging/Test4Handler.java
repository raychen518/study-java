package com.raychen518.study.java.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.raychen518.study.java._util.Randoms;

public class Test4Handler {

	public static void test() {
		{
			System.out.println("The default log level of the logger and the log handler is INFO.");
			System.out.println("So, by default, messages which log levels are under INFO will not be logged.");
			Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
			logMessages(logger);
			System.out.println();
		}

		{
			System.out.println("To log a message which log level is under INFO (the default log level),");
			System.out.println("only setting the logger using that log level does not work.");
			Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
			logger.setLevel(Level.FINE);
			logMessages(logger);
			System.out.println();
		}

		{
			System.out.println("To log a message which log level is under INFO (the default log level),");
			System.out.println("both the logger and the log handler should be set using that log level.");
			System.out.println("But, messages which log levels are INFO or above will be logged twice.");
			Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
			logger.setLevel(Level.FINE);
			Handler handler = new ConsoleHandler();
			handler.setLevel(logger.getLevel());
			logger.addHandler(handler);
			logMessages(logger);
			System.out.println();
		}

		{
			System.out.println("To log a message which log level is under INFO (the default log level),");
			System.out.println("both the logger and the log handler should be set using that log level,");
			System.out.println(
					"and furthermore, the logger should be configured not to use its parent logger and log handler, to avoid the Logging Twice issue.");
			Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
			logger.setLevel(Level.FINE);
			logger.setUseParentHandlers(false);
			Handler handler = new ConsoleHandler();
			handler.setLevel(logger.getLevel());
			logger.addHandler(handler);
			logMessages(logger);
			System.out.println();
		}
	}

	private static void logMessages(Logger logger) {
		logger.severe("Logging a SEVERE level message.");
		logger.warning("Logging a WARNING level message.");
		logger.info("Logging a INFO level message.");
		logger.config("Logging a CONFIG level message.");
		logger.fine("Logging a FINE level message.");
		logger.finer("Logging a FINER level message.");
		logger.finest("Logging a FINEST level message.");
	}

	public static void main(String[] args) {
		test();
	}

}
