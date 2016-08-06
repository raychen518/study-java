package com.raychen518.study.java.logging;

import java.util.Arrays;
import java.util.logging.Logger;

import com.raychen518.study.java._util.Utils;
import com.raychen518.study.java._util.Randoms;

/**
 * <pre>
 * - The default logging configuration file is at following location.
 *   =======================================================
 *   {JAVA_HOME}\jre\lib\logging.properties
 *   =======================================================
 *
 * - To specify a logging configuration file instead of using the default one,
 *   the following command can be used.
 *   =======================================================
 *   java -Djava.util.logging.config.file={loggingConfigurationFile} {TargetClass}
 *   e.g.:
 *   java -Djava.util.logging.config.file=d:/someApplication/logging.properties ApplicationStartup
 *   Note: The "-Dproperty=value" option is used to set a system property value for the application. 
 *   =======================================================
 *
 * - Ensure to specify a logging configuration file for this class when running it,
 *   such as using a VM argument as follows.
 *   =====================================================
 *   -Djava.util.logging.config.file=d:/temp/logging.properties
 *   =====================================================
 *   And the specified logging configuration file should have following settings.
 *   =====================================================
 *   .level= FINER													# Specify the global logging level.
 *   java.util.logging.ConsoleHandler.level = FINER					# Specify the logging level on the console.
 *   com.somecompany.someapplication.somemodule.level = SEVERE		# Specify the logging level for the logger "com.somecompany.someapplication.somemodule".
 *   =====================================================
 * </pre>
 */
public class Test2ConfigurationFile {

	/**
	 * <pre>
	 * In this method, besides the SEVERE, WARNING and INFO messages,
	 * the CONFIG, FINE and FINER messages are also logged
	 * due to the following setting in the logging configuration file.
	 * =========================================================================
	 * .level= FINER
	 * java.util.logging.ConsoleHandler.level = FINER
	 * =========================================================================
	 * </pre>
	 */
	public static void testGeneralLoggingLevel() {
		System.out.println("System.getProperty(\"java.util.logging.config.file\"): "
				+ System.getProperty("java.util.logging.config.file"));
		System.out.println();

		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));

		System.out.println("logger.getLevel(): " + logger.getLevel());
		System.out.println("Arrays.toString(logger.getHandlers()): " + Arrays.toString(logger.getHandlers()));
		if (logger.getHandlers().length > 0) {
			System.out.println("logger.getHandlers()[0].getLevel(): " + logger.getHandlers()[0].getLevel());
		}
		System.out.println();

		logMessages(logger);
	}

	/**
	 * <pre>
	 * In this method, only the SEVERE message is logged,
	 * because the logger is named by "com.somecompany.someapplication.somemodule"
	 * and it is limited to log only SEVERE messages using following setting
	 * in the logging configuration file.
	 * =========================================================================
	 * com.somecompany.someapplication.somemodule.level = SEVERE
	 * =========================================================================
	 * </pre>
	 */
	public static void testPackageLoggingLevel() {
		Logger logger = Logger.getLogger("com.somecompany.someapplication.somemodule");
		logMessages(logger);
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
		testGeneralLoggingLevel();
		Utils.printDelimiterLine1();

		testPackageLoggingLevel();
		Utils.printDelimiterLine1();
	}

}
