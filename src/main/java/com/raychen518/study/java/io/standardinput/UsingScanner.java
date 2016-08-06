package com.raychen518.study.java.io.standardinput;

import java.util.Scanner;

public class UsingScanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("User Name?");
		String userName = scanner.nextLine();

		System.out.println("Password?");
		int password = scanner.nextInt();

		scanner.close();

		System.out.println("Account: " + userName + "/" + password);
	}

}
