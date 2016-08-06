package com.raychen518.study.java.genericprogramming.wildcard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * This class shows how to use the wildcard with the "super" keyword.
 * </pre>
 *
 */
public class TestUsingSuper {

	public static void processThrowables(List<? super IOException> throwables) {
		// Processing the throwables...
		System.out.println(throwables);
	}

	public static void main(String[] args) {
		// =====================================================================
		// OK
		// The type List<IOException> is applicable to be used as the type
		// List<? super IOException>.
		// =====================================================================
		{
			List<IOException> input = new ArrayList<>();
			input.add(new IOException("IOException #1"));
			input.add(new IOException("IOException #2"));
			input.add(new IOException("IOException #3"));
			TestUsingSuper.processThrowables(input);
		}

		// =====================================================================
		// NG
		// The Method Not Applicable for the Arguments compilation error occurs
		// because the type List<Integer> is not applicable to be used as the
		// type List<? super IOException>.
		// =====================================================================
		{
			List<Integer> input = new ArrayList<>();
			input.add(123);
			input.add(456);
			input.add(789);
			// TestUsingSuper.processThrowables(input);
		}

		// =====================================================================
		// OK
		// The type List<Exception> is applicable to be used as the type
		// List<? super IOException>.
		// =====================================================================
		{
			List<Exception> input = new ArrayList<>();
			input.add(new Exception("Exception #1"));
			input.add(new Exception("Exception #2"));
			input.add(new Exception("Exception #3"));
			TestUsingSuper.processThrowables(input);
		}

		// =====================================================================
		// OK
		// The type List<Throwable> is applicable to be used as the type
		// List<? super IOException>.
		// =====================================================================
		{
			List<Throwable> input = new ArrayList<>();
			input.add(new Throwable("Throwable #1"));
			input.add(new Throwable("Throwable #2"));
			input.add(new Throwable("Throwable #3"));
			TestUsingSuper.processThrowables(input);
		}

		// =====================================================================
		// NG
		// The Method Not Applicable for the Arguments compilation error occurs
		// because the type List<Error> is not applicable to be used as the
		// type List<? super IOException>.
		// =====================================================================
		{
			List<Error> input = new ArrayList<>();
			input.add(new Error("Throwable #1"));
			input.add(new Error("Throwable #2"));
			input.add(new Error("Throwable #3"));
			// TestUsingSuper.processThrowables(input);
		}

		// =====================================================================
		// OK
		// The Method Not Applicable for the Arguments compilation error occurs
		// because the type List<FileNotFoundException> is not applicable to be
		// used as the type List<? super IOException>.
		// =====================================================================
		{
			List<FileNotFoundException> input = new ArrayList<>();
			input.add(new FileNotFoundException("FileNotFoundException #1"));
			input.add(new FileNotFoundException("FileNotFoundException #2"));
			input.add(new FileNotFoundException("FileNotFoundException #3"));
			// TestUsingSuper.processThrowables(input);
		}

		// =====================================================================
		// OK
		// The type List<Exception> is applicable to be used as the type
		// List<? super IOException>.
		// But, the list items are all of the type FileNotFoundException,
		// which is not the super class of the IOException class,
		// the result (the compilation and running are OK) may be not expected
		// (the compilation is NG).
		// =====================================================================
		{
			List<Exception> input = new ArrayList<>();
			input.add(new FileNotFoundException("FileNotFoundException #1"));
			input.add(new FileNotFoundException("FileNotFoundException #2"));
			input.add(new FileNotFoundException("FileNotFoundException #3"));
			TestUsingSuper.processThrowables(input);
		}
	}

}
