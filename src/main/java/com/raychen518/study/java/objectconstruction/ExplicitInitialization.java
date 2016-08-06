package com.raychen518.study.java.objectconstruction;

public class ExplicitInitialization {
	static class Test {
		// Fields can be initialized using values besides constants and
		// literals.

		private int someInt = (int) (Math.random() * 10);
		private boolean someBoolean = true;
		private Object someObject;

		public Test() {
		}

		public Test(Object someObject) {
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
		Test test1 = new Test();
		System.out.println("Test test1 = new Test();");

		System.out.println("test1.getSomeInt()\t: " + test1.getSomeInt());
		System.out.println("test1.isSomeBoolean()\t: " + test1.isSomeBoolean());
		System.out.println("test1.getSomeObject()\t: " + test1.getSomeObject());
		System.out.println();

		Test test2 = new Test(new Object());
		System.out.println("Test test2 = new Test(new Object());");

		System.out.println("test2.getSomeInt()\t: " + test2.getSomeInt());
		System.out.println("test2.isSomeBoolean()\t: " + test2.isSomeBoolean());
		System.out.println("test2.getSomeObject()\t: " + test2.getSomeObject());
		System.out.println();
	}

}
