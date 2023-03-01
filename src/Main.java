
import Module3.ArrayQueue;
import Module5.BST;
import Module6.MinHeap;
import Module7.ExternalChainingHashMap;
import Module8.AVL;
import Module8.AVLNode;
//import Module10.Sorting;
import Module11.Sorting;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Random rd = new Random();
        int n = 100;
        int[] foo = new int[n];

        for(int i = foo.length-1; i >0; i--){
            foo[i] = -i;
        }

        IntCompare c = new IntCompare();

        Sorting.lsdRadixSort(foo);
        for (int i : foo) {
            System.out.println(i);
        }
    }
}

class IntCompare implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}


