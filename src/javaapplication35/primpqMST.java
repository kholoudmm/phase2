package javaapplication35;

import java.io.*;
import java.util.*;
import java.lang.Comparable;

public class primpqMST {

    // Pair class with implemented comparable
    static class Pair<U extends Comparable<U>, V extends Comparable<V>>
            implements Comparable<Pair<U, V>> {

        public final U a;
        public final V b;

        private Pair(U a, V b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Pair<?, ?> pair = (Pair<?, ?>) o;
            if (!a.equals(pair.a)) {
                return false;
            }
            return b.equals(pair.b);
        }

        // Overriding so that objects in map
        // could find the object key
        @Override
        public int hashCode() {
            return 31 * a.hashCode() + b.hashCode();
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }

        @Override
        public int compareTo(Pair<U, V> o) {
            return getV().compareTo(o.getV());
        }

        private U getU() {
            return a;
        }

        private V getV() {
            return b;
        }
    }

    static class Graph {

        int vertices;
        ArrayList[] edges;

        // This variable keeps the least cost edge
        static Pair<Pair<Integer, Integer>, Integer> minCostEdge;

        Graph(int vertices) {
            minCostEdge = new Pair<>(new Pair<>(1, 1),
                    Integer.MAX_VALUE);
            this.vertices = vertices;
            edges = new ArrayList[vertices + 1];
            for (int i = 0; i <= vertices; i++) {
                edges[i]
                        = new ArrayList<Pair<Integer, Integer>>();
            }
        }

        void addEdge(int a, int b, int weight) {
            edges[a].add(new Pair<>(b, weight));

            // Since its undirected, adding the
            // edges to both the vertices
            edges[b].add(new Pair<>(a, weight));
            if (weight < minCostEdge.b) {
                minCostEdge
                        = new Pair<>(new Pair<>(a, b), weight);
            }
        }

        void MST() {

            // Priority queue for applying heap
            PriorityQueue<Pair<Pair<Integer, Integer>, Integer>> priorityQueue
                    = new PriorityQueue<>();

            // Adding all the connected vertices
            // of MinCostEdge vertex A to PQ
            Iterator<Pair<Integer, Integer>> iterator
                    = edges[minCostEdge.a.a].listIterator();
            while (iterator.hasNext()) {
                Pair<Integer, Integer> pair
                        = iterator.next();
                priorityQueue.add(
                        new Pair<>(
                                new Pair<>(minCostEdge.a.a, pair.a),
                                pair.b));
            }

            // Adding all the connected vertices
            // of MinCostEdge vertex B to PQ
            iterator = edges[minCostEdge.a.b].listIterator();
            while (iterator.hasNext()) {
                Pair<Integer, Integer> pair = iterator.next();
                priorityQueue.add(
                        new Pair<>(
                                new Pair<>(minCostEdge.a.b, pair.a),
                                pair.b));
            }

            // Set to check vertex is added or not
            Set<Integer> addedVertices = new HashSet<>();

            // Set contains all the added edges and cost from source
            Set<Pair<Pair<Integer, Integer>, Integer>> addedEdges
                    = new HashSet<>();

            // Using the greedy approach to find
            // the least costing edge to the GRAPH
            while (addedEdges.size() < vertices - 1) {

                // Polling from priority queue
                Pair<Pair<Integer, Integer>, Integer> pair
                        = priorityQueue.poll();

                // Checking wether the vertex A is added or not
                if (!addedVertices.contains(pair.a.a)) {
                    addedVertices.add(pair.a.a);
                    addedEdges.add(pair);

                    // Adding all the connected vertices with vertex A
                    iterator = edges[pair.a.a].listIterator();
                    while (iterator.hasNext()) {
                        Pair<Integer, Integer> pair1
                                = iterator.next();
                        priorityQueue.add(
                                new Pair<>(
                                        new Pair<>(pair.a.a, pair1.a),
                                        pair1.b));
                    }
                }

                // Checking wether the vertex B is added or not
                if (!addedVertices.contains(pair.a.b)) {
                    addedVertices.add(pair.a.b);
                    addedEdges.add(pair);

                    // Adding all the connected vertices with vertex B
                    iterator = edges[pair.a.b].listIterator();
                    while (iterator.hasNext()) {
                        Pair<Integer, Integer> pair1
                                = iterator.next();
                        priorityQueue
                                .add(
                                        new Pair<>(
                                                new Pair<>(pair.a.b, pair1.a),
                                                pair1.b));
                    }
                }
            }

            // Printing the MST
            Iterator<Pair<Pair<Integer, Integer>, Integer>> iterator1
                    = addedEdges.iterator();
            System.out.println("((V"
                    + ", "
                    + "V)"
                    + ", "
                    + "Cost)");
            while (iterator1.hasNext()) {
                System.out.println(iterator1.next());
            }
        }
    }
    //make graph fun that takes no of v and no of e and construct tree
    public static void MAKE_GRAPH(int V, int E) {
        Graph graph = new Graph(V);

        for (int i = 0; i < E; i++) {
            graph.addEdge((int)(Math.random()*(V)), (int)(Math.random()*(V)), (int)(1 + Math.random()*(10)));
        }

        graph.MST();
    }
}
