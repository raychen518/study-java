package com.raychen518.study.java.io.file;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Test {

	private static String FILE_NAME = "Test.txt";

	public static void main(String[] args) throws IOException {
		System.out.println("========================================");
		System.out.println("Create a File");
		System.out.println("========================================");
		System.out.println("...");
		System.out.println();

		// If the file exists then it will be truncated to zero size;
		// otherwise, a new file will be created.
		PrintWriter printWriter = new PrintWriter(FILE_NAME);

		// Write content to the file.
		printWriter.println("Item11 Item12 Item13");
		printWriter.println("Item21 Item22 Item23");
		printWriter.println("Item31 Item32 Item33");

		// Save written content.
		printWriter.close();

		System.out.println("========================================");
		System.out.println("Read a File");
		System.out.println("========================================");

		System.out.println("User Directory\t: " + System.getProperty("user.dir"));
		Path testFile = Paths.get(FILE_NAME);
		System.out.println("File Name\t: " + testFile.toString());
		System.out.println("File Path\t: " + testFile.toAbsolutePath().toString());

		Scanner scanner = new Scanner(testFile);
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();

		System.out.println();

		System.out.println("========================================");
		System.out.println("Delete a File");
		System.out.println("========================================");
		testFile.toFile().delete();
	}

}
