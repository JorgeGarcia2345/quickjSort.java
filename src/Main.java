import java.util.Arrays;
import java.util.Random;

public class Main {

	/**
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot.
	 * 
	 * @param array The array of data to sort
	 * @param first The first index of the array
	 * @param last  The last index of the array
	 * @return The index at which the pivot is placed
	 */
	public static int partition(int [] array, int first, int last) {
		// Initialize the pivot as the last element in the array
		int pivot = array[last];
		// Initialize i to start out as one less than first
		int i = first - 1;
		// Loop through array from first to last-1
		int temp;
		for (int j = first; j < last ; j++) {
			// If current element is smaller than the pivot
			if (array[j] < pivot) {
				// a) Increment i
				i++;
				// b) Swap array[i] and array[j]
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			// Else, do nothing
		}

		// After loop, swap array[i+1] and array[last] (or pivot)
		temp = array[i+1];
		array[i+1] = pivot;
		array[last] = temp;


		// Return the index of where the pivot was placed (i+1)
		return i+1;
	}


	/**
	 * The main function that implements QuickSort() array[] --> Array to be sorted,
	 * first --> Starting index, last --> Ending index
	 * @param array The array of data to be sorted
	 * @param first The first index in the array
	 * @param last The last index in the array
	 */
	public static void quickSort(int array[], int first, int last) {
		// Base Case:
		// If first >= last, return (done!)
		if (first >= last)
			return;
		// Recursive Case
		// Otherwise, call partition to find the pivot
		int pivot = partition(array, first, last);
		// Call quickSort on left part of array (less than pivot)
		quickSort(array, first, pivot-1);
		// Call quickSort on right part of array (greater than pivot
		quickSort(array, pivot+1, last);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = new int[50];
		Random rng = new Random();


		// Capture system clock time before
		// Call quickSort 1,000,000 times, each on a randomly generated array
		// Capture system clock time after
		// Display the milliseconds elapsed
		
		// int = 32 bits
		// long = 64 bits  (time in milliseconds)
		long startTime, endTime;

		startTime = System.currentTimeMillis();

		for (int j = 0; j < 1_000_000; j++) {

			for (int i = 0; i < array.length; i++) {
				array[i] = rng.nextInt(100);
			}

			quickSort(array, 0, array.length - 1);
		}



		endTime = System.currentTimeMillis();
		System.out.println("QuickSort Elapsed Time = " + (endTime - startTime) + " ms");



		startTime = System.currentTimeMillis();

		for (int j = 0; j < 1_000_000; j++) {


			for (int i = 0; i < array.length; i++) {
				array[i] = rng.nextInt(100);
			}

			Arrays.sort(array);
		}

		endTime = System.currentTimeMillis();
		System.out.println("Arrays.sort Elapsed Time = " + (endTime - startTime) + " ms");
			
		// Capture system clock time before
		// Call Arrays.sort 1,000,000 times, each on a randomly generated array
		// Capture system clock time after
		// Display the milliseconds elapsed
	}

}
