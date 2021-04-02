/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication35;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class main {
    // the main
    public static void main(String[] args) {
        // scanner object
        Scanner sc = new Scanner(System.in);
        // user message
        System.out.print("Choose the algorithm you want to apply on the graph: \n");
        System.out.println("1- Kruskal\n"
                + "2- priority-queue (pq) based Prim\n"
                + "3- min-heap (mh) based Prim\n");
        // reading from user
        int userAlgorithm = sc.nextInt();
        // if statment to determine which algorithm
        if (userAlgorithm == 1) {
            System.out.print("Choose the case number: \n");
            System.out.println("1- no. of vertices: 1000 & no. of edges: 10000\n"
                    + "2- no. of vertices: 1000 & no. of edges: 15000\n"
                    + "3- no. of vertices: 1000 & no. of edges: 25000\n"
                    + "4- no. of vertices: 5000 & no. of edges: 15000\n"
                    + "5- no. of vertices: 5000 & no. of edges: 25000\n"
                    + "6- no. of vertices: 10000 & no. of edges: 15000\n"
                    + "7- no. of vertices: 10000 & no. of edges: 25000\n"
                    + "8- no. of vertices: 20000 & no. of edges: 200000\n"
                    + "9- no. of vertices: 20000 & no. of edges: 300000\n"
                    + "10- no. of vertices: 50000 & no. of edges: 1,000,000\n");
            int userChoise = sc.nextInt();
            // switch to choose no of v and e
            switch (userChoise) {
                case 1:
                    Graph.MAKE_GRAPH(1000, 10000);
                    break;
                case 2:
                    Graph.MAKE_GRAPH(1000, 15000);
                    break;
                case 3:
                    Graph.MAKE_GRAPH(1000, 25000);
                    break;
                case 4:
                    Graph.MAKE_GRAPH(5000, 15000);
                    break;
                case 5:
                    Graph.MAKE_GRAPH(5000, 25000);
                    break;
                case 6:
                    Graph.MAKE_GRAPH(10000, 15000);
                    break;
                case 7:
                    Graph.MAKE_GRAPH(10000, 25000);
                    break;
                case 8:
                    Graph.MAKE_GRAPH(20000, 200000);
                    break;
                case 9:
                    Graph.MAKE_GRAPH(20000, 300000);
                    break;
                case 10:
                    Graph.MAKE_GRAPH(50000, 1000000);
                    break;

            }
            // if statment to determine which algorithm
        } else if (userAlgorithm == 2) {
            System.out.print("Choose the case number: \n");
            System.out.println("1- no. of vertices: 1000 & no. of edges: 10000\n"
                    + "2- no. of vertices: 1000 & no. of edges: 15000\n"
                    + "3- no. of vertices: 1000 & no. of edges: 25000\n"
                    + "4- no. of vertices: 5000 & no. of edges: 15000\n"
                    + "5- no. of vertices: 5000 & no. of edges: 25000\n"
                    + "6- no. of vertices: 10000 & no. of edges: 15000\n"
                    + "7- no. of vertices: 10000 & no. of edges: 25000\n"
                    + "8- no. of vertices: 20000 & no. of edges: 200000\n"
                    + "9- no. of vertices: 20000 & no. of edges: 300000\n"
                    + "10- no. of vertices: 50000 & no. of edges: 1,000,000\n");
            int userChoise = sc.nextInt();
            // switch to choose no of v and e
            switch (userChoise) {
                case 1:
                    primpqMST.MAKE_GRAPH(1000, 10000);
                    break;
                case 2:
                    primpqMST.MAKE_GRAPH(1000, 15000);
                    break;
                case 3:
                    primpqMST.MAKE_GRAPH(1000, 25000);
                    break;
                case 4:
                    primpqMST.MAKE_GRAPH(5000, 15000);
                    break;
                case 5:
                    primpqMST.MAKE_GRAPH(5000, 25000);
                    break;
                case 6:
                    primpqMST.MAKE_GRAPH(10000, 15000);
                    break;
                case 7:
                    primpqMST.MAKE_GRAPH(10000, 25000);
                    break;
                case 8:
                    primpqMST.MAKE_GRAPH(20000, 200000);
                    break;
                case 9:
                    primpqMST.MAKE_GRAPH(20000, 300000);
                    break;
                case 10:
                    primpqMST.MAKE_GRAPH(50000, 1000000);
                    break;

            }
            // if statment to determine which algorithm
        } else if (userAlgorithm == 3) {
            System.out.print("Choose the case number: \n");
            System.out.println("1- no. of vertices: 1000 & no. of edges: 10000\n"
                    + "2- no. of vertices: 1000 & no. of edges: 15000\n"
                    + "3- no. of vertices: 1000 & no. of edges: 25000\n"
                    + "4- no. of vertices: 5000 & no. of edges: 15000\n"
                    + "5- no. of vertices: 5000 & no. of edges: 25000\n"
                    + "6- no. of vertices: 10000 & no. of edges: 15000\n"
                    + "7- no. of vertices: 10000 & no. of edges: 25000\n"
                    + "8- no. of vertices: 20000 & no. of edges: 200000\n"
                    + "9- no. of vertices: 20000 & no. of edges: 300000\n"
                    + "10- no. of vertices: 50000 & no. of edges: 1,000,000\n");
            int userChoise = sc.nextInt();
            // switch to choose no of v and e
            switch (userChoise) {
                case 1:
                    primsmh.MAKE_GRAPH(1000, 10000);
                    break;
                case 2:
                    primsmh.MAKE_GRAPH(1000, 15000);
                    break;
                case 3:
                    primsmh.MAKE_GRAPH(1000, 25000);
                    break;
                case 4:
                    primsmh.MAKE_GRAPH(5000, 15000);
                    break;
                case 5:
                    primsmh.MAKE_GRAPH(5000, 25000);
                    break;
                case 6:
                    primsmh.MAKE_GRAPH(10000, 15000);
                    break;
                case 7:
                    primsmh.MAKE_GRAPH(10000, 25000);
                    break;
                case 8:
                    primsmh.MAKE_GRAPH(20000, 200000);
                    break;
                case 9:
                    primsmh.MAKE_GRAPH(20000, 300000);
                    break;
                case 10:
                    primsmh.MAKE_GRAPH(50000, 1000000);
                    break;

            }
        } else {
            System.out.println("---- WRONG SELECTION!! ----");
        }

    }
}
