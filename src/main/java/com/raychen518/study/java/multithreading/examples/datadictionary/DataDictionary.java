package com.raychen518.study.java.multithreading.examples.datadictionary;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * <pre>
 * This class represents a data dictionary which uses a pair of reentrant Read and Write locks
 * to control the access to its data in multi-threading.
 * </pre>
 */
public class DataDictionary {

	private final Map<String, Object> dataDictionary = new TreeMap<>();

	private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private final Lock readLock = readWriteLock.readLock();
	private final Lock writeLock = readWriteLock.writeLock();

	public Object get(String key) {
		readLock.lock();
		try {
			return dataDictionary.get(key);
		} finally {
			System.out.println(Thread.currentThread().getName() + ": " + dataDictionary);
			readLock.unlock();
		}
	}

	public String[] allKeys() {
		readLock.lock();
		try {
			return dataDictionary.keySet().toArray(new String[dataDictionary.keySet().size()]);
		} finally {
			readLock.unlock();
		}
	}

	public int size() {
		readLock.lock();
		try {
			return dataDictionary.size();
		} finally {
			readLock.unlock();
		}
	}

	public Object put(String key, Object value) {
		writeLock.lock();
		try {
			return dataDictionary.put(key, value);
		} finally {
			System.out.println(Thread.currentThread().getName() + ": " + dataDictionary);
			writeLock.unlock();
		}
	}

	public void clear() {
		writeLock.lock();
		try {
			dataDictionary.clear();
		} finally {
			writeLock.unlock();
		}
	}

	@Override
	public String toString() {
		return dataDictionary.toString();
	}

}
