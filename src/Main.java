
import Module3.ArrayQueue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> foo = new ArrayQueue<>();

        for(int i = 0;i<10;i++){
            foo.enqueue(i);
        }

        Object[] backing = foo.getBackingArray();
        System.out.println(Arrays.toString(backing));

        for(int i = 0;i<=5;i++){
            foo.dequeue();
        }

        backing = foo.getBackingArray();
        System.out.println(Arrays.toString(backing));

        for(int i = 10;i<24;i++){
            foo.enqueue(i);
        }

        backing = foo.getBackingArray();
        System.out.println(Arrays.toString(backing));

        foo.enqueue(24);

        backing = foo.getBackingArray();
        System.out.println(Arrays.toString(backing));
    }
}


