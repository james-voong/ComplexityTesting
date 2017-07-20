package tests;

import algorithms.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestingReversedSorted {

	private int[] reverseSorted50; //Fifty items.
	private int[] reverseSorted500; //Five hundred items.
	private int[] reverseSorted5000; //Five thousand items.
	private int[] reverseSorted50000; //Fifty thousand items. Having arrays of multiple sizes will allow us to see the relationship between number of elements and cost per element.

	@Before
	public void initialize() {

		reverseSorted50 = makeReverseSortedArray(50);
		reverseSorted500 = makeReverseSortedArray(500);
		reverseSorted5000 = makeReverseSortedArray(5000);
		reverseSorted50000 = makeReverseSortedArray(50000);
	}

	@Test
	public void testBubbleSort() {
		BubbleSort.bubble_srt(reverseSorted50);
		assertTrue(isSorted(reverseSorted50));
		BubbleSort.bubble_srt(reverseSorted500);
		assertTrue(isSorted(reverseSorted500));
		BubbleSort.bubble_srt(reverseSorted5000);
		assertTrue(isSorted(reverseSorted5000));
		BubbleSort.bubble_srt(reverseSorted50000); //50,000 squared is too high to show as an integer, rolls over to negative.
		assertTrue(isSorted(reverseSorted50000)); //Could possibly use a long instead of an int but we already know enough about the cost for our purposes.
	}

	@Test
	public void testSelectionSort() {
		SelectionSort.doSelectionSort(reverseSorted50);
		assertTrue(isSorted(reverseSorted50));
		SelectionSort.doSelectionSort(reverseSorted500);
		assertTrue(isSorted(reverseSorted500));
		SelectionSort.doSelectionSort(reverseSorted5000);
		assertTrue(isSorted(reverseSorted5000));
		SelectionSort.doSelectionSort(reverseSorted50000);
		assertTrue(isSorted(reverseSorted50000));
	}

	@Test
	public void testQuickSort() {
		QuickSort qs = new QuickSort();
		assertFalse(isSorted(reverseSorted500));// check that list is not
												// sorted
		qs.sort(reverseSorted50);
		assertTrue(isSorted(reverseSorted50));
		qs.sort(reverseSorted500);
		assertTrue(isSorted(reverseSorted500));
		qs.sort(reverseSorted5000);
		assertTrue(isSorted(reverseSorted5000));
		qs.sort(reverseSorted50000);
		assertTrue(isSorted(reverseSorted50000));
	}

	@Test
	public void testInsertionSort() {
		InsertionSort.doInsertionSort(reverseSorted50);
		assertTrue(isSorted(reverseSorted50));
		InsertionSort.doInsertionSort(reverseSorted500);
		assertTrue(isSorted(reverseSorted500));
		InsertionSort.doInsertionSort(reverseSorted5000);
		assertTrue(isSorted(reverseSorted5000));
		InsertionSort.doInsertionSort(reverseSorted50000); //Insertion sort does too many changes to show with an int.
		assertTrue(isSorted(reverseSorted50000)); //Again, could probably use a long, but probably ok without. Might be worth having a size 50 array too.
	}
	
	@Test
	public void testMergeSort() {
		MergeSort ms = new MergeSort(); //Merge sort is supposedly O(n log n)
		ms.sort(reverseSorted50);
		assertTrue(isSorted(reverseSorted50));
		ms.sort(reverseSorted500);
		assertTrue(isSorted(reverseSorted500));
		
		ms.sort(reverseSorted5000);
		assertTrue(isSorted(reverseSorted5000));
		ms.sort(reverseSorted50000);
		assertTrue(isSorted(reverseSorted50000));
	}

	// @After
	// public void finish () {
	// for (int each : reverseSorted500) System.out.print(each + " ");
	// System.out.println();
	// }
	
	private int[] makeReverseSortedArray(int size) {
		int[] newArray = new int[size];
		for (int i = 0; i < size; i++)
			newArray[i] = size - i;
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
