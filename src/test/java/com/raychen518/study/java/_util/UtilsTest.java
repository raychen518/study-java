package com.raychen518.study.java._util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UtilsTest {

	private static final String NUMBER_STRING_PADDING_MESSAGE_NUMBER_INVALID = "The number to pad should not be negative.";
	private static final String NUMBER_STRING_PADDING_MESSAGE_LENGTH_INVALID = "The length to pad should not be negative or zero.";

	@Test
	public void testPadNumberString1() {
		assertEquals("000", Utils.padNumberString(0));
		assertEquals("001", Utils.padNumberString(1));
		assertEquals("002", Utils.padNumberString(2));
		assertEquals("009", Utils.padNumberString(9));
		assertEquals("010", Utils.padNumberString(10));
		assertEquals("011", Utils.padNumberString(11));
		assertEquals("019", Utils.padNumberString(19));
		assertEquals("020", Utils.padNumberString(20));
		assertEquals("021", Utils.padNumberString(21));
		assertEquals("099", Utils.padNumberString(99));
		assertEquals("100", Utils.padNumberString(100));
		assertEquals("101", Utils.padNumberString(101));
		assertEquals("999", Utils.padNumberString(999));
		assertEquals("1000", Utils.padNumberString(1000));
		assertEquals("1001", Utils.padNumberString(1001));

		{
			Exception exception = null;

			try {
				Utils.padNumberString(-1);
			} catch (Exception e) {
				exception = e;
			}

			assertTrue(exception instanceof IllegalArgumentException);
			assertEquals(NUMBER_STRING_PADDING_MESSAGE_NUMBER_INVALID, exception.getMessage());
		}
	}

	@Test
	public void testPadNumberString2() {
		assertEquals("000", Utils.padNumberString(0, 3));
		assertEquals("001", Utils.padNumberString(1, 3));
		assertEquals("002", Utils.padNumberString(2, 3));
		assertEquals("009", Utils.padNumberString(9, 3));
		assertEquals("010", Utils.padNumberString(10, 3));
		assertEquals("011", Utils.padNumberString(11, 3));
		assertEquals("019", Utils.padNumberString(19, 3));
		assertEquals("020", Utils.padNumberString(20, 3));
		assertEquals("021", Utils.padNumberString(21, 3));
		assertEquals("099", Utils.padNumberString(99, 3));
		assertEquals("100", Utils.padNumberString(100, 3));
		assertEquals("101", Utils.padNumberString(101, 3));
		assertEquals("999", Utils.padNumberString(999, 3));
		assertEquals("1000", Utils.padNumberString(1000, 3));
		assertEquals("1001", Utils.padNumberString(1001, 3));

		assertEquals("1", Utils.padNumberString(1, 1));
		assertEquals("01", Utils.padNumberString(1, 2));
		assertEquals("000000001", Utils.padNumberString(1, 9));
		assertEquals("0000000001", Utils.padNumberString(1, 10));

		{
			Exception exception = null;

			try {
				Utils.padNumberString(-1, 3);
			} catch (Exception e) {
				exception = e;
			}

			assertTrue(exception instanceof IllegalArgumentException);
			assertEquals(NUMBER_STRING_PADDING_MESSAGE_NUMBER_INVALID, exception.getMessage());
		}

		{
			Exception exception = null;

			try {
				Utils.padNumberString(1, -1);
			} catch (Exception e) {
				exception = e;
			}

			assertTrue(exception instanceof IllegalArgumentException);
			assertEquals(NUMBER_STRING_PADDING_MESSAGE_LENGTH_INVALID, exception.getMessage());
		}

		{
			Exception exception = null;

			try {
				Utils.padNumberString(1, 0);
			} catch (Exception e) {
				exception = e;
			}

			assertTrue(exception instanceof IllegalArgumentException);
			assertEquals(NUMBER_STRING_PADDING_MESSAGE_LENGTH_INVALID, exception.getMessage());
		}
	}

}
