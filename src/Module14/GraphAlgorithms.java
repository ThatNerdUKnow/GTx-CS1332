package Module14;

import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.List;

/**
 * Your implementation of Prim's algorithm.
 */
public class GraphAlgorithms {

    /**
     * Runs Prim's algorithm on the given graph and returns the Minimum
     * Spanning Tree (MST) in the form of a set of Edges. If the graph is
     * disconnected and therefore no valid MST exists, return null.
     * <p>
     * You may assume that the passed in graph is undirected. In this framework,
     * this means that if (u, v, 3) is in the graph, then the opposite edge
     * (v, u, 3) will also be in the graph, though as a separate Edge object.
     * <p>
     * The returned set of edges should form an undirected graph. This means
     * that every time you add an edge to your return set, you should add the
     * reverse edge to the set as well. This is for testing purposes. This
     * reverse edge does not need to be the one from the graph itself; you can
     * just make a new edge object representing the reverse edge.
     * <p>
     * You may assume that there will only be one valid MST that can be formed.
     * <p>
     * You should NOT allow self-loops or parallel edges in the MST.
     * <p>
     * You may import/use java.util.PriorityQueue, java.util.Set, and any
     * class that implements the aforementioned interface.
     * <p>
     * DO NOT modify the structure of the graph. The graph should be unmodified
     * after this method terminates.
     * <p>
     * The only instance of java.util.Map that you may use is the adjacency
     * list from graph. DO NOT create new instances of Map for this method
     * (storing the adjacency list in a variable is fine).
     * <p>
     * You may assume that the passed in start vertex and graph will not be null.
     * You may assume that the start vertex exists in the graph.
     *
     * @param <T>   The generic typing of the data.
     * @param start The vertex to begin Prims on.
     * @param graph The graph we are applying Prims to.
     * @return The MST of the graph or null if there is no valid MST.
     */
    public static <T> Set<Edge<T>> prims(Vertex<T> start, Graph<T> graph) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Set<Vertex<T>> visited = new HashSet<>();
        Set<Edge<T>> mst = new HashSet<>();
        Set<Vertex<T>> vertices = graph.getVertices();
        PriorityQueue<Edge<T>> queue = new PriorityQueue<>();

        visited.add(start);

        addNeighborEdgesToQueue(start, queue, graph);

        while (queue.size() > 0 && mst.size() < vertices.size() - 1) {
            Edge<T> curr = queue.remove();

            // Edges are directed from u to v
            Vertex<T> v = curr.getV();

            if (!visited.contains(v)) {
                mst.add(curr);
                visited.add(v);
                addNeighborEdgesToQueue(v, queue, graph);
            }
        }

        // Check if we actually have an MST
        if (mst.size() != graph.getVertices().size() - 1) {
            return null;
        }

        // Add opposite directions for undirected edges
        addSisterEdges(mst, graph);

        return mst;
    }

    private static <T> void addNeighborEdgesToQueue(Vertex<T> from, PriorityQueue<Edge<T>> queue, Graph<T> graph) {

        List<VertexDistance<T>> neighbors = graph.getAdjList().get(from);
        for (VertexDistance<T> neighbor : neighbors) {
            Vertex<T> to = neighbor.getVertex();
            Integer distance = neighbor.getDistance();

            Edge<T> e = new Edge<>(from, to, distance);

            queue.add(e);
        }
    }

    private static <T> void addSisterEdges(Set<Edge<T>> mst, Graph<T> graph) {
        Set<Edge<T>> edges = graph.getEdges();
        Set<Edge<T>> sisters = new HashSet<>();

        for (Edge<T> edge : mst) {
            Vertex<T> from = edge.getU();
            Vertex<T> to = edge.getV();
            Integer distance = edge.getWeight();

            Edge<T> e = new Edge<>(to, from, distance);
            if (edges.contains(e)) {
                sisters.add(e);
            }
        }

        for (Edge<T> sister : sisters) {
            mst.add(sister);
        }
    }
}
