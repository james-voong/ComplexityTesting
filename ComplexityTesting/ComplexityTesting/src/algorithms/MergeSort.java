package algorithms;

public class MergeSort {
    
   private int[] array;
   private int[] tempMergArr;
   private int length;
   private int compares, changes; //Tracking variables, increment where appropriate.

   public static void main(String a[]){
        
       int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
       MergeSort mms = new MergeSort();
       mms.sort(inputArr);
       for(int i:inputArr){
           System.out.print(i);
           System.out.print(" ");
       }
   }
    
   public void sort(int inputArr[]) {
	   compares = 0;
	   changes = 0;
       this.array = inputArr;
       this.length = inputArr.length;
       this.tempMergArr = new int[length];
       doMergeSort(0, length - 1);
       
		System.out.println(String.format("\nMerge Sort: Comparisons: %d || Changes: %d || Array Length: %d",
				compares, changes, this.length));
		System.out.println(String.format("Comparisons/datapoint: %f || Changes/datapoint: %f", (float) compares / this.length,
				(float) changes / this.length));
   }

   private void doMergeSort(int lowerIndex, int higherIndex) {
       if (lowerIndex < higherIndex) {
           int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
           // Below step sorts the left side of the array
           doMergeSort(lowerIndex, middle);
           // Below step sorts the right side of the array
           doMergeSort(middle + 1, higherIndex);
           // Now merge both sides
           mergeParts(lowerIndex, middle, higherIndex);
       }
   }

   private void mergeParts(int lowerIndex, int middle, int higherIndex) {

       for (int i = lowerIndex; i <= higherIndex; i++) {
           tempMergArr[i] = array[i]; //This populates another temporary array with all the values from the section, if added to changes, will add ~4n, I think.
           							  // I think this could be more relevant if you were somehow trying to mergesort a linkedList, or something else not array backed.
       }
       int i = lowerIndex;
       int j = middle + 1;
       int k = lowerIndex;
       while (i <= middle && j <= higherIndex) {
    	   compares++; //This is where it actually compares values.
           if (tempMergArr[i] <= tempMergArr[j]) {
               array[k] = tempMergArr[i];
               i++;
           } else {
               array[k] = tempMergArr[j];
               j++;
               changes++; //This is a tricky one. Since it's writing from a temporary array back over the main one,  you could say it always makes a "change", but really it only makes a change in order if the item from the j (right) side is smaller than the item from the left (i) side.
           }
           k++;
       }
       while (i <= middle) {
           array[k] = tempMergArr[i];
           k++;
           i++;
       }

   }
}