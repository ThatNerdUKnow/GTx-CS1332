package Module11;

import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting {

    /**
     * Implement merge sort.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     * <p>
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     * <p>
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     * <p>
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     * <p>
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int length = arr.length;
        int middle = length / 2;

        // len 1 base case
        if (length == 1) {
            return;
        }
        // len 2 base case
        else if(length == 2){
            if(comparator.compare(arr[0],arr[1]) <= 0){
                return;
            }
            else{
                T temp = arr[1];
                arr[1] = arr[0];
                arr[0] = temp;
            }
        }

        T[] LeftArray = getArrSlice(arr, 0, middle - 1);
        T[] RightArray = getArrSlice(arr, middle, length - 1);

        mergeSort(LeftArray, comparator);
        mergeSort(RightArray, comparator);

        merge(arr, LeftArray, RightArray, middle, comparator);
    }

    private static <T> void merge(T[] arr, T[] left, T[] right, int middle, Comparator<T> comparator) {
        int length = arr.length;
        int iLeft = 0, iRight = 0, iArr = 0;

        // Neither array is empty
        while (iLeft < middle && iRight < (length - middle)) {
            T LeftItem = left[iLeft];
            T RightItem = right[iRight];
            int comparison = comparator.compare(LeftItem, RightItem);

            if (comparison <= 0) {
                arr[iArr] = left[iLeft];
                iLeft++;
            } else {
                arr[iArr] = right[iRight];
                iRight++;
            }
            iArr++;
        }

        while (iLeft < middle) {
            arr[iArr] = left[iLeft];
            iArr++;
            iLeft++;
        }

        while (iRight < (length - middle)) {
            arr[iArr] = right[iRight];
            iArr++;
            iRight++;
        }

    }

    private static <T> T[] getArrSlice(T[] arr, int start, int end) {
        T[] slice = (T[]) new Object[end - start + 1];

        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }

        return slice;
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     * <p>
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     * <p>
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     * <p>
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     * <p>
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     * <p>
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     * <p>
     * Do NOT use anything from the Math class except Math.abs().
     * <p>
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int base = 10;

        Queue<Integer>[] buckets = (Queue<Integer>[]) new Queue[19];


        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<Integer>();
        }

        int k = getK(arr, base);
        int length = arr.length;
        int divisor = 1;
        for (int i = 1; i <= k; i++) {
            for (int item : arr) {
                int bucket = radix(item, divisor, base);
                buckets[bucket + 9].add(item);
            }

            int index = 0;
            for (Queue<Integer> bucket : buckets) {
                while (bucket.size() > 0) {
                    arr[index] = bucket.remove();
                    index++;
                }
            }
            divisor *= base;
        }

    }

    private static int radix(int item, int divisor, int base) {

        return (item / divisor) % base;


    }

    private static int getK(int[] arr, int base) {
        int k = 0;

        for (int item : arr) {
            int j = getK(Math.abs(item), base);

            if (j > k) {
                k = j;
            }
        }
        return k;
    }

    private static int getK(int item, int base) {
        int k = 0;
        int temp = 1;
        while (temp <= item) {
            temp = temp * 10;
            k++;
        }
        return k;
    }
}