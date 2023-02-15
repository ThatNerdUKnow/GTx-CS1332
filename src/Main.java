
import Module3.ArrayQueue;
import Module5.BST;
import Module6.MinHeap;
import Module7.ExternalChainingHashMap;
import Module8.AVL;
import Module8.AVLNode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AVL<Integer> AVL = new AVL<>();
        AVLNode<Integer> A = new AVLNode<>(1);
        AVLNode<Integer> B = new AVLNode<>(3);
        AVLNode<Integer> C = new AVLNode<>(2);

        A.setRight(B);
        B.setLeft(C);

        AVL.balance(C);
        AVL.balance(B);
        AVL.balance(A);
    }
}


