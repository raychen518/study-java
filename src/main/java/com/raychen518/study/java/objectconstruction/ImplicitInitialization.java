package com.raychen518.study.java.objectconstruction;

public class ImplicitInitialization {
	static class Test {
		// Unlike method variables, fields can be defined without
		// initialization.

		private int someInt;
		private boolean someBoolean;
		private Object someObject;

		public Test() {
		}

		public Test(int someInt, boolean someBoolean, Object someObject) {
			this.someInt = someInt;
			this.someBoolean = someBoolean;
			this.someObject = someObject;
		}

		public int getSomeInt() {
			return someInt;
		}

		public void setSomeInt(int someInt) {
			this.someInt = someInt;
		}

		public boolean isSomeBoolean() {
			return someBoolean;
		}

		public void setSomeBoolean(boolean someBoolean) {
			this.someBoolean = someBoolean;
		}

		public Object getSomeObject() {
			return someObject;
		}

		public void setSomeObject(Object someObject) {
			this.someObject = someObject;
		}
	}

	public static void main(String[] args) {
		System.out.println(
				"All fields without initialization will be automatically set using default values: 0, false or null.");
		System.out.println();

		Test test1 = new Test(123, true, new Object());
		System.out.println("Test test1 = new Test(123, true, new Object());");

		System.out.println("test1.getSomeInt()\t: " + test1.getSomeInt());
		System.out.println("test1.isSomeBoolean()\t: " + test1.isSomeBoolean());
		System.out.println("test1.getSomeObject()\t: " + test1.getSomeObject());
		System.out.println();

		Test test2 = new Test();
		System.out.println("Test test2 = new Test();");

		System.out.println("test2.getSomeInt()\t: " + test2.getSomeInt());
		System.out.println("test2.isSomeBoolean()\t: " + test2.isSomeBoolean());
		System.out.println("test2.getSomeObject()\t: " + test2.getSomeObject());
		System.out.println();
	}

}
