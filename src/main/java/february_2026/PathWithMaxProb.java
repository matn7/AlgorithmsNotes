package february_2026;

import java.util.*;

public class PathWithMaxProb {

    // O(E log(V)) time | O(V + E) space
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int s = edge[0];
            int d = edge[1];
            double w = succProb[i];
            adj.get(s).add(new Pair(d, w));
            adj.get(d).add(new Pair(s, w));
        }

        double[] prob = new double[n];
        prob[start_node] = 1;

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start_node, 1.0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int n1 = current.node;
            double p1 = current.weight;

            if (n1 == end_node) {
                return p1;
            }
            if (p1 > prob[n1]) {
                continue;
            }

            List<Pair> neighbors = adj.get(n1);
            for (Pair nei : neighbors) {
                int n2 = nei.node;
                double p2 = nei.weight;
                double newProb = p1 * p2;

                if (newProb > prob[n2]) {
                    prob[n2] = newProb;
                    queue.add(new Pair(n2, newProb));
                }
            }
        }
        return 0.0;
    }

    static class Pair implements Comparable<Pair> {
        int node;
        double weight;

        public Pair(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(o.weight, weight);
        }
    }

}
