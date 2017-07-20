package algorithms;

public class QuickSort {

	private int array[];
	private int length;
	int changes, compares;

	public void sort(int[] inputArr) {
		// Checks if anything is in the array, if not, return.
		if (inputArr == null || inputArr.length == 0) {
			return;
		}

		changes = 0;
		compares = 0;

		this.array = inputArr;// save array into field
		length = inputArr.length;// save length of the array
		quickSort(0, length - 1);// call quickSort method and start at index 0,
									// end at length -1

		System.out.println(String.format("\nQuickSort: Comparisons: %d || Changes: %d || Array Length: %d", compares,
				changes, length));
		System.out.println(String.format("Comparisons/datapoint: %f || Changes/datapoint: %f",
				(float) compares / length, (float) changes / length));
	}

	private void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				compares++;
				i++;
			}
			while (array[j] > pivot) {
				compares++;
				j--;
			}
			if (i <= j) {
				compares++;
				if (i != j) changes += 2; //Otherwise it tracks replacing an index with itself as a change.
											//Doing +2 because we are treating each index changed as a change,
											//and in each case where i != j and a change is happening,
											//we'll definitely be swapping two values.
				exchangeNumbers(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j) {
			quickSort(lowerIndex, j);
		}
		if (i < higherIndex) {
			quickSort(i, higherIndex);
		}
	}

	private void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
//		changes++;
		array[j] = temp;
//		changes++;
	}

	public static void main(String a[]) {

		QuickSort sorter = new QuickSort();
		int[] input = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		sorter.sort(input);
		for (int i : input) {
			System.out.print(i);
			System.out.print(" ");
		}
	}
}