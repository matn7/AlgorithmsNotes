package hard;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        int[][][] edges = {
                {{1, 7}},                   // 0 vertex
                {{2, 6}, {3, 20}, {4, 3}},  // 1 vertex
                {{3, 14}},                  // 2 vertex
                {{4, 2}},                   // 3 vertex
                {},                         // 4 vertex
                {}                          // 5 vertex
        };

        DijkstrasAlgorithm dijkstrasAlgorithm = new DijkstrasAlgorithm();
        dijkstrasAlgorithm.dijkstrasAlgorithm(0, edges);

    }

    // O((v + e) * log(v)) time | O(v) space - where v is the number of vertices and e is the number of edges
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        // Write your code here.
        int numberOfVertices = edges.length;

        int[] minDistances = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            minDistances[i] = 9999;
        }
        minDistances[start] = 0;

        PriorityQueue<MinDistanceVertex> minDistancesHeap = new PriorityQueue<>();
        for (int idx = 0; idx < numberOfVertices; idx++) {
            minDistancesHeap.add(new MinDistanceVertex(idx, 9999));
        }
        minDistancesHeap.poll();
        minDistancesHeap.add(new MinDistanceVertex(start, 0));

        while (!minDistancesHeap.isEmpty()) {
            MinDistanceVertex minDistanceVertex = minDistancesHeap.remove();

            if (minDistanceVertex.currentMinDistance == 9999) {
                break;
            }

            for (int[] edge : edges[minDistanceVertex.vertex]) {
                int destination = edge[0];
                int distanceToDestination = edge[1];

                int newPathDistance = minDistanceVertex.currentMinDistance + distanceToDestination;
                int currentDestinationDistance = minDistances[destination];
                if (newPathDistance < currentDestinationDistance) {
                    minDistances[destination] = newPathDistance;
                    minDistancesHeap.add(new MinDistanceVertex(destination, newPathDistance));
                }
            }

        }

        for (int i = 0; i < numberOfVertices; i++) {
            if (minDistances[i] == 9999) {
                minDistances[i] = -1;
            }
        }

        return minDistances;
    }

    static class MinDistanceVertex implements Comparable<MinDistanceVertex> {
        int vertex;
        int currentMinDistance;

        public MinDistanceVertex(int vertex, int currentMinDistance) {
            this.vertex = vertex;
            this.currentMinDistance = currentMinDistance;
        }


        @Override
        public int compareTo(MinDistanceVertex o) {
            return currentMinDistance - o.currentMinDistance;
        }
    }


}
