
import Module12.CharacterComparator;
import Module12.PatternMatching;
//import Module13.Edge;
//import Module13.Graph;
//import Module13.GraphAlgorithms;
//import Module13.Vertex;
import Module3.ArrayQueue;
import Module5.BST;
import Module6.MinHeap;
import Module7.ExternalChainingHashMap;
import Module8.AVL;
import Module8.AVLNode;
//import Module10.Sorting;
import Module11.Sorting;
import Module14.Edge;
import Module14.Vertex;
import Module14.Graph;
import Module14.GraphAlgorithms;


import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        HashSet<Vertex<Integer>> vertices = new HashSet<>();
        HashSet<Edge<Integer>> edges = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            Vertex<Integer> v = new Vertex<>(i);
            vertices.add(v);
        }

        // generate a random number
        Random rng = new Random(100);

        for (int i = 0; i < 20; i++) {
            Vertex<Integer> v1 = vertices.stream().skip(rng.nextInt(vertices.size())).findFirst().orElse(null);
            Vertex<Integer> v2 = vertices.stream().skip(rng.nextInt(vertices.size())).findFirst().orElse(null);
            Edge<Integer> e = new Edge<>(v1, v2, rng.nextInt(10));
            edges.add(e);
            e = new Edge<>(v2,v1, rng.nextInt(10));
            edges.add(e);
        }

        Graph<Integer> g = new Graph<>(vertices, edges);

        Vertex<Integer> start = vertices.stream().findFirst().orElse(null);
        System.out.println("prims");
        Set<Edge<Integer>> mst = GraphAlgorithms.prims(start,g);

       for(Edge<Integer> e:mst){
           System.out.println(e);
       }
    }
}


