package com.raychen518.study.java._util;

public class Utils {

	private static final String DELIMITER_LINE_1 = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
	private static final String DELIMITER_LINE_2 = "------------------------------------------------------------";

	private static final String NUMBER_STRING_PADDING_PATTERN = "%0Xd";
	private static final String NUMBER_STRING_PADDING_PATTERN_PLACEHOLDER = "X";
	private static final int NUMBER_STRING_PADDING_DEFAULT_LENGTH = 3;
	private static final String NUMBER_STRING_PADDING_MESSAGE_NUMBER_INVALID = "The number to pad should not be negative.";
	private static final String NUMBER_STRING_PADDING_MESSAGE_LENGTH_INVALID = "The length to pad should not be negative or zero.";

	public static void printDelimiterLine1() {
		System.out.println();
		System.out.println(DELIMITER_LINE_1);
		System.out.println();
	}

	public static void printDelimiterLine2() {
		System.out.println();
		System.out.println(DELIMITER_LINE_2);
		System.out.println();
	}

	/**
	 * Convert the specified number to a string, and if the string's length is
	 * less than the default length (3), pad the string to the default length,
	 * from the left and using the character "0".
	 * 
	 * @param number
	 *            The number to convert to a string which will then be padded.
	 * @throws IllegalArgumentException
	 *             if {@code number < 0}
	 * @return The padded number string.
	 */
	public static String padNumberString(int number) {
		return padNumberString(number, NUMBER_STRING_PADDING_DEFAULT_LENGTH);
	}

	/**
	 * Convert the specified number to a string, and if the string's length is
	 * less than the specified length, pad the string to the specified length,
	 * from the left and using the character "0".
	 * 
	 * @param number
	 *            The number to convert to a string which will then be padded.
	 * @param length
	 *            The length which the number string will be padded to.
	 * @throws IllegalArgumentException
	 *             if {@code number < 0} or {@code length <= 0}
	 * @return The padded number string.
	 */
	public static String padNumberString(int number, int length) {
		if (number < 0) {
			throw new IllegalArgumentException(NUMBER_STRING_PADDING_MESSAGE_NUMBER_INVALID);
		}

		if (length <= 0) {
			throw new IllegalArgumentException(NUMBER_STRING_PADDING_MESSAGE_LENGTH_INVALID);
		}

		return String.format(NUMBER_STRING_PADDING_PATTERN.replace(NUMBER_STRING_PADDING_PATTERN_PLACEHOLDER,
				String.valueOf(length)), number);
	}

}
