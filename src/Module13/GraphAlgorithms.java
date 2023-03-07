package Module13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Your implementation of various graph traversal algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs a breadth first search (bfs) on the input graph, starting at
     * the parameterized starting vertex.
     * <p>
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     * <p>
     * You may import/use java.util.Set, java.util.List, java.util.Queue, and
     * any classes that implement the aforementioned interfaces, as long as they
     * are efficient.
     * <p>
     * The only instance of java.util.Map that you should use is the adjacency
     * list from graph. DO NOT create new instances of Map for BFS
     * (storing the adjacency list in a variable is fine).
     * <p>
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     * <p>
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the bfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> bfs(Vertex<T> start, Graph<T> graph) {
        //WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Queue<Vertex<T>> queue = new LinkedList<>();
        List<Vertex<T>> path = new LinkedList<>();
        Set<Vertex<T>> visited = new HashSet<>();
        Map<Vertex<T>, List<VertexDistance<T>>> adjacency = graph.getAdjList();

        queue.add(start);

        while (queue.size() != 0) {
            Vertex<T> curr = queue.remove();
            path.add(curr);
            visited.add(curr);

            List<VertexDistance<T>> neighbors = adjacency.get(curr);

            for (VertexDistance<T> neighbor : neighbors) {
                Vertex<T> v = neighbor.getVertex();
                if (!visited.contains(v)) {
                    queue.add(v);
                    visited.add(v);
                }
            }
        }
        return path;
    }

    /**
     * Performs a depth first search (dfs) on the input graph, starting at
     * the parameterized starting vertex.
     * <p>
     * When exploring a vertex, explore in the order of neighbors returned by
     * the adjacency list. Failure to do so may cause you to lose points.
     * <p>
     * NOTE: This method should be implemented recursively. You may need to
     * create a helper method.
     * <p>
     * You may import/use java.util.Set, java.util.List, and any classes that
     * implement the aforementioned interfaces, as long as they are efficient.
     * <p>
     * The only instance of java.util.Map that you may use is the adjacency list
     * from graph. DO NOT create new instances of Map for DFS
     * (storing the adjacency list in a variable is fine).
     * <p>
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     * <p>
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin the dfs on.
     * @param graph The graph to search through.
     * @return List of vertices in visited order.
     */
    public static <T> List<Vertex<T>> dfs(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        HashSet<Vertex<T>> visited = new HashSet<>();
        List<Vertex<T>> path = new LinkedList<>();
        Map<Vertex<T>, List<VertexDistance<T>>> adjacency = graph.getAdjList();

        dfs(start, visited, path, adjacency);

        return path;
    }

    private static <T> void dfs(Vertex<T> curr, HashSet<Vertex<T>> visited, List<Vertex<T>> path, Map<Vertex<T>, List<VertexDistance<T>>> adjacency) {
        visited.add(curr);
        path.add(curr);

        for (VertexDistance<T> neighbor : adjacency.get(curr)) {
            if (!visited.contains(neighbor.getVertex())) {
                dfs(neighbor.getVertex(), visited, path, adjacency);
            }

        }
    }
}