
import Module3.ArrayQueue;
import Module5.BST;
import Module6.MinHeap;
import Module7.ExternalChainingHashMap;
import Module8.AVL;
import Module8.AVLNode;
import Module10.Sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer[] foo = new Integer[]{7,4,15,1,6,10,18,0,3,5,8,13,16,19,2,9,11,14,17,12};
        IntCompare c = new IntCompare();
        Sorting.insertionSort(foo,c);
        for(Integer i:foo){
            System.out.println(i);
        }
    }
}

 class IntCompare implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}


