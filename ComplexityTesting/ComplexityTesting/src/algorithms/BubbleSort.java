package algorithms;

public class BubbleSort {

	static long changes; // Changes is most relevant for BubbleSort. Compares
						// will always be n^2 regardless of order of data
						// pre-sort, but changes will be much more dependent.
	static long compares;

	// logic to sort the elements
	public static void bubble_srt(int array[]) {
		changes = 0;
		compares = 0;
		int n = array.length;
		int k;
		// start going through the array from the last index
		for (int m = n; m >= 0; m--) { // m = a new value equal at first to the
										// length of the array. n is the length
										// of the array. m goes down.
			boolean swapped = false;
			// start going through from the first index
			for (int i = 0; i < n - 1; i++) { // i goes from 0 up to n, nearly.
				k = i + 1;// save next index

				// check if value at current index is greater than value at next
				// index
				if (array[i] > array[k]) {
					swapNumbers(i, k, array);// if so, swap them
					swapped = true;
				}
				compares++;
			}
			if (swapped == false)
				break;
			// printNumbers(array);
		}
		System.out.println(String.format("\nBubbleSort: Comparisons: %d || Changes: %d || Array Length: %d", compares,
				changes, n));
		System.out.println(String.format("Comparisons/datapoint: %f || Changes/datapoint: %f",
				(float) compares / n, (float) changes / n));
	}

	private static void swapNumbers(int i, int j, int[] array) {

		int temp;
		temp = array[i];
		array[i] = array[j];
		changes++;
		array[j] = temp;
		changes++;
	}

	private static void printNumbers(int[] input) {

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		bubble_srt(input);
	}
}