package com.raychen518.study.java.genericprogramming.onclasses;

/**
 * <pre>
 * This class shows how to add type parameters to classes.
 * 
 * - To add a type parameter for a class, add the "<>" text immediately after the class name,
 *   then put another text inside that "<>" text as the name of the type parameter.
 *   
 * - That type parameter text is capitalized and often short, such as the letter "T".
 * 
 * - When naming a type parameter,
 *   - the letter "E" is often used to indicate an element of a collection, such as java.util.ArrayList<E>;
 *   - the letter "K"/"V" is often used to indicate a key/value of a (table/map) item, such as java.util.HashMap<K, V>;
 *   - the letter "T" is often used to indicate any type (the letter "U"/"S" can also be used for this case), such as java.lang.Comparable<T>.
 * 
 * - The letter "?" (wildcard) indicates an any unknown type,
 *   and can replace a type parameter (for type decision) in the code sometimes,
 *   but it cannot be used as a type in the code.
 * 
 * - References
 *   The Java Tutorials > Learning the Java Language > Lesson: Generics
 *   https://docs.oracle.com/javase/tutorial/java/generics/index.html
 * </pre>
 */
public class Test1<T> {

	/**
	 * <pre>
	 * The field is the type parameter.
	 * </pre>
	 */
	private T someField;

	/**
	 * <pre>
	 * The method return is the type parameter.
	 * </pre>
	 */
	public T getSomeField() {
		return someField;
	}

	/**
	 * <pre>
	 * The method parameter is the type parameter.
	 * </pre>
	 */
	public void setSomeField(T someField) {
		this.someField = someField;
	}

	public static void main(String[] args) {
		{
			Test1<Integer> test = new Test1<>();
			test.setSomeField(123);
			System.out.println("test.getSomeField(): " + test.getSomeField());
		}

		{
			Test1<String> test = new Test1<>();
			test.setSomeField("abc");
			System.out.println("test.getSomeField(): " + test.getSomeField());
		}
	}

}
