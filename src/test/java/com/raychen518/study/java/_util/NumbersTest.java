package com.raychen518.study.java._util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.raychen518.study.java._util.Numbers;

public class NumbersTest {

	@Test
	public void testFindMinValue() {
		List<double[]> valuesList = new ArrayList<>();
		List<Double> expectedMinValueList = new ArrayList<>();

		int testDataItemCount = generateTestDataForFindMinValue(valuesList, expectedMinValueList);

		for (int i = 0; i < testDataItemCount; i++) {
			Assert.assertEquals(expectedMinValueList.get(i), Numbers.findMinValue(valuesList.get(i)), 0);
		}
	}

	private static int generateTestDataForFindMinValue(List<double[]> valuesList, List<Double> expectedMinValueList) {
		int testDataItemCount = 0;

		testDataItemCount++;
		valuesList.add(new double[] { 1.2 });
		expectedMinValueList.add(1.2);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3 });
		expectedMinValueList.add(1.2);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, 3.4 });
		expectedMinValueList.add(1.2);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, 1.2 });
		expectedMinValueList.add(1.2);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, 0.2 });
		expectedMinValueList.add(0.2);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, -3.4 });
		expectedMinValueList.add(-3.4);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, 0 });
		expectedMinValueList.add(0D);

		return testDataItemCount;
	}

	@Test
	public void testFindMaxValue() {
		List<double[]> valuesList = new ArrayList<>();
		List<Double> expectedMaxValueList = new ArrayList<>();

		int testDataItemCount = generateTestDataForFindMaxValue(valuesList, expectedMaxValueList);

		for (int i = 0; i < testDataItemCount; i++) {
			Assert.assertEquals(expectedMaxValueList.get(i), Numbers.findMaxValue(valuesList.get(i)), 0);
		}
	}

	private static int generateTestDataForFindMaxValue(List<double[]> valuesList, List<Double> expectedMaxValueList) {
		int testDataItemCount = 0;

		testDataItemCount++;
		valuesList.add(new double[] { 1.2 });
		expectedMaxValueList.add(1.2);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3 });
		expectedMaxValueList.add(2.3);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, 3.4 });
		expectedMaxValueList.add(3.4);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, 1.2 });
		expectedMaxValueList.add(2.3);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, 0.2 });
		expectedMaxValueList.add(2.3);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, -3.4 });
		expectedMaxValueList.add(2.3);

		testDataItemCount++;
		valuesList.add(new double[] { 1.2, 2.3, 0 });
		expectedMaxValueList.add(2.3);

		return testDataItemCount;
	}

}
