package com.raychen518.study.java.reflection.examples;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <pre>
 * To improve
 * - Fields from superclass are not included.
 * - Refine the method "toString".
 * - Consider more about the method "haveMethodToString".
 *   Instead of calling the "toString" methods of target objects,
 *   it may better to just do special process from the String object.
 * </pre>
 */
public final class ObjectAnalyzer {
	private static final String EQUAL_SIGN = "=";
	private static final String SQUARE_BRACKET_LEFT = "[";
	private static final String SQUARE_BRACKET_RIGHT = "]";
	private static final String CURLY_BRACKET_LEFT = "{";
	private static final String CURLY_BRACKET_RIGHT = "}";
	private static final String NULL = "null";
	private static final String FIELD_DELIMETER = ", ";
	private static final String METHOD_NAME_TO_STRING = "toString";

	public static String toString(Object object) throws IllegalArgumentException, IllegalAccessException {
		if (object == null) {
			return NULL;
		}

		String content = "";

		if (object.getClass().isArray()) {
			content += object.getClass().getComponentType().getName() + SQUARE_BRACKET_LEFT + SQUARE_BRACKET_RIGHT
					+ CURLY_BRACKET_LEFT;

			for (int i = 0; i < Array.getLength(object); i++) {
				if (i > 0) {
					content += FIELD_DELIMETER;
				}

				Object fieldValue = Array.get(object, i);

				if (object.getClass().getComponentType().isPrimitive()) {
					content += fieldValue;
				} else {
					content += toString(fieldValue);
				}
			}

			content += CURLY_BRACKET_RIGHT;

			return content;
		}

		content += object.getClass().getSimpleName() + SQUARE_BRACKET_LEFT;

		Field[] fields = object.getClass().getDeclaredFields();
		AccessibleObject.setAccessible(fields, true);

		for (int i = 0; i < fields.length; i++) {
			if (i > 0) {
				content += FIELD_DELIMETER;
			}

			Field field = fields[i];

			content += field.getName() + EQUAL_SIGN;

			Object fieldValue = field.get(object);

			if (field.getType().isPrimitive()) {
				content += fieldValue;
			} else {
				if (haveMethodToString(field.getType())) {
					content += (fieldValue == null) ? NULL : fieldValue.toString();
				} else {
					content += toString(fieldValue);
				}
			}
		}

		content += SQUARE_BRACKET_RIGHT;

		return content;
	}

	private static boolean haveMethodToString(Class<?> clazz) {
		boolean result = false;

		if (!clazz.isPrimitive()) {
			for (Method method : clazz.getDeclaredMethods()) {
				if (method.getName().equalsIgnoreCase(METHOD_NAME_TO_STRING)) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		System.out.println(ObjectAnalyzer.toString(new TestA()));
		System.out.println(ObjectAnalyzer.toString(new TestA(123, true, "abc")));
		System.out.println();

		System.out.println(ObjectAnalyzer.toString(new TestB()));
		System.out
				.println(ObjectAnalyzer.toString(new TestB(new TestA(111, true, "def"), new int[] { 444, 555, 666 })));
		System.out.println();
	}

	@SuppressWarnings("unused")
	private static class TestA {
		private int field1;
		private boolean field2;
		private String field3;

		public TestA() {
		}

		public TestA(int field1, boolean field2, String field3) {
			this.field1 = field1;
			this.field2 = field2;
			this.field3 = field3;
		}

		public int getField1() {
			return field1;
		}

		public boolean isField2() {
			return field2;
		}

		public String getField3() {
			return field3;
		}

	}

	@SuppressWarnings("unused")
	private static class TestB {
		private TestA field1 = new TestA();
		private int[] field2 = { 111, 222, 333 };

		public TestB() {
		}

		public TestB(TestA field1, int[] field2) {
			this.field1 = field1;
			this.field2 = field2;
		}
	}

}
