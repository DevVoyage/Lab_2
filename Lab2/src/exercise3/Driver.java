package exercise3;

import java.util.*;

public class Driver
{

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 1000;
	
	// Bubble Sort
    public static void bubbleSort(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort
    public static void insertionSort(Integer[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            /* Move elements of array[0..i-1], that are greater than key, to one position ahead
			   of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Selection Sort
    public static void selectionSort(Integer[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    // Quick Sort
    public static void quickSort(Integer[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(Integer[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1; // index of smaller element
        for (int j = low; j < high; j++) {
        	// If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and [j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i+1] and [high]
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

	public static void main( String[] args )
	{
		System.out.println("Please provide a sorting algorithm choice: b (Bubble), i (Insertion), s (Selection), or q (QuickSort)");
        Scanner keyboardInput = new Scanner(System.in);
        String target = keyboardInput.nextLine();
        
        char method = target.charAt(0);
        
        
		Integer[] nums = new Integer[SIZE];
		Random rand = new Random();

		for( int i = 0; i < SIZE; i++ )
		{
			nums[i] = rand.nextInt( UPPER_BOUND );
			//System.out.println( nums[i] );
		}
		
		System.out.println("Array before sorting: " + Arrays.toString(nums));
		
		switch (method) {
        case 'b':
            bubbleSort(nums);
            System.out.println("Array after Bubble Sort: " + Arrays.toString(nums));
            break;
        case 'i':
            insertionSort(nums);
            System.out.println("Array after Insertion Sort: " + Arrays.toString(nums));
            break;
        case 's':
            selectionSort(nums);
            System.out.println("Array after Selection Sort: " + Arrays.toString(nums));
            break;
        case 'q':
            quickSort(nums, 0, nums.length - 1);
            System.out.println("Array after Quick Sort: " + Arrays.toString(nums));
            break;
        default:
            System.out.println("Invalid sorting algorithm choice.");
		}
	}
}
