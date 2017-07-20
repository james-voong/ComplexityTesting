package algorithms;

public class InsertionSort {
	static long changes;
	static long comparisons;

	public static void main(String a[]) {
		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr2 = doInsertionSort(arr1);
		for (int i : arr2) {
			System.out.print(i);
			System.out.print(", ");
		}
	}

	public static int[] doInsertionSort(int[] input) {
		changes = 0;
		comparisons = 0;
		int n = input.length;
		int temp;
		for (int i = 1; i < input.length; i++) {// start from index 1

			for (int j = i; j > 0; j--) { // set j to index and iterate
											// backwards through the array
				comparisons++;
				if (input[j] < input[j - 1]) { // compare value of j to value of
												// j-1
					temp = input[j];// it lower, swap them
					input[j] = input[j - 1];
					changes++;
					input[j - 1] = temp;
					changes++;

				}
			}
		}
		System.out.println(String.format("\nInsertion Sort: Comparisons: %d || Changes: %d || Array Length: %d",
				comparisons, changes, n));
		System.out.println(String.format("Comparisons/datapoint: %f || Changes/datapoint: %f", (float) comparisons / n,
				(float) changes / n));
		return input;
	}
}