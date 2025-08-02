package july_2025;

import java.util.*;

public class PathWithMaxProbability {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;

        PathWithMaxProbability pathWithMaxProbability = new PathWithMaxProbability();
        double result = pathWithMaxProbability.maxProbability(n, edges, succProb, start, end);
        System.out.println(result);
    }

    // O(E * log(V)) time | O(E + V) space
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
            int n1 = current.val;
            double p1 = current.prob;
            if (n1 == end_node) {
                return p1;
            }
            if (p1 > prob[n1]) {
                continue;
            }

            List<Pair> neighbors = adj.get(n1);
            for (Pair nei : neighbors) {
                int n2 = nei.val;
                double p2 = nei.prob;
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
        int val;
        double prob;

        public Pair(int val, double prob) {
            this.val = val;
            this.prob = prob;
        }

        @Override
        public int compareTo(Pair o) {
            return Double.compare(o.prob, prob);
        }
    }

}
