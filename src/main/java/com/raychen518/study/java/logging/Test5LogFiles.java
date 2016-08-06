package com.raychen518.study.java.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.raychen518.study.java._util.Randoms;

/**
 * <pre>
 * The FileHandler class is used to output the log to files.
 * 
 * - Default behaviors of a file handler can be changed
 *   by modifying related settings in the logging configuration file
 *   or invoking related constructors/methods on the FileHandler object in runtime.
 *   <See the FileHandler class for more details.>
 * </pre>
 */
public class Test5LogFiles {

	public static void testUsingDefaultConfiguration1(int logFileUniqueNumber) throws SecurityException, IOException {
		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
		FileHandler fileHandler = new FileHandler();
		logger.addHandler(fileHandler);
		logger.info("... testUsingDefaultConfiguration #1 ...");

		showLogFileLocation(logFileUniqueNumber);
	}

	public static void testUsingDefaultConfiguration2(int logFileUniqueNumber) throws SecurityException, IOException {
		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
		FileHandler fileHandler = new FileHandler();
		logger.addHandler(fileHandler);
		logger.info("... testUsingDefaultConfiguration #2 ...");

		showLogFileLocation(logFileUniqueNumber);
	}

	public static void testUsingNondefaultFormatter(int logFileUniqueNumber) throws SecurityException, IOException {
		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
		Handler fileHandler = new FileHandler();
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
		logger.info("... testUsingNondefaultFormatter ...");

		showLogFileLocation(logFileUniqueNumber);
	}

	public static void testUsingNondefaultLevel(int logFileUniqueNumber) throws SecurityException, IOException {
		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
		Handler fileHandler = new FileHandler();
		fileHandler.setLevel(Level.WARNING);
		logger.addHandler(fileHandler);
		logger.severe("... testUsingNondefaultLevel (SEVERE) ...");
		logger.warning("... testUsingNondefaultLevel (WARNING) ...");
		logger.info("... testUsingNondefaultLevel (INFO) ...");

		showLogFileLocation(logFileUniqueNumber);
	}

	public static void testUsingNondefaultFilter(int logFileUniqueNumber) throws SecurityException, IOException {
		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
		Handler fileHandler = new FileHandler();
		fileHandler.setFilter(new LogRecordFilter());
		logger.addHandler(fileHandler);
		logger.info("... testUsingNondefaultFilter #1 ...");
		logger.info("... testUsingNondefaultFilter #2 (Not for File) ...");
		logger.info("... testUsingNondefaultFilter #3 ...");
		logger.info("... testUsingNondefaultFilter #4 (Not for File) ...");

		showLogFileLocation(logFileUniqueNumber);
	}

	public static void testUsingNondefaultSettings() throws SecurityException, IOException {
		Logger logger = Logger.getLogger(Randoms.generateRandomString(5));
		String fileNamePattern = "%t/test%u.log";
		int fileLimit = 100;
		int fileCount = 10;
		boolean fileAppend = false;
		logger.addHandler(new FileHandler(fileNamePattern, fileLimit, fileCount, fileAppend));
		logger.info("... testUsingNondefaultSettings #1 ...");
		logger.info("... testUsingNondefaultSettings #2 ...");
		logger.info("... testUsingNondefaultSettings #3 ...");

		String logFileDirectory = System.getProperty("java.io.tmpdir");
		logFileDirectory = logFileDirectory.substring(0, logFileDirectory.length() - 1);
		String logFileLocationInfo = "";
		int logFileUniqueNumber = 0;
		logFileLocationInfo += "The log has been outputted to the following files.\n";
		logFileLocationInfo += "\t" + logFileDirectory + "\\test0.log." + (logFileUniqueNumber++) + "\n";
		logFileLocationInfo += "\t" + logFileDirectory + "\\test0.log." + (logFileUniqueNumber++) + "\n";
		logFileLocationInfo += "\t" + logFileDirectory + "\\test0.log." + (logFileUniqueNumber++) + "\n";
		logFileLocationInfo += "\t...";
		System.out.println(logFileLocationInfo);
		System.out.println();
	}

	private static void showLogFileLocation(int logFileUniqueNumber) {
		showLogFileLocation(logFileUniqueNumber, null);
	}

	private static void showLogFileLocation(int logFileUniqueNumber, String logFileDirectory) {
		System.out.println("The log has been outputted to the file "
				+ (logFileDirectory == null ? System.getProperty("user.home") : logFileDirectory) + "\\java"
				+ logFileUniqueNumber + ".log.");
		System.out.println();
	}

	private static class LogRecordFilter implements Filter {

		@Override
		public boolean isLoggable(LogRecord logRecord) {
			return !logRecord.getMessage().contains("Not for File");
		}

	}

	public static void main(String[] args) throws SecurityException, IOException {
		int logFileUniqueNumber = 0;
		testUsingDefaultConfiguration1(logFileUniqueNumber++);
		testUsingDefaultConfiguration2(logFileUniqueNumber++);
		testUsingNondefaultFormatter(logFileUniqueNumber++);
		testUsingNondefaultLevel(logFileUniqueNumber++);
		testUsingNondefaultFilter(logFileUniqueNumber++);

		testUsingNondefaultSettings();
	}

}
