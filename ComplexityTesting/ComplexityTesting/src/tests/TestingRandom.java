package tests;

import algorithms.*;
import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestingRandom {

	private int[] random50; // Fifty items.
	private int[] random500; // Five hundred items.
	private int[] random5000; // Five thousand items.
	private int[] random50000; // Fifty thousand items. Having arrays of
								// multiple sizes will allow us to see the
								// relationship between number of elements and
								// cost per element.

	@Before
	public void initialize() {

		random50 = new int[50];
		Utility.fillIntArrayFromFile(random50, "/premade/random50");
		random500 = new int[500];
		Utility.fillIntArrayFromFile(random500, "/premade/random500");
		random5000 = new int[5000];
		Utility.fillIntArrayFromFile(random5000, "/premade/random5000");
		random50000 = new int[50000];
		Utility.fillIntArrayFromFile(random50000, "/premade/random50000");

		// PrintWriter writer;
		// try {
		// writer = new PrintWriter("random50000", "UTF-8");
		//
		// String numbers = random50000[0] + "";
		// for (int i = 1; i < random50000.length; i++) numbers += (", " +
		// random50000[i]);
		//
		// writer.println(numbers);
		// writer.close();
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// System.out.print("{");
		// System.out.print(random50000[0]);
		// for (int i = 1; i < random50000.length; i++) System.out.print(", " +
		// random50000[i]);
		// System.out.println("}");
	}

	@Test
	public void testBubbleSort() {
		BubbleSort.bubble_srt(random50);
		assertTrue(isSorted(random50));
		BubbleSort.bubble_srt(random500);
		assertTrue(isSorted(random500));
		BubbleSort.bubble_srt(random5000);
		assertTrue(isSorted(random5000));
		BubbleSort.bubble_srt(random50000); // 50,000 squared is too high to
											// show as an integer, rolls over to
											// negative.
		assertTrue(isSorted(random50000)); // Could possibly use a long instead
											// of an int but we already know
											// enough about the cost for our
											// purposes.
	}

	@Test
	public void testSelectionSort() {
		SelectionSort.doSelectionSort(random50);
		assertTrue(isSorted(random50));
		SelectionSort.doSelectionSort(random500);
		assertTrue(isSorted(random500));
		SelectionSort.doSelectionSort(random5000);
		assertTrue(isSorted(random5000));
		SelectionSort.doSelectionSort(random50000);
		assertTrue(isSorted(random50000));
	}

	@Test
	public void testQuickSort() {
		QuickSort qs = new QuickSort();
		assertFalse(isSorted(random500));// check that list is not
											// sorted
		qs.sort(random50);
		assertTrue(isSorted(random50));
		qs.sort(random500);
		assertTrue(isSorted(random500));
		qs.sort(random5000);
		assertTrue(isSorted(random5000));
		qs.sort(random50000);
		assertTrue(isSorted(random50000));
	}

	@Test
	public void testInsertionSort() {
		InsertionSort.doInsertionSort(random50);
		assertTrue(isSorted(random50));
		InsertionSort.doInsertionSort(random500);
		assertTrue(isSorted(random500));
		InsertionSort.doInsertionSort(random5000);
		assertTrue(isSorted(random5000));
		InsertionSort.doInsertionSort(random50000); // Insertion sort does too
													// many changes to show with
													// an int.
		assertTrue(isSorted(random50000)); // Again, could probably use a long,
											// but probably ok without. Might be
											// worth having a size 50 array too.
	}

	@Test
	public void testMergeSort() {
		MergeSort ms = new MergeSort(); // Merge sort is supposedly O(n log n)
		ms.sort(random50);
		assertTrue(isSorted(random50));
		ms.sort(random500);
		assertTrue(isSorted(random500));

		ms.sort(random5000);
		assertTrue(isSorted(random5000));
		ms.sort(random50000);
		assertTrue(isSorted(random50000));
	}

	// @After
	// public void finish () {
	// for (int each : random500) System.out.print(each + " ");
	// System.out.println();
	// }

	private int[] makeRandomArray(int size) { // Make an array full of unique
												// random values.
		int[] newArray = new int[size];
		for (int i = 0; i < size; i++)
			newArray[i] = i;
		RandomizeArray(newArray);
		return newArray;
	}

	private static int[] RandomizeArray(int[] array) { // Taken from
														// http://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
		Random rgen = new Random(); // Random number generator

		for (int i = 0; i < array.length; i++) {
			int randomPosition = rgen.nextInt(array.length);
			int temp = array[i];
			array[i] = array[randomPosition];
			array[randomPosition] = temp;
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
