
import Module3.ArrayQueue;
import Module5.BST;
import Module6.MinHeap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BST<Integer> foo = new BST<>();

    foo.add(1);
    foo.add(0);
    foo.add(2);
    foo.add(3);
        foo.remove(1);
        MinHeap<Integer> bar = new MinHeap<>();


        for(Integer i = 20; i > 0;i--){
            bar.add(i*2);
        }

        while(true){
            Integer x = bar.remove();
            System.out.println(x);
        }

    }




}


