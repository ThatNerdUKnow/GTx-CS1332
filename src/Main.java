
import Module3.ArrayQueue;
import Module5.BST;
import Module6.MinHeap;
import Module7.ExternalChainingHashMap;
import Module8.AVL;
import Module8.AVLNode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] foo = new Integer[]{7,4,15,1,6,10,18,0,3,5,8,13,16,19,2,9,11,14,17,12};
        AVL<Integer> bar = new AVL<>();
        for (Integer item:foo) {
            bar.add(item);
        }
        bar.remove(7);
    }
}


