package november_2023;

import java.util.*;

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
        int start = 0;

        dijkstrasAlgorithm(start, edges);
    }

    // O((v + e) * log(n)) time | O(n) space
    public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        int[] distances = new int[edges.length];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Node> distanceHeap = new PriorityQueue<>();
        distanceHeap.add(new Node(start, 0));

        while (!distanceHeap.isEmpty()) {
            Node currentNode = distanceHeap.poll();
            int currIdx = currentNode.idx;
            int currDistance = currentNode.distance;

            int[][] neighbors = edges[currIdx];
            for (int[] neighbor : neighbors) {
                int neighborIdx = neighbor[0];
                int neighborDistance = neighbor[1];
                if (currDistance + neighborDistance < distances[neighborIdx]) {
                    distances[neighborIdx] = currDistance + neighborDistance;
                    Node neighborNode = new Node(neighborIdx, currDistance + neighborDistance);
                    distanceHeap.add(neighborNode);
                }
            }
        }

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                distances[i] = -1;
            }
        }

        return distances;
    }

    static class Node implements Comparable<Node> {
        int idx;
        int distance;

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
