package may_2025;

import java.util.*;

public class MaxProbability2 {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1}, {1,2}, {0,2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start_node = 0;
        int end_node = 2;

        MaxProbability2 maxProbability = new MaxProbability2();
        double result = maxProbability.maxProbability(n, edges, succProb, start_node, end_node);
        System.out.println(result);
    }

    // O((V + E)*log(V)) time | O(V + E) space
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
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
        queue.add(new Pair(start_node, 1));
        double[] probs = new double[n];
        probs[start_node] = 1;

        while (!queue.isEmpty()) {
            Pair currPair = queue.poll();
            int node = currPair.node;
            double prob = currPair.prob;
            if (node == end_node) {
                break;
            }
            if (probs[node] > prob) {
                continue;
            }
            List<Pair> neighbors = adj.get(node);
            for (Pair nei : neighbors) {
                double newProb = prob * nei.prob;
                if (newProb > probs[nei.node]) {
                    probs[nei.node] = newProb;
                    queue.add(new Pair(nei.node, newProb));
                }
            }
        }
        return probs[end_node];
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
