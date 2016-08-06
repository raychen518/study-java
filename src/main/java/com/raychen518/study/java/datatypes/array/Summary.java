package com.raychen518.study.java.datatypes.array;

import java.util.Arrays;

public class Summary {

	public static void main(String[] args) {
		System.out.println("========================================");
		System.out.println("Common Ways to Define/Initialize/Print Arrays");
		System.out.println("========================================");

		{
			int[] items = new int[5];

			for (int i = 0; i < items.length; i++) {
				items[i] = (i + 1) * 100;
			}

			for (int i = 0; i < items.length; i++) {
				System.out.println((i + 1) + ": " + items[i]);
			}
			System.out.println();

			for (int item : items) {
				System.out.println(item);
			}
			System.out.println();

			System.out.println(Arrays.toString(items));
			System.out.println();
		}

		{
			int[] items = { 100, 200, 300, 400, 500 };

			for (int i = 0; i < items.length; i++) {
				System.out.println((i + 1) + ": " + items[i]);
			}
		}

		System.out.println();

		System.out.println("========================================");
		System.out.println("Copying Arrays");
		System.out.println("========================================");
		System.out.println("The method Arrays.copyOf() can be used to copy arrays.");
		System.out.println();

		{
			int[] itemsA = { 100, 200, 300, 400, 500 };
			System.out.println("Arrays.toString(itemsA): " + Arrays.toString(itemsA));
			System.out.println();

			int[] itemsB = itemsA;
			System.out.println("int[] itemsB = itemsA;");
			System.out.println("Arrays.toString(itemsB): " + Arrays.toString(itemsB));
			System.out.println(
					"itemsB == itemsA: " + (itemsB == itemsA) + "\t// It is only an address copy, not content copy.");
			System.out.println();

			int[] itemsC = Arrays.copyOf(itemsA, itemsA.length);
			System.out.println("int[] itemsC = Arrays.copyOf(itemsA, itemsA.length);");
			System.out.println("Arrays.toString(itemsC): " + Arrays.toString(itemsC));
			System.out.println("itemsC == itemsA: " + (itemsC == itemsA) + "\t// It is a content copy.");
		}

		System.out.println();

		System.out.println("========================================");
		System.out.println("Changing Lengths of Arrays");
		System.out.println("========================================");
		System.out.println("The method Arrays.copyOf() can be used to change lengths of arrays.");
		System.out.println();

		{
			int[] items = { 100, 200, 300, 400, 500 };

			System.out.println("Arrays.toString(items): " + Arrays.toString(items));
			System.out.println();

			items = Arrays.copyOf(items, items.length * 2);
			System.out.println("items = Arrays.copyOf(items, items.length * 2);");
			System.out.println("Arrays.toString(items): " + Arrays.toString(items));
			System.out.println();

			items = Arrays.copyOf(items, items.length - 7);
			System.out.println("items = Arrays.copyOf(items, items.length - 7);");
			System.out.println("Arrays.toString(items): " + Arrays.toString(items));
		}

		System.out.println();

		System.out.println("========================================");
		System.out.println("Sorting Arrays");
		System.out.println("========================================");
		System.out.println("The method Arrays.sort() can be used to sort arrays.");
		System.out.println();

		{
			int[] items = { 1, 5, 3, 4, 2 };

			System.out.println("Arrays.toString(items): " + Arrays.toString(items));
			System.out.println();

			Arrays.sort(items);
			System.out.println("Arrays.sort(items);");
			System.out.println("Arrays.toString(items): " + Arrays.toString(items));
		}

		System.out.println();

		System.out.println("========================================");
		System.out.println("Searching Arrays");
		System.out.println("========================================");
		System.out.println("The method Arrays.binarySearch() can be used to search arrays.");
		System.out.println();

		{
			int[] items = { 100, 200, 300, 400, 500 };

			System.out.println("Arrays.toString(items): " + Arrays.toString(items));
			System.out.println();

			System.out.println("Arrays.binarySearch(items, 300): " + Arrays.binarySearch(items, 300));
			System.out.println("Arrays.binarySearch(items, 600): " + Arrays.binarySearch(items, 600));
		}

		System.out.println();

		System.out.println("========================================");
		System.out.println("Filling Arrays");
		System.out.println("========================================");
		System.out.println("The method Arrays.fill() can be used to fill arrays.");
		System.out.println();

		{
			int[] items = { 100, 200, 300, 400, 500 };

			System.out.println("Arrays.toString(items): " + Arrays.toString(items));
			System.out.println();

			Arrays.fill(items, 300);
			System.out.println("Arrays.fill(items, 300);");
			System.out.println("Arrays.toString(items): " + Arrays.toString(items));
		}

		System.out.println();

		System.out.println("========================================");
		System.out.println("Comparing Arrays");
		System.out.println("========================================");
		System.out.println("The method Arrays.equals() can be used to compare arrays.");
		System.out.println();

		{
			int[] itemsA = { 100, 200, 300, 400, 500 };
			int[] itemsB = { 100, 200, 300, 400, 500 };
			int[] itemsC = { 100, 200, 300, 400, 501 };

			System.out.println("Arrays.toString(itemsA): " + Arrays.toString(itemsA));
			System.out.println("Arrays.toString(itemsB): " + Arrays.toString(itemsB));
			System.out.println("Arrays.toString(itemsC): " + Arrays.toString(itemsC));
			System.out.println();

			System.out.println("Arrays.equals(itemsB, itemsA): " + Arrays.equals(itemsB, itemsA));
			System.out.println("Arrays.equals(itemsC, itemsA): " + Arrays.equals(itemsC, itemsA));
		}

		System.out.println();

		System.out.println("========================================");
		System.out.println("Multi-dimensions Arrays");
		System.out.println("========================================");
		System.out.println("Note: The method Arrays.deepToString() can be used to print multi-dimensions arrays.");
		System.out.println();

		{
			int[][] itemsA = new int[3][4];

			for (int i = 0; i < itemsA.length; i++) {
				for (int j = 0; j < itemsA[i].length; j++) {
					itemsA[i][j] = (i + 1) * 10 + (j + 1);
				}
			}

			for (int i = 0; i < itemsA.length; i++) {
				System.out.println("Arrays.toString(itemsA[" + i + "]): " + Arrays.toString(itemsA[i]));
			}

			System.out.println();

			int[][] itemsB = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 } };

			for (int[] item : itemsB) {
				for (int itemElement : item) {
					System.out.print(itemElement + " ");
				}
				System.out.println();
			}

			System.out.println();

			System.out.println("Arrays.deepToString(itemsA): " + Arrays.deepToString(itemsA));
			System.out.println("Arrays.deepToString(itemsB): " + Arrays.deepToString(itemsB));
		}

		System.out.println();

		System.out.println("========================================");
		System.out.println("Irregular Multi-dimensions Arrays");
		System.out.println("========================================");

		{
			int[][] items = new int[7][];

			for (int i = 0; i < items.length; i++) {
				items[i] = new int[i + 1];
			}

			for (int i = 0; i < items.length; i++) {
				for (int j = 0; j < items[i].length; j++) {
					items[i][j] = (i + 1) * (j + 1);
				}
			}

			for (int i = 0; i < items.length; i++) {
				System.out.println("Arrays.toString(items[" + i + "]): " + Arrays.toString(items[i]));
			}
		}
	}

}
