package december_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {

    public static void main(String[] args) {
        int[][][] edges = {
                {{4, 4}, {5, 3}},
                {{3, 5}, {4, 7}},
                {{2, 5}, {4, 6}, {5, 8}},
                {{2, 7}, {3, 6}, {5, 2}, {1, 4}},
                {{3, 8}, {4, 2}, {1, 3}}
        };

        PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm();
        primsAlgorithm.primsAlgorithm(edges);
    }

    // Find minimum spanning tree

    // O(e * log(v)) time | O(v + e) space
    public int[][][] primsAlgorithm(int[][][] edges) {
        // Write your code here.
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (int[] edge : edges[0]) {
            minHeap.add(new Node(0, edge[0], edge[1]));
        }
        List<List<List<Integer>>> mst = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            mst.add(new ArrayList<>());
        }

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int vertex = node.vertex;
            int discoveredVertex = node.discoveredVertex;
            int distance = node.distance;

            if (mst.get(discoveredVertex).size() == 0) {
                List<Integer> element0 = new ArrayList<>();
                element0.add(vertex);
                element0.add(distance);
                mst.get(vertex).add(element0);
                List<Integer> element1 = new ArrayList<>();
                element1.add(vertex);
                element1.add(distance);
                mst.get(discoveredVertex).add(element1);
                for (int[] e : edges[discoveredVertex]) {
                    int neighbor = e[0];
                    int neighborDistance = e[1];
                    if (mst.get(neighbor).size() == 0) {
                        minHeap.add(new Node(discoveredVertex, neighbor, neighborDistance));
                    }
                }
            }
        }
        return new int[][][] {};
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int discoveredVertex;
        int distance;

        public Node(int vertex, int discoveredVertex, int distance) {
            this.vertex = vertex;
            this.discoveredVertex = discoveredVertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

}
