// A Java program for Dijkstra's single source shortest path algorithm.

import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath {

    /*find the vertex with minimum distance value,
     from the set of vertices not yet included in shortest path tree*/
    static final int V = 12;

    int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    // print the constructed distance array
    void printSolution(int dist[], int n, int src) {
        System.out.println("Source\t\t\t\tTree Vertex# \t\t\t Shortest path from Source (remaining Vertices)"); 
        System.out.println("---------------------------------------------------------------------------------------------------------------");
       
        //Switch to manufacture the tree vertex and convert it from numbers to city names
        String ci = " ";
        for (int i = 0; i < V; i++) {
            if (i == 0) {
                ci = "JEDDAH";
            } else if (i == 1) {
                ci = "MAKKAH";
            } else if (i == 2) {
                ci = "MADINAH";
            } else if (i == 3) {
                ci = "RIYADH";
            } else if (i == 4) {
                ci = "DAMMAM";
            } else if (i == 5) {
                ci = "TAIF";
            } else if (i == 6) {
                ci = "ABHA";
            } else if (i == 7) {
                ci = "TABUK";
            } else if (i == 8) {
                ci = "QASIM";
            } else if (i == 9) {
                ci = "HAIL";
            } else if (i == 10) {
                ci = "JIZAN";
            } else if (i == 11) {
                ci = "NAJRAN";
            }
 
            // Switch to convert source numbers to city names
        String c ="";
        if (src == 0) {
                c = "JEDDAH";
            } else if (src == 1) {
                c = "MAKKAH";
            } else if (src == 2) {
                c = "MADINAH";
            } else if (src == 3) {
                c = "RIYADH";
            } else if (src == 4) {
                c = "DAMMAM";
            } else if (src == 5) {
                c = "TAIF";
            } else if (src == 6) {
                c = "ABHA";
            } else if (src == 7) {
                c = "TABUK";
            } else if (src == 8) {
                c = "QASIM";
            } else if (src == 9) {
                c = "HAIL";
            } else if (src == 10) {
                c = "JIZAN";
            } else if (src == 11) {
                c = "NAJRAN";
            }

           System.out.printf("(%d)%-28s (%d)%-28s  %-25d \n",src, c,   i,ci, dist[i]);

 
        }
    }

    //  single source shortest path, algorithm for a graph represented using adjacency matrix representation
    void dijkstra(int graph[][], int src) { // >> the shortest distance from "src to i"
        int dist[] = new int[V]; // The output array. dist[i] will hold
        


        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];  // sptSet[i] will true if vertex i is included in shortest

 
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;  // Initialize all distances as INFINITE and stpSet[] as false
        }

        // Distance of source vertex from itself is always 0 nd is equal to jeddah
        dist[src] = 0;

        // here fanction to Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // I select the minimum header distance from the group of vertices
            // here not yet addressed. 
            int u = minDistance(dist, sptSet); // U is always equal to src in the first iteration.
            // Mark the picked vertex as processed
            sptSet[u] = true; 

            // Update >> for dist value of the adjacent vertices of the vertex.
            for (int v = 0; v < V; v++) // Update dist[v] only if is not in sptSet
             /* there is an edge from u to v,
             and total weight of path from (src to v ) through u is smaller than current value of dist[v]*/
            {
                if (!sptSet[v] && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // print the constructed distance array
        printSolution(dist, V, src);
    }
    // main
    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{
            {0, 79, 420, 949, 1343, 167, 625, 1024, 863, 777, 710, 905},
            {79, 0, 358, 870, 1265, 88, 627, 1037, 876, 790, 685, 912},
            {420, 358, 0, 848, 1343, 446, 985, 679, 518, 432, 1043, 1270},
            {949, 870, 848, 0, 395, 782, 1064, 1304, 330, 640, 1272, 950},
            {1343, 1265, 1343, 395, 0, 1177, 1495, 1729, 725, 1035, 1667, 1345},
            {167, 88, 446, 782, 1177, 0, 561, 1204, 936, 957, 763, 864},
            {625, 627, 985, 1064, 1459, 561, 0, 1649, 1488, 1402, 202, 280},
            {1024, 1037, 679, 1304, 1729, 1204, 1649, 0, 974, 664, 1722, 1929},
            {863, 876, 518, 330, 725, 936, 1488, 974, 0, 310, 1561, 1280},
            {777, 790, 432, 640, 1035, 957, 1402, 664, 974, 0, 1475, 1590},
            {710, 685, 1043, 1272, 1667, 763, 202, 1722, 1561, 1475, 0, 482},
            {905, 912, 1270, 950, 1345, 864, 280, 1929, 1280, 1590, 482, 0}};

        ShortestPath t = new ShortestPath();

        t.dijkstra(graph, 0); // 0 >>> JEDDAH

    }

}
