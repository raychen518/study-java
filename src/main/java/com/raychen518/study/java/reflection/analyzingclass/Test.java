package com.raychen518.study.java.reflection.analyzingclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Test {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, InstantiationException {
		System.out.println("================================");
		System.out.println("Analyzing Class");
		System.out.println("================================");
		System.out.println("Notes:");
		System.out.println("- Primitive classes have no fields, constructors and methods.");
		System.out.println();

		Class<SomeClass> theClass = SomeClass.class;

		System.out.println("====================================================");
		System.out.println("Class Information");
		System.out.println("====================================================");
		System.out.println("theClass.toString()\t\t\t\t: " + theClass.toString());
		System.out.println("theClass.getName()\t\t\t\t: " + theClass.getName());
		System.out.println("theClass.getCanonicalName()\t\t\t: " + theClass.getCanonicalName());
		System.out.println("theClass.getTypeName()\t\t\t\t: " + theClass.getTypeName());
		System.out.println("theClass.getPackage().getName()\t\t\t: " + theClass.getPackage().getName());
		System.out.println("theClass.getSimpleName()\t\t\t: " + theClass.getSimpleName());
		System.out
				.println("Modifier.toString(theClass.getModifiers())\t: " + Modifier.toString(theClass.getModifiers()));
		System.out.println("theClass.getSuperclass().getName()\t\t: " + theClass.getSuperclass().getName());
		System.out.println("theClass.isInterface()\t\t\t\t: " + theClass.isInterface());
		System.out.println("theClass.isEnum()\t\t\t\t: " + theClass.isEnum());
		System.out.println("theClass.isAnnotation()\t\t\t\t: " + theClass.isAnnotation());
		System.out.println("theClass.isArray()\t\t\t\t: " + theClass.isArray());
		System.out.println("theClass.isPrimitive()\t\t\t\t: " + theClass.isPrimitive());
		System.out.println();

		System.out.println("Notes:");
		System.out.println("- It seems there is no quick approach to return subclasses of a specified class.");
		System.out.println(
				"  An approach (but not quick) is to scan all classes and find those ones extending the specified class.");
		System.out.println();

		System.out.println("====================================================");
		System.out.println("Field Information");
		System.out.println("====================================================");
		System.out.println("theClass.getFields()");
		System.out.println("--------------------------------");
		Field[] thePublicFields = theClass.getFields();

		int thePublicFieldNo = 0;
		for (Field field : thePublicFields) {
			System.out.println("No.\t\t\t\t\t\t: " + (++thePublicFieldNo));
			System.out.println("field.toString()\t\t\t\t: " + field.toString());
			System.out.println("field.getName()\t\t\t\t\t: " + field.getName());
			System.out.println("field.getType().getName()\t\t\t: " + field.getType().getName());
			System.out
					.println("Modifier.toString(field.getModifiers())\t\t: " + Modifier.toString(field.getModifiers()));
			System.out.println("field.isAccessible()\t\t\t\t: " + field.isAccessible());
			System.out.println("field.get(null)\t\t\t\t\t: " + field.get(null));
			System.out.println();
		}

		System.out.println("theClass.getDeclaredFields()");
		System.out.println("--------------------------------");
		Field[] theDeclaredFields = theClass.getDeclaredFields();

		int theDeclaredFieldNo = 0;
		for (Field field : theDeclaredFields) {
			System.out.println("No.\t\t\t\t\t\t: " + (++theDeclaredFieldNo));
			System.out.println("field.toString()\t\t\t\t: " + field.toString());
			System.out.println("field.getName()\t\t\t\t\t: " + field.getName());
			System.out.println("field.getType().getName()\t\t\t: " + field.getType().getName());
			System.out
					.println("Modifier.toString(field.getModifiers())\t\t: " + Modifier.toString(field.getModifiers()));
			System.out.println("field.isAccessible()\t\t\t\t: " + field.isAccessible());
			field.setAccessible(true);
			System.out.println("field.get(null)\t\t\t\t\t: " + field.get(theClass.newInstance()));
			System.out.println();
		}

		System.out.println("====================================================");
		System.out.println("Constructor Information");
		System.out.println("====================================================");
		System.out.println("theClass.getConstructors()");
		System.out.println("--------------------------------");
		Constructor<?>[] thePublicConstructors = theClass.getConstructors();

		int thePublicConstructorNo = 0;
		for (Constructor<?> constructor : thePublicConstructors) {
			System.out.println("No.\t\t\t\t\t\t: " + (++thePublicConstructorNo));
			System.out.println("constructor.toString()\t\t\t\t: " + constructor.toString());
			System.out.println("constructor.getName()\t\t\t\t: " + constructor.getName());
			System.out.println("constructor.getParameterCount()\t\t\t: " + constructor.getParameterCount());
			System.out.println("Arrays.toString(constructor.getParameterTypes()): "
					+ Arrays.toString(constructor.getParameterTypes()));
			System.out.println("Modifier.toString(constructor.getModifiers())\t: "
					+ Modifier.toString(constructor.getModifiers()));
			System.out.println("Arrays.toString(constructor.getExceptionTypes()): "
					+ Arrays.toString(constructor.getExceptionTypes()));
			System.out.println("constructor.isAccessible()\t\t\t: " + constructor.isAccessible());
			System.out.println();
		}

		System.out.println("theClass.getDeclaredConstructors()");
		System.out.println("--------------------------------");
		Constructor<?>[] theDeclaredConstructors = theClass.getDeclaredConstructors();

		int theDeclaredConstructorNo = 0;
		for (Constructor<?> constructor : theDeclaredConstructors) {
			System.out.println("No.\t\t\t\t\t\t: " + (++theDeclaredConstructorNo));
			System.out.println("constructor.toString()\t\t\t\t: " + constructor.toString());
			System.out.println("constructor.getName()\t\t\t\t: " + constructor.getName());
			System.out.println("constructor.getParameterCount()\t\t\t: " + constructor.getParameterCount());
			System.out.println("Arrays.toString(constructor.getParameterTypes()): "
					+ Arrays.toString(constructor.getParameterTypes()));
			System.out.println("Modifier.toString(constructor.getModifiers())\t: "
					+ Modifier.toString(constructor.getModifiers()));
			System.out.println("Arrays.toString(constructor.getExceptionTypes()): "
					+ Arrays.toString(constructor.getExceptionTypes()));
			System.out.println("constructor.isAccessible()\t\t\t: " + constructor.isAccessible());
			System.out.println();
		}

		System.out.println("====================================================");
		System.out.println("Method Information");
		System.out.println("====================================================");
		System.out.println("theClass.getMethods()");
		System.out.println("--------------------------------");
		Method[] thePublicMethods = theClass.getMethods();

		int thePublicMethodNo = 0;
		for (Method method : thePublicMethods) {
			System.out.println("No.\t\t\t\t\t\t: " + (++thePublicMethodNo));
			System.out.println("method.toString()\t\t\t\t: " + method.toString());
			System.out.println("method.getName()\t\t\t\t: " + method.getName());
			System.out.println("method.getParameterCount()\t\t\t: " + method.getParameterCount());
			System.out.println(
					"Arrays.toString(method.getParameterTypes())\t: " + Arrays.toString(method.getParameterTypes()));
			System.out.println("method.getReturnType().getName()\t\t: " + method.getReturnType().getName());
			System.out
					.println("Modifier.toString(method.getModifiers())\t: " + Modifier.toString(method.getModifiers()));
			System.out.println(
					"Arrays.toString(method.getExceptionTypes())\t: " + Arrays.toString(method.getExceptionTypes()));
			System.out.println("method.isAccessible()\t\t\t\t: " + method.isAccessible());
			System.out.println();
		}

		System.out.println("theClass.getDeclaredMethods()");
		System.out.println("--------------------------------");
		Method[] theDeclaredMethods = theClass.getDeclaredMethods();

		int theDeclaredMethodNo = 0;
		for (Method method : theDeclaredMethods) {
			System.out.println("No.\t\t\t\t\t\t: " + (++theDeclaredMethodNo));
			System.out.println("method.toString()\t\t\t\t: " + method.toString());
			System.out.println("method.getName()\t\t\t\t: " + method.getName());
			System.out.println("method.getParameterCount()\t\t\t: " + method.getParameterCount());
			System.out.println(
					"Arrays.toString(method.getParameterTypes())\t: " + Arrays.toString(method.getParameterTypes()));
			System.out.println("method.getReturnType().getName()\t\t: " + method.getReturnType().getName());
			System.out
					.println("Modifier.toString(method.getModifiers())\t: " + Modifier.toString(method.getModifiers()));
			System.out.println(
					"Arrays.toString(method.getExceptionTypes())\t: " + Arrays.toString(method.getExceptionTypes()));
			System.out.println("method.isAccessible()\t\t\t\t: " + method.isAccessible());
			System.out.println();
		}

		System.out.println("====================================================");
		System.out.println("Modifier Information");
		System.out.println("====================================================");
		int modifiers = theClass.getModifiers();
		// int modifiers = String.class.getModifiers();
		System.out.println("modifiers\t\t\t\t\t: " + modifiers);
		System.out.println("Modifier.toString(modifiers)\t\t\t: " + Modifier.toString(modifiers));
		System.out.println("Modifier.isAbstract(modifiers)\t\t\t: " + Modifier.isAbstract(modifiers));
		System.out.println("Modifier.isFinal(modifiers)\t\t\t: " + Modifier.isFinal(modifiers));
		System.out.println("Modifier.isInterface(modifiers)\t\t\t: " + Modifier.isInterface(modifiers));
		System.out.println("Modifier.isNative(modifiers)\t\t\t: " + Modifier.isNative(modifiers));
		System.out.println("Modifier.isPrivate(modifiers)\t\t\t: " + Modifier.isPrivate(modifiers));
		System.out.println("Modifier.isProtected(modifiers)\t\t\t: " + Modifier.isProtected(modifiers));
		System.out.println("Modifier.isPublic(modifiers)\t\t\t: " + Modifier.isPublic(modifiers));
		System.out.println("Modifier.isStatic(modifiers)\t\t\t: " + Modifier.isStatic(modifiers));
		System.out.println("Modifier.isStrict(modifiers)\t\t\t: " + Modifier.isStrict(modifiers));
		System.out.println("Modifier.isSynchronized(modifiers)\t\t: " + Modifier.isSynchronized(modifiers));
		System.out.println("Modifier.isTransient(modifiers)\t\t\t: " + Modifier.isTransient(modifiers));
		System.out.println("Modifier.isVolatile(modifiers)\t\t\t: " + Modifier.isVolatile(modifiers));
	}

}
