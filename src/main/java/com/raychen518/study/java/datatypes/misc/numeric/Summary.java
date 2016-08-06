package com.raychen518.study.java.datatypes.misc.numeric;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Summary {

	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println("BigInteger & BigDecimal");
		System.out.println("========================================");
		System.out.println("BigInteger and BigDecimal can process numeric values in any length.");
		System.out.println();

		System.out.println("e.g.");
		System.out.println("Long.MAX_VALUE\t\t\t\t\t\t\t: " + Long.MAX_VALUE);
		System.out.println("Long.MAX_VALUE + 1\t\t\t\t\t\t: " + (Long.MAX_VALUE + 1)
				+ "\t\t// Wrong. Should be 9223372036854775808.");
		System.out.println("BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE)\t\t: "
				+ BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE) + "\t\t// Correct.");
		System.out.println();

		System.out.println("e.g.");
		System.out.println("Double.MAX_VALUE\t\t\t\t\t\t: " + Double.MAX_VALUE);
		System.out.println("Double.MAX_VALUE * 10\t\t\t\t\t\t: " + (Double.MAX_VALUE * 10)
				+ "\t\t\t// Wrong. Should be 1.79769313486231570E+309.");
		System.out.println("BigDecimal.valueOf(Double.MAX_VALUE).multiply(BigDecimal.TEN)\t: "
				+ BigDecimal.valueOf(Double.MAX_VALUE).multiply(BigDecimal.TEN) + "\t// Correct.");
		System.out.println();
	}

}