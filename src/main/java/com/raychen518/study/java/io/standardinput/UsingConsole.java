package com.raychen518.study.java.io.standardinput;

import java.io.Console;

public class UsingConsole {

	public static void main(String[] args) {
		// Note: The following code cannot work due to unknown reason.

		Console console = System.console();

		String userName = console.readLine("User Name?");
		char[] password = console.readPassword("Password?");

		System.out.println("Account: " + userName + "/" + password.toString());
	}

}
