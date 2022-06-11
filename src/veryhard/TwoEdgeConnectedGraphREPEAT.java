package veryhard;

import java.util.Arrays;
import java.util.List;

public class TwoEdgeConnectedGraphREPEAT {

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2, 5},  // edge 0
                {0, 2},     // edge 1
                {0, 1, 3},  // edge 2
                {2, 4, 5},  // edge 3
                {3, 5},     // edge 4
                {0, 3, 4}   // edge 5
        };

        TwoEdgeConnectedGraphREPEAT twoEdgeConnectedGraphREPEAT = new TwoEdgeConnectedGraphREPEAT();
        twoEdgeConnectedGraphREPEAT.twoEdgeConnectedGraph(edges);
    }

    //      (0)-------(5)
    //     / |         | \
    //   (1) |         |  (4)
    //     \ |         | /
    //      (2)-------(3)


    // OK - repeated 24/02/2022
    // O(v + e) time | O(v) space
    public boolean twoEdgeConnectedGraph(int[][] edges) {
        // edges = [[1,2,5],    #0
        //          [0,2],      #1
        //          [0,1,3],    #2
        //          [2,4,5],    #3
        //          [3,5],      #4
        //          [0,3,4]]    #5
        // Write your code here.
        if (edges.length == 0) {
            return true;
        }
        //      (0)-------(5)
        //     / |         | \
        //   (1) |         |  (4)
        //     \ |         | /
        //      (2)-------(3)
        int[] arrivalTimes = new int[edges.length];
        Arrays.fill(arrivalTimes, -1);
        // arrivalTimes = [-1, -1, -1, -1, -1, -1]
        int startVertex = 0;

        // rec(0, -1, 0, [-1, -1, -1, -1, -1, -1], [][])
        if (getMinimumArrivalTimeOfAncestors(startVertex, -1, 0,
                arrivalTimes, edges) == -1) {
            // bridge found
            return false;
        } else {
            System.out.println();
        }

        return areAllVerticesVisited(arrivalTimes);
    }

    private boolean areAllVerticesVisited(int[] arrivalTimes) {
        for (int time : arrivalTimes) {
            if (time == -1) {
                return false;
            }
        }
        return true;
    }

    // rec(5, 4, 5, [0, 1, 2,  3,  4,  5], [][]) =>
    // rec(4, 3, 4, [0, 1, 2,  3, -1, -1], [][])
    // rec(3, 2, 3, [0, 1, 2,  3, -1, -1], [][])
    // rec(2, 1, 2, [0, 1, 2, -1, -1, -1], [][])
    // rec(1, 0, 1, [0, 1, -1, -1, -1, -1], [][])
    // rec(0, -1, 0, [0, 1, -1, -1, -1, -1], [][])
    private int getMinimumArrivalTimeOfAncestors(int currentVertex, int parent,
                                                     int currentTime, int[] arrivalTimes, int[][] edges) {
        // currentVertex, parent, currentTime
        // 0, -1, 0      mat = 0 < '0'
        // 1,  0, 1      mat = 1 < '1'
        //  0   1   2   3   4   5
        //  *       d
        // [0,  1,  2,  3,  4,  5]
        arrivalTimes[currentVertex] = currentTime;

        int minimumArrivalTime = currentTime; // 4

        for (int destination : edges[currentVertex]) { // [0,3,4]
            if (arrivalTimes[destination] == -1) { // node not visited
                minimumArrivalTime = Math.min(minimumArrivalTime,
                    getMinimumArrivalTimeOfAncestors(destination, currentVertex,
                            currentTime + 1, arrivalTimes, edges));
                // min(4, rec(5, 4, 5, [0, 1, 2,  3,  4, -1], [][]))
            } else if (destination != parent) { // already visited has arrival time
                minimumArrivalTime = Math.min(minimumArrivalTime, arrivalTimes[destination]); // 0
            }
        }

        if (minimumArrivalTime == currentTime && parent != -1) {
            return -1;
        }
        return minimumArrivalTime;
    }

}
