package hard;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstrasAlgorithmREPEAT {

    public static void main(String[] args) {
        int[][][] edges = {
                {{1, 7}},                   // 0 vertex     {1 - vertex, 7 - weight}
                {{2, 6}, {3, 20}, {4, 3}},  // 1 vertex
                {{3, 14}},                  // 2 vertex
                {{4, 2}},                   // 3 vertex
                {},                         // 4 vertex
                {}                          // 5 vertex
        };

        //      [0]       [4]       [5]
        //        \      A  A
        //         \ 7  / 3 |
        //          V  /    |
        //          [1]     | 2
        //         /   \    |
        //      6 /  20 \   |
        //       V       V  |
        //      [2]------>[3]
        //           14
        DijkstrasAlgorithmREPEAT dijkstrasAlgorithmREPEAT = new DijkstrasAlgorithmREPEAT();
        int[] result = dijkstrasAlgorithmREPEAT.dijkstrasAlgorithm(0, edges);

        for (int element : result) {
            System.out.print(element + " -> ");
        }

    }

    // O((v + e) * log(v)) time | O(v) space - where v is the number of vertices and e is the number of edges
    // OK - repeated 25/01/2022
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        //      [0]       [4]       [5]
        //        \      A  A
        //         \ 7  / 3 |
        //          V  /    |
        //          [1]     | 2
        //         /   \    |
        //      6 /  20 \   |
        //       V       V  |
        //      [2]------>[3]
        //           14
        int numberOfVertices = edges.length; // 6

        int[] minDistances = new int[numberOfVertices];
        // minDist [0, 0, 0, 0, 0, 0]
        for (int i = 0; i < numberOfVertices; i++) {
            minDistances[i] = 99999;
        }
        // minDist [99999, 99999, 99999, 99999, 99999, 99999]
        minDistances[start] = 0;
        // minDist [0, 99999, 99999, 99999, 99999, 99999]

        // MinDistanceVertex(int vertex, int currentMinDistance)
        PriorityQueue<MinDistanceVertex> minDistancesHeap = new PriorityQueue<>();
        for (int idx = 0; idx < numberOfVertices; idx++) {
            minDistancesHeap.add(new MinDistanceVertex(idx, 99999));
        }
        // [(0, 99999), (1, 99999), (2, 99999), (3, 99999), (4, 99999), (5, 99999)]
        minDistancesHeap.poll();
        // [(1, 99999), (2, 99999), (3, 99999), (4, 99999), (5, 99999)]
        minDistancesHeap.add(new MinDistanceVertex(start, 0));
        // [(0, 0), (1, 99999), (2, 99999), (3, 99999), (4, 99999), (5, 99999)]

//        Set<Integer> visited = new HashSet<>();

//        while (visited.size() != numberOfVertices) { // v
        while (!minDistancesHeap.isEmpty()) {
            // [(4, 10), (3, 99999), (4, 99999), (5, 99999)]
            MinDistanceVertex minDistanceVertex = minDistancesHeap.poll(); // (4, 10)
            // [(3, 99999), (4, 99999), (5, 99999)]
            int vertex = minDistanceVertex.vertex; // 4
            int currentMinDistance = minDistanceVertex.currentMinDistance; // 10

//            if (visited.contains(vertex)) {
//                continue;
//            }

            if (currentMinDistance == 99999) {
                break;
            }

//            visited.add(vertex);
            // edges[1] = {{2, 6}, {3, 20}, {4, 3}}
            for (int[] edge : edges[vertex]) {
                int destination = edge[0]; // 4
                int distanceToDestination = edge[1]; // 3

//                if (visited.contains(destination)) {
//                    continue;
//                }
                // minDist [0, 7, 13, 27, 10, 99999]
                int newPathDistance = currentMinDistance + distanceToDestination; // 7 + 3 = 10
                int currentDestinationDistance = minDistances[destination]; // 99999
                if (newPathDistance < currentDestinationDistance) {
                    minDistances[destination] = newPathDistance;
                    minDistancesHeap.poll();
                    // [(3, 99999), (4, 99999), (5, 99999)]
                    minDistancesHeap.add(new MinDistanceVertex(destination, newPathDistance));
                    System.out.println();
                    // [(4, 10), (3, 99999), (4, 99999), (5, 99999)]
                }
            }
        }

        int[] result = new int[minDistances.length];

        for (int i = 0; i < minDistances.length; i++) {
            if (minDistances[i] == 99999) {
                result[i] = -1;
            } else {
                result[i] = minDistances[i];
            }
        }
        return result;
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

//    // O(v^2 + e) time | O(v) space - where v is the number of vertices and e is the number of edges
//    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
//        int numberOfVertices = edges.length; // 6
//
//        int[] minDistances = new int[numberOfVertices];
//        for (int i = 0; i < numberOfVertices; i++) {
//            minDistances[i] = 99999;
//        }
//        minDistances[start] = 0;
//        // minDist [0, 99999, 99999, 99999, 99999, 99999]
//
//        Set<Integer> visited = new HashSet<>();
//        // visited = [0]
//
//        while (visited.size() != numberOfVertices) {
//            // VertexInfo(int vertex, int currentMinDistance)
//            VertexInfo vertexInfo = getVertexWithMinDistance(minDistances, visited); // (5,99999)
//
//            if (vertexInfo.currentMinDistance == 99999) {
//                break;
//            }
//
//            // visited = [0, 1, 4, 2, 3]
//            visited.add(vertexInfo.vertex);
//
//            // edges[3] = {{4, 2}}
//            // minDist [0, 7, 13, 27, 10, 99999]
//            for (int[] edge : edges[vertexInfo.vertex]) {
//                int destination = edge[0]; // 4
//                int distanceToDestination = edge[1]; // 2
//
//                if (visited.contains(destination)) {
//                    continue;
//                }
//
//                int newPathDistance = vertexInfo.currentMinDistance + distanceToDestination; // 27 + 2 = 29
//                int currentDestinationDistance = minDistances[destination];
//                if (newPathDistance < currentDestinationDistance) {
//                    minDistances[destination] = newPathDistance;
//                }
//            }
//        }
//
//        int[] result = new int[minDistances.length];
//
//        for (int i = 0; i < minDistances.length; i++) {
//            if (minDistances[i] == 99999) {
//                result[i] = -1;
//            } else {
//                result[i] = minDistances[i];
//            }
//        }
//        return result;
//    }
//
//    private VertexInfo getVertexWithMinDistance(int[] distances, Set<Integer> visited) {
//        int currentMinDistance = 99999;
//        Integer vertex = null;
//
//        // minDist [0, 7, 13, 27, 10, 99999]
//        for (int vertexIdx = 0; vertexIdx < distances.length; vertexIdx++) {
//            int distance = distances[vertexIdx];
//            if (visited.contains(vertexIdx)) {
//                continue;
//            }
//            if (distance <= currentMinDistance) {
//                vertex = vertexIdx; // 4
//                currentMinDistance = distance; // 10
//            }
//        }
//
//        return new VertexInfo(vertex, currentMinDistance);
//    }
//
//    static class VertexInfo {
//        int vertex;
//        int currentMinDistance;
//
//        public VertexInfo(int vertex, int currentMinDistance) {
//            this.vertex = vertex;
//            this.currentMinDistance = currentMinDistance;
//        }
//    }

}
