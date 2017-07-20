package tests;

import algorithms.*;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestingFewUnique {

	private int[] fewUnique50; // Fifty items.
	private int[] fewUnique500; // Five hundred items.
	private int[] fewUnique5000; // Five thousand items.
	private int[] fewUnique50000; // Fifty thousand items. Having arrays of
									// multiple sizes will allow us to see the
									// relationship between number of elements
									// and cost per element.

	@Before
	public void initialize() {
		
		fewUnique50 = new int[50];
		Utility.fillIntArrayFromFile(fewUnique50, "/premade/fewUnique500");
		fewUnique500 = new int[500];
		Utility.fillIntArrayFromFile(fewUnique500, "/premade/fewUnique500");
		fewUnique5000 = new int[5000];
		Utility.fillIntArrayFromFile(fewUnique5000, "/premade/fewUnique5000");
		fewUnique50000 = new int[50000];
		Utility.fillIntArrayFromFile(fewUnique50000, "/premade/fewUnique50000");
		
//		System.out.print("{");
//		System.out.print(fewUnique50000[0]);
//		for (int i = 1; i < fewUnique50000.length; i++) System.out.print(", " + fewUnique50000[i]);
//		System.out.println("}");
	}

	@Test
	public void testBubbleSort() {
		BubbleSort.bubble_srt(fewUnique50);
		assertTrue(isSorted(fewUnique50));
		BubbleSort.bubble_srt(fewUnique500);
		assertTrue(isSorted(fewUnique500));
		BubbleSort.bubble_srt(fewUnique5000);
		assertTrue(isSorted(fewUnique5000));
		BubbleSort.bubble_srt(fewUnique50000);
		assertTrue(isSorted(fewUnique50000));
	}


	@Test
	public void testSelectionSort() {
		SelectionSort.doSelectionSort(fewUnique50);
		assertTrue(isSorted(fewUnique50));
		SelectionSort.doSelectionSort(fewUnique500);
		assertTrue(isSorted(fewUnique500));
		SelectionSort.doSelectionSort(fewUnique5000);
		assertTrue(isSorted(fewUnique5000));
		SelectionSort.doSelectionSort(fewUnique50000);
		assertTrue(isSorted(fewUnique50000));
	}

	@Test
	public void testQuickSort() {
		QuickSort qs = new QuickSort();
		assertFalse(isSorted(fewUnique500));// check that list is not
											// sorted
		qs.sort(fewUnique50);
		assertTrue(isSorted(fewUnique50));
		qs.sort(fewUnique500);
		assertTrue(isSorted(fewUnique500));
		qs.sort(fewUnique5000);
		assertTrue(isSorted(fewUnique5000));
		qs.sort(fewUnique50000);
		assertTrue(isSorted(fewUnique50000));
	}

	@Test
	public void testInsertionSort() {
		InsertionSort.doInsertionSort(fewUnique50);
		assertTrue(isSorted(fewUnique50));
		InsertionSort.doInsertionSort(fewUnique500);
		assertTrue(isSorted(fewUnique500));
		InsertionSort.doInsertionSort(fewUnique5000);
		assertTrue(isSorted(fewUnique5000));
		InsertionSort.doInsertionSort(fewUnique50000);
		assertTrue(isSorted(fewUnique50000));
	}

	@Test
	public void testMergeSort() {
		MergeSort ms = new MergeSort(); // Merge sort is supposedly O(n log n)
		ms.sort(fewUnique50);
		assertTrue(isSorted(fewUnique50));
		ms.sort(fewUnique500);
		assertTrue(isSorted(fewUnique500));

		ms.sort(fewUnique5000);
		assertTrue(isSorted(fewUnique5000));
		ms.sort(fewUnique50000);
		assertTrue(isSorted(fewUnique50000));
	}

	// @After
	// public void finish () {
	// for (int each : fewUnique500) System.out.print(each + " ");
	// System.out.println();
	// }

	private int[] makeFewUniqueArray(int size) { // Make an array full of unique
													// fewUnique values.
		int[] newArray = new int[size];
		for (int i = 0; i < size; i++)
			newArray[i] = i / (size / 10); // Makes each index contain an int
											// from 0 to 9.
		RandomizeArray(newArray);
		return newArray;
	}

	private static int[] RandomizeArray(int[] array) { // Taken from
														// http://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-fewUnique-order/
		Random rgen = new Random(); // FewUnique number generator

		for (int i = 0; i < array.length; i++) {
			int fewUniquePosition = rgen.nextInt(array.length);
			int temp = array[i];
			array[i] = array[fewUniquePosition];
			array[fewUniquePosition] = temp;
		}

		return array;
	}

	private boolean isSorted(int array[]) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1])
				return false;
		}
		return true;
	}
}
