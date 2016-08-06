package com.raychen518.study.java.logging;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.raychen518.study.java._util.Utils;
import com.raychen518.study.java._util.Randoms;

public class Test1GeneralTesting {

	public static void showGlobalLoggerInfo() {
		System.out.println("Information of the Global Logger");
		System.out.println();

		System.out.println("Logger.GLOBAL_LOGGER_NAME: " + Logger.GLOBAL_LOGGER_NAME);
		System.out.println();

		System.out.println("Logger.getGlobal(): " + Logger.getGlobal());
		System.out.println("Logger.getGlobal().getName(): " + Logger.getGlobal().getName());
		System.out.println("Logger.getGlobal().getLevel(): " + Logger.getGlobal().getLevel());
		System.out.println("Logger.getGlobal().getResourceBundleName(): " + Logger.getGlobal().getResourceBundleName());
		System.out.println("Logger.getGlobal().getHandlers().length: " + Logger.getGlobal().getHandlers().length);
		System.out.println("Arrays.toString(Logger.getGlobal().getHandlers()): "
				+ Arrays.toString(Logger.getGlobal().getHandlers()));
		System.out.println();

		System.out
				.println("Logger.getGlobal().isLoggable(Level.SEVERE): " + Logger.getGlobal().isLoggable(Level.SEVERE));
		System.out.println(
				"Logger.getGlobal().isLoggable(Level.WARNING): " + Logger.getGlobal().isLoggable(Level.WARNING));
		System.out.println("Logger.getGlobal().isLoggable(Level.INFO): " + Logger.getGlobal().isLoggable(Level.INFO));
		System.out
				.println("Logger.getGlobal().isLoggable(Level.CONFIG): " + Logger.getGlobal().isLoggable(Level.CONFIG));
		System.out.println("Logger.getGlobal().isLoggable(Level.FINE): " + Logger.getGlobal().isLoggable(Level.FINE));
		System.out.println("Logger.getGlobal().isLoggable(Level.FINER): " + Logger.getGlobal().isLoggable(Level.FINER));
		System.out
				.println("Logger.getGlobal().isLoggable(Level.FINEST): " + Logger.getGlobal().isLoggable(Level.FINEST));
		System.out.println("Note: By default, only messages of the SEVERE, WARNING and INFO levels will be logged.");
	}

	public static void showLoggingLevels() {
		System.out.println("Logging Levels");
		System.out.println();

		System.out.println("Level Name (Value)\t\tDescription");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Level.OFF (" + Level.OFF.intValue()
				+ ") \t\tThe message level indicating that the logging should be turned off.");
		System.out.println(
				"Level.SEVERE (" + Level.SEVERE.intValue() + ") \t\tThe message level indicating serious failures.");
		System.out.println("Level.WARNING (" + Level.WARNING.intValue()
				+ ") \t\tThe message level indicating potential problems.");
		System.out.println(
				"Level.INFO (" + Level.INFO.intValue() + ") \t\tThe message level indicating informational messages.");
		System.out.println("Level.CONFIG (" + Level.CONFIG.intValue()
				+ ") \t\tThe message level indicating static configuration messages.");
		System.out.println(
				"Level.FINE (" + Level.FINE.intValue() + ") \t\tThe message level indicating tracing information.");
		System.out.println("Level.FINER (" + Level.FINER.intValue()
				+ ") \t\tThe message level indicating fairly detailed tracing information.");
		System.out.println("Level.FINEST (" + Level.FINEST.intValue()
				+ ") \t\tThe message level indicating highly detailed tracing information.");
		System.out.println("Level.ALL (" + Level.ALL.intValue()
				+ ") \tThe message level indicating that messages of all levels should be logged.");

	}

	public static void makeSingleLogging() {
		// A logging displays as follows by default.
		// =================================================
		// [Date & Time] [Class Name (Qualified)] [Method Name]
		// [Message]
		// =================================================

		// There are several methods can be used to make a logging, as follows.
		Logger.getGlobal().info("Doing something...");
		Logger.getGlobal().log(Level.INFO, "Doing something...");
		Logger.getGlobal().log(Level.INFO, "Doing something... {0}, {1}, {2}", new Object[] { 123, "abc", true });
		Logger.getGlobal().log(Level.INFO, "Doing something...", new Exception("Some exception occurred."));
	}

	public static void makeMultipleLoggings() {
		Logger.getGlobal().severe("Logging a SEVERE level message.");
		Logger.getGlobal().warning("Logging a WARNING level message.");
		Logger.getGlobal().info("Logging a INFO level message.");

		// By default, the messages which levels are under INFO will not be
		// logged (i.e. the levels CONFIG, FINE, FINER and FINEST).
		// To enable the logging of those messages,
		// 1. the logger's level should be set using ALL or FINEST.
		// 2. a handler which level is ALL or FINEST should be created for the
		// logger.
		Logger.getGlobal().setLevel(Level.ALL);
		Handler handler = new ConsoleHandler();
		handler.setLevel(Logger.getGlobal().getLevel());
		Logger.getGlobal().addHandler(handler);

		Logger.getGlobal().config("Logging a CONFIG level message.");
		Logger.getGlobal().fine("Logging a FINE level message.");
		Logger.getGlobal().finer("Logging a FINER level message.");
		Logger.getGlobal().finest("Logging a FINEST level message.");

		// Reset the global logger.
		Logger.getGlobal().removeHandler(handler);
		Logger.getGlobal().setLevel(null);
	}

	private static void makeMultipleLoggings2() {
		Logger.getGlobal().severe("Logging a SEVERE level message.");
		Logger.getGlobal().warning("Logging a WARNING level message.");
		Logger.getGlobal().info("Logging a INFO level message.");

		// If the logging level in the global logger is under INFO,
		// i.e. FINE or FINER or FINEST or ALL,
		// a handler with the logging level FINE or ALL should be created and
		// added into the global logger, for logging those messages which level
		// is under INFO, because by default only messages which level is same
		// as or beyond INFO will be logged.
		Handler handler = null;
		if (Logger.getGlobal().getLevel() != null && Logger.getGlobal().getLevel().intValue() < Level.INFO.intValue()) {
			handler = new ConsoleHandler();
			handler.setLevel(Logger.getGlobal().getLevel());
			Logger.getGlobal().addHandler(handler);
		}

		Logger.getGlobal().config("Logging a CONFIG level message.");
		Logger.getGlobal().fine("Logging a FINE level message.");
		Logger.getGlobal().finer("Logging a FINER level message.");
		Logger.getGlobal().finest("Logging a FINEST level message.");

		// Reset the global logger.
		if (handler != null) {
			Logger.getGlobal().removeHandler(handler);
		}
	}

	public static void setLoggingLevel() {
		Logger.getGlobal().setLevel(Level.OFF);
		System.out.println("The logging has been turned off. (level: " + Logger.getGlobal().getLevel() + ")");

		System.out.println("Making multiple loggings...");
		makeMultipleLoggings2();
		System.out.println();

		Logger.getGlobal().setLevel(Level.ALL);
		System.out.println("The logging has been turned on for messages of all levels. (level: "
				+ Logger.getGlobal().getLevel() + ")");

		System.out.println("Making multiple loggings...");
		makeMultipleLoggings2();
		System.out.println();

		Logger.getGlobal().setLevel(Level.WARNING);
		System.out.println("The logging has been set for messages of the WARNING level and its upper levels. (level: "
				+ Logger.getGlobal().getLevel() + ")");

		System.out.println("Making multiple loggings...");
		makeMultipleLoggings2();
	}

	public static void createCustomLoggers() {
		// Create and use a custom logger.
		String loggerName = "com.somecompany.someapplication";
		Logger logger = Logger.getLogger(loggerName);
		showLoggerInfo(logger);
		System.out.println();

		logger.info("(Custom Logger) Doing something...");
		System.out.println();

		// Get and use an existing custom logger.
		Logger sameLogger = Logger.getLogger(loggerName);
		System.out.println("(logger == sameLogger): " + (logger == sameLogger));
		sameLogger.info("(Custom Logger) Doing something again...");
		System.out.println();

		// It is conventional to use the qualified name of the host class as the
		// logger's name.
		Logger loggerCreatedByConvention = Logger.getLogger(Test1GeneralTesting.class.getName());
		System.out.println("loggerCreatedByConvention.getName(): " + loggerCreatedByConvention.getName());
		System.out.println();

		// Create and use a custom logger.
		String childLoggerName = loggerName + ".somemodule";
		Logger childLogger = Logger.getLogger(childLoggerName);
		System.out.println("childLogger.getParent(): " + childLogger.getParent());
		System.out.println("(childLogger.getParent() == logger): " + (childLogger.getParent() == logger));
		System.out.println();

		// TODO The following code tries to verify that the child logger will
		// inherit the logging level from its parent logger, but it fails due to
		// unknown reason.
		System.out.println("childLogger.getLevel(): " + childLogger.getLevel());
		childLogger.finer("(Custom Child Logger) Logging a FINER level message.");
		logger.setLevel(Level.FINER);
		System.out.println("childLogger.getLevel(): " + childLogger.getLevel());
		childLogger.finer("(Custom Child Logger) Logging a FINER level message.");
	}

	public static void makeLoggingsWhenInvocationInfoLost() {
		// Sometimes, the accurate invocation information (such as the class
		// name and the method name) cannot be retrieved in the logging due to
		// some reasons (such as the JVM has improved the execution process).
		// The method "logp" can be used to solve this case.

		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
		String logMessage = "Doing something...";

		logger.info(logMessage);
		logger.log(Level.INFO, logMessage);

		String className = "com.somecompany.someapplication.somepackage.SomeClass";
		String methodName = "someMethod";

		logger.logp(Level.INFO, className, methodName, logMessage);
	}

	/**
	 * <pre>
	 * The "entering" and "exiting" methods can be used to log the entry and return of a method.
	 * </pre>
	 */
	public static String logEntryAndReturn(int parameter1, String parameter2, boolean parameter3) {
		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
		logger.setLevel(Level.ALL);
		Handler handler = new ConsoleHandler();
		handler.setLevel(logger.getLevel());
		logger.addHandler(handler);

		String className = "com.somecompany.someapplication.somepackage.SomeClass";
		String methodName = "someMethod";
		Object[] methodParameters = { parameter1, parameter2, parameter3 };
		String methodResult = "Done!";

		logger.entering(className, methodName, methodParameters);

		// ...

		logger.exiting(className, methodName, methodResult);

		return methodResult;
	}

	/**
	 * <pre>
	 * There are 2 methods which is able to log with an exception - "logp" and "throwing".
	 * </pre>
	 */
	public static void logWithException() {
		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
		String logMessage = "Doing something...";
		String className = "com.somecompany.someapplication.somepackage.SomeClass";
		String methodName = "someMethod";

		// Using the method "logp".
		logger.logp(Level.SEVERE, className, methodName, logMessage, new Exception("Some unknown exception occurred!"));

		// Using the method "throwing".
		// A handler with the logging level FINER or ALL should be created and
		// added into the logger,
		// since the logging by this method is done using the FINER level by
		// default.
		logger.setLevel(Level.FINER);
		Handler handler = new ConsoleHandler();
		handler.setLevel(logger.getLevel());
		logger.addHandler(handler);
		logger.throwing(className, methodName, new Exception("Some unknown exception occurred!"));
	}

	private static void showLoggerInfo(Logger logger) {
		System.out.println("logger: " + logger);
		System.out.println("logger.getName(): " + logger.getName());
		System.out.println("logger.getLevel(): " + logger.getLevel());
		System.out.println("logger.getResourceBundleName(): " + logger.getResourceBundleName());
		System.out.println("Arrays.toString(logger.getHandlers()): " + Arrays.toString(logger.getHandlers()));
		System.out.println("logger.getParent(): " + logger.getParent());
		if (logger.getParent() != null) {
			System.out.println("--------------------------------------------------------------------");
			showLoggerInfo(logger.getParent());
			System.out.println("--------------------------------------------------------------------");
		}
	}

	public static void main(String[] args) {
		showGlobalLoggerInfo();
		Utils.printDelimiterLine1();

		showLoggingLevels();
		Utils.printDelimiterLine1();

		makeSingleLogging();
		Utils.printDelimiterLine1();

		makeMultipleLoggings();
		Utils.printDelimiterLine1();

		setLoggingLevel();
		Utils.printDelimiterLine1();

		createCustomLoggers();
		Utils.printDelimiterLine1();

		makeLoggingsWhenInvocationInfoLost();
		Utils.printDelimiterLine1();

		logEntryAndReturn(123, "abc", true);
		Utils.printDelimiterLine1();

		logWithException();
		Utils.printDelimiterLine1();
	}

}
