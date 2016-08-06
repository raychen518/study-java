package com.raychen518.study.java.reflection.examples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * <pre>
 * To improve:
 * - The modifier display for interfaces/enums/annotations may be incorrect.
 * - The class category display may be incorrect.
 * - There is no display for "extends" section.
 * - There is no display for "implements" section.
 * - There is no display for "throws" section.
 * - There is no display for Type Parameters section.
 * </pre>
 */
public final class ClassAnalyzer {

	private static final String INDENT = "    ";
	private static final String SPACE = " ";
	private static final String SEMICOLON = ";";
	private static final String ROUND_BRACKET_LEFT = "(";
	private static final String ROUND_BRACKET_RIGHT = ")";
	private static final String CURLY_BRACKET_LEFT = "{";
	private static final String CURLY_BRACKET_RIGHT = "}";
	private static final String PARAMETER_DELIMETER = ", ";

	public static void print(Class<?> theClass) {
		printClass(theClass);
		System.out.println(SPACE + CURLY_BRACKET_LEFT);

		printFields(theClass);
		if (theClass.getDeclaredFields().length > 0) {
			System.out.println();
		}

		printConstructors(theClass);
		if (theClass.getDeclaredConstructors().length > 0) {
			System.out.println();
		}

		printMethods(theClass);
		System.out.println(CURLY_BRACKET_RIGHT);
	}

	private static void printClass(Class<?> theClass) {
		String modifierDisplay = Modifier.toString(theClass.getModifiers());

		if (modifierDisplay.length() > 0) {
			System.out.print(modifierDisplay + SPACE);
		}

		System.out.print(getClassCategoryName(theClass) + SPACE);

		System.out.print(theClass.getSimpleName());
	}

	private static void printFields(Class<?> theClass) {
		Field[] fields = theClass.getDeclaredFields();

		for (Field field : fields) {
			System.out.print(INDENT);

			String modifierDisplay = Modifier.toString(field.getModifiers());

			if (modifierDisplay.length() > 0) {
				System.out.print(modifierDisplay + SPACE);
			}

			System.out.print(field.getType().getName() + SPACE);

			System.out.println(field.getName() + SEMICOLON);
		}
	}

	private static void printConstructors(Class<?> theClass) {
		Constructor<?>[] constructors = theClass.getDeclaredConstructors();

		for (Constructor<?> constructor : constructors) {
			System.out.print(INDENT);

			String modifierDisplay = Modifier.toString(constructor.getModifiers());

			if (modifierDisplay.length() > 0) {
				System.out.print(modifierDisplay + SPACE);
			}

			System.out.print(constructor.getName() + ROUND_BRACKET_LEFT);

			Class<?>[] parameterTypes = constructor.getParameterTypes();

			for (int i = 0; i < parameterTypes.length; i++) {
				if (i > 0) {
					System.out.print(PARAMETER_DELIMETER);
				}

				System.out.print(parameterTypes[i].getName());
			}

			System.out.println(ROUND_BRACKET_RIGHT + SEMICOLON);
		}
	}

	private static void printMethods(Class<?> theClass) {
		Method[] methods = theClass.getDeclaredMethods();

		for (Method method : methods) {
			System.out.print(INDENT);

			String modifierDisplay = Modifier.toString(method.getModifiers());

			if (modifierDisplay.length() > 0) {
				System.out.print(modifierDisplay + SPACE);
			}

			System.out.print(method.getReturnType().getName() + SPACE);

			System.out.print(method.getName() + ROUND_BRACKET_LEFT);

			Class<?>[] parameterTypes = method.getParameterTypes();

			for (int i = 0; i < parameterTypes.length; i++) {
				if (i > 0) {
					System.out.print(PARAMETER_DELIMETER);
				}

				System.out.print(parameterTypes[i].getName());
			}

			System.out.println(ROUND_BRACKET_RIGHT + SEMICOLON);
		}
	}

	private static String getClassCategoryName(Class<?> theClass) {
		ClassCategory classCategory;

		if (theClass.isInterface()) {
			classCategory = ClassCategory.INTERFACE;
		} else if (theClass.isEnum()) {
			classCategory = ClassCategory.ENUM;
		} else if (theClass.isAnnotation()) {
			classCategory = ClassCategory.ANNOTATION;
		} else {
			classCategory = ClassCategory.CLASS;
		}

		return classCategory.getName();
	}

	private enum ClassCategory {
		CLASS("class"), INTERFACE("interface"), ENUM("enum"), ANNOTATION("annotation");

		private String name;

		ClassCategory(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	public static void main(String[] args) {
		// class: java.lang.String.class
		// interface: java.util.List.class;
		// enum: java.nio.file.AccessMode
		// annotation: javax.xml.ws.Action

		ClassAnalyzer.print(java.lang.String.class);
		// ClassAnalyzer.print(java.util.List.class);
		// ClassAnalyzer.print(java.nio.file.AccessMode.class);
		// ClassAnalyzer.print(javax.xml.ws.Action.class);

		// System.out.println();
		// Class<?> someClass = int.class;
		//
		// System.out.println("someClass.getName()\t\t\t: " +
		// someClass.getName());
		// System.out.println("someClass.getFields().length\t\t: " +
		// someClass.getFields().length);
		// System.out.println("someClass.getConstructors().length\t: " +
		// someClass.getConstructors().length);
		// System.out.println("someClass.getMethods().length\t\t: " +
		// someClass.getMethods().length);
	}

}
