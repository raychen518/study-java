package com.raychen518.study.java.objectconstruction;

public class CallingAnotherConstructor {
	static class Test {
		private int someInt = 0;
		private String someString = "";

		public Test(int someInt, String someString) {
			// The "this" term can be used to call another constructor.
			this(someInt, someString, false);
		}

		public Test(int someInt, String someString, boolean makingStringUpperCase) {
			this.someInt = someInt;
			this.someString = makingStringUpperCase ? someString.toUpperCase() : someString.toLowerCase();
		}

		public int getSomeInt() {
			return someInt;
		}

		public void setSomeInt(int someInt) {
			this.someInt = someInt;
		}

		public String getSomeString() {
			return someString;
		}

		public void setSomeString(String someString) {
			this.someString = someString;
		}

	}

	public static void main(String[] args) {
		Test test1 = new Test(123, "I love you!");
		System.out.println("Test test1 = new Test(123, \"I love you!\");");

		System.out.println("test1.getSomeInt()\t: " + test1.getSomeInt());
		System.out.println("test1.getSomeString()\t: " + test1.getSomeString());
		System.out.println();

		Test test2 = new Test(123, "I love you!", true);
		System.out.println("Test test2 = new Test(123, \"I love you!\", true);");

		System.out.println("test2.getSomeInt()\t: " + test2.getSomeInt());
		System.out.println("test2.getSomeString()\t: " + test2.getSomeString());
		System.out.println();
	}

}
