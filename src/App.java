import java.util.Arrays;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // ======================bubble sort=========================
        int[] numbers = generateRandomArray(10000);

        System.out.println("Before: " + Arrays.toString(Arrays.copyOfRange(numbers, 0, 10)));

        long start = System.nanoTime();
        Sort.bubbleSort(numbers);
        long end = System.nanoTime();

        int bubbleSortTime = (int) ((end - start) / 1_000_000.0);

        // ======================selection sort=========================
        //// #region Selection Sort
        // Reset the array for the next sort
        numbers = generateRandomArray(10000);

        start = System.nanoTime();
        Sort.selectionSort(numbers);
        end = System.nanoTime();

        int selectionSortTime = (int) ((end - start) / 1_000_000.0);
        ////#endregion

        // ======================insertion sort=========================
        // Reset the array for the next sort
        numbers = generateRandomArray(10000);

        start = System.nanoTime();
        Sort.insertionSort(numbers);
        end = System.nanoTime();

        int insertionSortTime = (int) ((end - start) / 1_000_000.0);

        // ======================merge sort=========================
        // Reset the array for the next sort
        numbers = generateRandomArray(10000);

        System.out.println("Before: " + Arrays.toString(Arrays.copyOfRange(numbers, 0, 10)));

        start = System.nanoTime();
        Sort.mergeSort(numbers, 0, numbers.length - 1);
        end = System.nanoTime();

        int mergeSortTime = (int) ((end - start) / 1_000_000.0);

        // Print the results
        System.out.println("After: " + Arrays.toString(Arrays.copyOfRange(numbers, 0, 10)));
        System.out.println("Bubble Sort Time: " + bubbleSortTime + " ms");
        System.out.println("Selection Sort Time: " + selectionSortTime + " ms");
        System.out.println("Insertion Sort Time: " + insertionSortTime + " ms");
        System.out.println("Merge Sort Time: " + mergeSortTime + " ms");

        if (bubbleSortTime < selectionSortTime && bubbleSortTime < insertionSortTime
                && bubbleSortTime < mergeSortTime) {
            System.out.println("Bubble Sort is the fastest.");
        } else if (selectionSortTime < bubbleSortTime && selectionSortTime < insertionSortTime
                && selectionSortTime < mergeSortTime) {
            System.out.println("Selection Sort is the fastest.");
        } else if (insertionSortTime < bubbleSortTime && insertionSortTime < selectionSortTime
                && insertionSortTime < mergeSortTime) {
            System.out.println("Insertion Sort is the fastest.");
        } else {
            System.out.println("Merge Sort is the fastest.");
        }
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }
}
