package Module10;

import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     * <p>
     * It should be:
     * in-place
     * stable
     * adaptive
     * <p>
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     * <p>
     * NOTE: You should implement bubble sort with the last swap optimization.
     * <p>
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int stopIndex = arr.length - 1;
        while (stopIndex != 0) {
            int i = 0;
            int lastSwapped = 0;
            while (i < stopIndex) {
                int comparison = comparator.compare(arr[i], arr[i + 1]);
                if (comparison >= 1) {
                    swap(arr, i, i + 1);
                    lastSwapped = i;
                }
                i++;
            }
            stopIndex = lastSwapped;
        }
    }

    private static <T> void swap(T[] arr, int indexA, int indexB) {
        T temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    /**
     * Implement selection sort.
     * <p>
     * It should be:
     * in-place
     * unstable
     * not adaptive
     * <p>
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     * <p>
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for (int n = arr.length - 1; n >= 1; n--) {
            int maxIndex = n;
            for (int i = 0; i < n; i++) {
                int comparison = comparator.compare(arr[i], arr[maxIndex]);
                if (comparison >= 1) {
                    maxIndex = i;
                }
            }
            swap(arr, maxIndex, n);
        }
    }

    /**
     * Implement insertion sort.
     * <p>
     * It should be:
     * in-place
     * stable
     * adaptive
     * <p>
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     * <p>
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for (int n = 0; n < arr.length - 1; n++) {
            int i = n + 1;
            while (i != 0 && comparator.compare(arr[i], arr[i - 1]) <= -1) {
                swap(arr, i, i - 1);
                i--;
            }
        }
    }
}