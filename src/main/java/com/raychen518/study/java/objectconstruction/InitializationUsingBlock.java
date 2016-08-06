package com.raychen518.study.java.objectconstruction;

public class InitializationUsingBlock {
	static class Test {
		private static int someCount = 0;

		private int someInt = 0;
		private boolean someBoolean = false;
		private Object someObject = null;

		static {
			System.out.println("Initialize Using Static Block...");
			System.out.println();

			someCount = 1000;
		}

		{
			System.out.println("Initialize Using Block...");
			System.out.println();

			someInt = 123;
			someBoolean = true;
			someObject = new Object();
		}

		public Test() {
			System.out.println("Initialize Using Constructor...");
			System.out.println();
		}

		public Test(boolean someBoolean) {
			System.out.println("Initialize Using Constructor...");
			System.out.println();

			this.someBoolean = someBoolean;
		}

		public int getSomeCount() {
			return someCount;
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
		System.out
				.println("Besides in definitions and constructors, fields can also be initialized in (static) blocks.");
		System.out.println();

		Test test1 = new Test();
		System.out.println("Test test1 = new Test();");

		System.out.println("test1.getSomeInt()\t: " + test1.getSomeInt());
		System.out.println("test1.isSomeBoolean()\t: " + test1.isSomeBoolean());
		System.out.println("test1.getSomeObject()\t: " + test1.getSomeObject());
		System.out.println("test1.getSomeCount()\t: " + test1.getSomeCount());
		System.out.println();

		Test test2 = new Test(false);
		System.out.println("Test test2 = new Test(false);");

		System.out.println("test2.getSomeInt()\t: " + test2.getSomeInt());
		System.out.println("test2.isSomeBoolean()\t: " + test2.isSomeBoolean());
		System.out.println("test2.getSomeObject()\t: " + test2.getSomeObject());
		System.out.println("test2.getSomeCount()\t: " + test2.getSomeCount());
		System.out.println();
	}

}
