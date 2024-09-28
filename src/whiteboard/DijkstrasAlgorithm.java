package whiteboard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        int[][][] edges = {
                {{1,7}},
                {{2,6}, {3,20}, {4,3}},
                {{3,11}},
                {{4,2}},
                {},
                {}
        };

        DijkstrasAlgorithm dijkstrasAlgorithm = new DijkstrasAlgorithm();
        int[] result = dijkstrasAlgorithm.dijkstrasAlgorithm(0, edges);
        System.out.println();
    }

    // Directly, positive edges, no self loops
    // Adjacency list to represent a graph

    // ********
    // * STAR - G *
    // ********

    // O((v+e)*log(v)) time | O(v) space
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        // Write your code here.
        int[] distances = new int[edges.length];
        Map<Integer, Node> graphMap = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        distances[start] = 0;
        //    0    1    2    3    4    5
        // [  0, INF, INF, INF, INF, INF]

        PriorityQueue<Node> distanceHeap = new PriorityQueue<>();
        distanceHeap.add(new Node(start, 0));

        while (!distanceHeap.isEmpty()) {
            Node currentElement = distanceHeap.remove();
            int currentIdx = currentElement.idx;
            int currentDistance = currentElement.distance;
            graphMap.put(currentIdx, currentElement);

            int[][] neighbors = edges[currentIdx];
            for (int[] neighbor : neighbors) {
                int neighborIdx = neighbor[0];
                int neighborDistance = neighbor[1];
                if (currentDistance + neighborDistance < distances[neighborIdx]) {
                    distances[neighborIdx] = currentDistance + neighborDistance;
                    Node neighborNode = new Node(neighborIdx, currentDistance + neighborDistance);
                    distanceHeap.add(neighborNode);
                    neighborNode.cameFrom = currentElement; // to determine path if needed
                }
            }

        }

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == Integer.MAX_VALUE)  {
                distances[i] = -1;
                graphMap.put(i, new Node(i, -1));
            }
        }

        return distances;
    }

    static class Node implements Comparable<Node> {
        int idx;
        int distance;
        Node cameFrom;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return o.distance - distance;
        }
    }

}
