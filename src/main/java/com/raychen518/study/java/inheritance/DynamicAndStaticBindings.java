package com.raychen518.study.java.inheritance;

public class DynamicAndStaticBindings {

	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println("Steps for a Method to Be Invoked");
		System.out.println("========================================");
		System.out.println("Assuming there is a method call as follows.");
		System.out.println("----------------------------------------");
		System.out.println("someObject.doSomething(someParameters)");
		System.out.println("----------------------------------------");
		System.out.println("someObject\t: The implicit parameter.");
		System.out.println("doSomething\t: The method name.");
		System.out.println("someParameters\t: The explicit parameters.");
		System.out.println("someClass\t: The class of someObject.");
		System.out.println();

		System.out.println(
				"1. The compiler searches the class \"someClass\" and all its superclasses for methods naming \"doSomething\".");
		System.out.println("   Note: Only public methods in the superclasses are searched.");
		System.out.println(
				"2. In above search results, the compiler tries to find one method which has same parameters as \"someParameters\".");
		System.out.println("   Notes:");
		System.out.println("       - This process is called Overloading Resolution.");
		System.out.println(
				"       - This process may become complicated because conversions of the parameters' data types are involved.");
		System.out.println("   Errors occur if no matching method is found or multiple matching methods are found.");
		System.out.println();

		System.out.println("This compiler behaviour described in the step 1 and 2 is called Dynamic Binding.");
		System.out.println();

		System.out.println("If the invoked method is a private method, static method or final method/constructor,");
		System.out.println("then the compiler can identify the method accurately.");
		System.out.println("This compiler behaviour is called Static Binding.");
		System.out.println();
	}

}
