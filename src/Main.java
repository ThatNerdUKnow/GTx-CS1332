
import Module12.CharacterComparator;
import Module12.PatternMatching;
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
        CharSequence text = "AAAAAAAA";
        CharSequence pattern = "AA";

        CharacterComparator comparator = new CharacterComparator();
        List<Integer> t = PatternMatching.boyerMoore(pattern,text,comparator);

        for(Integer i: t){
            System.out.println(i);
        }

    }
}


