package Module6;

import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     * <p>
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     * <p>
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     * <p>
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (backingArray.length == size + 1) {
            resize();
        }

        size++;
        backingArray[size] = data;
        heapify(size);
    }

    private void heapify(int index) {
        int parent = index / 2;
        if (parent != 0) {
            if (backingArray[parent].compareTo(backingArray[index]) > 0) {
                swap(parent, index);
                heapify(parent);
            }
        }

    }

    private void swap(int i, int j) {
        T temp = backingArray[i];
        backingArray[i] = backingArray[j];
        backingArray[j] = temp;
    }

    private void resize() {
        T[] temp = (T[]) new Comparable[backingArray.length * 2];


        int i = 0;
        for (T item : backingArray) {
            temp[i] = backingArray[i];
            i++;
        }

        this.backingArray = temp;
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     * <p>
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T temp = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size] = null;
        size--;
        downheap(1);
        return temp;
    }

    private void downheap(int index) {
        if (index > size / 2) {
            return;
        }
        int left = index * 2;
        int right = left + 1;
        if (right > size) {
            if (backingArray[index].compareTo(backingArray[left]) > 0) {
                swap(index, left);
                downheap(left);
            }
        } else {
            int smallerChild = 0;
            if (backingArray[left].compareTo(backingArray[right]) > 0) {
                smallerChild = right;
            } else {
                smallerChild = left;
            }

            if (backingArray[index].compareTo(backingArray[smallerChild]) > 0) {
                swap(index, smallerChild);
                downheap(smallerChild);
            }
        }
    }


    /**
     * Returns the backing array of the heap.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     * <p>
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
