
import Module3.ArrayQueue;
import Module5.BST;
import Module6.MinHeap;
import Module7.ExternalChainingHashMap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ExternalChainingHashMap<Integer, Integer> foo = new ExternalChainingHashMap<>();
        var table = foo.getTable();

        foo.put(0,0);
        foo.put(13,13);
        foo.put(13*2,13*2);

        foo.remove(13);
        foo.getTable();
    }
}


