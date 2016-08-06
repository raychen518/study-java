package com.raychen518.study.java.multithreading.examples.datadictionary;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.raychen518.study.java._util.Utils;

public class _Demo {

	private static final String DATA_DICTIONARY_ITEM_BASE_KEY = "key";

	private static final String DATA_DICTIONARY_ITEM_BASE_VALUE = "value";

	private static final AtomicInteger DATA_DICTIONARY_ITEM_NUMBER_GENERATOR = new AtomicInteger(11);

	private static final ThreadLocal<Integer> DATA_DICTIONARY_ITEM_NUMBER = new ThreadLocal<Integer>() {

		@Override
		protected Integer initialValue() {
			return DATA_DICTIONARY_ITEM_NUMBER_GENERATOR.getAndIncrement();
		}

	};

	private static String generateDataDictionaryItemKey() {
		return generateDataDictionaryItemKey(DATA_DICTIONARY_ITEM_NUMBER.get());
	}

	private static String generateDataDictionaryItemKey(int dataDictionaryItemNumber) {
		return DATA_DICTIONARY_ITEM_BASE_KEY + Utils.padNumberString(dataDictionaryItemNumber);
	}

	private static String generateDataDictionaryItemValue() {
		return generateDataDictionaryItemValue(DATA_DICTIONARY_ITEM_NUMBER.get());
	}

	private static String generateDataDictionaryItemValue(int dataDictionaryItemNumber) {
		return DATA_DICTIONARY_ITEM_BASE_VALUE + Utils.padNumberString(dataDictionaryItemNumber);
	}

	private static interface DataDictionaryProcess {
	}

	private static class DataDictionaryGetProcess implements DataDictionaryProcess, Runnable {

		private DataDictionary dataDictionary;

		public DataDictionaryGetProcess(DataDictionary dataDictionary) {
			this.dataDictionary = dataDictionary;
		}

		@Override
		public void run() {
			dataDictionary.get(generateDataDictionaryItemKey(new Random().nextInt(dataDictionary.size() + 1)));
		}

	}

	private static class DataDictionaryPutProcess implements DataDictionaryProcess, Runnable {

		private DataDictionary dataDictionary;

		public DataDictionaryPutProcess(DataDictionary dataDictionary) {
			this.dataDictionary = dataDictionary;
		}

		@Override
		public void run() {
			dataDictionary.put(generateDataDictionaryItemKey(), generateDataDictionaryItemValue());
		}

	}

	private static enum DataDictionaryProcessType {

		GET("GET"), PUT("PUT");

		private final String name;

		private DataDictionaryProcessType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public static DataDictionaryProcessType getRandomValue() {
			DataDictionaryProcessType[] values = DataDictionaryProcessType.values();
			return values[new Random().nextInt(values.length)];
		}

	}

	private static Thread createRandomDataDictionaryProcessThread(DataDictionary dataDictionary) {
		DataDictionaryProcessType dataDictionaryProcessType = DataDictionaryProcessType.getRandomValue();
		Runnable runnable = createDataDictionaryProcess(dataDictionaryProcessType, dataDictionary);
		String threadName = generateDataDictionaryProcessThreadName(dataDictionaryProcessType);
		return new Thread(runnable, threadName);
	}

	private static Runnable createDataDictionaryProcess(DataDictionaryProcessType dataDictionaryProcessType,
			DataDictionary dataDictionary) {
		Runnable result = null;

		switch (dataDictionaryProcessType) {
		case GET:
			result = new DataDictionaryGetProcess(dataDictionary);
			break;

		case PUT:
			result = new DataDictionaryPutProcess(dataDictionary);
			break;
		}

		return result;
	}

	private static int dataDictionaryGetProcessCounter = 0;
	private static int dataDictionaryPutProcessCounter = 0;

	private static String generateDataDictionaryProcessThreadName(DataDictionaryProcessType dataDictionaryProcessType) {
		int dataDictionaryItemNumber = 0;

		switch (dataDictionaryProcessType) {
		case GET:
			dataDictionaryItemNumber = ++dataDictionaryGetProcessCounter;
			break;

		case PUT:
			dataDictionaryItemNumber = ++dataDictionaryPutProcessCounter;
			break;
		}

		return dataDictionaryProcessType.getName() + Utils.padNumberString(dataDictionaryItemNumber);
	}

	public static void main(String[] args) {
		DataDictionary dataDictionary = new DataDictionary();

		// Add some data dictionary items before the testing.
		for (int i = 0; i < 3; i++) {
			int dataDictionaryItemNumber = i + 1;
			dataDictionary.put(generateDataDictionaryItemKey(dataDictionaryItemNumber),
					generateDataDictionaryItemValue(dataDictionaryItemNumber));
		}

		for (int i = 0; i < 5; i++) {
			createRandomDataDictionaryProcessThread(dataDictionary).start();
		}

	}

}
