package tests;

import algorithms.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestingSorted {

	private int[] sorted50; // Fifty items.
	private int[] sorted500; // Five hundred items.
	private int[] sorted5000; // Five thousand items.
	private int[] sorted50000; // Fifty thousand items. Having arrays of
								// multiple sizes will allow us to see the
								// relationship between number of elements and
								// cost per element.

	@Before
	public void initialize() {

		sorted50 = makeNearSortedArray(50);
		sorted500 = makeNearSortedArray(500);
		sorted5000 = makeNearSortedArray(5000);
		sorted50000 = makeNearSortedArray(50000);
	}

	@Test
	public void testBubbleSort() {
		BubbleSort.bubble_srt(sorted50);
		assertTrue(isSorted(sorted50));
		BubbleSort.bubble_srt(sorted500);
		assertTrue(isSorted(sorted500));
		BubbleSort.bubble_srt(sorted5000);
		assertTrue(isSorted(sorted5000));
		BubbleSort.bubble_srt(sorted50000);
		assertTrue(isSorted(sorted50000));
	}

	@Test
	public void testSelectionSort() {
		SelectionSort.doSelectionSort(sorted50);
		assertTrue(isSorted(sorted50));
		SelectionSort.doSelectionSort(sorted500);
		assertTrue(isSorted(sorted500));
		SelectionSort.doSelectionSort(sorted5000);
		assertTrue(isSorted(sorted5000));
		SelectionSort.doSelectionSort(sorted50000);
		assertTrue(isSorted(sorted50000));
	}

	@Test
	public void testQuickSort() {
		QuickSort qs = new QuickSort();
		assertTrue(isSorted(sorted500));// check that list is sorted already,
										// since this is what we're testing.
		qs.sort(sorted50);
		assertTrue(isSorted(sorted50));
		qs.sort(sorted500);
		assertTrue(isSorted(sorted500));
		qs.sort(sorted5000);
		assertTrue(isSorted(sorted5000));
		qs.sort(sorted50000);
		assertTrue(isSorted(sorted50000));
	}

	@Test
	public void testInsertionSort() {
		InsertionSort.doInsertionSort(sorted50);
		assertTrue(isSorted(sorted50));
		InsertionSort.doInsertionSort(sorted500);
		assertTrue(isSorted(sorted500));
		InsertionSort.doInsertionSort(sorted5000);
		assertTrue(isSorted(sorted5000));
		InsertionSort.doInsertionSort(sorted50000);
		assertTrue(isSorted(sorted50000));
	}

	@Test
	public void testMergeSort() {
		MergeSort ms = new MergeSort(); // Merge sort is supposedly O(n log n)
		ms.sort(sorted50);
		assertTrue(isSorted(sorted50));
		ms.sort(sorted500);
		assertTrue(isSorted(sorted500));

		ms.sort(sorted5000);
		assertTrue(isSorted(sorted5000));
		ms.sort(sorted50000);
		assertTrue(isSorted(sorted50000));
	}

	private int[] makeNearSortedArray(int size) { // Make an array which is
													// nearly in order but has
													// some elements in the
													// wrong places.
		int[] newArray = new int[size];
		for (int i = 0; i < size; i++)
			newArray[i] = i;
		return newArray;
	}

	private boolean isSorted(int array[]) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1])
				return false;
		}
		return true;
	}
}
