package com.raychen518.study.java.reflection.analyzingobject;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import com.raychen518.study.java.reflection.analyzingclass.SomeClass;

public class Test {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		System.out.println("================================");
		System.out.println("Analyzing Object");
		System.out.println("================================");
		SomeClass someObject = new SomeClass();

		System.out.println("====================================================");
		System.out.println("Getting/Setting Field Values");
		System.out.println("====================================================");
		System.out.println("someObject.toString(): " + someObject.toString());
		System.out.println();

		System.out.println("// Get the value of a public field.");
		Field publicField1 = someObject.getClass().getDeclaredField("publicField1");
		System.out.println("Field publicField1 = someObject.getClass().getDeclaredField(\"publicField1\");");
		System.out.println("publicField1.get(null): " + publicField1.get(null));
		System.out.println();

		System.out.println("// Set the value of a public field.");
		publicField1.set(null, 456);
		System.out.println("publicField1.set(null, 456);");
		System.out.println("publicField1.get(null): " + publicField1.get(null));
		System.out.println();

		System.out.println("// Get the value of a private field.");
		Field privateField1 = someObject.getClass().getDeclaredField("privateField1");
		privateField1.setAccessible(true);
		System.out.println("Field privateField1 = someObject.getClass().getDeclaredField(\"privateField1\");");
		System.out.println("privateField1.setAccessible(true);");
		System.out.println("privateField1.get(someObject): " + privateField1.get(someObject));
		System.out.println();

		System.out.println("// Set the value of a private field.");
		privateField1.set(someObject, false);
		System.out.println("privateField1.set(someObject, false);");
		System.out.println("privateField1.get(someObject): " + privateField1.get(someObject));
		System.out.println();

		System.out.println("someObject.toString(): " + someObject.toString());
		System.out.println();

		System.out.println("====================================================");
		System.out.println("Getting/Setting Field Values in Batch");
		System.out.println("====================================================");
		System.out.println("someObject.toString(): " + someObject.toString());

		Field[] fields = someObject.getClass().getDeclaredFields();
		AccessibleObject.setAccessible(fields, true);

		// Change fields.
		for (Field field : fields) {
			int fieldModifiers = field.getModifiers();

			// A field cannot be modified if it is final.
			// Just skip changing it.
			if (Modifier.isFinal(fieldModifiers)) {
				continue;
			}

			Class<?> fieldType = field.getType();
			Object targetObject = Modifier.isStatic(fieldModifiers) ? null : someObject;

			if (fieldType.isPrimitive()) {
				if (fieldType == int.class) {
					field.set(targetObject, ((int) field.get(targetObject)) * 10);
				}

				if (fieldType == boolean.class) {
					field.set(targetObject, !((boolean) field.get(targetObject)));
				}
			} else {
				if (fieldType == String.class) {
					field.set(targetObject, String.valueOf(field.get(targetObject)) + " - changed");
				} else {
					// Do nothing to arrays and other types this time.
				}
			}
		}

		System.out.println("someObject.toString(): " + someObject.toString());
		System.out.println();

		System.out.println("====================================================");
		System.out.println("Invoking Methods");
		System.out.println("====================================================");
		{
			System.out.println("Invoke A Single Method");
			System.out.println("--------------------------------");
			Method method = null;
			Object methodResult = null;

			method = someObject.getClass().getDeclaredMethod("doSomething", int.class, boolean.class);
			method.setAccessible(true);
			methodResult = method.invoke(someObject, 111, true);
			System.out.println("methodResult: " + Arrays.toString((Object[]) methodResult));
			System.out.println();

			method = someObject.getClass().getDeclaredMethod("doSomething", int.class, boolean.class, String.class);
			method.setAccessible(true);
			methodResult = method.invoke(someObject, 222, false, "abc");
			System.out.println("methodResult: " + methodResult);
			System.out.println();
		}

		{
			System.out.println("Invoke Methods in Batch");
			System.out.println("--------------------------------");
			Method[] methods = someObject.getClass().getDeclaredMethods();
			AccessibleObject.setAccessible(methods, true);

			for (Method method : methods) {
				// There are many methods, let's focus on methods which names
				// start with "doSomething" this time.
				if (method.getName().startsWith("doSomething")) {
					int methodModifiers = method.getModifiers();
					Object targetObject = Modifier.isStatic(methodModifiers) ? null : someObject;
					method.invoke(targetObject, generateParameterArray(method.getParameterTypes()));
				}
			}
		}
	}

	private static Object[] generateParameterArray(Class<?>[] parameterTypes) {
		Object[] objects = new Object[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			objects[i] = generateParameterValue(parameterTypes[i]);
		}

		return objects;
	}

	private static Object generateParameterValue(Class<?> parameterType) {
		Object object = null;

		if (parameterType == int.class) {
			object = 100;
		}

		if (parameterType == boolean.class) {
			object = false;
		}

		if (parameterType == String.class) {
			object = "XXX";
		}

		return object;
	}

}
