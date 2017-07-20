package tests;

import algorithms.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestingNearlySorted {

	private int[] nearlySorted50; //Fifty items.
	private int[] nearlySorted500; //Five hundred items.
	private int[] nearlySorted5000; //Five thousand items.
	private int[] nearlySorted50000; //Fifty thousand items. Having arrays of multiple sizes will allow us to see the relationship between number of elements and cost per element.

	@Before
	public void initialize() {

		nearlySorted50 = new int[50];
		Utility.fillIntArrayFromFile(nearlySorted50, "/premade/nearlySorted50");
		nearlySorted500 = new int[500];
		Utility.fillIntArrayFromFile(nearlySorted500, "/premade/nearlySorted500");
		nearlySorted5000 = new int[5000];
		Utility.fillIntArrayFromFile(nearlySorted5000, "/premade/nearlySorted5000");
		nearlySorted50000 = new int[50000];
		Utility.fillIntArrayFromFile(nearlySorted50000, "/premade/nearlySorted50000");	}

	@Test
	public void testBubbleSort() {
		BubbleSort.bubble_srt(nearlySorted50);
		assertTrue(isSorted(nearlySorted50));
		BubbleSort.bubble_srt(nearlySorted500);
		assertTrue(isSorted(nearlySorted500));
		BubbleSort.bubble_srt(nearlySorted5000);
		assertTrue(isSorted(nearlySorted5000));
		BubbleSort.bubble_srt(nearlySorted50000);
		assertTrue(isSorted(nearlySorted50000));
	}

	@Test
	public void testSelectionSort() {
		SelectionSort.doSelectionSort(nearlySorted50);
		assertTrue(isSorted(nearlySorted50));
		SelectionSort.doSelectionSort(nearlySorted500);
		assertTrue(isSorted(nearlySorted500));
		SelectionSort.doSelectionSort(nearlySorted5000);
		assertTrue(isSorted(nearlySorted5000));
		SelectionSort.doSelectionSort(nearlySorted50000);
		assertTrue(isSorted(nearlySorted50000));
	}

	@Test
	public void testQuickSort() {
		QuickSort qs = new QuickSort();
		assertFalse(isSorted(nearlySorted500));// check that list is not
												// sorted
		qs.sort(nearlySorted50);
		assertTrue(isSorted(nearlySorted50));
		qs.sort(nearlySorted500);
		assertTrue(isSorted(nearlySorted500));
		qs.sort(nearlySorted5000);
		assertTrue(isSorted(nearlySorted5000));
		qs.sort(nearlySorted50000);
		assertTrue(isSorted(nearlySorted50000));
	}

	@Test
	public void testInsertionSort() {
		InsertionSort.doInsertionSort(nearlySorted50);
		assertTrue(isSorted(nearlySorted50));
		InsertionSort.doInsertionSort(nearlySorted500);
		assertTrue(isSorted(nearlySorted500));
		InsertionSort.doInsertionSort(nearlySorted5000);
		assertTrue(isSorted(nearlySorted5000));
		InsertionSort.doInsertionSort(nearlySorted50000);
		assertTrue(isSorted(nearlySorted50000));
	}
	
	@Test
	public void testMergeSort() {
		MergeSort ms = new MergeSort(); //Merge sort is supposedly O(n log n)
		ms.sort(nearlySorted50);
		assertTrue(isSorted(nearlySorted50));
		ms.sort(nearlySorted500);
		assertTrue(isSorted(nearlySorted500));
		
		ms.sort(nearlySorted5000);
		assertTrue(isSorted(nearlySorted5000));
		ms.sort(nearlySorted50000);
		assertTrue(isSorted(nearlySorted50000));
	}
	
	private int[] makeNearSortedArray(int size) { //Make an array which is nearly in order but has some elements in the wrong places.
		int[] newArray = new int[size];
		for (int i = 0; i < size; i++)
			newArray[i] = i;
		SlightlyRandomizeArray(newArray);
		return newArray;
	}

	private static int[] SlightlyRandomizeArray(int[] array){ //Tweaked from http://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
		Random rgen = new Random();  // Random number generator			
		int numberOfChanges = Math.max(2, (int) (array.length / 10.0)); //Make at least 2 changes, but preferably swap about 10% of values with other nearby values.
		
		for (int i=0; i <= numberOfChanges; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int randomOffset = rgen.nextInt(11) -5; //Should be int between -5 and 5.
		    while (randomPosition + randomOffset >= array.length) randomOffset--; //Basically if the randomOffset would take us outside the array size, keep reducing it until it won't.
		    while (randomPosition + randomOffset < 0) randomOffset++; //And the same for the other direction.
		    int temp = array[randomPosition + randomOffset];
		    array[randomPosition + randomOffset] = array[randomPosition];
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
