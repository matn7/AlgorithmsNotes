package hard;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        // directed edges
        // positive weight
        // no-loops

        // 0    4
        //  \ / |
        //   1  |
        //  / \ |
        // 2 -- 3
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

//    // O(v^2 + e) time | O(v) space - where v is the number of vertices and e is the number of edges
//    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
//        // Write your code here.
//        int numberOfVertices = edges.length;
//        int[] minDistances = new int[numberOfVertices];
//        for (int i = 0; i < numberOfVertices; i++) {
//            minDistances[i] = 9999;
//        }
//        minDistances[start] = 0;
//        Set<Integer> visited = new HashSet<>();
//
//        while (visited.size() != numberOfVertices) {
//            MinDistanceVertex minDistanceVertex = getVertexWithMinDistance(minDistances, visited);
//
//            if (minDistanceVertex.currentMinDistance == 9999) {
//                break; // find node not connected to any other nodes
//            }
//
//            visited.add(minDistanceVertex.vertex);
//
//            for (int[] edge : edges[minDistanceVertex.vertex]) {
//                // edge {1, 7} {destination, distance}
//                int destination = edge[0];
//                int distanceToDestination = edge[1];
//
//                if (visited.contains(destination)) {
//                    continue;
//                }
//
//                int newPathDistance = minDistanceVertex.currentMinDistance + distanceToDestination;
//                int currentDestinationDistance = minDistances[destination];
//                if (newPathDistance < currentDestinationDistance) {
//                    minDistances[destination] = newPathDistance;
//                }
//            }
//
//        }
//
//        for (int i = 0; i < numberOfVertices; i++) {
//            if (minDistances[i] == 9999) {
//                minDistances[i] = -1;
//            }
//        }
//
//        return minDistances;
//    }
//        private MinDistanceVertex getVertexWithMinDistance(int[] distances, Set<Integer> visited) {
//            int currentMinDistance = 9999;
//            int vertex = -1;
//
//            for (int vertexIdx = 0; vertexIdx < distances.length; vertexIdx++) {
//                int distance = distances[vertexIdx];
//                if (visited.contains(vertexIdx)) {
//                    continue;
//                }
//                if (distance <= currentMinDistance) {
//                    vertex = vertexIdx;
//                    currentMinDistance = distance;
//                }
//            }
//
//            return new MinDistanceVertex(vertex, currentMinDistance);
//        }

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

        Set<Integer> visited = new HashSet<>();

        while (visited.size() != numberOfVertices) {
            MinDistanceVertex minDistanceVertex = minDistancesHeap.remove(); // log(v) 0, 1, 4, 2, 3

            if (visited.contains(minDistanceVertex.vertex)) {
                continue;
            }

            if (minDistanceVertex.currentMinDistance == 9999) {
                break; // find node not connected to any other nodes
            }

            visited.add(minDistanceVertex.vertex);

            for (int[] edge : edges[minDistanceVertex.vertex]) {
                // edge {1, 7} {destination, distance}
                int destination = edge[0]; // 4
                int distanceToDestination = edge[1]; // 2

                if (visited.contains(destination)) {
                    continue;
                }

                int newPathDistance = minDistanceVertex.currentMinDistance + distanceToDestination; // 13 + 14
                int currentDestinationDistance = minDistances[destination]; // 3, 27
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

//    // O((v + e) * log(v)) time | O(v) space - where v is the number of vertices and e is the number of edges
//    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
//        // Write your code here.
//        int numberOfVertices = edges.length;
//
//        int[] minDistances = new int[numberOfVertices];
//        for (int i = 0; i < numberOfVertices; i++) {
//            minDistances[i] = 9999;
//        }
//        minDistances[start] = 0;
//
//        PriorityQueue<MinDistanceVertex> minDistancesHeap = new PriorityQueue<>();
//        for (int idx = 0; idx < numberOfVertices; idx++) {
//            minDistancesHeap.add(new MinDistanceVertex(idx, 9999));
//        }
//        minDistancesHeap.poll();
//        minDistancesHeap.add(new MinDistanceVertex(start, 0));
//
//        while (!minDistancesHeap.isEmpty()) { // v
//            MinDistanceVertex minDistanceVertex = minDistancesHeap.remove(); // log(v)
//
//            if (minDistanceVertex.currentMinDistance == 9999) {
//                break; // find node not connected to any other nodes
//            }
//
//            for (int[] edge : edges[minDistanceVertex.vertex]) {
//                // edge {1, 7} {destination, distance}
//                int destination = edge[0];
//                int distanceToDestination = edge[1];
//
//                int newPathDistance = minDistanceVertex.currentMinDistance + distanceToDestination;
//                int currentDestinationDistance = minDistances[destination];
//                if (newPathDistance < currentDestinationDistance) {
//                    minDistances[destination] = newPathDistance;
//                    minDistancesHeap.add(new MinDistanceVertex(destination, newPathDistance));
//                }
//            }
//
//        }
//
//        for (int i = 0; i < numberOfVertices; i++) {
//            if (minDistances[i] == 9999) {
//                minDistances[i] = -1;
//            }
//        }
//
//        return minDistances;
//    }

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

    // {0,  1,  4,  2,  3,  5}      <-- nodes to lookup
    //  0   1   2   3   4   5       <-- nodes
    // -----------------------
    //  0   -   -   -   -   -
    //  0   7   -   -   -   -   <- pick 0
    //  0   7   13  27  10  -   <- pick 1
    //  0   7   13  27  10  -   <- pick 4 (no neighbors)
    //  0   7   13  27  10  -   <- pick 2
    //  0   7   13  27  10  -   <- pick 3 (no need to consider as node 4 is already visited)
    //  0   7   13  27  10  -1  <- pick 5 (no way to go to 5 from other nodes)

}
