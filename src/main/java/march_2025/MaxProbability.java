package march_2025;

import java.util.*;

public class MaxProbability {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start_node = 0;
        int end_node = 2;
//
//        int n = 5;
//        int[][] edges = {{1,4},{2,4},{0,4},{0,3},{0,2},{2,3}};
//        double[] succProb = {0.37,0.17,0.93,0.23,0.39,0.04};
//        int start_node = 3;
//        int end_node = 4;

        MaxProbability maxProbability = new MaxProbability();
        double result = maxProbability.maxProbability(n, edges, succProb, start_node, end_node);
        System.out.println(result);
    }

    // O(E * log(V)) time | O(V + E) space
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, List<Node>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int s = edge[0];
            int d = edge[1];
            double w = succProb[i];
            adj.get(s).add(new Node(d, w));
            adj.get(d).add(new Node(s, w));
        }

        double[] dist = new double[n];
        dist[start_node] = 1.0;

        PriorityQueue<Node> maxHeap = new PriorityQueue<>();
        maxHeap.add(new Node(start_node, 1.0));

        while (!maxHeap.isEmpty()) {
            Node current = maxHeap.poll();
            int nodeId = current.id;
            double prob = current.prob;

            if (nodeId == end_node) {
                return prob;
            }
            if (prob > dist[nodeId]) {
                continue;
            }

            for (Node neighbor : adj.get(nodeId)) {
                int neiId = neighbor.id;
                double neiProb = neighbor.prob;

                double newProb = prob * neiProb;

                if (newProb > dist[neiId]) {
                    dist[neiId] = newProb;
                    maxHeap.add(new Node(neiId, newProb));
                }
            }
        }

        return 0.0;
    }

    static class Node implements Comparable<Node> {
        int id;
        double prob;

        public Node(int id, double prob) {
            this.id = id;
            this.prob = prob;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(o.prob, this.prob);
        }
    }

}
