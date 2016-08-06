package com.raychen518.study.java.genericprogramming.reflection;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <pre>
 * This class shows an example which prints the generic information of a specified generic class.
 * </pre>
 */
public class Test2 {

	public static void main(String[] args) {
		// Read the name of the class to print the generic information, from
		// the command line (the argument "args" of the main() method) or the
		// user input.
		String className;
		if (args.length > 0) {
			className = args[0];
		} else {
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"Please enter the name of the class to print the generic information (e.g. java.util.Collections, java.util.Map):");
			className = scanner.next();
			scanner.close();
		}

		try {
			// Get the class to print the generic information.
			Class<?> object = Class.forName(className);

			// Print the class-level generic information of the specified class.
			printClassLevelInfo(object);

			// Print the method-level generic information of the specified
			// class.
			for (Method method : object.getDeclaredMethods()) {
				printMethodLevelInfo(method);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void printClassLevelInfo(Class<?> object) {
		// Print the qualified name of the the specified class.
		System.out.print(object);

		// Print the declared type parameters of the specified class.
		printTypes(object.getTypeParameters(), "<", ", ", ">", true);

		// Print the extended superclass of the specified class.
		Type superclass = object.getGenericSuperclass();
		if (superclass != null) {
			System.out.print(" extends ");
			printType(superclass, false);
		}

		// Print the implemented interfaces of the specified class.
		printTypes(object.getGenericInterfaces(), " implements ", ", ", "", false);
		System.out.println();
	}

	public static void printMethodLevelInfo(Method method) {
		// Print the modifiers of the specified method.
		System.out.print(Modifier.toString(method.getModifiers()));
		System.out.print(" ");

		// Print the declared type parameters of the specified method.
		printTypes(method.getTypeParameters(), "<", ", ", "> ", true);

		// Print the return type of the specified method.
		printType(method.getGenericReturnType(), false);
		System.out.print(" ");

		// Print the name of the specified method.
		System.out.print(method.getName());

		// Print the parameter types of the specified method.
		System.out.print("(");
		printTypes(method.getGenericParameterTypes(), "", ", ", "", false);
		System.out.println(")");
	}

	public static void printTypes(Type[] types, String prefix, String separator, String suffix, boolean isDefinition) {
		if (prefix.equals(" extends ") && Arrays.equals(types, new Type[] { Object.class })) {
			return;
		}

		if (types.length > 0) {
			System.out.print(prefix);
		}

		for (int i = 0; i < types.length; i++) {
			if (i > 0) {
				System.out.print(separator);
			}
			printType(types[i], isDefinition);
		}

		if (types.length > 0) {
			System.out.print(suffix);
		}
	}

	public static void printType(Type type, boolean isDefinition) {
		if (type instanceof Class) {
			Class<?> actualType = (Class<?>) type;
			System.out.print(actualType.getName());
		} else if (type instanceof TypeVariable) {
			TypeVariable<?> actualType = (TypeVariable<?>) type;
			System.out.print(actualType.getName());
			if (isDefinition) {
				printTypes(actualType.getBounds(), " extends ", " & ", "", false);
			}
		} else if (type instanceof WildcardType) {
			WildcardType actualType = (WildcardType) type;
			System.out.print("?");
			printTypes(actualType.getUpperBounds(), " extends ", " & ", "", false);
			printTypes(actualType.getLowerBounds(), " super ", " & ", "", false);
		} else if (type instanceof ParameterizedType) {
			ParameterizedType actualType = (ParameterizedType) type;
			Type ownerType = actualType.getOwnerType();
			if (ownerType != null) {
				printType(ownerType, false);
				System.out.print(".");
			}
			printType(actualType.getRawType(), false);
			printTypes(actualType.getActualTypeArguments(), "<", ", ", ">", false);
		} else if (type instanceof GenericArrayType) {
			GenericArrayType actualType = (GenericArrayType) type;
			System.out.print("");
			printType(actualType.getGenericComponentType(), isDefinition);
			System.out.print("[]");
		}
	}
}
