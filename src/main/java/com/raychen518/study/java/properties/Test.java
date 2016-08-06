package com.raychen518.study.java.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Index
		// - Set and Read Properties
		// - Set Properties Using Defaults
		// - Store Properties
		// - Load Properties
		// - Read System Properties
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		// =================================================
		// Set and Read Properties
		// =================================================
		{
			Properties properties = new Properties();
			properties.put("key1", "value1");
			properties.put("key2", "value2");
			properties.put("key3", "value3");

			System.out.println("properties: " + properties);
			System.out.println("properties.size(): " + properties.size());
			System.out.println("properties.getProperty(\"key2\"): " + properties.getProperty("key2"));
			System.out.println("properties.containsKey(\"key3\"): " + properties.containsKey("key3"));
			System.out.println("properties.containsKey(\"key4\"): " + properties.containsKey("key4"));
			System.out.println("properties.containsValue(\"value2\"): " + properties.containsValue("value2"));
			System.out.println("properties.contains(\"value2\"): " + properties.contains("value2"));
			System.out.println("properties.getProperty(\"key4\"): " + properties.getProperty("key4"));
			System.out.println("properties.getProperty(\"key4\", \"value4AsDefault\"): "
					+ properties.getProperty("key4", "value4AsDefault"));
			System.out.println();

			for (Entry<Object, Object> property : properties.entrySet()) {
				System.out.println(property.getKey() + ": " + property.getValue());
			}
			System.out.println();

			Enumeration<?> propertyNames = properties.propertyNames();
			while (propertyNames.hasMoreElements()) {
				String propertyName = (String) propertyNames.nextElement();
				System.out.println(propertyName);
			}
			System.out.println();
		}

		{
			Properties properties = new Properties();
			properties.put("item1", 123);
			properties.put("item2", "abc");
			properties.put("item3", true);

			for (Entry<Object, Object> property : properties.entrySet()) {
				System.out.println(property.getKey() + ": " + property.getValue());
			}
			System.out.println();
		}

		// =================================================
		// Set Properties Using Defaults
		// =================================================
		{
			Properties defaultProperties = new Properties();
			defaultProperties.put("key1", "defaultValue1");
			defaultProperties.put("key2", "defaultValue2");
			defaultProperties.put("key3", "defaultValue3");

			Properties properties = new Properties(defaultProperties);

			System.out.println("----------------------------");
			System.out.println("properties: " + properties);
			System.out.println("properties.size(): " + properties.size());
			System.out.println("----------------------------");
			for (Entry<Object, Object> property : properties.entrySet()) {
				System.out.println(property.getKey() + ": " + property.getValue());
			}
			System.out.println("----------------------------");
			System.out.println("properties.getProperty(\"key1\"): " + properties.getProperty("key1"));
			System.out.println("properties.getProperty(\"key2\"): " + properties.getProperty("key2"));
			System.out.println("properties.getProperty(\"key3\"): " + properties.getProperty("key3"));
			System.out.println("----------------------------");
			System.out.println();
		}

		// =================================================
		// Store Properties
		// =================================================
		{
			Properties properties = new Properties();
			properties.put("key1", "value1");
			properties.put("key2", "value2");
			properties.put("key3", "value3");

			try {
				String propertiesFileName = "application.properties";
				FileOutputStream fileOutputStream = new FileOutputStream(propertiesFileName);

				properties.store(fileOutputStream, "Application Properties");

				System.out.println("The properties file " + System.getProperty("user.dir") + "\\" + propertiesFileName
						+ " has been created.");
				System.out.println();

				// The properties file named "application.properties" will be
				// created after above statements are executed, with following
				// content.
				// -----------------------------------------
				// #Application Properties
				// #Sat Feb 20 15:45:15 CST 2016
				// key3=value3
				// key2=value2
				// key1=value1
				// -----------------------------------------
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		{
			Properties properties = new Properties();
			properties.put("module1.page1.item1", "value111");
			properties.put("module1.page2.item2", "value122");
			properties.put("module2.page3.item4", "value234");

			try {
				String propertiesFilePath = System.getProperty("user.home") + "\\" + "application.properties";
				FileOutputStream fileOutputStream = new FileOutputStream(propertiesFilePath);

				properties.store(fileOutputStream, "Application Properties");

				System.out.println("The properties file " + propertiesFilePath + " has been created.");
				System.out.println();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// =================================================
		// Load Properties
		// =================================================
		{
			Properties properties = new Properties();

			try {
				System.out.println("properties.size(): " + properties.size());

				String propertiesFileName = "application.properties";
				FileInputStream fileInputStream = new FileInputStream(propertiesFileName);

				properties.load(fileInputStream);

				System.out.println("properties.size(): " + properties.size());

				for (Entry<Object, Object> property : properties.entrySet()) {
					System.out.println(property.getKey() + ": " + property.getValue());
				}
				System.out.println();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// =================================================
		// Read System Properties
		// =================================================
		{
			Properties properties = System.getProperties();
			SortedMap<Object, Object> sortedProperties = new TreeMap<Object, Object>(properties);

			for (Entry<Object, Object> property : sortedProperties.entrySet()) {
				System.out.println(property.getKey() + ": " + property.getValue());
			}
			System.out.println();
		}
	}

}
