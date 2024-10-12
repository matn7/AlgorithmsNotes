package problems.veryhard;

import java.util.ArrayList;
import java.util.List;

public class TwoEdgeConnectedGraph {

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2, 5},
                {0, 2},
                {0, 1, 3},
                {2, 4, 5},
                {3, 5},
                {0, 3, 4}
        };

        TwoEdgeConnectedGraph edgeConnectedGraph = new TwoEdgeConnectedGraph();
        edgeConnectedGraph.twoEdgeConnectedGraph(edges);
    }

    // O(v + e) time | O(v) space
    public boolean twoEdgeConnectedGraph(int[][] edges) {
        // Write your code here.
        if (edges.length == 0) {
            return true;
        }
        List<Integer> arrivalTimes = new ArrayList<>();
        for (int[] element : edges) {
            arrivalTimes.add(-1);
        }
        int startVertex = 0;

        if (getMinimumArrivalTimeOfAncestors(startVertex, -1, 0, arrivalTimes, edges) == -1) {
            return false;
        }

        return areAllVerticesVisited(arrivalTimes);
    }

    private boolean areAllVerticesVisited(List<Integer> arrivalTimes) {
        for (Integer time : arrivalTimes) {
            if (time == -1) {
                return false;
            }
        }
        return true;
    }

    public int getMinimumArrivalTimeOfAncestors(int currentVertex, int parent, int currentTime,
                                                List<Integer> arrivalTimes, int[][] edges) {
        arrivalTimes.set(currentVertex, currentTime);
        int minimumArrivalTime = currentTime;

        for (int destination : edges[currentVertex]) {
            if (arrivalTimes.get(destination) == -1) {
                minimumArrivalTime = Math.min(minimumArrivalTime, getMinimumArrivalTimeOfAncestors(
                        destination, currentVertex, currentTime + 1, arrivalTimes, edges));
            } else if (destination != parent) {
                minimumArrivalTime = Math.min(minimumArrivalTime, arrivalTimes.get(destination));
            }
        }

        if (minimumArrivalTime == currentTime && parent != -1) {
            return -1;
        }

        return minimumArrivalTime;
    }

}
