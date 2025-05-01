package april_2025;

import java.util.*;

public class MaxProbability {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0,1}, {1,2}, {0,2}
        };
        double[] succProb = {0.5, 0.5, 0.2};
        int start_node = 0;
        int end_node = 2;

        MaxProbability maxProbability = new MaxProbability();
        maxProbability.maxProbability(n, edges, succProb, start_node, end_node);
    }

    // O((V + E) * log(V)) time | O(V + E) space
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] result = new double[n];
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int s = edge[0];
            int d = edge[1];
            adj.get(s).add(new Pair(d, succProb[i]));
            adj.get(d).add(new Pair(s, succProb[i]));
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        queue.add(new Pair(start_node, 1.0));
        result[start_node] = 1.0;

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();
            int node = currPair.node;
            double currProb = currPair.prob;
            if (node == end_node) {
                return currProb;
            }
            if (currProb > result[node]) {
                continue;
            }
            List<Pair> neighbors = adj.get(node);
            for (Pair neighbor : neighbors) {
                double newProb = currProb * neighbor.prob;
                if (newProb > result[neighbor.node]) {
                    result[neighbor.node] = newProb;
                    queue.add(new Pair(neighbor.node, newProb));
                }
            }
        }


        return 0.0;
    }

    static class Pair {
        int node;
        double prob;

        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

}
