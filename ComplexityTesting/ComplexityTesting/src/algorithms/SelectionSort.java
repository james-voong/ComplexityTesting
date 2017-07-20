package algorithms;

public class SelectionSort {
	static int changes;
	static int compares;

	public static int[] doSelectionSort(int[] arr) {
		changes = 0;
		compares = 0;
		int n = arr.length;
		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;// Save the first index
			for (int j = i + 1; j < arr.length; j++) {// compare first index
														// with the rest

				compares++;
				if (arr[j] < arr[index]) { // if next index is smaller than
											// first index
					index = j;// save the new index; overwriting the old one
					changes++;
				}
			}
			// after you reach the end of the list
			int smallerNumber = arr[index]; // save the value of smaller number

			// save the larger number at the position of the smaller one
			arr[index] = arr[i];

			// set the smaller number to the first saved position
			arr[i] = smallerNumber;

		}
		System.out.println("\nSelectionSort: " + "Compares: " + compares + " || Changes: " + changes
				+ " ||Array Length: " + arr.length);
		System.out.println(String.format("Comparisons/datapoint: %f || Changes/datapoint: %f", (float) compares / n,
				(float) changes / n));
		return arr;
	}

	public static void main(String a[]) {

		int[] arr1 = { 10, 34, 2, 56, 7, 67, 88, 42 };
		int[] arr2 = doSelectionSort(arr1);
		for (int i : arr2) {
			System.out.print(i);
			System.out.print(", ");
		}
	}
}
