package whiteboard;

import java.util.Arrays;

public class TwoEdgeConnectedGraph {

    // O(v + e) time | O(v) space
    public boolean twoEdgeConnectedGraph(int[][] edges) {
        // Write your code here.
        if (edges.length == 0) {
            return true;
        }
        int[] arrivalTimes = new int[edges.length];
        Arrays.fill(arrivalTimes, -1);
        int startVertex = 0;
        if (getMinimumArrivalTimeOfAncestor(startVertex, -1, 0, arrivalTimes, edges) == -1) {
            return false;
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

    private int getMinimumArrivalTimeOfAncestor(int currentVertex, int parent, int currentTime,
                                                int[] arrivalTimes, int[][] edges) {
        arrivalTimes[currentVertex] = currentTime;

        int minimumArrivalTime = currentTime;

        for (int destination : edges[currentVertex]) {
            if (arrivalTimes[destination] == -1) {
                minimumArrivalTime = Math.min(minimumArrivalTime,
                        getMinimumArrivalTimeOfAncestor(destination, currentTime, currentTime + 1,
                                arrivalTimes, edges));
            } else if (destination != parent) {
                minimumArrivalTime = Math.min(minimumArrivalTime, arrivalTimes[destination]);
            }
        }

        if (minimumArrivalTime == currentTime && parent != -1) {
            return -1;
        }
        return minimumArrivalTime;
    }
}
