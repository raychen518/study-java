package com.raychen518.study.java.reflection.general;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		System.out.println("====================================================");
		System.out.println("Getting Class by Class/Object");
		System.out.println("====================================================");
		System.out.println("Getting Class by Class\t\t: <Class>.class");
		System.out.println("Getting Class by Object\t\t: <Object>.getClass()");
		System.out.println();

		System.out.println("ArrayList.class.getName()\t\t\t: " + ArrayList.class.getName());
		System.out.println(
				"(new ArrayList<Object>()).getClass().getName()\t: " + (new ArrayList<Object>()).getClass().getName());
		System.out.println("ArrayList.class == (new ArrayList<Object>()).getClass(): "
				+ (ArrayList.class == (new ArrayList<Object>()).getClass()));
		System.out.println();

		System.out.println("int.class.getName()\t\t\t\t: " + int.class.getName());
		System.out.println("Integer.class.getName()\t\t\t\t: " + Integer.class.getName());
		System.out.println("double[].class.getName()\t\t\t: " + double[].class.getName());
		System.out.println("Double[].class.getName()\t\t\t: " + Double[].class.getName());
		System.out.println();

		System.out.println("====================================================");
		System.out.println("Getting Class by Class Name");
		System.out.println("====================================================");
		System.out.println("Getting Class by Class Name\t: Class.forName(<Class Name>)");
		System.out.println();

		try {
			System.out.println("Class.forName(\"java.util.ArrayList\").getName()\t: "
					+ Class.forName("java.util.ArrayList").getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println();

		System.out.println("====================================================");
		System.out.println("Creating an Instance by Class");
		System.out.println("====================================================");
		System.out.println("The method .newInstance() can be used to create an instance of the specified class,");
		System.out.println("by invoking the default constructor of the specified class.");
		System.out.println(
				"Note: To create an instance by invoking a constructor with parameters, use Constructor.newInstance() method instead.");
		System.out.println();

		SomeClass someObject = null;

		try {
			someObject = SomeClass.class.newInstance();
			System.out.println("someObject = SomeClass.class.newInstance();");
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		if (someObject != null) {
			System.out.println("someObject: " + someObject);
		}
		System.out.println();

		try {
			Object currentDate = Class.forName("java.util.Date").newInstance();
			System.out.println("Object currentDate = Class.forName(\"java.util.Date\").newInstance();");
			System.out.println("currentDate: " + currentDate);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
