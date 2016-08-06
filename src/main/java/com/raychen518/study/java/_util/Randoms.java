package com.raychen518.study.java._util;

import java.util.Random;

public class Randoms {

	private static final String RANDOM_STRING_CHARACTER_SET = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String generateRandomString(int length) {
		String result = null;

		if (length > 0) {
			result = "";
			Random random = new Random();
			for (int i = 0; i < length; i++) {
				result += RANDOM_STRING_CHARACTER_SET.charAt(random.nextInt(RANDOM_STRING_CHARACTER_SET.length()));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(generateRandomString(-1));
		System.out.println(generateRandomString(0));
		System.out.println(generateRandomString(1));
		System.out.println(generateRandomString(2));
		System.out.println(generateRandomString(3));
		System.out.println(generateRandomString(4));
		System.out.println(generateRandomString(5));

	}

}
